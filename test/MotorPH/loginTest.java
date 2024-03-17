
package MotorPH;

import UserAccount.UserAccount;
import org.junit.Test;
public class loginTest {
    
//*************TEST CASE 1: CREDENTIAL IS VALID*************//
	@Test
	public void test_validCreadential() {
	    String username="paul";
	    String password="password";
		UserAccount login = new UserAccount(username, password);
		assert(login.checkPassword());  
		System.out.println("TEST CASE 1: CREDENTIAL IS VALID -> PASSED");  
	}

}