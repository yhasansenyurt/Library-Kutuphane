public class Book {
    protected int id;
    protected String title;
    protected Author author;
    public boolean borrowed;

    public Book(int id, String title, Author author){
        try {
            setTitle(title);
            setId(id);
            this.author = author;
        }
        catch (Exception e){
            System.out.println("Please check your inputs. Object was not created.");
        }
    }
    public Book(int id, String title){
        try {
            setTitle(title);
            setId(id);
        }
        catch(Exception e){
            System.out.println("Please check your inputs. Object was not created.");
        }
    }
    public boolean isBorrowed(){
        return this.borrowed;
    }

    public boolean borrowed(){
        // If borrowed is equal to true, this book cannot be borrowed. So, it returns false.
        if(this.borrowed){
            return false;
        }
        else{
            this.borrowed = true;
            return true;
        }
    }
    public boolean returned(){
        // If borrowed is equal to false, this book cannot be returned. So, it returns false.
        if(!this.borrowed){
            return false;
        }
        else{
            this.borrowed = false;
            return true;

        }
    }

    public String toString(){
        return "Book name is " + getTitle() + ", Author is " + getAuthor().getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        // This mechanism checks whether int variable is positive or not.
        try {
            if (id <= 0) {
                throw new Exception("Id cannot be negative.");
            } else {
                this.id = id;
            }
        }
        catch(Exception e){
            System.out.println("Please check your book's id. Id cannot be negative or zero.");

        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        // This mechanism checks whether string variable's length is less than 3 symbols or not.
        try {
            if (title.length() < 3) {
                throw new Exception();
            } else {
                this.title = title;
            }
        }
        catch(Exception e){
            System.out.println("Length of title must be greater than 3 symbols.");
        }

    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}
