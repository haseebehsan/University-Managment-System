package oop_project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Haseeb
 */
public class Teacher extends Employee {

    String Qualification;
    long CNIC;
    String password;
    long pointer;

    Teacher() {

    }

    Teacher(long pointer) throws FileNotFoundException, IOException {
        //super(.seek(pointer), );
        this.pointer = pointer;
        RandomAccessFile teacherDATA = new RandomAccessFile("teacherDATA.txt", "rw");

        teacherDATA.seek(pointer);
        this.ID = teacherDATA.readInt();
        this.NAME = teacherDATA.readUTF();
        this.CNIC = teacherDATA.readLong();
        this.Qualification = teacherDATA.readUTF();

        super.setName(NAME);
        super.setID(ID);
    }

    Teacher(int ID, String Name, long CNIC, String Qualification, String password) throws IOException {
        super(Name, ID);
        this.NAME = toMYSTRING(Name);
        this.ID = ID;
        //System.out.println(toMYSTRING("hello3"));
        this.Qualification = toMYSTRING(Qualification);
        this.CNIC = CNIC;
        this.password = toMYSTRING(password);
        addData();
    }

    long searchByID(int ID) throws FileNotFoundException, IOException {
        long result = 0;
        RandomAccessFile teacherDATA = new RandomAccessFile("teacherDATA.txt", "rw");

        while (teacherDATA.getFilePointer() < teacherDATA.length()) {
            result = teacherDATA.getFilePointer();
            if (teacherDATA.readInt() == ID) {
                break;

            }
            teacherDATA.readUTF();
            teacherDATA.readLong();
            teacherDATA.readUTF();

        }
        return result;
    }

    long searchByNAME(String Name) throws FileNotFoundException, IOException {
        long result = 0;
        RandomAccessFile teacherDATA = new RandomAccessFile("teacherDATA.txt", "rw");

        while (teacherDATA.getFilePointer() < teacherDATA.length()) {

            result = teacherDATA.getFilePointer();
            teacherDATA.readInt();
            if (teacherDATA.readUTF().equals(Name)) {
                break;

            }

            teacherDATA.readLong();
            teacherDATA.readUTF();

        }
        return result;
    }

    void addData() throws FileNotFoundException, IOException {
        //System.out.println(toMYSTRING("hello2"));
        RandomAccessFile teacherID = new RandomAccessFile("teacherID.txt", "rw");
        teacherID.seek(teacherID.length());

        teacherID.writeInt(this.ID);
        teacherID.writeUTF(this.password);

        RandomAccessFile teacherDATA = new RandomAccessFile("teacherDATA.txt", "rw");
        teacherDATA.seek(teacherDATA.length());
        teacherDATA.writeInt(this.ID);
        teacherDATA.writeUTF(this.NAME);
        teacherDATA.writeLong(CNIC);
        teacherDATA.writeUTF(this.Qualification);
    }

    Long getCNIC() {
        return this.CNIC;
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

    void deleteteacher(long byteindex) throws FileNotFoundException, IOException {
        //public void delete(long byteindex) throws FileNotFoundException, IOException {
        RandomAccessFile DeletingStudent = new RandomAccessFile("teacherDATA.txt", "rw");
        if (DeletingStudent.length() == 46) {
            System.out.println("hahaha");
            DeletingStudent.setLength(0);
        } else {

            long NextStudentsData_StartingByteValue = byteindex + 46;
            RandomAccessFile NextReplacingStudent = new RandomAccessFile("teacherDATA.txt", "rw");

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
        }/*(long byteindex) throws FileNotFoundException, IOException {
         //public void delete(long byteindex) throws FileNotFoundException, IOException {
         RandomAccessFile DeletingTeacher = new RandomAccessFile("teacherDATA.txt", "rw");
         long NextTeachersData_StartingByteValue = byteindex + 34;
         RandomAccessFile NextReplacingTeacher = new RandomAccessFile("teacherDATA.txt", "rw");

         DeletingTeacher.seek(byteindex);
         NextReplacingTeacher.seek(NextTeachersData_StartingByteValue);

         while (DeletingTeacher.getFilePointer() < DeletingTeacher.length()) {

         if (NextReplacingTeacher.getFilePointer() == DeletingTeacher.length()) {
         break;
         }

         DeletingTeacher.writeInt(NextReplacingTeacher.readInt());
         DeletingTeacher.writeUTF(NextReplacingTeacher.readUTF());
         DeletingTeacher.writeLong(NextReplacingTeacher.readLong());
         DeletingTeacher.writeUTF(NextReplacingTeacher.readUTF());

         }
         DeletingTeacher.setLength(DeletingTeacher.getFilePointer());        //decreases the length of file because of deletion

         //System.out.println("Teacher commanded is seccessfully deleted from the record...");
         //RecordManagmentMenu();
         //}
         }*/
    }
    }
