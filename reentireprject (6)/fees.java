import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Calendar;

public class fees extends Frame implements ActionListener
{
   JButton btnNew=new JButton("New");
   JButton btnPay=new JButton("Pay");
   JButton btnCancel=new JButton("Cancel");
   JButton btnSearch=new JButton("Search");
   JButton btnbounce=new JButton("Bounce");
   JButton btnreceipt=new JButton("Receipt");

   Choice txtcourseid=new Choice();
   Choice paidtype=new Choice();

   TextField txtdate=new TextField(30);
   TextField txtreceiptno=new TextField(30);
   TextField txtstudregno=new TextField(30);
   TextField txtcoursefees=new TextField(30);
   TextField txtalreadypaid=new TextField(30);
   TextField txtpaynow=new TextField(30);
   TextField txtstudname=new TextField(30);
   TextField txtcoursename=new TextField(30);
   TextField txtamtpending=new TextField(30);
   TextField txtstatus=new TextField(30);
 
   
   JLabel lbldate=new JLabel("Date:");
   JLabel lblreceiptno=new JLabel("Receipt No:");
   JLabel lblstudregno=new JLabel("Stud Reg. No:");
   JLabel lblcourseid=new JLabel("Course ID:");
   JLabel lblcoursefees=new JLabel("Course Fees:");
   JLabel lblalreadypaid=new JLabel("Already Paid:");
   JLabel lblpaynow=new JLabel("Pay Now:");
   JLabel lblstudname=new JLabel("Student Name:");
   JLabel lblcoursename=new JLabel("Course Name:");
   JLabel lblamtpending=new JLabel("Amount Pending:");
   JLabel lblstatus=new JLabel("Status");
   JLabel lblpic=new JLabel();
public fees()
{
  setLayout(null);
  setTitle("");
  setSize(1500,900);
  setVisible(true);
  setTitle("FEES FORM");
 
  lblpic.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/fees1.jpg"));
  lbldate.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblreceiptno.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblstudregno.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblcourseid.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblcoursefees.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblalreadypaid.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblpaynow.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblstudname.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblcoursename.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblamtpending.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblstatus.setFont(new Font("monotype corsiva",Font.BOLD,25));
  txtstatus.setFont(new Font("monotype corsiva",Font.BOLD,15));

  lblpic.setBounds(850,180,600,500); 
  lbldate.setBounds(100,60,200,30);
  txtdate.setBounds(430,60,400,30);
  lblreceiptno.setBounds(100,110,200,30);
  txtreceiptno.setBounds(430,110,400,30);
  lblstudregno.setBounds(100,170,200,30);
  txtstudregno.setBounds(430,170,400,30);
  lblcourseid.setBounds(100,230,200,30);
  txtcourseid.setBounds(430,230,400,30);
  lblstudname.setBounds(100,290,200,30);
  txtstudname.setBounds(430,290,400,30);
  lblcoursename.setBounds(100,350,200,30);
  txtcoursename.setBounds(430,350,400,30);
  lblcoursefees.setBounds(100,410,300,30);
  txtcoursefees.setBounds(430,410,400,30);
  lblalreadypaid.setBounds(100,470,200,30);
  txtalreadypaid.setBounds(430,470,400,30);
  lblpaynow.setBounds(100,530,300,30);
  txtpaynow.setBounds(430,530,400,30);
  paidtype.setBounds(850,530,100,30);
  lblamtpending.setBounds(100,590,200,30);
  txtamtpending.setBounds(430,590,400,30);
  lblstatus.setBounds(100,650,200,30);
  txtstatus.setBounds(430,650,400,30);

 
  btnSearch.setBounds(850,230,100,30);
  btnNew.setBounds(430,690,100,30);
  btnPay.setBounds(530,690,100,30);
  btnCancel.setBounds(830,690,100,30);
  btnbounce.setBounds(630,690,100,30);
  btnreceipt.setBounds(730,690,100,30);
  add(lblpic);
  add(lbldate);
  add(lblreceiptno); 
  add(lblstudregno);  
  add(lblcourseid);
  add(lblstudname);
  add(lblcoursename); 
  add(lblcoursefees);
  add(lblalreadypaid);
  add(lblpaynow);
  add(lblamtpending);
  add(lblstatus);
  add(txtdate);
  add(txtreceiptno);
  add(txtstudregno);
  add(txtstudname);
  add(txtcoursename);
  add(txtcoursefees);
  add(txtalreadypaid);
  add(txtpaynow);
  add(txtamtpending);
  add(txtstatus);
  add(txtcourseid);
  add(paidtype);
  add(btnNew);
  add(btnPay);
  add(btnCancel); 
  add(btnSearch);
  add(btnbounce);
  add(btnreceipt);
  btnCancel.addActionListener(this);    
  btnPay.addActionListener(this);
  btnNew.addActionListener(this);    
  btnSearch.addActionListener(this);  
  btnbounce.addActionListener(this);  
  btnreceipt.addActionListener(this);
}
 public void actionPerformed(ActionEvent e)
 {
   if(e.getSource()==btnCancel)
   {
      this.dispose();
   }
   if(e.getSource()==btnbounce)
   {
    tbldemo10 obj=new tbldemo10();
   }
   if(e.getSource()==btnreceipt)
   {
    try
    {
      Connection con;
      con=DriverManager.getConnection("jdbc:odbc:imsdsn"); 
      PrintWriter obj=new PrintWriter("Receipt");
      obj.println("\t\t\tHACK Institute     ");
      obj.println("");
      obj.print("Receipt No:-  "+txtreceiptno.getText());
      obj.println("\t\t\t\tDate:-  "+txtdate.getText());
      obj.println("\t     _________\t\t\t\t\t_______________");
      obj.println("                                        ");
      obj.println("  Student Name:- "+txtstudname.getText());   
      obj.println("                 ___________________\n");
      obj.println("                                        ");
      obj.println("  Stud Regno:-   "+txtstudregno.getText());
      obj.println("                 ___________________\n");
      obj.println("                                        ");
      obj.println("  Course Id:-    "+txtcourseid.getSelectedItem());  
      obj.println("                 ____________________\n");
      obj.println("                                        ");
      obj.println("  Course Name:-  "+txtcoursename.getText());  
      obj.println("                 _____________________\n");
      obj.println("                                        ");
      obj.println("  Pay Now:-      "+txtpaynow.getText());
      obj.println("                 _____________________\n");
      obj.println("                                        ");
      obj.println("  Paid Type:-    "+paidtype.getSelectedItem());
      obj.println("                 _____________________\n");
      obj.close();
      
      Runtime r=Runtime.getRuntime();
      r.exec("notepad c:\\amritaj\\project1\\receipt");     
     
   }
   catch(Exception ee)
   {
     System.out.println("Exception :"+ee);
   }
   }
   if(e.getSource()==btnNew)
   {

     txtcourseid.removeAll();
     paidtype.removeAll();
     Calendar cal=Calendar.getInstance();
     txtdate.setText(""+cal.get(Calendar.DATE)+" / "+((cal.get(Calendar.MONTH))+1)+" / "+cal.get(Calendar.YEAR));
     paidtype.add("Cheque");
     paidtype.add("cash");
     Connection con;
     try
     {
      con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
      ResultSet res;
      Statement st=con.createStatement();
      res=st.executeQuery("select *from keytbl");
      while(res.next())
      {
        txtreceiptno.setText(""+res.getString(5));
      }
   }
   catch(Exception ee)
   {
     System.out.println("Exception :"+ee);
   }
  try
  {
    Connection con1; 
    con1=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res2;
    Statement st2=con1.createStatement();
    res2=st2.executeQuery("select course_id from coursetbl");
    while(res2.next())
     {
       txtcourseid.add(res2.getString(1));
       
     }
    
  }
   catch(Exception X)
     {
       System.out.println("Exception :"+X);
      }
   
   txtstudregno.setText("");
  
   txtcoursefees.setText("");
   txtalreadypaid.setText("");
   txtpaynow.setText("");
   txtcoursename.setText("");
   txtstudname.setText("");
   txtamtpending.setText("");
   txtstatus.setText("");
 }
 if(e.getSource()==btnSearch)
 {
paidtype.removeAll();
   int flg,t=0,flg1=0;
 
 try
    {
    Connection con3; 
    con3=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res3;
    Statement st3=con3.createStatement();
    res3=st3.executeQuery("select * from enrolltbl where course_id='"+txtcourseid.getSelectedItem()+"'AND stud_regno="+Integer.parseInt(txtstudregno.getText()));
     while(res3.next())
      {
       flg1=1;
      }
    }

   catch(Exception Xx)
   {
     System.out.println("Exception :"+Xx);
   }
if(flg1==0)
JOptionPane.showMessageDialog(null,"U r nt enroll in dis course");
if(flg1==1)
  {

   try
   {
     
    Connection con; 
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res;
    Statement st=con.createStatement();
    
    res=st.executeQuery("select *from coursetbl where course_id='"+txtcourseid.getSelectedItem()+"'");
     while(res.next())
     {
       txtcoursename.setText(""+res.getString(2));
       txtcoursefees.setText(""+res.getString(4));
     }
   
     flg=1;
     Connection con1; 
    con1=DriverManager.getConnection("jdbc:Odbc:imsdsn");
     ResultSet res1;
     Statement st1=con1.createStatement();
     res1=st1.executeQuery("select * from feestbl where stud_regno="+Integer.parseInt(txtstudregno.getText())+" AND course_id='"+txtcourseid.getSelectedItem()+"'");
     int p;
     String str="";
      while(res1.next())
      {
        p=Integer.parseInt(res1.getString(5));
        
        paidtype.add(""+res1.getString(6));
        t=t+p;
      }
int flga=0;
     

     ResultSet res4;
     Statement st4=con1.createStatement();
     res4=st4.executeQuery("select * from feestbl where stud_regno="+Integer.parseInt(txtstudregno.getText())+" AND course_id='"+txtcourseid.getSelectedItem()+"'");

   while(res4.next())
{

str=res4.getString(6);
}

   
 if(str.equals("cash"))
{
 paidtype.add("cheque");

}
else
 paidtype.add("cash");

 ResultSet res5;
     Statement st5=con1.createStatement();
     res5=st5.executeQuery("select * from feestbl where stud_regno="+Integer.parseInt(txtstudregno.getText()));
     while(res5.next())
     {
       flga=1;
     }
if(flga==0)
{
paidtype.removeAll();

paidtype.add("cash");
paidtype.add("cheque");
}
      txtalreadypaid.setText(""+t);
    Connection con2; 
    con2=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res2;
    Statement st2=con2.createStatement();
    res2=st2.executeQuery("select *from studenttbl where stud_regno="+Integer.parseInt(txtstudregno.getText()));
     while(res2.next())
     {
       txtstudname.setText(""+res2.getString(2));
       
     }
    int n1=Integer.parseInt(txtcoursefees.getText());
    int n2=Integer.parseInt(txtalreadypaid.getText());
    txtamtpending.setText(""+(n1-n2));
    
    if(n1==n2)
    {
    txtstatus.setForeground(Color.pink);
    txtstatus.setText("CLEARED!!");
    
    }    
  else
    {
    txtstatus.setForeground(Color.red);
    txtstatus.setText("INCOMPLETE!!");
      
   }
}
 catch(Exception X)
   {
     System.out.println("Exception :"+X);
   }
 }
}
 if(e.getSource()==btnPay)
 {
  try
   {

        //class.forName("sun.jdbc.odbc.jdbcOdbcDriver");
     Connection con; 
          con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
     ResultSet res;
      
     Statement st=con.createStatement();
     res=st.executeQuery("select *from feestbl");
     String str="insert into feestbl(receipt_no,tdate,stud_regno,course_id,amount_paid,paid_type)values(?,?,?,?,?,?)";     
PreparedStatement ps=con.prepareStatement(str);
     ps.setString(1,txtreceiptno.getText());
     ps.setString(2,txtdate.getText());
     ps.setString(3,txtstudregno.getText());
     ps.setString(4,txtcourseid.getSelectedItem());
     ps.setString(5,txtpaynow.getText());
     ps.setString(6,paidtype.getSelectedItem());
    
     int n=Integer.parseInt(txtpaynow.getText());
     int n1=Integer.parseInt(txtcoursefees.getText());
     int n2=Integer.parseInt(txtalreadypaid.getText());    
if(n<=(n1-n2))
     {
          ps.executeUpdate();
      JOptionPane.showMessageDialog(null,"Paid Successfully");
      str="update keytbl set receipt_no=receipt_no+1";

      PreparedStatement ps1=con.prepareStatement(str);
      ps1.executeQuery();
    }

    else
    {

      if (n1==n2)

       JOptionPane.showMessageDialog(null,"Your Amount Is Cleared");
      else

       JOptionPane.showMessageDialog(null,"plz Re-Enter Ur Amount");
  
    txtpaynow.setText("");
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
  fees obj=new fees();
}
}  
 

    
   
   
  
  
       
