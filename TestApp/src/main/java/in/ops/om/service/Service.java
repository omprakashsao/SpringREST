package in.ops.om.service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import in.ops.om.dao.Repository;

public class Service {

	Repository repo;
	
	public Service(Repository repo) {
		// TODO Auto-generated constructor stub
		this.repo = repo;
	}
	
	public List<String> getInfo(){
		try {
			return repo.getData()
					.stream()
					.filter(s->s.length()<=5)
					.collect(Collectors.toList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			return Arrays.asList();
		}
	}
	
	 
}
