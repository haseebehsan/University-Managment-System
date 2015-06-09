package oop_project;

//import oop_project.methods.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Haseeb
 */
public class Student extends Person {

    long index;
    String descipline;
    String NAME;
    int ID;
    long CNIC;
    String password;

    Student() {

    }

    Student(long index) throws FileNotFoundException, IOException {
        this.index = index;
        RandomAccessFile student = new RandomAccessFile("studentDATA.txt", "rw");
        student.seek(index);
        this.ID = student.readInt();
        this.NAME = methods.remove_spaces(student.readUTF());
        this.CNIC = student.readLong();
        this.descipline = methods.remove_spaces(student.readUTF());

    }

    Student(int ID, String Name, long CNIC, String Descipline, String password) throws IOException {
        super(Name);

        this.NAME = toMYSTRING(Name);
        this.ID = ID;
        //System.out.println(toMYSTRING("hello3"));
        this.descipline = toMYSTRING(Descipline);
        this.CNIC = CNIC;
        this.password = (password);

        addData();
        //this.NAME = oop_project.methods.toMYSTRING(NAME);
        //String string = 
        //this.ID = ID;

    }

    void addData() throws FileNotFoundException, IOException {
        System.out.println(toMYSTRING("hello2"));
        RandomAccessFile studentID = new RandomAccessFile("studentID.txt", "rw");
        studentID.seek(studentID.length());

        studentID.writeInt(this.ID);
        studentID.writeUTF(this.password);

        RandomAccessFile studentDATA = new RandomAccessFile("studentDATA.txt", "rw");
        studentDATA.seek(studentDATA.length());
        studentDATA.writeInt(this.ID);
        studentDATA.writeUTF(this.NAME);
        studentDATA.writeLong(CNIC);
        studentDATA.writeUTF(this.descipline);
    }

    void editDetails(long index, int ID, String NAME, long CNIC, String decipline) throws FileNotFoundException, IOException {
        RandomAccessFile studentDATA = new RandomAccessFile("studentDATA.txt", "rw");
        studentDATA.seek(index);
        studentDATA.write(this.ID);
        studentDATA.writeUTF(this.NAME);
        studentDATA.writeLong(CNIC);
        studentDATA.writeUTF(this.descipline);

    }

    long searchByID(int ID) throws FileNotFoundException, IOException {
        long result = -1;
        RandomAccessFile studentDATA = new RandomAccessFile("studentDATA.txt", "rw");

        while (studentDATA.getFilePointer() < studentDATA.length()) {
            long temp = studentDATA.getFilePointer();
            if (studentDATA.readInt() == ID) {
                result = temp;
                break;

            }
            studentDATA.readUTF();
            studentDATA.readLong();
            studentDATA.readUTF();

        }
        return result;
    }

    boolean findID(int ID) throws IOException {
        boolean result = false;
        RandomAccessFile studentDATA = null;
        try {
            studentDATA = new RandomAccessFile("studentDATA.txt", "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (studentDATA.getFilePointer() < studentDATA.length()) {
            //result = studentDATA.getFilePointer();
            if (studentDATA.readInt() == ID) {
                result = true;
                break;

            }
            studentDATA.readUTF();
            studentDATA.readLong();
            studentDATA.readUTF();

        }
        return result;
    }

    long searchByNAME(String Name) throws FileNotFoundException, IOException {
        long result = -1;
        RandomAccessFile studentDATA = new RandomAccessFile("studentDATA.txt", "rw");

        while (studentDATA.getFilePointer() < studentDATA.length()) {

            result = studentDATA.getFilePointer();
            studentDATA.readInt();
            if (studentDATA.readUTF().equals(Name)) {
                break;

            }

            studentDATA.readLong();
            studentDATA.readUTF();

        }
        return result;
    }

    void deletestudent(long byteindex) throws FileNotFoundException, IOException {
        //public void delete(long byteindex) throws FileNotFoundException, IOException {
        RandomAccessFile DeletingStudent = new RandomAccessFile("studentDATA.txt", "rw");
        if (DeletingStudent.length() == 46) {
            System.out.println("hahaha");
            DeletingStudent.setLength(0);
        } else {

            long NextStudentsData_StartingByteValue = byteindex + 46;
            RandomAccessFile NextReplacingStudent = new RandomAccessFile("studentDATA.txt", "rw");

            DeletingStudent.seek(byteindex);
            NextReplacingStudent.seek(NextStudentsData_StartingByteValue);

            while (DeletingStudent.getFilePointer() < DeletingStudent.length()) {

                if (NextReplacingStudent.getFilePointer() == DeletingStudent.length()) {
                    break;
                }

                DeletingStudent.writeInt(NextReplacingStudent.readInt());
                DeletingStudent.writeUTF(NextReplacingStudent.readUTF());
                DeletingStudent.writeLong(NextReplacingStudent.readLong());
                DeletingStudent.writeUTF(NextReplacingStudent.readUTF());

            }
            DeletingStudent.setLength(DeletingStudent.getFilePointer());        //decreases the length of file because of deletion

        //System.out.println("Student commanded is seccessfully deleted from the record...");
            //RecordManagmentMenu();
            //}
        }
    }

    public final String toMYSTRING(String input) {
        String output = "";
        //= input;
        for (int i = input.length(); i < 15; i++) {
            output += " ";
        }
        output = input + output;
        return output;
    }
}
