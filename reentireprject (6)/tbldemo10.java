import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.sql.*;
import java.util.Calendar;
public class tbldemo10 extends Frame implements ActionListener
{
   JButton btnNew=new JButton("New");
   JButton btnsave=new JButton("Save");
   JButton btnCancel=new JButton("Cancel");
   
   TextField txtreceiptno=new TextField(30);
   TextField txtregno=new TextField(30);
   TextField txtcourseid=new TextField(30);
   TextField txtamountpaid=new TextField(30);
  
   JLabel lblpic=new JLabel();
   JLabel lbltitle=new JLabel("BOUNCE FORM");
   JLabel lblreceiptno=new JLabel("Receipt No:");
   JLabel lblregno=new JLabel("Stud Reg. No:");
   JLabel lblcourseid=new JLabel("Course id:");
   JLabel lblamountpaid=new JLabel("Amount:");
  
public tbldemo10()
{
  setLayout(null);
  setTitle("");
  setSize(1500,900);
  setVisible(true);
  setTitle("BOUNCE FORM");
 
  lblpic.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/bounce1.jpg"));
  lbltitle.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,35));
  lbltitle.setForeground(Color.red);
  lbltitle.setText("<html><u>BOUNCE FORM</u></html>");
  lblreceiptno.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblregno.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblamountpaid.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblcourseid.setFont(new Font("monotype corsiva",Font.BOLD,25));
    
  lblpic.setBounds(700,30,900,400); 
  lbltitle.setBounds(400,50,400,40);  
  lblreceiptno.setBounds(100,110,200,30);
  txtreceiptno.setBounds(430,110,200,30);
  lblregno.setBounds(100,170,200,30);
  txtregno.setBounds(430,170,200,30);
  lblcourseid.setBounds(100,230,200,30);
  txtcourseid.setBounds(430,230,200,30);
 
  lblamountpaid.setBounds(100,290,200,30);
  txtamountpaid.setBounds(430,290,200,30);
 
  btnNew.setBounds(370,350,100,30);
  btnsave.setBounds(470,350,100,30);
  btnCancel.setBounds(570,350,100,30);
  add(lblpic);
  add(lbltitle);
  add(lblreceiptno); 
  add(txtreceiptno);
  add(lblregno);  
  add(txtregno);
  add(txtcourseid);
  add(lblcourseid);
  add(lblamountpaid);  
  add(txtamountpaid);
 
  add(btnNew);
  add(btnsave);
  add(btnCancel); 
  
  btnCancel.addActionListener(this);    
  btnsave.addActionListener(this);
  btnNew.addActionListener(this);    
    
  
}
 public void actionPerformed(ActionEvent e)
 {
   if(e.getSource()==btnCancel)
   {
      this.dispose();
   }
  
   if(e.getSource()==btnNew)
   {
    
   txtregno.setText("");
   txtcourseid.setText("");
   txtamountpaid.setText("");
   txtreceiptno.setText("");
 }

 if(e.getSource()==btnsave)
 {
   try
   {
    

//********************
    Connection con1;
    con1=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res1;
    Statement st1=con1.createStatement();
    res1=st1.executeQuery("select * from feestbl");
    String str1="update feestbl set amount_paid="+0+" where stud_regno="+Integer.parseInt(txtregno.getText())+"AND course_id='"+txtcourseid.getText()+"'AND receipt_no="+Integer.parseInt(txtreceiptno.getText());
     System.out.println(""+str1);
     PreparedStatement ps1=con1.prepareStatement(str1);
     ps1.executeUpdate();
     JOptionPane.showMessageDialog(null,"Deducted Successfully");
     
//**************************
   
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
  tbldemo10 obj=new tbldemo10();
}
}  
 

    
   
   
  
  
       
