package pe.edu.uni.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.uni.demo.dto.ClienteDto;
import pe.edu.uni.demo.dto.CuentaDto;
import pe.edu.uni.demo.dto.OperacionDto;

@Service
public class EurekaService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> getClientes() {
		String sql = "select * from cliente";
		List<Map<String, Object>> listado;
		listado = jdbcTemplate.queryForList(sql);
		return listado;
	}

	public ClienteDto getCliente(String codigo) {
		ClienteDto bean = null;
		String sql = "select chr_cliecodigo codigo, vch_cliepaterno paterno,";
		sql += "vch_cliematerno materno, vch_clienombre nombre,";
		sql += "chr_cliedni dni, vch_clieciudad ciudad,";
		sql += "vch_cliedireccion direccion, vch_clietelefono telefono,";
		sql += "vch_clieemail email ";
		sql += "from cliente where chr_cliecodigo = ?";
		try {
			bean = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<ClienteDto>(ClienteDto.class), codigo);
		} catch (Exception e) {
		}
		return bean;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public CuentaDto crearCuenta(CuentaDto bean) {
		// Variables
		String sql, sucursal, cuenta;
		int conta;
		// Verificar el importe
		if (bean.getImporte() <= 0) {
			throw new RuntimeException("El importe de apertura debe ser mayor o igual wur cero.");
		}
		// Verificar empleado
		varificarEmpleado(bean.getEmpleado());
		// Leer la sucursal
		sql = "select chr_sucucodigo cont from Asignado ";
		sql += "where chr_emplcodigo=? and dtt_asigfechabaja is null";
		sucursal = jdbcTemplate.queryForObject(sql, String.class, bean.getEmpleado());
		// Incrementar contador de cuenta
		sql = "update sucursal ";
		sql += "set int_sucucontcuenta = int_sucucontcuenta + 1 ";
		sql += "where chr_sucucodigo = ?";
		jdbcTemplate.update(sql, sucursal);
		// Leer el contador
		sql = "select int_sucucontcuenta from Sucursal where chr_sucucodigo = ?";
		conta = jdbcTemplate.queryForObject(sql, Integer.class, sucursal);
		// Crear el codigo de la cuenta
		cuenta = "000000" + conta;
		cuenta = sucursal + cuenta.substring(cuenta.length() - 5);
		// Registrar cuenta
		sql = "insert into cuenta(chr_cuencodigo,chr_monecodigo,";
		sql += "chr_sucucodigo,chr_emplcreacuenta,chr_cliecodigo,";
		sql += "dec_cuensaldo,dtt_cuenfechacreacion,vch_cuenestado,";
		sql += "int_cuencontmov,chr_cuenclave) ";
		sql += "values(?,?,?,?,?,?,getdate(),'ACTIVO',1,?)";
		Object[] datos = { cuenta, bean.getMoneda(), sucursal, bean.getEmpleado(), bean.getCliente(), bean.getImporte(),
				bean.getClave() };
		jdbcTemplate.update(sql, datos);
		// Registrar el movimientro
		sql = "insert into movimiento(chr_cuencodigo,int_movinumero,";
		sql += "dtt_movifecha,chr_emplcodigo,chr_tipocodigo,";
		sql += "dec_moviimporte,chr_cuenreferencia) ";
		sql += "values(?,1,getdate(),?,'001',?,null)";
		jdbcTemplate.update(sql, cuenta, bean.getEmpleado(), bean.getImporte());
		// Reporte
		bean.setCuenta(cuenta);
		bean.setSucursal(sucursal);
		bean.setClave("******");
		return bean;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public OperacionDto registrarRetiro(OperacionDto bean) {
		// Variables
		String sql;
		int conta;
		double saldo;
		long operacion;
		// Verificar el importe
		if (bean.getImporte() <= 0) {
			throw new RuntimeException("El importe de apertura debe ser mayor o igual wur cero.");
		}
		// Verificar empleado
		varificarEmpleado(bean.getEmpleado());

		// Verificar saldo
		sql = "select dec_cuensaldo from cuenta with (UPDLOCK) where chr_cuencodigo=?";
		saldo = jdbcTemplate.queryForObject(sql, Double.class, bean.getCuenta());
		if (bean.getImporte() > saldo) {
			throw new RuntimeException("No existe saldo suficiente.");
		}
		// Actualizar la cuenta
		sql = "update cuenta set dec_cuensaldo = ?, int_cuencontmov = int_cuencontmov + 1 ";
		sql += "where chr_cuencodigo = ? and chr_cuenclave = ?";
		saldo -= bean.getImporte();
		conta = jdbcTemplate.update(sql, saldo, bean.getCuenta(), bean.getClave());
		if (conta != 1) {
			throw new RuntimeException("Es posible que la clave sea incorrecta.");
		}
		// Leer nro. de operacion
		sql = "select int_cuencontmov from cuenta where chr_cuencodigo = ?";
		operacion = jdbcTemplate.queryForObject(sql, Long.class,bean.getCuenta());
		// Registrar movimiento
		sql = "insert into movimiento(chr_cuencodigo,int_movinumero,";
		sql += "dtt_movifecha,chr_emplcodigo,chr_tipocodigo,";
		sql += "dec_moviimporte,chr_cuenreferencia) ";
		sql += "values(?,?,getdate(),?,'004',?,null)";
		jdbcTemplate.update(sql, bean.getCuenta(), operacion, bean.getEmpleado(),  bean.getImporte());
		// Reporte
		bean.setOperacion(operacion);
		return bean;
	}

	@Transactional(propagation = Propagation.NESTED)
	private void varificarEmpleado(String empleado) {
		String sql = "select count(1) cont from Asignado ";
		sql += "where chr_emplcodigo=? and dtt_asigfechabaja is null";
		int conta = jdbcTemplate.queryForObject(sql, Integer.class, empleado);
		if (conta != 1) {
			throw new RuntimeException("Empleado no existe.");
		}
	}

}
