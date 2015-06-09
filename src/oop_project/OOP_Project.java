package oop_project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Haseeb
 */
public class OOP_Project {

    // = new RandomAccessFile("studentDATA.txt", "rw");

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        new Start().setVisible(true);
        /*
         // TODO code application logic here
         RandomAccessFile teacherDATA = new RandomAccessFile("teacherDATA.txt", "rw");
         long CNIC = 3310040;
         //          System.out.println(oop_project.methods.toMYSTRING("hello"));
         System.out.println(teacherDATA.length());

         Teacher n = new Teacher(81, "haseeb", CNIC, "BSSE", "1517");
         //teacherDATA.setLength(0);

         System.out.println(teacherDATA.length());*/

        //Table table = new Table();
//        
//        RandomAccessFile student = new RandomAccessFile("studentID.txt", "rw");
//        //student.setLength(0);
//        //System.out.println(getEnteries());
//        //System.out.println(getEnteries());
//        while (student.getFilePointer() < student.length()) {
//            
//                    
//                    System.out.println (student.readInt());
//                    //System.out.println( student.readUTF());
//                    //System.out.println( student.readLong());
//                    
//                    System.out.println( student.readUTF());
//                    System.out.println(" ");
//                    
//
//                
//        }
        
        Student n = new Student();
        n.deletestudent(0);
    }
/*
    
    public static int getEnteries() {

        int count = 0;
        RandomAccessFile student = null;

        try {
            student = new RandomAccessFile("studentDATA.txt", "rw");
            student.seek(0);
        } catch (Exception ex) {
        }

        try {

            while (true) {
                student.readInt();
                student.readUTF();
                student.readLong();
                student.readUTF();
                count++;
            }

        } catch (Exception e) {
        }
        try {
            student.close();
        } catch (Exception ex) {
        }

        return count;

    }
    */

}
