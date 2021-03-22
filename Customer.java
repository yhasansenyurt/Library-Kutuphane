public class Customer extends Person{
    protected String address;
    protected Book borrowedBook;
    protected boolean borrowABook = false;

    public Customer(String name, String birthPlace, int birthDate, String address) {
        super(name, birthDate, birthPlace);
        try {
            setAddress(address);
        }
        catch (Exception e){
            System.out.println("Please check your inputs. Object was not created.");
        }
    }

    public Customer(String name, int birthDate, String address){
        super(name, birthDate);
        try {
            setAddress(address);
        }
        catch (Exception e){
            System.out.println("Please check your inputs. Object was not created.");
        }
    }
    public Customer(String name,String address){
        super(name);
        try {
            setAddress(address);
        }
        catch (Exception e){
            System.out.println("Please check your inputs. Object was not created.");
        }
    }
    public Customer(String name, int birthDate){
        super(name, birthDate);


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
            System.out.println("Please check your customer's address. Address cannot be less than 3 symbols.");

        }
    }



    public Book getBorrowedBook() {
        if(this.borrowABook) {
            return borrowedBook;
        }
        else{
            return null;
        }
    }

    public boolean getBorrowABook() {
        return this.borrowABook;
    }

    public void setBorrowABook(boolean borrowABook) {
        this.borrowABook = borrowABook;
    }

    public void setBorrowedBook(Book borrowedBook) {
        // This is the method that is for borrow a book for customer. It checks the conditions of
        // book and customer, and if the situations are okay, customer can borrow a book.
        if(!borrowedBook.isBorrowed() && !getBorrowABook()) {
            this.borrowedBook = borrowedBook;
            borrowedBook.borrowed();
            this.borrowABook = true;
        }
        else{
            this.borrowABook = false;
        }
    }


    public String toString(){
        if(getBirthPlace() == null){
            birthPlace = "-";
        }
        if(getAddress() == null){
            address = "-";
        }
        if(getBirthDate() == null){
            birthDate = "-";
        }
        return "Name: " + getName() + ", Birth Date: " + getBirthDate() + ", Birth Place: " +getBirthPlace()
                + "\nAddress: " + getAddress();
    }
}
