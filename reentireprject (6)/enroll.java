import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.sql.*;
import java.util.Calendar;

public class enroll extends Frame implements ActionListener
{
   Choice batch=new Choice();
   Choice txtcourseid=new Choice();
   JButton btnNew=new JButton("New");
   JButton btnSave=new JButton("Save");
   JButton btnEdit=new JButton("Batch chng");
   JButton btnSearch=new JButton("Search");
   JButton btnCancel=new JButton("Cancel");
   JButton btnSsearch=new JButton("Ssearch");
   JButton btnclick=new JButton("Click");
   JButton reasonforbatchchange=new JButton("Reason");//to c d reason 
   TextField txtstudregno=new TextField(30);
   
   TextField txtstudname=new TextField(30);
   TextField txtadate=new TextField(30);
   TextField txtcoursefees=new TextField(30);
   TextField txtbatchno=new TextField(30);
   TextField txtreason=new TextField(30);
 
   JLabel lblpic=new JLabel();
   JLabel lbltitle=new JLabel("ENROLLMENT");
   JLabel lbltitle1=new JLabel("FORM");      

   JLabel lblreason=new JLabel("Reason fr Batch chngng:");
   JLabel lblstudregno=new JLabel("Stud Reg No:");
   JLabel lblcourseid=new JLabel("Course Id:");
   JLabel lbladate=new JLabel("Date:");
   JLabel lblcoursefees=new JLabel("Course Fees:");
   JLabel lblbatchno=new JLabel("Batch no:");
public enroll()
{
  setLayout(null);
  setTitle("");
  setSize(1500,900);
  setVisible(true);

  lblpic.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/enroll1.jpg"));
  lbltitle.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,35));
  lbltitle.setForeground(Color.red);
  lbltitle.setText("<html><u>ENROLLMENT</u></html>");
   lbltitle1.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,35));
  lbltitle1.setForeground(Color.red);
  lbltitle1.setText("<html><u> FORM</u></html>");

  lblstudregno.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblcourseid.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lbladate.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblcoursefees.setFont(new Font("monotype corsiva",Font.BOLD,25)); 
  lblbatchno.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblreason.setFont(new Font("monotype corsiva",Font.BOLD,25));

  lblpic.setBounds(950,50,300,800); 
  lbltitle.setBounds(450,50,400,40);
  lbltitle1.setBounds(520,100,400,40);
  lbladate.setBounds(100,140,200,40);
  txtadate.setBounds(320,140,200,40);
  lblstudregno.setBounds(100,210,200,40);
  txtstudregno.setBounds(320,210,200,40);
  txtstudname.setBounds(540,210,200,40);
  lblcourseid.setBounds(100,270,200,40);
  txtcourseid.setBounds(320,270,200,40);
  lblcoursefees.setBounds(100,330,200,40);
  txtcoursefees.setBounds(320,330,200,40);
  lblbatchno.setBounds(100,390,200,40);
  batch.setBounds(320,390,200,40);
  btnSearch.setBounds(540,270,80,20);
  lblreason.setBounds(100,450,200,40);
  txtreason.setBounds(320,450,400,40);
  reasonforbatchchange.setBounds(750,450,80,30);
  btnNew.setBounds(200,530,100,40);
  btnSave.setBounds(300,530,100,40);
  btnEdit.setBounds(400,530,100,40);
  btnCancel.setBounds(500,530,100,40);
  btnSsearch.setBounds(600,530,100,40);

  add(lblpic);
  add(lbltitle);
  add(lbltitle1);
  add(lblstudregno);  
  add(lblcourseid); 
  add(txtstudname);
  add(lbladate); 
  add(lblcoursefees); 
  add(lblbatchno); 
  add(txtbatchno);
  add(txtstudregno);
  add(txtcourseid);
  add(txtadate);
  add(txtcoursefees);
  add(batch);
  add(lblreason);
  add(txtreason);
  add(reasonforbatchchange);
  add(btnNew);
  add(btnSave);
  add(btnEdit);
  add(btnSearch);
  add(btnSsearch);
  add(btnCancel);
  
  btnNew.addActionListener(this);
  btnCancel.addActionListener(this);    
  btnSave.addActionListener(this);
  btnEdit.addActionListener(this);
  btnSearch.addActionListener(this);
  btnSsearch.addActionListener(this);
  btnclick.addActionListener(this);
  reasonforbatchchange.addActionListener(this);
 
 }


