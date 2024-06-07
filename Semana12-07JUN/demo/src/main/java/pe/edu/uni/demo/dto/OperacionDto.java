package pe.edu.uni.demo.dto;

public class OperacionDto {
	
	private long operacion;
	private String cuenta;
	private double importe;
	private String empleado;
	private String clave;
	
	public OperacionDto() {
	}

	public OperacionDto(String cuenta, double importe, String empleado, String clave) {
		super();
		this.cuenta = cuenta;
		this.importe = importe;
		this.empleado = empleado;
		this.clave = clave;
	}

	public long getOperacion() {
		return operacion;
	}

	public void setOperacion(long operacion) {
		this.operacion = operacion;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
}
