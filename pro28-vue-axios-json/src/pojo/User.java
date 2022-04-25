package pojo;

/**
 * @author shkstart
 * @create 2022-03-28 23:46
 */
public class User {
    private String numae;
    private String pwd;

    public User() {

    }

    public User(String numae, String pwd) {
        this.numae = numae;
        this.pwd = pwd;
    }

    public String getNumae() {
        return numae;
    }

    public void setNumae(String numae) {
        this.numae = numae;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "numae='" + numae + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
