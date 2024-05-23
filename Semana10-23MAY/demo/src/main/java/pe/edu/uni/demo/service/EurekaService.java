package pe.edu.uni.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EurekaService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<Map<String,Object>> getClientes(){
		String sql = "select * from cliente";
		List<Map<String,Object>>  listado;
		listado = jdbcTemplate.queryForList(sql);
		return listado;
	}
	
	
	
	
	
}
