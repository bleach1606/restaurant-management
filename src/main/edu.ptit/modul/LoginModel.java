package modul;

public class LoginModel {
    private String userName;
    private String password;

    public LoginModel(){

    }

    public LoginModel(String username, String password){
        this.userName = username;
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}