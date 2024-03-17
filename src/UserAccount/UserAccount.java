package UserAccount;

public class UserAccount 
{

    private String username;
    private String password;
    private String[][] accounts = {{"admin", "pass"}};

    public UserAccount(String username, String password) 
    {
    	this.username = username;
        this.password = password;
    }

    public boolean checkPassword()
    {
        if((username.equals(accounts[0][0])) && (password.equals(accounts[0][1])))
            return true;
        else
            return false;
    }
}