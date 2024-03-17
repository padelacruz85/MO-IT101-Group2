package deductions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class salary_seductions {

    private double salary;
    public double total;
       
    public double getSSSdeduction() {
        final int constant = 25000;
        if ((int) Math.round(salary) < constant) {
            return salary * 0.045;
        }
        return constant * 0.045;
    }

    private double getWithholdingTax() {
        double withHoldingTax = 0;
        if (salary > 20833 && salary <= 33333) {
            withHoldingTax = (salary - 20833) * 0.15;
        } else if (salary >= 33333 && salary <= 66667) {
            withHoldingTax = 1875 + (salary - 33333) * 0.2;
        } else if (salary >= 66667 && salary <= 166667) {
            withHoldingTax = 8541 + (salary - 66667) * 0.25;
        } else if (salary >= 166667 && salary <= 666667) {
            withHoldingTax = 33541 + (salary - 166667) * 0.3;
        } else if (salary > 666667) {
            withHoldingTax = 183541 + (salary - 666667) * 0.35;
        }
        return withHoldingTax;
    }

    private double getPagibigDeduction() {
        final double minimunCompensation = 1500;
        if (salary > minimunCompensation) {
            return salary * 0.02;
        }
        return salary * 0.01;
    }

    public double getPhilHealthDeduction() {
        return salary * 0.05;
    }

    public double getTotalDeductions(double salary) {
        this.salary = salary;
        return getSSSdeduction() + getPagibigDeduction() + getPhilHealthDeduction() + getWithholdingTax();
    }

    public boolean getTotalDeductionsTestValidation() {
        return true;
    }
    
    //*************TEST CASE 1: VALIDATE SSS DEDUCTION*************//
//	@Test
//	public void test_getSSSdeduction() {
//		 salary=200000; 
//		 assertEquals((25000 * 0.045),getSSSdeduction(), "Compute SSS deduction is matching.");  
//		 System.out.println("TEST CASE 1: VALIDATE SSS DEDUCTION -> PASSED");  
//	}
//
//	//*************TEST CASE 2: VALIDATE WITHHOLDING TAX*************//
//	@Test
//	public void test_getWithholdingTax() {
//		salary=200000; 
//		assertEquals(33541 + (salary - 166667) * 0.3,getWithholdingTax(), "Compute Withholding Tax deduction is correct.");  
//		System.out.println("TEST CASE 2: VALIDATE WITH HOLDING TAX -> PASSED");  
//	}
//	//*************TEST CASE 3: VALIDATE PAG_IBIG*************//
//	@Test
//	public void test_getPagibigDeduction() {
//		salary=200000; 
//		assertEquals(salary * 0.02, getPagibigDeduction(), "Compute With Pag-Ibig deduction is correct.");  
//		System.out.println("TEST CASE 4: VALIDATE PHILHEALTH -> PASSED");  
//	}	 
//	//*************TEST CASE 4: VALIDATE PHILHEALTH*************//
//	@Test
//	public void test_getPhilHealthDeduction() {
//		salary=200000; 
//		assertEquals(salary * 0.05, getPhilHealthDeduction(), "Compute With PhilHealth deduction is correct.");  
//		System.out.println("TEST CASE 4: VALIDATE PHILHEALTH -> PASSED");  
//	}	 
}