public class Author extends Person {
    protected String publisher;

    public Author(String name, String publisher, int birthDate) {

            super(name, birthDate);
            try {
                setPublisher(publisher);
            }
            catch (Exception e){
                System.out.println("Please check your inputs. Object was not created.");
            }
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        // This mechanism checks whether string variable's length is less than 3 symbols or not.
        try {
            if (publisher.length() < 3) {
                throw new Exception();
            } else {
                this.publisher = publisher;
            }
        }
        catch (Exception e){
            System.out.println("Please check your publisher. Publisher cannot be less than 3 symbols.");

        }
    }

    public String toString(){
        return "Author is " + getName();


    }
}
