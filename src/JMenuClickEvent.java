
package project;
import javax.swing.*;
//import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;
//import javax.swing.table.DefaultTableModel;

import java.sql.*;
//import java.io.*;
//import java.util.*;

public class JMenuClickEvent implements ActionListener{
    public JFrame f ;
    JMenuBar menuBar; 
    JMenu Employee ,Department , Project,Performance;
    JMenuItem i1,i2,i3,i4,i5;

   
    Connection con;
    JMenuClickEvent(Connection con){
        this.con = con;
    }
    JLabel background;
    JTable tableEmployees;
    JMenu btnAdd, btnDelete, btnUpdate, btnView, btnAddSalary, btnlogout, btnNewReg, btnApproveLeave;
    JMenuBar mb;

    public JMenuClickEvent(){
        tableEmployees = new JTable();
        f =  new JFrame("Emploee Management System");
        f.setSize(1280,750);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuBar = new JMenuBar();
        Employee = new JMenu("Employee");
        Department = new JMenu("Department");
        Project = new JMenu("Project");
        Performance = new JMenu("Performance");
        i1 = new JMenuItem("View Functionalities");
        i3 = new JMenuItem("Add Department to Employee");
        i4 = new JMenuItem("Assign to Employee");
        i5 = new JMenuItem("Performance Details");
        Employee.add(i1);
        Department.add(i3);
        Project.add(i4);
        Performance.add(i5);
        i1.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);
        i5.addActionListener(this);
        i1.setActionCommand("view");
        i3.setActionCommand("Add");
        i4.setActionCommand("Assign");
        i5.setActionCommand("performance");
        menuBar.add(Employee);
        menuBar.add(Department);
        menuBar.add(Project);
        menuBar.add(Performance);
        f.setJMenuBar(menuBar);
        f.setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand()=="view"){
            // JOptionPane.showMessageDialog(f,"hello","Alert",JOptionPane.WARNING_MESSAGE);
            EmployeeInformation pro=new EmployeeInformation();
            pro.dis();  

        }
        if(e.getActionCommand()=="Add"){
            System.out.println("0");
            new AddDept();
        }
        if(e.getActionCommand()=="Assign"){
            AddProject add = new AddProject();
            add.Dis();
        }
        if(e.getActionCommand()=="performance"){
            new ViewPeformance();
        }
        

    }
        
    public static void main(String args[]) throws Exception{
        String str = "com.jtattoo.plaf.texture.TextureLookAndFeel";
        UIManager.setLookAndFeel(str);
        new JMenuClickEvent(); 
    }
}