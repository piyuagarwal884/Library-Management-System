package Library;

public class Book {
    private String BookName;
    private String Author;
    private String Publisher;
    private String Address;
    private int qty;
    private double price;
    private int brwcopies;

    public Book(){}

    // Constructor: Initializes book details
    public Book(String BookName, String Author, String Publisher, int qty, double price, int brwcopies) {
        this.BookName = BookName;
        this.Author = Author;
        this.Publisher = Publisher;
        this.qty = qty;
        this.price = price;
        this.brwcopies = brwcopies;
    }

    // Converts book details to string format
    @Override
    public String toString() {
        return "Book Name: " + BookName +
               ", Author: " + Author +
               ", Publisher: " + Publisher +
               ", Collection Address: " + Address +
               ", Quantity: " + qty +
               ", Price: " + price +
               ", Borrowing Copies: " + brwcopies;
    }

    // Getters and Setters for book attributes
    public String getbookname() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBrwcopies() {
        return brwcopies;
    }

    public void setBrwcopies(int brwcopies) {
        this.brwcopies = brwcopies;
    }

    public String getaddress(){
        return Address;
    }

    public void setaddress(String Address){
        this.Address = Address;
    }


    public String toString2(){
        String text= BookName +"<N/>" + Author + "<N/>" + Publisher + "<N/>" + Address + "<N/>" + qty + "<N/>" + price + "<N/>" + brwcopies + "Book";
        return text;
    }

    public Book parseBook(String s){
        String[]a = s.split("<N/>");
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
}
