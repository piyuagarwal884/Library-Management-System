package Library;

import java.util.*;


public class Admin extends User {

    public Admin(String name) {
        super(name);
        this.operations = new IOOperation[]{
            new Addbooks(),
            new ViewBooks(),
            new DeleteBook(),
            new Search(),
            new Deletealldata(),
            new ViewOrders(),
            new Exit(),
        };
    
    }

    public Admin(String name, String phone_no,String address,String user_name,String password){
        super(name, phone_no, address, user_name, password);
        this.operations = new IOOperation[]{
            new Addbooks(),
            new ViewBooks(),
            new DeleteBook(),
            new Search(),
            new Deletealldata(),
            new ViewOrders(),
            new Exit(),
            
        };
    
    }

    @Override
     public void menu(Database database,User user){
        Scanner scan = new Scanner(System.in);

        System.out.println("1. View Books");
        System.out.println("2. Add Books");
        System.out.println("3. Delete Books");
        System.out.println("4. Search");
        System.out.println("5. Delete all data");
        System.out.println("6. View Orders");
        System.out.println("7. Exit");
        int n = scan.nextInt();

        this.operations[n].oper(database,user);

        scan.close();
    }

  
    @Override
    public String toString(){
        String text= name +"<N/>" + phone_no + "<N/>" + address + "<N/>" + user_name + "<N/>" + password + "Admin";
        return text;
    }
}