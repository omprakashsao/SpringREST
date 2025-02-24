package in.ops.om;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import in.ops.om.dao.Repository;
import in.ops.om.service.Service;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
	
	@Mock
	Repository repo;
	
	@InjectMocks
	Service service;
	
	
	@Test
	public void testGetInfo() {
		
		try {
			when(repo.getData()).thenReturn(Arrays.asList("rohan","ankit","sachin","saurav"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		int actual = 0;
		try {
			actual = service.getInfo().size();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(2,actual );
	
	}
	
	@Test
	public void testHandleException() {
		try {
			// dummy implement given using Mocking
			when(repo.getData()).thenThrow(new SQLException("CONNECTION ISSUE"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Test using JUnit
		List<String> actual = service.getInfo();
		assertNotNull(actual);
		assertEquals(0, actual.size());
	}

}
