package model;

public class UserAccount {

    private String userName;
    private String userType;
    private Boolean active;

    public UserAccount(String userName, String userType) {
        this.userName = userName;
        this.userType = userType;
    }

    public UserAccount() {
    }

    public UserAccount(String userName, String userType, Boolean active) {
        this.userName = userName;
        this.userType = userType;
        this.active = active;
    }

    @Override
    public String toString(){
        return this.userName+"("+this.userType+")";
    }
}
