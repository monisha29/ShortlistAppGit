package Classes;

/**
 * Created by HPPC on 29-10-2017.
 */

public class Contact
{ private String address;
  private String email;
  private String alternateEmail;
  private int phoneNo;
  private int alternatePhoneNo;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getAlternatePhoneNo() {
        return alternatePhoneNo;
    }

    public void setAlternatePhoneNo(int alternatePhoneNo) {
        this.alternatePhoneNo = alternatePhoneNo;
    }
}
