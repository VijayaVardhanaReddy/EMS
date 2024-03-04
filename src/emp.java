package project;

import javax.swing.*;
//import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class emp extends JFrame implements ActionListener
{
    JLabel background;
    JMenuItem btnApplyLeave,btnUpdateProfile,btnViewSalary,btnChangePwd,btnViewLeave;
    JButton btnlogout;
    JMenu ale,up,vs,cp,vl;
    JMenuBar mb;

    Connection con;
    emp(Connection con){
        this.con = con;
    }

    public emp(String x) {

        /*
        ImageIcon img = new ImageIcon("C:/Users/dell/Downloads/jpimg (1).jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setLayout(new FlowLayout());
        //background.setBounds(300, 150, 500,500);
        setContentPane(background);
        */

        String un = x;
        String digits = un.replaceAll("[^0-9]", "");
        //String digits = extractInt(un);
        int id = Integer.parseInt(digits);
        //System.out.println(id);

        
        ImageIcon img1 = new ImageIcon("C:/Users/dell/Downloads/HRMS-Landing-Banner.png");
        background = new JLabel("", img1, JLabel.CENTER);
        background.setLayout(new FlowLayout());
        //background.setBounds(300, 150, 500,500);
        setContentPane(background);

        JPanel p = new JPanel();
        //p.setBackground(Color.green);
        p.setBounds(0,3,1300,40);
        Color fcolor=new Color(137, 209, 194);
        p.setBackground(fcolor);

        mb = new JMenuBar();
        ale = new JMenu("Leave");
        up = new JMenu("Update Profile");
        vs = new JMenu("View Salary");
        cp = new JMenu("Change Password");

        JLabel name = new JLabel("EMPLOYEE-"+id);
        name.setBounds(4,9,200,20);
        add(name,BorderLayout.EAST);
        name.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        btnApplyLeave = new JMenuItem("Apply");
        btnApplyLeave.setBounds(0,100,100,50);
        btnApplyLeave.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        ale.add(btnApplyLeave);
        btnApplyLeave.addActionListener(this);

        btnViewLeave = new JMenuItem("View Status");
        btnViewLeave.setBounds(400,100,100,50);
        btnViewLeave.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        btnViewLeave.addActionListener(this);
        ale.add(btnViewLeave);

        btnUpdateProfile = new JMenuItem("Update");
        btnUpdateProfile.setBounds(200,100,100,50);
        btnUpdateProfile.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        up.add(btnUpdateProfile);
        btnUpdateProfile.addActionListener(this);

        btnViewSalary = new JMenuItem("View Salary");
        btnViewSalary.setBounds(400,100,100,50);
        btnViewSalary.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        btnViewSalary.addActionListener(this);
        vs.add(btnViewSalary);

        btnChangePwd = new JMenuItem("Change");
        btnChangePwd.setBounds(400,100,100,50);
        btnChangePwd.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        btnChangePwd.addActionListener(this);
        cp.add(btnChangePwd);

        mb.add(up);
        mb.add(vs);
        mb.add(ale);
        mb.add(cp);

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
        // Add action listeners to options buttons
        btnApplyLeave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show form for applying for leave
                JInternalFrame applyLeaveFrame = new JInternalFrame("Apply for Leave",false,true,false,true);
                applyLeaveFrame.setBounds(350,80,500, 500);
                applyLeaveFrame.setLayout(null);
                applyLeaveFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                applyLeaveFrame.setVisible(true);
                //applyLeaveFrame.setBackground(Color.pink);

                JLabel idLabel = new JLabel("ID");
                idLabel.setBounds(100,100,100,30);
                idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                applyLeaveFrame.add(idLabel);

                JTextField idVal = new JTextField(""+id);
                idVal.setEditable(false); 
                idVal.setBounds(250,100,200,30);
                idVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                applyLeaveFrame.add(idVal);
        
                // Add labels and text fields for leave information
                JLabel lblStartDate = new JLabel("Start Date:");
                lblStartDate.setBounds(100,150,100,30);
                lblStartDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                applyLeaveFrame.add(lblStartDate);

                JTextField txtStartDate = new JTextField();
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                txtStartDate.setText(sdf.format(cal.getTime()));
                applyLeaveFrame.add(txtStartDate);
                txtStartDate.setBounds(250,150,220,30);

                //txtStartDate.setBounds(230,100,220,30);
                //txtStartDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                //applyLeaveFrame.add(txtStartDate);

                JLabel lblEndDate = new JLabel("End Date:");
                lblEndDate.setBounds(100,200,100,30);
                lblEndDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                applyLeaveFrame.add(lblEndDate);

                JTextField txtEndDate = new JTextField();
                Calendar cal1 = Calendar.getInstance();
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                txtEndDate.setText(sdf1.format(cal1.getTime()));
                applyLeaveFrame.add(txtEndDate);
                txtEndDate.setBounds(250,200,220,30);

                //txtEndDate.setBounds(230,150,220,30);
                //txtEndDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                //applyLeaveFrame.add(txtEndDate);

                JLabel lblReason = new JLabel("Reason:");
                lblReason.setBounds(100,250,120,30);
                lblReason.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                applyLeaveFrame.add(lblReason);

                JComboBox<String> txtReason = new JComboBox<>(new String[]{"Sick","Duty","Vacation","LOP","Maternity"});
                txtReason.setEditable(true);
                txtReason.setBounds(250,250,200,30);
                txtReason.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                applyLeaveFrame.add(txtReason);

                JButton btnSubmit = new JButton("Save");
                btnSubmit.setBounds(250,400,80, 20);
                btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 17));
                applyLeaveFrame.add(btnSubmit);
                btnSubmit.setBackground(Color.green);

                
                // Add action listener to submit button
                btnSubmit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Get leave information from form

                        String dateString = txtStartDate.getText();
                        LocalDate date = LocalDate.parse(dateString);
                        java.sql.Date sqlDate = java.sql.Date.valueOf(date);
                        
                        String dateString1 = txtEndDate.getText();
                        LocalDate date1 = LocalDate.parse(dateString1);
                        java.sql.Date sqlDate1 = java.sql.Date.valueOf(date1);
                        
                        String reason = (String) txtReason.getSelectedItem();

                        // Insert leave into database
                        try 
                        {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "Vijay@2424");
                            PreparedStatement stmt = con.prepareStatement("INSERT INTO leaves (emp_id, leave_type, start_date, end_date, status) VALUES (?, ?, ?, ?, ?)");
                            stmt.setInt(1, id);
                            stmt.setString(2, reason); 
                            stmt.setDate(3, sqlDate); 
                            stmt.setDate(4, sqlDate1);
                            stmt.setString(5, "Pending");

                            stmt.executeUpdate();
                            con.close();

                            JOptionPane.showMessageDialog(applyLeaveFrame, "Leave applied successfully!");
                            applyLeaveFrame.dispose();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                // Add components to layout
                // Code for adding components to layout goes here
                add(applyLeaveFrame,BorderLayout.CENTER);
            }
        });

        btnUpdateProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                JInternalFrame updateEmployeeFrame = new JInternalFrame("Edit Employee",false,true,false,true);
                updateEmployeeFrame.setLayout(null);
                updateEmployeeFrame.setBounds(350,70,600, 550);
                updateEmployeeFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                updateEmployeeFrame.setVisible(true);
                //updateEmployeeFrame.setBackground(Color.pink);
                //updateEmployeeFrame.setSize(1000, 600);

                /*
                JPanel jp = new JPanel(new BorderLayout(0, 0));
                JLabel jl = new JLabel("Enter Id!");
                jl.setFont(new Font("Arial", Font.BOLD, 16));
                jp.add(jl, BorderLayout.NORTH);
                */

                //String enterid = JOptionPane.showInputDialog(null,jp);
                //----(1)

                        //int id = Integer.parseInt(enterid);
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
                        idVal.setEditable(false); 
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
                        designationVal.setEditable(false); 
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


        btnViewSalary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String dbName = "ems";
                    String db_username = "root";
                    String db_password = "Vijay@2424";
                    Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/"+dbName, db_username, db_password);

                    Statement stmt = null;
                    stmt = con.createStatement();
                    String s = ("select amount from salary where emp_id="+id);
                    ResultSet rs = stmt.executeQuery(s);
                    if(rs.next())
                    {
                        JOptionPane.showMessageDialog(emp.this,"Your Salary: "+rs.getString(1));
                    }
                    con.close();
                }
                catch (Exception ex) 
                {
                    JOptionPane.showMessageDialog(emp.this, "NO salary added");
                    ex.printStackTrace();
                }
            }
        });

        btnChangePwd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JInternalFrame changepwdFrame = new JInternalFrame("Change Password",false,true,false,true);
                changepwdFrame.setBounds(370,100,400, 350);
                changepwdFrame.setLayout(null);
                changepwdFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                changepwdFrame.setVisible(true);
                //changepwdFrame.setBackground(Color.pink);


                JLabel lblUsername = new JLabel("Username: ");
                lblUsername.setBounds(100,120,100,20);
                lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 17));
                changepwdFrame.add(lblUsername);

                JTextField txtUsername = new JTextField(un);
                txtUsername.setEditable(false);
                txtUsername.setBounds(200,120,100,20);
                txtUsername.setFont(new Font("Times New Roman", Font.PLAIN, 17));
                changepwdFrame.add(txtUsername);

                JLabel lblPassword = new JLabel("Password: ");
                lblPassword.setBounds(100,170,150,20);
                lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 17));
                changepwdFrame.add(lblPassword);

                JPasswordField txtPassword = new JPasswordField(15);
                txtPassword.setBounds(200,170,100,20);
                txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 17));
                changepwdFrame.add(txtPassword);

                JButton Save = new JButton("Save");
                Save.setBounds(200,250,80, 30);
                Save.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                changepwdFrame.add(Save);
                Save.setBackground(Color.green);

                Save.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Get employee information from form
                        char[] pwd = txtPassword.getPassword();
                        String newpwd = String.valueOf(pwd);

                        // Insert employee information into database
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            String dbName = "ems";
                            String db_username = "root";
                            String db_password = "Vijay@2424";
                            Connection con= DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/"+dbName, db_username, db_password);

                            //Statement stmt = con.createStatement();

                            PreparedStatement stmt = con.prepareStatement("UPDATE users SET password = ? WHERE username = ?");
                            
                            stmt.setString(1, newpwd);
                            stmt.setString(2, un);
                            stmt.executeUpdate();

                            con.close();
                            JOptionPane.showMessageDialog(changepwdFrame, "Password Changed Successfully");
                            changepwdFrame.dispose();
                        } 
                        catch (Exception ex) 
                        {
                            ex.printStackTrace();
                        }
                      }
                   });
                   add(changepwdFrame,BorderLayout.CENTER);
                   changepwdFrame.setVisible(true);
            }
        });

        btnViewLeave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JFrame ALFrame = new JFrame("Approve");
                ALFrame.setSize(600, 400);
                ALFrame.setLocationRelativeTo(null);
                ALFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        //setLayout(new BorderLayout());

                JTable tableLeave1 = new JTable();

                            // Create a table model
                DefaultTableModel Model = new DefaultTableModel();
                Model.setColumnIdentifiers(new String[] {"Leave_ID","Employee_ID","Leave_Type","Start_Date","End_Date","Status"});
                tableLeave1.setModel(Model);
                JScrollPane scrollPane = new JScrollPane(tableLeave1);
                ALFrame.add(scrollPane, BorderLayout.CENTER);
                            // Connect to the database and retrieve data
                        try {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "Vijay@2424");
                                Statement stmt = con.createStatement();
                                ResultSet rs = stmt.executeQuery("SELECT * FROM leaves");
                                
                                while (rs.next()) 
                                {
                                    Model.addRow(new Object[] {rs.getInt(6),rs.getInt(1) , rs.getString(2) ,rs.getDate(3) , rs.getDate(4), rs.getString(5)});
                                }
                                con.close();
                            } 
                            catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            ALFrame.setVisible(true);
                /*
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String dbName = "ems";
                    String db_username = "root";
                    String db_password = "Vijay@2424";
                    Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/"+dbName, db_username, db_password);

                    Statement stmt = null;
                    stmt = con.createStatement();
                    String s = ("select status,leave_id,start_date,end_date from leaves where emp_id="+id);
                    ResultSet rs = stmt.executeQuery(s);
                    while(rs.next())
                    {
                        JOptionPane.showMessageDialog(emp.this,"Leave: "+rs.getString(2)+rs.getString(1)+rs.getDate(3)+rs.getDate(4));
                    }
                    con.close();
                }
                catch (Exception ex) 
                {
                    ex.printStackTrace();
                }
                */
            }
        });

        // Add components to options panel
        // Code for adding components to options panel goes here

        // Show options panel
        setSize(1300,750);
        setLayout(null);
        setTitle("Welcome Employee");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /*
    public String extractInt(String un)
    {
        String str = un.replaceAll("[^0-9]", " ");
        str = str.replaceAll(" +", " ");

        if (str.equals(""))
            return "-1";
        return str;
    }
    */

    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        
    }
    public static void main(String username) throws SQLException, ClassNotFoundException
    {
        new emp(username);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // TODO Auto-generated method stub
    }
}
