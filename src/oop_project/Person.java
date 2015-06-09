package oop_project;

/**
 *
 * @author Haseeb
 */
public class Person {

    String Name;
    Person(){
        
    }
    
    
    Person(String Name) {
        this.Name = Name;
    }

    String getName() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.Name;
    }
    
    void setName(String name){
        this.Name = name;
    }
}
