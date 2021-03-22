import java.util.ArrayList;

public class Library {
    protected String address;
    ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<Customer> customers = new ArrayList<Customer>();

    public Library(String address) {
        try {
            setAddress(address);
        }
        catch (Exception e){
            System.out.println("Please check your inputs. Object was not created.");
        }
    }

    public static void printOpeningHours(){
        System.out.println("Libraries are open daily from 9 am to 5 pm.");
    }
    public void printAddress(){
        System.out.println(this.getAddress());

    }
    public void addBook(Book book){
        books.add(book);

    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }


    public void borrowBook(String bookName, String customerName){
        /*
         There are 4 boolean variables for checking the all situations. These variables are for print
         necessary warnings. If one of them is false, the message will be printed according to their
         priority order.
        */
        boolean check_book_name = false;
        boolean check_book_borrowed = false;
        boolean check_customer_name = false;
        boolean check_customer_borrowed = false;
        for(Book book : books) {
            if(book.getTitle() != null) {
                if (book.getTitle().equals(bookName)) { //Checks books list to compare input and book.
                    check_book_name = true; // Now, book name is correct. If there will be a warning, warning
                    // will not include book's name warning.
                    if (!book.isBorrowed()) { // Checks if book is borrowed or not.
                        check_book_borrowed = true; // Now everything is okay for book. It is time to look at customer.
                        for (Customer customer : customers) {
                            if (customer.getName() != null) { //avoiding null objects.

                                if (customer.getName().equals(customerName)) { //Checks input and list.
                                    check_customer_name = true;
                                    if (!customer.getBorrowABook()) {
                                        check_customer_borrowed = true; // Now, book and customer situations are okay.
                                        customer.setBorrowedBook(book); // Setting customer's book.
                                        book.borrowed(); // Telling the program this book is borrowed.
                                        System.out.println(customerName + " successfully borrowed " + bookName + ".");
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if(!check_book_name){
            System.out.println("Sorry, this book is not in our catalog");
        }
        else if(!check_book_borrowed){
            System.out.println("Sorry, this book is already borrowed");
        }
        else if(!check_customer_name){
            System.out.println("Sorry, " + customerName + " is not a customer");
        }
        else if(!check_customer_borrowed){
            System.out.println("Sorry, "+ customerName + " already borrowed a book");
        }


    }
    public void returnBook(String customerName){
        /*
        These two booleans are for printing the warning messages according to incorrectness of customer's
        name or whether customer borrowed a book or not.
         */
        boolean check_customer_name = false;
        boolean check_customer_borrowed = false;
        for(Customer customer : customers) {
            if (customer.getName() != null) { //avoiding null objects.
                if (customer.getName().equals(customerName)) {
                    check_customer_name = true;
                    if (customer.getBorrowABook()) {
                        check_customer_borrowed = true; // Now, controls are okay.
                        System.out.println(customerName + " successfully returned " + customer.getBorrowedBook().getTitle());
                        customer.setBorrowABook(false); // Setting customer can borrow some book after this returning.
                        customer.borrowedBook.returned(); // Book is returned. Now book is available.
                        customer.borrowedBook = null; // Setting customer's book is null(empty).
                        break;
                    }
                }
            }
        }
        if(!check_customer_name){
            System.out.println("Sorry, "+ customerName + " is not a customer.");
        }
        else if(!check_customer_borrowed){
            System.out.println("Sorry, " + customerName + " did not borrow a book");
        }
    }
    public void printAvailableBooks(){
        if(books.isEmpty()){
            System.out.println("No book in catalog.");
        }
        else {
            for (Book book : books) {
                if (!book.isBorrowed()) {
                    System.out.println(book);
                }
            }
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        // This mechanism checks whether string variable's length is less than 3 symbols or not.
        try {
            if (address.length() < 3) {
                throw new Exception();
            } else {
                this.address = address;
            }
        }
        catch (Exception e){
            System.out.println("Please check your library's address. Address cannot be less than 3 symbols.");
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
    public String toString(){
        return getAddress();
    }
}
