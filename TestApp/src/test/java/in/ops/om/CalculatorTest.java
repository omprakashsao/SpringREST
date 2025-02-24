package in.ops.om;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import in.ops.om.bean.Calculator;


public class CalculatorTest {
	Calculator cal = null;
	
	@BeforeEach
	public void setUp() {
		 cal = new Calculator();	
	}

    
    @Test
    public void testAdd() {
       Integer actual = cal.add(10, 20);
       assertEquals(30, actual);
    }
    
    @AfterEach
    public void setUp1() {
    	cal = null;
    }
}
