/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package deductionsTest;

import deductions.salary_deductions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class salary_deductionsTest {
    /**
     * Test of getTotalDeductionsTest method, of class salary_deductions.
     */
    @Test
    public void testGetTotalDeductionsTest() {
        System.out.println("getTotalDeductionsTest");
        double salary = 0.0;
        salary_deductions instance = new salary_deductions(salary);
        double expResult = 0.0;
        double result = instance.getTotalDeductions(salary);
        assertEquals(expResult, result, 0);
    }
    
}
