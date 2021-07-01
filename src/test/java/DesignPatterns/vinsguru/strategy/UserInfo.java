package DesignPatterns.vinsguru.strategy;

public class UserInfo {

    private String firstName;
    private String lastName;
    private String email;

    public UserInfo(){
        this.firstName = "Mike";
        this.lastName = "Spooner";
        this.email = "mikeunderscore2004@yahoo.com";
    }

    public UserInfo(String firstName, String lastName, String email) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
    }

    public void enterUserInfo() {
        System.out.println("User information taken");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
