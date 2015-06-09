package oop_project;

//import java.io.IOException;

/**
 *
 * @author Haseeb
 */
public class Employee extends Person {

    public String NAME;
    public int ID;

    Employee() {
        super("              ");
        this.ID = 0;

    }

    Employee(String Name, int ID) {
        super(Name);
        //System.out.println(toMYSTRING("hello4"));
        //System.out.println(toMYSTRING(Name));
        this.NAME = (Name);
        System.out.println(NAME);
        //this.NAME = toMYSTRING(NAME);

        //String string = 
        this.ID = ID;
    }

   /*
    void setName(String name) throws IOException {
        super.setName(toMYSTRING(NAME));
    }
*/
    void setID(int ID) {
        this.ID = ID;
    }

    int getID() {
        return this.ID;
    }

    public String toMYSTRING(String input) {
        String output = input;
        for (int i = input.length(); i < 15; i++) {
            output += " ";
        }
        return output;
    }
}
