package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/31  15:11
 */
public class Login {
    private String userName="admin";
    private String password="123456";

    public void login(String name,String password) throws NameException,PasswordException {
        if(!name.equals(this.userName)){
            throw new NameException();
        }
        if(!password.equals(this.password)){
            throw new PasswordException();
        }

        System.out.println("登录成功！！");
    }

    public static void main(String[] args) throws PasswordException, NameException {
        Login lo=new Login();
        lo.login("admin","123456");
    }
}
