package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class zjpLogin extends JFrame implements ActionListener 
{

    private JLabel lblUsername, lblPassword, heading;
    JTextField txtUsername;
    private JPanel p,p1;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnForgetPassword,btnCancel;

    public zjpLogin() {
        
        setLayout(new FlowLayout());
        
        /*
        ImageIcon img = new ImageIcon("C:/Users/dell/Downloads/pngtre (1).jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setLayout(new FlowLayout());
        //background.setBounds(300, 150, 500,500);
        setContentPane(background);
        */
        p1 = new JPanel();
        p1.setBounds(0,0,1280, 700);
        Color fcolor=new Color(137, 209, 194);
        p1.setBackground(fcolor);

        heading = new JLabel("WELCOME TO EMS");
        heading.setBounds(470,10,400, 250);
        heading.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        add(heading);
        
        //setContentPane(new JLabel(new ImageIcon("C:/Users/dell/OneDrive/Desktop/admin.png")));
        //pack();

        p = new JPanel();
        p.setBounds(450,190,400, 230);
        Color color=new Color(255, 193, 0);
        p.setBackground(color);

        /*
        ImageIcon img1 = new ImageIcon("C:/Users/dell/OneDrive/Desktop/admin.png");
        background = new JLabel(img1);
        background.setBounds(700, 200, img.getIconWidth(), img.getIconHeight());
        //background.setBounds(300, 150, 500,500);
        setContentPane(background);
        */
        
        
        
        lblUsername = new JLabel("Username: ");
        lblUsername.setBounds(470,200,150,30);
        lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(lblUsername);

        txtUsername = new JTextField(15);
        txtUsername.setBounds(610,200,200,30);
        txtUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(txtUsername);

        lblPassword = new JLabel("Password: ");
        lblPassword.setBounds(470,250,150,30);
        lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(lblPassword);

        txtPassword = new JPasswordField(15);
        txtPassword.setBounds(610,250,200,30);
        txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(txtPassword);



        btnLogin = new JButton("Login");
        btnLogin.setBounds(610,310,130, 30);
        btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        btnForgetPassword = new JButton("Forget Password");
        btnForgetPassword.setBounds(650,370,130, 30);
        btnForgetPassword.setFont(new Font("Times New Roman", Font.PLAIN, 13));

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(540,370,100, 30);
        btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        
        add(btnLogin);
        add(btnForgetPassword);
        add(btnCancel);

        btnLogin.addActionListener(this);
        btnForgetPassword.addActionListener(this);
        btnCancel.addActionListener(this);

        add(p);
        add(p1);
        //Color color1 = new Color(37, 150, 190);
        //setBackground(color1);
        setSize(1280,700);
        setLayout(null);
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    /*
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            checkCredentials();
        } else if (e.getSource() == btnForgetPassword) {
            forgotPassword();
        }
    }
    */
    Connection con;
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == btnLogin) 
        {
            // Get the entered username and password
            String username = txtUsername.getText();
            char[] password = txtPassword.getPassword();

            // Connect to the database and check the entered credentials
            try 
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String dbName = "ems";
                String db_username = "root";
                String db_password = "xyz";
                Connection conn= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/"+dbName, db_username, db_password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT username FROM users WHERE username='" + username + "' AND password='" + new String(password) + "'");

                if (rs.next())
                {
                    //String role = rs.getString("role");
                    if (username.contains("HR."))
                    {
                        JOptionPane.showMessageDialog(null, "Welcome, " + txtUsername.getText());
                        zadminpage.main(null);
                        dispose();
                    } 
                    else if (username.contains("G.")) 
                    {
                        JOptionPane.showMessageDialog(null, "Welcome, " + txtUsername.getText());
                        JMenuClickEvent.main(null);
                    } 
                    else if (username.contains("EMP.")) 
                    {
                        //JOptionPane.showMessageDialog(null, "Welcome, " + txtUsername.getText());
                        emp.main(username);
                        JOptionPane.showMessageDialog(null, "Welcome, " + txtUsername.getText());
                        dispose();
                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(this, "Invalid role!");
                    }
                } 
                else 
                {
                    JOptionPane.showMessageDialog(this, "Invalid username or password!");
                }
                conn.close();
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        } 
        else if (e.getSource() == btnForgetPassword) 
        {
            forgotPassword();
        }
        else if (e.getSource() == btnCancel)
        {
            Cancelbutton();
        }
    }


    private void forgotPassword() 
    {
        String username = JOptionPane.showInputDialog(this, "Enter your username: ");
        if (username != null) 
        {
            // Code to send a password reset link to the user's email address using the entered username
            // You may use JavaMail API to send the email
            // also you can retrieve email address from your databse using the given username 
        }
    }
    private void Cancelbutton()
    {
        txtUsername.setText("");
        txtPassword.setText("");
        //dispose();
    }
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
    {
        String str = "com.jtattoo.plaf.texture.TextureLookAndFeel";
        UIManager.setLookAndFeel(str);
        new zjpLogin();
    }
}
     




























































































































/*
    private void checkCredentials() {
        // Code to check the entered username and password with the data present in the database

        //First, create a connection to your database
        Connection conn = null;
        try {
            String dbName = "ems";
            String db_username = "root";
            String db_password = "Vijay@2424";
            conn= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/"+dbName, db_username, db_password);
          // Register JDBC driver
          
          // Create a statement
          Statement stmt = conn.createStatement();

          // Execute a query
          ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username = '" + txtUsername.getText() + "' AND password = '" + new String(txtPassword.getPassword()) + "'");

          if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Welcome, " + txtUsername.getText());
          } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
          }

          // Clean-up environment
          rs.close();
          stmt.close();
          conn.close();
        } catch(SQLException se) {
          // Handle errors for JDBC
          se.printStackTrace();
        } catch(Exception e) {
          // Handle errors for Class.forName
          e.printStackTrace();
        } 
        }
        */
