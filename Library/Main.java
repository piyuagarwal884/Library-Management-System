package Library;
import java.util.Scanner;


public class Main{ 
    static Database database = new Database();
    static Scanner input;
    public static void main(String[]args){
        int login;
        do { 
            input = new Scanner(System.in);
            System.out.println("""
                               --Welcome to Library--
                               1.Login
                               2.New User""");
            login = input.nextInt();
    
            switch(login){
                case 1 ->{Login();
                    break;
                }
                case 2 ->{ 
                    NewUser();
                    break;
                }
    
                default -> System.out.println("Invalid choice");
                }
        } while (login != 0);
    }

    private static void Login(){
        System.out.print("Username:");
        String user_name = input.next();
        System.out.print("Password:");
        String password = input.next();
        int n = database.login(user_name, password);

        if(n!=-1){
            
            User user = database.getuser(n);
            user.menu(database,user);
            
        }
        else{
            System.out.println("User Does Not Exist");
        }
    }
    
    private static void NewUser(){
        System.out.println("--Please Enter The Required Data to Signup--");
        System.out.print("Enter your Name:");
        input.nextLine();
        String name = input.nextLine();
        System.out.print("Enter your Phone number:");
        String phone_no = input.nextLine();
        System.out.print("Enter your Address:");
        String address = input.nextLine();
        System.out.print("Create your Username:");
        String user_name = input.nextLine();
        System.out.print("Create your Password:");
        String password = input.nextLine();
        System.out.print("1.Admin\n2.New User\n");
        int signup = input.nextInt();
        User user=null;
        switch (signup) {
            case 1 -> {
                user = new Admin(name, phone_no, address, user_name, password);
            }
            case 2 -> {
                user = new NewUser(name, phone_no, address, user_name, password);
            }
            default -> System.out.println("Invalid Choice");
        }
        database.adduser(user,password);
        user.menu(database , user);
    }

}