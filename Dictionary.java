public class Dictionary extends Book {
    protected int definitions;

    public Dictionary(int id,String title,Author author,int definitions){
        super(id, title, author);
        try {
            setDefinitions(definitions);
        }
        catch (Exception e){
            System.out.println("Please check your inputs. Object was not created.");
        }
    }
    public Dictionary(int id,String title,int definitions){

        super(id,title);
        setDefinitions(definitions);

    }

    public int getDefinitions() {
        return definitions;
    }

    public void setDefinitions(int definitions){
        // This mechanism checks whether int variable is positive or not.
        try {
            if (definitions <= 0) {
                throw new Exception();
            } else {
                this.definitions = definitions;
            }
        }
        catch (Exception e){
            System.out.println("Please check your definitions of dictionary. " +
                    "Definitions cannot be negative or zero.");
        }
    }

    public String toString() {
        return "Dictionary Name is " + getTitle() + ", definitions: " + getDefinitions();
    }
}
