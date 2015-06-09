package oop_project;

import java.io.IOException;

/**
 *
 * @author Haseeb
 */
public class Admin extends Employee {
    //String username = "haseeb";

    //String password = "1214";

    Admin() {
        super("Haseeb", 1);

    }

    void newTeacher(int ID, String name, long CNIC, String qualification, String password) throws IOException {
        Teacher teacher = new Teacher(ID, name, CNIC, qualification, password);
    }

    void newStudent(String NAME, int ID, String Password, long CNIC, String Desipline) throws IOException {
        Student student = new Student(ID, NAME, CNIC, Desipline, Password);
    }
    
    
    
    

}
