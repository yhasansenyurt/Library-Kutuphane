public class Person {
    protected String name;
    public String birthDate;
    protected String birthPlace;

    public Person(String name,int birthDate, String birthPlace) {
        try {
            setName(name);
            setBirthPlace(birthPlace);
            setBirthDate(birthDate);
        }
        catch (Exception e){
            System.out.println("Please check your inputs. Object was not created.");
        }
    }

    public Person(String name, int birthDate){
        try {
            setName(name);
            setBirthDate(birthDate);
        }
        catch (Exception e){
            System.out.println("Please check your inputs. Object was not created.");
        }
    }

    public Person(String name){
        try {
            setName(name);
        }
        catch (Exception e){
            System.out.println("Please check your inputs. Object was not created.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // This mechanism checks whether string variable's length is less than 3 symbols or not.
        try {
            if (name.length() < 3) {
                throw new Exception();
            } else {
                this.name = name;
            }
        }
        catch (Exception e){
            System.out.println("Name cannot be smaller than 3 symbols.");

        }

    }

    public String getBirthDate() {
        return birthDate;

    }

    public void setBirthDate(int birthDate) {
        // This mechanism checks whether int variable is positive or not.
        try {
            if (birthDate <= 0) {
                throw new Exception();
            } else {
                this.birthDate = String.valueOf((int) birthDate);
            }
        }
        catch (Exception e){
            System.out.println("Please check your person's birthDate. Birthday cannot be negative or zero.");

        }
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        // This mechanism checks whether string variable's length is less than 3 symbols or not.
        try {
            if (birthPlace.length() < 3) {
                throw new Exception();
            } else {
                this.birthPlace = birthPlace;
            }
        }
        catch (Exception e){
            System.out.println("Please check your person's birthplace. " +
                    "Birthplace cannot be less than 3 symbols.");

        }
    }

    public String toString(){

        return "Name: " + getName() + ", Birth Date: " + getBirthDate() + ", Birth Place: " + getBirthPlace();
    }
}
