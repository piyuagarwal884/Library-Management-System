package Library;
import java.util.Scanner;

public class Addbooks implements IOOperation{
    
    @Override
    public void oper(Database database,User user){
        Scanner s = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Enter Book Name:");
        book.setBookName(s.next());
        System.out.println("Enter Author Name:");
        book.setAuthor(s.next());
        System.out.println("Enter Publisher Name:");
        book.setPublisher(s.next());
        System.out.println("Enter book collection address:");
        book.setaddress(s.next());
        System.out.println("Enter the quantity of books:");
        book.setQty(s.nextInt());
        System.out.println("Enter the Price of 1 book:");
        book.setPrice(s.nextDouble());
        System.out.println("Enter borrowing copies:");
        book.setBrwcopies(s.nextInt());
        database.addBook(book);
        System.out.println("Book added successfully");
    }
}
