package Classes;

/**
 * Created by HPPC on 29-10-2017.
 */

public class Customer {
    private String customerId ;
    private String password;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //TODO : Abc
    //TODO: change
    public String login(String id , String password) {
        String type = id.charAt(0)+"";
        return type;
    }
}
