import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.util.*;
import java.sql.*;
public class login extends Frame implements ActionListener
{
  
   JButton btnLogin=new JButton("Login");
   JButton btnCancel=new JButton("Cancel");
   
   TextField txtUsername=new TextField(30);
   //TextField txtPassword=new TextField(30);
   JPasswordField passwordField=new JPasswordField(20);
   
   JLabel lblpic=new JLabel();
   char[] password;
   
public login()
{
  setLayout(null);
  setTitle("");
  setVisible(true);
 //********************TO OPEN THE FRAME IN THE CENTER**************
  Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
  int height=screenSize.height;
  int width=screenSize.width;
  setSize((width/2)-225,(height/2)-50);
  setLocationRelativeTo(null);
 //****************************************************************
  lblpic.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/login1.jpg"));
 
  lblpic.setBounds(10,10,570,350);  
  txtUsername.setBounds(198,144,148,25);
 passwordField.setBounds(198,175,148,25);
  btnLogin.setBounds(146,220,85,25);
  btnCancel.setBounds(244,220,85,25);
   
  add(lblpic);
  add(txtUsername);
  add(passwordField);
  add(btnLogin);
  add(btnCancel); 
 
 
  passwordField.setFont(new java.awt.Font("Arial",Font.BOLD,20));
  //passwordField.setBackground(Color.YELLOW);
  passwordField.setForeground(Color.BLUE);  
  btnLogin.addActionListener(this);
  btnCancel.addActionListener(this);    
  
}
public void actionPerformed(ActionEvent e)
{

  if(e.getSource()==btnCancel)
  {
    System.exit(0);
  }
  if(e.getSource()==btnLogin)
  {
   try
   {
     password=passwordField.getPassword();
   for(char c:password)
   {
    System.out.println(""+c);
   }
  passwordField.selectAll();
  //passwordField.setEchoChar('*');
    Connection con;
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    int ctr=0;
    String str="";
    char[] correctPass;
    // Arrays.fill(correctPass,'0');
    ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("select *from logintbl");
  
   while(res.next())
   {
      
      str=""+res.getString(2);
   }
  correctPass=str.toCharArray();
 
   if (Arrays.equals(password,correctPass))
    {
     ctr++;
    }
    ResultSet res1;
    Statement st1=con.createStatement();
    res1=st1.executeQuery("select *from logintbl where username='"+txtUsername.getText()+"'");
   
   while(res1.next())
   {
      
      ctr++;
   }
   if(ctr==2)
    {
    JOptionPane.showMessageDialog(null,"Welcome To Institute Management");
     MenuD obj=new MenuD();
    }
    
    else
    {
      JOptionPane.showMessageDialog(null,"Wrong UserID And Password");
   
 }

  }
  catch(Exception X)
  {
     System.out.println("Exception :"+X);
  }

}

 }
public static void main(String argv[])
throws IOException
{
login obj=new login();

}
}  
  

    
   
   
  
  
       
