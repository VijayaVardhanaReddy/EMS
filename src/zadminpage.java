package project;

import javax.swing.*;
//import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class zadminpage extends JFrame implements ActionListener
{
    Connection con;
    zadminpage(Connection con){
        this.con = con;
    }
    // Declare components
    JLabel background;
    JTable tableEmployees,tableLeave;
    JMenuItem btnAdd, btnDelete, btnUpdate, btnView, btnAddSalary, btnNewReg, btnApproveLeave;
    JButton btnlogout;
    JMenu a,d,u,v,as,n,al;
    JMenuBar mb;

    public zadminpage()
    {

        mb = new JMenuBar();
        a = new JMenu("Add Employee");
        d = new JMenu("Delete Employee");
        u = new JMenu("Update Employee");
        v = new JMenu("View Employee");
        as = new JMenu("Add Salary");
        n = new JMenu("Regitration");
        al = new JMenu("Leaves");


        /*
        ImageIcon img = new ImageIcon("C:/Users/dell/Downloads/jpimg (1).jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setLayout(new FlowLayout());
        //background.setBounds(300, 150, 500,500);
        setContentPane(background);
        */

        /*
        JPanel p1 = new JPanel();
        p1.setBackground(Color.lightGray);
        p1.setBounds(3,5,1250,80);
        */
        JPanel p = new JPanel();
        //p.setBackground(Color.green);
        p.setBounds(0,3,1300,40);
        Color fcolor=new Color(137, 209, 194);

        //Color color=new Color(0, 97, 195);
        p.setBackground(fcolor);

        JLabel adminname = new JLabel("HR Manager");
        adminname.setBounds(4,9,200,25);
        adminname.setBackground(Color.BLACK);
        add(adminname,BorderLayout.EAST);
        adminname.setFont(new Font("Georgia", Font.PLAIN, 20));

        //add(p1);

        // Initialize components
        tableEmployees = new JTable();
        tableLeave = new JTable();

        btnAdd = new JMenuItem("Add");
        btnAdd.setBounds(20,30,60, 20);
        btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        //btnAdd.setBackground(Color.pink);
        a.add(btnAdd);
        btnAdd.addActionListener(this);

        btnDelete = new JMenuItem("Delete");
        btnDelete.setBounds(80,30,60, 20);
        btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        d.add(btnDelete);
        btnDelete.addActionListener(this);

        btnUpdate = new JMenuItem("Update");
        btnUpdate.setBounds(220,30,60, 20);
        btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        u.add(btnUpdate);
        btnUpdate.addActionListener(this);

        btnView =new JMenuItem("View");
        btnView.setBounds(320,30,60, 20);
        btnView.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        v.add(btnView);
        btnView.addActionListener(this);

        btnAddSalary = new JMenuItem("Salary");
        btnAddSalary.setBounds(420,30,60, 20);
        btnAddSalary.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        as.add(btnAddSalary);
        btnAddSalary.addActionListener(this);

        btnNewReg = new JMenuItem("New Registration");
        btnNewReg.setBounds(520,30,60, 20);
        btnNewReg.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        n.add(btnNewReg);
        btnNewReg.addActionListener(this);

        btnApproveLeave = new JMenuItem("Approve Leave");
        btnApproveLeave.setBounds(220,50,60, 20);
        btnApproveLeave.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        al.add(btnApproveLeave);
        btnApproveLeave.addActionListener(this);

        
        mb.add(a);
        mb.add(d);
        mb.add(u);
        mb.add(v);
        mb.add(as);
        mb.add(n);
        mb.add(al);
        
        p.add(mb);
        //setJMenuBar(mb);
        add(p);


        btnlogout = new JButton("Log-out");
        btnlogout.setBounds(1150,10,100,21);
        btnlogout.setBackground(Color.orange);
        btnlogout.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnlogout.addActionListener(this);
        p.add(btnlogout,BorderLayout.EAST);

        btnlogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(btnlogout, "Are you sure?");
                JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    zjpLogin obj = new zjpLogin();
                    obj.setTitle("Login");
                    obj.setVisible(true);
                }
            }
        });

        // Add action listeners to buttons
        btnAdd.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // Show form for adding an employee
                JInternalFrame addEmployeeFrame = new JInternalFrame("Add Employee",false,true,false,true);
                addEmployeeFrame.setBounds(350,80,550, 550);
                addEmployeeFrame.setLayout(null);
                addEmployeeFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                addEmployeeFrame.setVisible(true);
                //addEmployeeFrame.setBackground(Color.pink);
                //addEmployeeFrame.setSize(1000, 600);

                // Add labels and text fields for employee information
                JLabel idLabel = new JLabel("Enter ID");
                idLabel.setBounds(100,100,220,30);
                idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                addEmployeeFrame.add(idLabel);

                JTextField idVal = new JTextField("");
                idVal.setBounds(250,100,200,30);
                idVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                addEmployeeFrame.add(idVal);

                idVal.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                        e.consume();  // if it's not a number, ignore the event
                    }
                }
            }); 
                JLabel lblName = new JLabel("Name:");
                lblName.setBounds(100,150,100,30);
                lblName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                addEmployeeFrame.add(lblName);  

                JTextField txtName = new JTextField();
                txtName.setBounds(250,150,200,30);
                txtName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                addEmployeeFrame.add(txtName);

                JLabel lblEmail = new JLabel("Email:");
                lblEmail.setBounds(100,200,100,30);
                lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                addEmployeeFrame.add(lblEmail);

                JTextField txtEmail = new JTextField();
                txtEmail.setBounds(250,200,200,30);
                txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                addEmployeeFrame.add(txtEmail);

                JLabel genderLabel = new JLabel("Gender");
                genderLabel.setBounds(100,250,100,30);
                genderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                addEmployeeFrame.add(genderLabel);

                JComboBox<String> genderVal = new JComboBox<>(new String[]{"Male", "Female"});
                genderVal.setBounds(250,250,200,30);
                genderVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                addEmployeeFrame.add(genderVal);
                
                
                JLabel phoneLabel = new JLabel("Ph No");
                phoneLabel.setBounds(100,300,100,30);
                phoneLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                addEmployeeFrame.add(phoneLabel);

                JTextField phoneVal = new JTextField("");
                phoneVal.setBounds(250,300,200,30);
                phoneVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                addEmployeeFrame.add(phoneVal);
                phoneVal.addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                            e.consume();  // if it's not a number, ignore the event
                        }
                    }
                }); 

                JLabel designationLabel = new JLabel("Designation");
                designationLabel.setBounds(100,350,100,30);
                designationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                addEmployeeFrame.add(designationLabel);

                JTextField designationVal = new JTextField("");
                designationVal.setBounds(250,350,200,30);
                designationVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                addEmployeeFrame.add(designationVal);
                
                JButton btnSave = new JButton("Save");
                btnSave.setBounds(250,400,100, 30);
                btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                addEmployeeFrame.add(btnSave);
                btnSave.setBackground(Color.green);

                JButton backButton = new JButton("Back");
                backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                backButton.setBounds(100, 400, 100,30);
                addEmployeeFrame.add(backButton);


                backButton.addActionListener(actionListener -> {
                    addEmployeeFrame.dispose();
                    setVisible(true);
                });

                // Add action listener to save button
                btnSave.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Get employee information from form
                        int id = Integer.parseInt(idVal.getText());
                        String name = txtName.getText();
                        String email = txtEmail.getText();
                        String gender = (String) genderVal.getSelectedItem();
                        String phoneNum = phoneVal.getText();
                        String designation = designationVal.getText();

                        // Insert employee information into database
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            String dbName = "ems";
                            String db_username = "root";
                            String db_password = "Vijay@2424";
                            Connection con= DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/"+dbName, db_username, db_password);

                            //Statement st = con.createStatement();
                            PreparedStatement stmt = con.prepareStatement("INSERT INTO employees (id, name, email, gender, phoneNum, designation) VALUES (?, ?, ?, ?, ?, ?)");
                            stmt.setInt(1, id);
                            stmt.setString(2, name);
                            stmt.setString(3, email);
                            stmt.setString(4, gender);
                            stmt.setString(5, phoneNum);
                            stmt.setString(6, designation);
                            stmt.executeUpdate();
                            
                            //String s = "insert into salary(emp_id) values(emp_id="+id+")";
                            //st.executeUpdate(s);
                            PreparedStatement stmt2 = con.prepareStatement("INSERT INTO salary (emp_id,amount) VALUES (?,?)");
                            stmt2.setInt(1, id);
                            stmt2.setDouble(2, 0);
                            stmt2.executeUpdate();

                            con.close();
                            JOptionPane.showMessageDialog(addEmployeeFrame, "Employee added successfully!");
                            addEmployeeFrame.dispose();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                // Add components to layout
                // Code for adding components to layout goes here
                //add(new JScrollPane(addEmployeeFrame));
                addEmployeeFrame.setVisible(true);
                add(addEmployeeFrame,BorderLayout.CENTER);
                
            }
        });



        
        
        btnDelete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    JPanel jp = new JPanel(new BorderLayout(0, 0));
                    JLabel jl = new JLabel("Enter Id!");
                    jl.setFont(new Font("Arial", Font.BOLD, 16));
                    jp.add(jl, BorderLayout.NORTH);

                    String enterid = JOptionPane.showInputDialog(null,jp);

                    //submitButton.addActionListener(actionEvent -> {
                    int id = Integer.parseInt(enterid);
                    Statement statement = null;
                    //Statement statement1 = null;

                    try 
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        String dbName = "ems";
                        String db_username = "root";
                        String db_password = "Vijay@2424";
                        Connection con= DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/"+dbName, db_username, db_password);

                        statement = con.createStatement();
                        //--(4)
                        String q = String.format("select * from employees where id = %d;", id);
                        ResultSet resultSet = statement.executeQuery(q);
                        if (resultSet.next())
                        {
                            //System.out.println(resultSet.getString(2));

                            String deleteQuery = String.format("delete from employees where id = %d;", id);
                            statement.executeUpdate(deleteQuery);
                            setVisible(true);
                            con.close();
                            JOptionPane.showMessageDialog(null, "Employee deleted successfully!");
                            //frame.dispose();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Invaild Id");
                        }
                    }
                    catch (SQLException throwables) 
                    {
                        throwables.printStackTrace();
                    }
                    catch (Exception ex) 
                    {
                        ex.printStackTrace();
                    }
                    
                    /*
                    try 
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        String dbName = "ems";
                        String db_username = "root";
                        String db_password = "Vijay@2424";
                        Connection con= DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/"+dbName, db_username, db_password);

                        statement1 = con.createStatement();
                        String q1 = String.format("select * from salary where emp_id = %d;", id);
                        ResultSet resultSet1 = statement.executeQuery(q1);
                        if(resultSet1.next())
                        {
                            //System.out.println(resultSet1.getString(2));

                            String deleteQuery = String.format("delete from salary where emp_id = %d;", id);
                            statement1.executeUpdate(deleteQuery);
                            setVisible(true);
                            con.close();
                            JOptionPane.showMessageDialog(null, "Employee deleted successfully!");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Invaild Id");
                        }
                    }
                    catch (SQLException throwables) 
                    {
                        throwables.printStackTrace();
                    }
                    catch (Exception ex) 
                    {
                        ex.printStackTrace();
                    }
                    */

                  //});
            }
        });





    btnUpdate.addActionListener(new ActionListener() 
    {
            public void actionPerformed(ActionEvent e) 
            {
                JInternalFrame updateEmployeeFrame = new JInternalFrame("Edit Employee",false,true,false,true);
                updateEmployeeFrame.setLayout(null);
                updateEmployeeFrame.setBounds(350,70,600, 550);
                updateEmployeeFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                updateEmployeeFrame.setVisible(true);
                //updateEmployeeFrame.setBackground(Color.pink);
                //updateEmployeeFrame.setSize(1000, 600);

                JPanel jp = new JPanel(new BorderLayout(0, 0));
                JLabel jl = new JLabel("Enter Id!");
                jl.setFont(new Font("Arial", Font.BOLD, 16));
                jp.add(jl, BorderLayout.NORTH);

                String enterid = JOptionPane.showInputDialog(null,jp);
                //----(1)

                        int id = Integer.parseInt(enterid);
                        Statement statement = null;
                        try 
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            String dbName = "ems";
                            String db_username = "root";
                            String db_password = "Vijay@2424";
                            Connection con= DriverManager.getConnection(
                                        "jdbc:mysql://localhost:3306/"+dbName, db_username, db_password);
                            statement = con.createStatement();

                        String q = String.format("select * from employees where id = %d;",id);
                        ResultSet resultSet = statement.executeQuery(q);
                        resultSet.next();
                        // Add labels and text fields for employee information

                        
                        JLabel idLabel = new JLabel("ID");
                        idLabel.setBounds(100,100,100,30);
                        idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        updateEmployeeFrame.add(idLabel);

                        JTextField idVal = new JTextField(resultSet.getString(1));
                        idVal.setEditable(true); 
                        idVal.setBounds(250,100,200,30);
                        idVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        updateEmployeeFrame.add(idVal);

                        JLabel lblName = new JLabel("Name:");
                        lblName.setBounds(100,150,100,30);
                        lblName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        updateEmployeeFrame.add(lblName);

                        JTextField txtName = new JTextField(resultSet.getString(2));
                        txtName.setEditable(true);
                        txtName.setBounds(250,150,200,30);
                        txtName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        updateEmployeeFrame.add(txtName);

                        JLabel lblEmail = new JLabel("Email:");
                        lblEmail.setBounds(100,200,100,30);
                        lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        updateEmployeeFrame.add(lblEmail);

                        JTextField txtEmail = new JTextField(resultSet.getString(3));
                        txtEmail.setEditable(true);
                        txtEmail.setBounds(250,200,200,30);
                        txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        updateEmployeeFrame.add(txtEmail);

                        JLabel genderLabel = new JLabel("Gender");
                        genderLabel.setBounds(100,250,100,30);
                        genderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        updateEmployeeFrame.add(genderLabel);


                        String gender = resultSet.getString(4);
                        JComboBox<String> genderVal = new JComboBox<>(new String[]{"Male", "Female"});
                        genderVal.setSelectedIndex(gender.equals("Male") ? 1 : 0 );
                        genderVal.setEditable(true);
                        genderVal.setBounds(250,250,200,30);
                        genderVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        updateEmployeeFrame.add(genderVal);
                        
                        
                        JLabel phoneLabel = new JLabel("Ph No");
                        phoneLabel.setBounds(100,300,100,30);
                        phoneLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        updateEmployeeFrame.add(phoneLabel);

                        JTextField phoneVal = new JTextField(resultSet.getString(5));
                        phoneVal.setEditable(true);
                        phoneVal.setBounds(250,300,200,30);
                        phoneVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        updateEmployeeFrame.add(phoneVal);
                        phoneVal.addKeyListener(new KeyAdapter() {
                            public void keyTyped(KeyEvent e) {
                                char c = e.getKeyChar();
                                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                                    e.consume();  // if it's not a number, ignore the event
                                }
                            }
                        }); 

                        JLabel designationLabel = new JLabel("Designation");
                        designationLabel.setBounds(100,350,100,30);
                        designationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        updateEmployeeFrame.add(designationLabel);

                        JTextField designationVal = new JTextField(resultSet.getString(6));
                        designationVal.setEditable(true); 
                        designationVal.setBounds(250,350,200,30);
                        designationVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        updateEmployeeFrame.add(designationVal);

                        JButton Save = new JButton("Save");
                        Save.setBounds(250,400,80, 30);
                        Save.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        updateEmployeeFrame.add(Save);
                        Save.setBackground(Color.green);

                        JButton backButton = new JButton("Back");
                        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        backButton.setBounds(100, 400, 80,30);
                        updateEmployeeFrame.add(backButton);


                        backButton.addActionListener(actionListener -> {
                            updateEmployeeFrame.dispose();
                            setVisible(true);
                        });

                // Add action listener to save button
                Save.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Get employee information from form
                        int id = Integer.parseInt(idVal.getText());
                        String name = txtName.getText();
                        String email = txtEmail.getText();
                        String gender = (String) genderVal.getSelectedItem();
                        String phoneNum = phoneVal.getText();
                        String designation = designationVal.getText();

                        // Insert employee information into database
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            String dbName = "ems";
                            String db_username = "root";
                            String db_password = "Vijay@2424";
                            Connection con= DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/"+dbName, db_username, db_password);

                            //Statement stmt = con.createStatement();

                            PreparedStatement stmt = con.prepareStatement("UPDATE employees SET name = ?, email = ?, gender = ?, phoneNum = ?, designation = ? WHERE id = ?");
                            stmt.setString(1, name);
                            stmt.setString(2, email);
                            stmt.setString(3, gender);
                            stmt.setString(4, phoneNum);
                            stmt.setString(5, designation);
                            stmt.setInt(6, id);

                            stmt.executeUpdate();

                            con.close();
                            JOptionPane.showMessageDialog(updateEmployeeFrame, "Employee details updated successfully!");
                            updateEmployeeFrame.dispose();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                      }
                   });
              }
              catch (Exception ex) 
              {
                  ex.printStackTrace();
              }
             //}
          //});
                // Add components to layout
                // Code for adding components to layout goes here
                add(updateEmployeeFrame,BorderLayout.CENTER);
                updateEmployeeFrame.setVisible(true);
        }
    });



    btnAddSalary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JInternalFrame addSalFrame = new JInternalFrame("Add Salary",false,true,false,true);
                addSalFrame.setLayout(null);
                addSalFrame.setBounds(350,80,600, 300);
                addSalFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                //addSalFrame.setBackground(Color.pink);

                JPanel jp = new JPanel(new BorderLayout(0, 0));
                JLabel jl = new JLabel("Enter Id!");
                jl.setFont(new Font("Arial", Font.BOLD, 16));
                jp.add(jl, BorderLayout.NORTH);

                String enterid = JOptionPane.showInputDialog(null,jp);
                // Show form for adding salary
                //--(3)
                int id = Integer.parseInt(enterid);
                try{
                //submit.addActionListener(new ActionListener() {
                    //public void actionPerformed(ActionEvent e) {

                        //addSalFrame.setSize(800, 600);

                        JLabel lblAmount = new JLabel("Amount:");
                        lblAmount.setBounds(100,100,120,30);
                        lblAmount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        addSalFrame.add(lblAmount);

                        JTextField Amountval = new JTextField("");
                        Amountval.setBounds(250,100,220,30);
                        Amountval.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        addSalFrame.add(Amountval);

                        JButton btnSave = new JButton("Save");
                        btnSave.setBounds(300,200,100, 50);
                        btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        addSalFrame.add(btnSave);
                        btnSave.setBackground(Color.green);

                        JButton backBtn = new JButton("Back");
                        backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                        backBtn.setBounds(150, 200, 100,50);
                        addSalFrame.add(backBtn);
                   


                        backBtn.addActionListener(actionListener -> {
                            addSalFrame.dispose();
                            setVisible(true);
                        });

                        btnSave.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                // Get employee information from form
                                double amount = Double.parseDouble(Amountval.getText());
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                String dbName = "ems";
                                String db_username = "root";
                                String db_password = "Vijay@2424";
                                Connection con= DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/"+dbName, db_username, db_password);
                                
        
                                // Insert employee information into database
                                PreparedStatement stmt = con.prepareStatement("update salary set amount=? where emp_id=?");
                                stmt.setInt(2, id);
                                stmt.setDouble(1, amount);
                                stmt.executeUpdate();
                                con.close();
                                
                                JOptionPane.showMessageDialog(addSalFrame, "Employee Salary updated successfully!");
                                addSalFrame.dispose();
                                
                            }
                        catch (Exception ex) 
                        {
                            ex.printStackTrace();
                        }
                       }
                     });
                   //}
                 //});

                // Add action listener to save button
                // Add components to layout
                // Code for adding components to layout goes here
                //add(addSalaryFrame,BorderLayout.CENTER);
                //addSalaryFrame.setVisible(true);
                }
                catch (Exception ex) 
                {
                    ex.printStackTrace();
                }
                add(addSalFrame,BorderLayout.CENTER);
                addSalFrame.setVisible(true);
          }
        });

        /*
        */
        

        btnView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create a new JFrame to display the table
                JFrame viewEmployeesFrame = new JFrame("View Employees");
                viewEmployeesFrame.setSize(600, 400);
                viewEmployeesFrame.setLocationRelativeTo(null);
                viewEmployeesFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
                // Create a table model and set it as the model for the table
                DefaultTableModel tableModel = new DefaultTableModel();
                tableModel.setColumnIdentifiers(new String[] {"ID", "Name", "Email", "Gender", "Phone Number", "Designation","SalAmt"});
                tableEmployees.setModel(tableModel);
        
                // Add the table to the frame
                viewEmployeesFrame.add(new JScrollPane(tableEmployees));
        
                // Retrieve employee data from the database and add it to the table model
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "Vijay@2424");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT a.*,b.amount FROM employees a,salary b where a.id=b.emp_id");
                    while (rs.next()) {
                        tableModel.addRow(new Object[] {rs.getInt("id"), rs.getString("name"), rs.getString("email"), 
                                                       rs.getString("gender"), rs.getString("phoneNum"), rs.getString("designation"),rs.getString("amount") });
                    }
                    con.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                // Display the frame
                viewEmployeesFrame.setVisible(true);
            }
        });


        btnApproveLeave.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                        JFrame ALFrame = new JFrame("Approve");
                        ALFrame.setSize(600, 400);
                        ALFrame.setLocationRelativeTo(null);
                        ALFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        //setLayout(new BorderLayout());


                            // Create a table model
                        DefaultTableModel Model = new DefaultTableModel();
                        Model.setColumnIdentifiers(new String[] {"Employee_ID","Leave_Type","Start_Date","End_Date","Status","Leave_ID"});
                        tableLeave.setModel(Model);
                        //ALFrame.add(new JScrollPane(tableLeave));
                            // Connect to the database and retrieve data
                        try {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "Vijay@2424");
                                Statement stmt = con.createStatement();
                                ResultSet rs = stmt.executeQuery("SELECT * FROM leaves");
                                
                                while (rs.next()) 
                                {
                                    Model.addRow(new Object[] {rs.getInt(1) , rs.getString(2) ,rs.getDate(3) , rs.getDate(4), rs.getString(5) , rs.getInt(6)});
                                }
                                con.close();
                            } 
                            catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            //emp_id, leave_type, start_date, end_date, status
                            // Create the table
                            
                            /*
                            tableLeave.setFillsViewportHeight(true);
                            tableLeave.setAutoCreateRowSorter(true);
                            tableLeave.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                            tableLeave.setRowHeight(25);
                            tableLeave.setFont(new Font("Arial", Font.PLAIN, 16));
                            tableLeave.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
                            */
                            tableLeave.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                            tableLeave.getModel().addTableModelListener(tableLeave);
                            
                            
                            // Add the table to the frame
                            JScrollPane scrollPane = new JScrollPane(tableLeave);
                            ALFrame.add(scrollPane, BorderLayout.CENTER);

                            // Add a "Save Changes" button
                            
                            JButton saveButton = new JButton("Save");
                            scrollPane.add(saveButton);
                            saveButton.setBounds(200,200,80, 30);
                            saveButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
                            saveButton.setBackground(Color.green);
                            

                            
                            saveButton.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent e) {
                                try {
                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "Vijay@2424");
                                    PreparedStatement pst = null;
                                    for (int i = 0; i < tableLeave.getRowCount();i++) 
                                    {
                                        int id =  (int) tableLeave.getValueAt(i, 0);
                                        String l_type = (String) tableLeave.getValueAt(i, 1);
                                        Date s_date = (Date) tableLeave.getValueAt(i, 2);
                                        Date e_date = (Date) tableLeave.getValueAt(i, 3);
                                        String status = (String) tableLeave.getValueAt(i, 4);
                                        int Lid = (int) tableLeave.getValueAt(i, 5);

                                        pst = con.prepareStatement("UPDATE leaves SET emp_id=?, leave_type=?, start_date=?, end_date=?, status=? WHERE leave_id=?");

                                        pst.setInt(1, id);
                                        pst.setString(2, l_type);
                                        pst.setDate(3, s_date);
                                        pst.setDate(4, e_date);
                                        pst.setString(5, status);
                                        pst.setInt(6, Lid);
                                        pst.executeUpdate();
                                        }
                                        con.close();
                                        JOptionPane.showMessageDialog(null, "Changes saved successfully!");
                                        ALFrame.dispose();
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                        }
                                }
                            });
                            
                            ALFrame.setVisible(true);
                        }
                    });


        btnNewReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JInternalFrame NewReg = new JInternalFrame("New User",false,true,false,true);
                NewReg.setLayout(null);
                NewReg.setBounds(350,80,500, 370);
                NewReg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                NewReg.setVisible(true);
                //NewReg.setBackground(Color.pink);

                JLabel lblusename = new JLabel("Name");
                lblusename.setBounds(100,100,100,30);
                lblusename.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                NewReg.add(lblusename);

                JTextField txtusename = new JTextField("");
                txtusename.setBounds(230,100,220,30);
                txtusename.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                NewReg.add(txtusename);

                JLabel lblusepwd = new JLabel("Password");
                lblusepwd.setBounds(100,150,100,30);
                lblusepwd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                NewReg.add(lblusepwd);

                JTextField txtusepwd = new JTextField("");
                txtusepwd.setBounds(230,150,220,30);
                txtusepwd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                NewReg.add(txtusepwd);

                JLabel lblemail = new JLabel("Email");
                lblemail.setBounds(100,200,120,30);
                lblemail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                NewReg.add(lblemail);

                JTextField txtrole = new JTextField("");
                txtrole.setBounds(230,200,220,30);
                txtrole.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                NewReg.add(txtrole);

                    JButton btnSave = new JButton("Save");
                    btnSave.setBounds(270,250,100, 30);
                    btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                    btnSave.setBackground(Color.green);
                    NewReg.add(btnSave);

                    JButton backBtn = new JButton("Back");
                    backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                    backBtn.setBounds(150, 250, 100,30);
                    NewReg.add(backBtn);
                   


                        backBtn.addActionListener(actionListener -> {
                            NewReg.dispose();
                            setVisible(true);
                        });

                        btnSave.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                // Get employee information from form
                                String name = txtusename.getText();
                                String pwd = txtusepwd.getText();
                                String role = txtrole.getText();
        
                                // Insert employee information into database
                                try {
                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                    String dbName = "ems";
                                    String db_username = "root";
                                    String db_password = "Vijay@2424";
                                    Connection con= DriverManager.getConnection(
                                    "jdbc:mysql://localhost:3306/"+dbName, db_username, db_password);
                                    //Statement stmt = con.createStatement();
                                    PreparedStatement stmt = con.prepareStatement("INSERT INTO users (username, password, email) VALUES (?, ?, ?)");

                                    stmt.setString(1, name);
                                    stmt.setString(2, pwd);
                                    stmt.setString(3, role);
                                    stmt.executeUpdate();
        
                                    con.close();
                                    JOptionPane.showMessageDialog(NewReg, "Registration done successfully!");
                                    NewReg.dispose();
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });

                        add(NewReg,BorderLayout.CENTER);
                        NewReg.setVisible(true);
            }
        });


                

        /*
        btnApproveLeave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show form for approving leave
                JFrame approveLeaveFrame = new JFrame("Approve Leave");
                approveLeaveFrame.setSize(400, 300);
                approveLeaveFrame.setLocationRelativeTo(null);
                approveLeaveFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                // Add labels and text fields for leave ID and status

                JButton btnSave = new JButton("Save");
                btnSave.setBackground(Color.green);

                // Add action listener to save button
                btnSave.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Get leave ID and updated status from form
                        int leaveId = Integer.parseInt(txtLeaveId.getText());
                        String leaveStatus = txtLeaveStatus.getText();

                        // Update leave status in database
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "password");
                            PreparedStatement stmt = con.prepareStatement("UPDATE leaves SET status = ? WHERE id = ?");
                            stmt.setString(1, leaveStatus);
                            stmt.setInt(2, leaveId);
                            stmt.executeUpdate();
                            con.close();
                            JOptionPane.showMessageDialog(approveLeaveFrame, "Leave status updated successfully!");
                            approveLeaveFrame.dispose();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                // Add components to layout
                // Code for adding components to layout goes here

                approveLeaveFrame.setVisible(true);
            }
        });
        */
        setSize(1280,750);
        setLayout(null);
        setTitle("WELCOME HR-MANEGER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        new zadminpage();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
    }
}