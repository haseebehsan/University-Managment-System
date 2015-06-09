/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.RandomAccessFile;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Haseeb
 */
public class StudentsTable {
    
    private JTable table;
    private RandomAccessFile student = null;
    private JFrame Frame;
    private JScrollPane scrlBar;
    private methods methods;
    private JButton btn;
    
    public StudentsTable() {
        
        Frame = new JFrame();
        
        Frame.setTitle("All Students");
        Frame.setSize(600, 600);
        Frame.setResizable(false);
        Frame.setLocationRelativeTo(null);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setLayout(new BorderLayout(0, 0));
        
        methods = new methods();
        
        JTable();
        
        JPanel pane = new JPanel();
        pane.setVisible(true);
        pane.setBounds(0, 0, 200, 600);
        JButton back = new JButton("close");
        back.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.dispose();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        
        JButton delete = new JButton("Delete a student");
        delete.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                new deleteStudent().setVisible(true);
                Frame.dispose();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        pane.add(delete);
        pane.add(back);
        pane.setLayout(new FlowLayout());
        
        Frame.add(pane, BorderLayout.SOUTH);
        //Frame.add(btn);

        Frame.setVisible(true);
        
    }
    
    private void JTable() {
        
        int rows = getEnteries();
        //System.out.println(rows);

        try {
            student = null;
            student = new RandomAccessFile("studentDATA.txt", "rw");
        } catch (Exception ex) {
        }
        
        String[] colums = {"ID", "NAME", "CNIC", "DESCIPLINE"};
        
        String[][] data = new String[rows][4];
        
        for (int i = 0; i < rows; i++) {

            //for (int j = 0; j < 4; j++) {
            try {
                
                data[i][0] = methods.remove_spaces(student.readInt() + " ");
                data[i][1] = methods.remove_spaces(student.readUTF());
                data[i][2] = methods.remove_spaces(student.readLong() + " ");
                data[i][3] = methods.remove_spaces(student.readUTF());
                
            } catch (Exception ex) {
            }

            //}
        }
        
        try {
            student.close();
        } catch (Exception ex) {
        }
        
        table = new JTable(data, colums);
        table.setEnabled(false);
        
        table.setBounds(0, 0, 600, 400);
        table.setVisible(true);
        scrlBar = new JScrollPane(table);
        scrlBar.setBounds(0, 0, 600, 400);
        Frame.add(scrlBar, BorderLayout.NORTH);
        
    }
    
    private int getEnteries() {
        
        int count = 0;
        student = null;
        
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
}
