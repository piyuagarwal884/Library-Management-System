package Library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Database {

    // Stores all users, books, and their respective names
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<String> bookNames = new ArrayList<>();

    // File paths for storing user and book data
    private File userFile = new File("C:\\Users\\aanki\\Downloads\\Library management system\\Library\\data\\Users");
    private File bookFile = new File("C:\\Users\\aanki\\Downloads\\Library management system\\Library\\data\\Books");
    private File folder = new File("C:\\Users\\aanki\\Downloads\\Library management system\\Library\\data");

    // Constructor: Initializes database, creates directories if missing, and loads existing users
    public Database() {
        if (!folder.exists()) {
            folder.mkdir();
        }
        if (!userFile.exists()) {
            try {
                userFile.createNewFile();
            } catch (IOException e) {
            }

        }
        if (!bookFile.exists()) {
            try {
                bookFile.createNewFile();
            } catch (IOException e) {
            }
        }
        getUsers();
    }

    // Adds a new user to the database and saves to file
    public void adduser(User input, String password) {
        users.add(input);
        usernames.add(input.getname());
        saveUser();  // Save updated user list to file
    }

    // Validates user login by checking username and password
    public int login(String user_name, String password) {
        for (User input : users) {
            if (input.getuser_name(user_name).matches(user_name) && input.getpassword(password).matches(password)) {
                return users.indexOf(input); // Return user index if login successful
            }
        }
        return -1; // Return -1 if user not found
    }

    // Retrieves user from list based on index
    public User getuser(int n) {
        return users.get(n);
    }

    // Adds a book to the book collection
    public void addBook(Book book) {
        books.add(book);
        bookNames.add(book.getbookname());
        saveBooks();
    }

    // Reads stored user data from file and loads into memory
    private void getUsers() {
        String text1 = "";
        try (BufferedReader br1 = new BufferedReader(new FileReader(userFile))) {
            String s1;
            while ((s1 = br1.readLine()) != null) {
                text1 = text1 + s1;

            }
        } catch (IOException e) {
            System.err.println(e.toString());  // Handle file reading errors
        }

        // If file contains data, process it and create user objects
        if (!text1.matches("") || !text1.isEmpty()) {
            String[] a1 = text1.split("<NewUser>");
            for (String s : a1) {
                String[] a2 = s.split("<N/>");
                if (a2.length >= 6) {
                    if (a2[5].matches("Admin")) {
                        User user = new Admin(a2[0], a2[1], a2[2], a2[3], a2[4]);
                        users.add(user);
                        usernames.add(user.getname());
                    } else {
                        User user = new NewUser(a2[0], a2[1], a2[2], a2[3], a2[4]);
                        users.add(user);
                        usernames.add(user.getname());
                    }
                }
            }
        }
    }

    // Saves current users to the file
    private void saveUser() {

        String text1 = "";
        for (User user : users) {
            text1 = text1 + user.toString() + " <NewUser/>\n";
        }
        try {
            PrintWriter pw = new PrintWriter(userFile);
            pw.print(text1);
            pw.close();
            System.err.println("Data saved successfully");
        } catch (Exception e) {
            System.err.println(e.toString());  // Handle file writing errors
        }
    }

    private void getBooks() {
        String text1 = "";
        try (BufferedReader br1 = new BufferedReader(new FileReader(bookFile))) {
            String s1;
            while ((s1 = br1.readLine()) != null) {
                text1 = text1 + s1;
            }

        } catch (IOException e) {
            System.err.println(e.toString());  // Handle file reading errors
        }

        // If file contains data, process it and create user objects
        if (!text1.matches("") || !text1.isEmpty()) {
            String[] a1 = text1.split("<NewBook>");
            for (String s : a1) {
                Book book = parseBook(s);
                books.add(book);
                bookNames.add(book.getbookname());
            }
        }
    }

    public Book parseBook(String s) {
        String[] a = s.split("<N/>");
        Book book = new Book();
        book.setBookName(a[0]);
        book.setAuthor(a[1]);
        book.setPublisher(a[2]);
        book.setaddress(a[3]);
        book.setQty(Integer.parseInt(a[4]));
        book.setPrice(Double.parseDouble(a[5]));
        book.setBrwcopies(Integer.parseInt(a[6]));
        return book;
    }

    private void saveBooks() {

        String text1 = "";
        for (Book book : books) {
            text1 = text1 + book.toString() + " <NewBook/>\n";
        }
        try (PrintWriter pw = new PrintWriter(bookFile)) {
            pw.print(text1);
            pw.close();
            System.err.println("Book saved successfully");
        } catch (Exception e) {
            System.err.println(e.toString());  // Handle file writing errors
        }
    }
}
