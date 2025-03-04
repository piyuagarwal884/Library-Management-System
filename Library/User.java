package Library;

public abstract class User {
    protected String name;
    protected String phone_no;
    protected String address;
    protected String user_name;
    protected String password;
    protected IOOperation[] operations;

    public User(String name){
        this.name=name;
    }

    public User(String name,String phone_no,String address,String user_name,String password){
        this.name=name;
        this.phone_no=phone_no;
        this.address=address;
        this.user_name=user_name;
        this.password=password;
    }
    
    public String getname(){
        return name;
    }

    public String getphone_no(String phone_no){
        return phone_no;
    }

    public String getaddress(String address){
        return address;
    }

    public String getuser_name(String user_name){
        return user_name;
    }

    public String getpassword(String password){
        return password;
    }

    @Override
    abstract public String toString();
    abstract public void menu(Database database,User user);
}