public void actionPerformed(ActionEvent e)
{
  if(e.getSource()==btnNew)
  {

    txtstudregno.setText("");   
    txtcourseid.removeAll();
    txtadate.setText("");
    txtcoursefees.setText("");
    txtreason.setText("");
    txtstudname.setText("");
    Calendar cal=Calendar.getInstance();
    txtadate.setText(""+cal.get(Calendar.DATE)+" / "+((cal.get(Calendar.MONTH))+1)+" / "+cal.get(Calendar.YEAR));
    batch.removeAll(); 
   //to add all d course_id  
  try
   {
    
    Connection con; 
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res2;
    Statement st2=con.createStatement();
    res2=st2.executeQuery("select *from coursetbl");
     while(res2.next())
     {
       txtcourseid.add(""+res2.getString(1));
       
     }

   }
   catch(Exception X)
     {
       System.out.println("Exception :"+X);
      }

  }
  if(e.getSource()==reasonforbatchchange)
  {
int flg=0;
String s="null",s1="";
      try
      {
    Connection con; 
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res2;
    Statement st2=con.createStatement();
    res2=st2.executeQuery("select *from enrolltbl where course_id='"+txtcourseid.getSelectedItem()+"'AND stud_regno="+Integer.parseInt(txtstudregno.getText()));
     while(res2.next())
     {
       txtreason.setText(""+res2.getString(7));
     }
     ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("select *from enrolltbl where course_id='"+txtcourseid.getSelectedItem()+"'AND stud_regno="+Integer.parseInt(txtstudregno.getText()));
     while(res.next())
       {
    s1=s1+res.getString(7);
     if(s.equals(s1))
        flg=1;
       }
 if(flg==1)
{
 txtreason.setText("");
 JOptionPane.showMessageDialog(null,"U Didn't Chng ur Batch");
  
}

     }
   catch(Exception X)
     {
       System.out.println("Exception :"+X);
     }
 } 
  if(e.getSource()==btnCancel)
  {
    this.dispose();
  }
  
if(e.getSource()==btnSsearch)
  {
    tbldemo6 obj=new tbldemo6();
  }
  
 if(e.getSource()==btnSearch)
  {
  int ctr=0;
    try
   {
    
    Connection con; 
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res2;
    Statement st2=con.createStatement();
    res2=st2.executeQuery("select *from coursetbl");
     while(res2.next())
     {
       txtcourseid.add(""+res2.getString(1));
       
     }

   }
   catch(Exception X)
     {
       System.out.println("Exception :"+X);
      }
    try
   {
    
    Connection con; 
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res2;
    Statement st2=con.createStatement();
    res2=st2.executeQuery("select *from coursetbl where course_id='"+txtcourseid.getSelectedItem()+"'");
     while(res2.next())
     {
       txtcoursefees.setText(""+res2.getString(4));
       ctr++;
     }

   }
   catch(Exception X)
     {
       System.out.println("Exception :"+X);
      }
   
  try
  {
    Connection con1; 
    con1=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res2;
    Statement st2=con1.createStatement();
    res2=st2.executeQuery("select *from batchtbl where course_id='"+txtcourseid.getSelectedItem()+"'");
    while(res2.next())
     {
       batch.add(res2.getString(1));
       ctr++;
     }
    if(ctr<2)
       JOptionPane.showMessageDialog(null,"Either No Such ID and No Batch Created");
  }
   catch(Exception X)
     {
       System.out.println("Exception :"+X);
      }
//to display d name of a student
    try
   {
    
    Connection con; 
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res2;
    Statement st2=con.createStatement();
    res2=st2.executeQuery("select *from studenttbl where Stud_regno="+Integer.parseInt(txtstudregno.getText()));
     while(res2.next())
     {
       txtstudname.setText(""+res2.getString(2));
       
     }

   }
   catch(Exception X)
     {
       System.out.println("Exception :"+X);
      }
   

   
  }
  if(e.getSource()==btnSave)
  {
   try
   {
   int flg=0;
  //class.forName("sun.jdbc.odbc.jdbcOdbcDriver");
    Connection con; 
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("select *from enrolltbl");
    String str="insert into enrolltbl(stud_regno,course_id,adate,course_fees,batch_no,description,reason)values(?,?,?,?,?,?,?)";
    PreparedStatement ps=con.prepareStatement(str);
    ps.setString(1,txtstudregno.getText());
    ps.setString(2,txtcourseid.getSelectedItem());
    ps.setString(3,txtadate.getText());
    ps.setString(4,txtcoursefees.getText());
    ps.setString(5,batch.getSelectedItem());
    ps.setString(6," ");
    ps.setString(7," ");
    ResultSet res1;
    Statement st1=con.createStatement();
   
    res1=st1.executeQuery("select *from enrolltbl where course_id='"+txtcourseid.getSelectedItem() +"'AND stud_regno="+Integer.parseInt(txtstudregno.getText()));
     while(res1.next())
     {
      flg=1;
      JOptionPane.showMessageDialog(null,"You Hv Already Enroll In This course");
  
     }
    int flg1=0;
    ResultSet res2;
    Statement st2=con.createStatement();
   
     res2=st2.executeQuery("select *from studenttbl where stud_regno="+Integer.parseInt(txtstudregno.getText()));
     while(res2.next())
     {
      flg1=1;
     }
if(flg1==1)
{
    if(flg==0)
  {  
    ps.executeUpdate();
    JOptionPane.showMessageDialog(null,"saved Successfully");
   }
   
  }

if(flg1==0)
JOptionPane.showMessageDialog(null,"Plz first fill the student tbl");
}
   catch(Exception X)
     {
       System.out.println("Exception :"+X);
      }
}

if(e.getSource()==btnEdit)
{
   String s="";
  try
  {
   //fetch d value of description in string s
    Connection con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res3;
    Statement st3=con.createStatement();
    res3=st3.executeQuery("select *from enrolltbl where stud_regno="+Integer.parseInt(txtstudregno.getText())+"AND course_id='"+txtcourseid.getSelectedItem()+"'");
    while(res3.next())
    { 
    s=s+res3.getString(6);
    }
   //if descriptn's value z null thn do nthng othws cnctnt , aftr string s
   String str1=" ";
   if(s.equals(str1))
   {
   }
   else
  s=s+",";
 //concatenate currnt batch no in string s
    ResultSet res4;
    Statement st4=con.createStatement();
    res4=st4.executeQuery("select *from enrolltbl where stud_regno="+Integer.parseInt(txtstudregno.getText())+"AND course_id='"+txtcourseid.getSelectedItem()+"'");


    while(res4.next())
    {
    s=s+res4.getString(5);
    }

    //update d value of descrptn y assigning value of string s
    ResultSet res2;
    Statement st2=con.createStatement();
    res2=st2.executeQuery("select *from enrolltbl");
    String str2="update enrolltbl set description='"+s+"'where stud_regno="+Integer.parseInt(txtstudregno.getText())+"AND course_id='"+txtcourseid.getSelectedItem()+"'";
    PreparedStatement ps2=con.prepareStatement(str2);
    ps2.executeUpdate();

   //now update d batch_no
    ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("select *from enrolltbl");
    String str="update enrolltbl set batch_no='"+batch.getSelectedItem()+"', reason='"+txtreason.getText()+"' where stud_regno="+Integer.parseInt(txtstudregno.getText())+"AND course_id='"+txtcourseid.getSelectedItem()+"'";
    PreparedStatement ps=con.prepareStatement(str);
    ps.executeUpdate();
    JOptionPane.showMessageDialog(null,"Updated  Successfully");
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
enroll obj=new enroll();
}
}  
  

    
   
   
  
  
       
