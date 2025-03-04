package Library;

import java.util.*;

public class NewUser extends User{
    public NewUser(String name) {
        super(name);
        this.operations = new IOOperation[]{
            new ViewBooks(),
            new Search(),
            new Placeorder(),
            new Borrowbook(),
            new CalculateFine(),
            new ReturnBook(),
            new Exit(),
        };
    }

    public NewUser(String name, String phone_no,String address,String user_name,String password){
        super(name, phone_no, address, user_name, password);
        this.operations = new IOOperation[]{
            new ViewBooks(),
            new Search(),
            new Placeorder(),
            new Borrowbook(),
            new CalculateFine(),
            new ReturnBook(),
            new Exit(),
        };
    }   

    @Override
    public void menu(Database database,User user){
        Scanner scan = new Scanner(System.in);
        System.out.println("1. View Books");
        System.out.println("2. Search");
        System.out.println("3. Place Order");
        System.out.println("4. Borrow Books");
        System.out.println("5. Calculate fine");
        System.out.println("6. Return Book");
        System.out.println("7. Exit");

        int n = scan.nextInt();

        this.operations[n-1].oper(database,user);

        scan.close();
    }

    @Override
    public String toString(){
        String text= name +"<N/>" + phone_no + "<N/>" + address + "<N/>" + user_name + "<N/>" + password + "NewUser";
        return text;
    }

}