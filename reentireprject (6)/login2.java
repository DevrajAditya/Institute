import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.sql.*;
public class login2 extends Frame implements ActionListener
{
  
   JButton btnLogin=new JButton("Login");
   JButton btnCancel=new JButton("Cancel");
   
   TextField txtUsername=new TextField(30);
   TextField txtPassword=new TextField(30);
   
   JLabel lblpic=new JLabel();
  
   
public login2()
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
  txtPassword.setBounds(198,175,148,25);
  btnLogin.setBounds(146,220,85,25);
  btnCancel.setBounds(244,220,85,25);
   
  add(lblpic);
  add(txtUsername);
  add(txtPassword);
  add(btnLogin);
  add(btnCancel); 
  
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
    Connection con;
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    int flg=0;
    
    ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("select *from logintbl where username='"+txtUsername.getText()+"'AND password='"+txtPassword.getText()+"'");
   
   while(res.next())
   {
      
      flg=1;
   }
   if(flg==1)
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
login2 obj=new login2();

}
}  
  

    
   
   
  
  
       
