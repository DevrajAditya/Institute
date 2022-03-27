
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.applet.*;
import java.io.*;
import java.sql.*;
public class student extends Frame implements ActionListener
{
   Choice gender=new Choice();
   JButton btnNew=new JButton("New");
   JButton btnSave=new JButton("Save");
   JButton btnEdit=new JButton("Edit");
   JButton btnInfosrch=new JButton("Infosrch");
   JButton btnSearch=new JButton("Search");
   JButton btnCancel=new JButton("Cancel");
   JButton btnTable=new JButton("Table");
  
   TextField txtStudregno=new TextField(30);
   TextField txtStudname=new TextField(30);
   TextField txtStudfathername=new TextField(30);
   TextField txtStuddob=new TextField(30);
   TextField txtStudaddress=new TextField(30);
   TextField txtStudcontactno=new TextField(30);
   TextField txtStuddoa=new TextField(30);
   TextField txtStudttl=new TextField(30);

   JLabel lbltitle=new JLabel("Student    Form");
   JLabel lblStudregno=new JLabel("Student Regno:");
   JLabel lblStudname=new JLabel("Student Name:");
   JLabel lblStudfathername=new JLabel("Student Father's Name:");
   JLabel lblStuddob=new JLabel("Student DOB:");
   JLabel lblStudgender=new JLabel("Student Gender:");
   JLabel lblStudaddress=new JLabel("Student address:");
   JLabel lblStudcontactno=new JLabel("Student Contact NO:");
   JLabel lblStuddoa=new JLabel("Student DOA:");
   JLabel lblStudttl=new JLabel("Student Fees Pending:");
   JLabel lblpic=new JLabel();
  
public student()
{
  setLayout(null);
  setTitle("");
  setSize(1500,750);
  setVisible(true);

  lbltitle.setFont(new Font("Harlow Solid",Font.BOLD,35));
  lbltitle.setForeground(Color.red);
  lbltitle.setText("<html><u>STUDENT FORM</u></html>");
  lblpic.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/student1.jpg"));
  lblStudregno.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblStudname.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblStuddob.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblStudfathername.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblStudgender.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblStudaddress.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblStudcontactno.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblStuddoa.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblStudttl.setFont(new Font("monotype corsiva",Font.BOLD,25));
  
  lbltitle.setBounds(500,50,400,60);
  lblpic.setBounds(900,100,700,800);
  lblStudregno.setBounds(100,140,200,40);
  txtStudregno.setBounds(430,140,400,40);
  lblStudname.setBounds(100,210,200,40);
  txtStudname.setBounds(430,210,400,40);
  lblStudfathername.setBounds(100,270,300,40);
  txtStudfathername.setBounds(430,270,400,40);
  lblStuddob.setBounds(100,330,200,40);
  txtStuddob.setBounds(430,330,400,40);
  lblStudgender.setBounds(100,390,300,40);
  gender.setBounds(430,390,400,40);
  lblStudaddress.setBounds(100,450,300,40);
  txtStudaddress.setBounds(430,450,400,40);
  lblStudcontactno.setBounds(100,510,300,40);
  txtStudcontactno.setBounds(430,510,400,40);
  lblStuddoa.setBounds(100,570,200,40);
  txtStuddoa.setBounds(430,570,400,40);
  lblStudttl.setBounds(100,630,200,40);
  txtStudttl.setBounds(430,630,400,40);
  btnNew.setBounds(250,680,100,40);
  btnSave.setBounds(350,680,100,40);
  btnSearch.setBounds(450,680,100,40);
  btnEdit.setBounds(550,680,100,40);
  btnCancel.setBounds(650,680,100,40);
  btnTable.setBounds(750,680,100,40);
  btnInfosrch.setBounds(850,680,100,40);
  
  add(lbltitle);
  add(lblpic);
  add(lblStudname); 
  add(lblStudregno); 
  add(lblStudfathername);
  add(lblStuddob); 
  add(lblStudgender);
  add(lblStudaddress);
  add(lblStudcontactno);
  add(lblStuddoa);
  add(lblStudttl);
 
  add(txtStudregno);
  add(txtStudname);
  add(txtStudfathername);
  add(txtStuddob);
  add(gender);
  add(txtStudaddress);
  add(txtStudcontactno);
  add(txtStuddoa);
  add(txtStudttl);
  add(btnInfosrch);
  add(btnNew);
  add(btnSave);
  add(btnSearch); 
  add(btnEdit); 
  add(btnCancel);
  add(btnTable);
  
  btnCancel.addActionListener(this);    
  btnSave.addActionListener(this);
  btnNew.addActionListener(this);    
  btnEdit.addActionListener(this);    
  btnSearch.addActionListener(this); 
  btnTable.addActionListener(this);  
  btnInfosrch.addActionListener(this);   
 }
public void actionPerformed(ActionEvent e)
{
 if(e.getSource()==btnTable)
 {
  tbldemo4 obj=new tbldemo4();
  }
  if(e.getSource()==btnInfosrch)
 {
  tbldemo9 obj=new tbldemo9();
  }
  if(e.getSource()==btnNew)
   {
    Connection con;
     try
     {
    txtStudttl.setText("0");
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("select *from keytbl");
    while(res.next())
     {
      txtStudregno.setText(""+res.getString(2));
     }
    }
   catch(Exception ee)
   {
   System.out.println("Exception :"+ee);
   }
 
    
    txtStudname.setText("");
    txtStuddob.setText("");
    txtStudfathername.setText("");
    txtStudaddress.setText("");
    txtStudcontactno.setText("");
    txtStuddoa.setText("");
    lblpic.setIcon(new ImageIcon(" "));
    gender.removeAll();
    gender.add("male");
    gender.add("female");
    }
  if(e.getSource()==btnCancel)
   {
     this.dispose();
   }
  if(e.getSource()==btnSave)
   {
    try
     {
  //class.forName("sun.jdbc.odbc.jdbcOdbcDriver");
    Connection con;
    
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("select *from studenttbl");
    String str="insert into studenttbl(stud_regno,stud_name,stud_fathername,stud_dob,stud_gender,stud_address,stud_contactno,stud_doa)values(?,?,?,?,?,?,?,?)";
    PreparedStatement ps=con.prepareStatement(str);
   
    ps.setString(1,txtStudregno.getText());
    ps.setString(2,txtStudname.getText());
    ps.setString(3,txtStudfathername.getText());
    ps.setString(4,txtStuddob.getText());
    ps.setString(5,gender.getSelectedItem());
    ps.setString(6,txtStudaddress.getText());
    ps.setString(7,txtStudcontactno.getText());
    ps.setString(8,txtStuddoa.getText());
    ps.executeUpdate();
    JOptionPane.showMessageDialog(null,"saved Successfully");
    txtStudregno.setText("");   
    txtStudname.setText("");
    txtStuddob.setText("");
    txtStudfathername.setText("");
  
    txtStudaddress.setText("");
    txtStudcontactno.setText("");
    txtStuddoa.setText("");
    
    str="update keytbl set stud_regno=stud_regno+1";
    PreparedStatement ps1=con.prepareStatement(str);
    ps1.executeQuery();
        
     }
   catch(Exception X)
     {
       System.out.println("Exception :"+X);
      }
}

if(e.getSource()==btnSearch)
   {
gender.removeAll();
int t=0,t1=0;
    try
     {
    Connection con;
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    int flg=0;
    txtStudname.setText("");
    txtStuddob.setText("");
    txtStudfathername.setText("");
    //txtStudgender.setText("");
    txtStudaddress.setText("");
    txtStudcontactno.setText("");
    txtStuddoa.setText("");
   
    ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("select *from studenttbl where stud_regno="+Integer.parseInt(txtStudregno.getText()));
   
   while(res.next())
     {
      txtStudname.setText(""+res.getString(2));
      txtStudfathername.setText(""+res.getString(3));
      txtStuddob.setText(""+res.getString(4));
      gender.add(""+res.getString(5));
      txtStudaddress.setText(""+res.getString(6));
      txtStudcontactno.setText(""+res.getString(7));
      txtStuddoa.setText(""+res.getString(8));
      String Fname="c:/amritaj/project1/image1/"+txtStudregno.getText()+".jpg";
      lblpic.setIcon(new ImageIcon(Fname));
       flg=1;
      }
ResultSet res4;
    Statement st4=con.createStatement();
    res4=st4.executeQuery("select *from studenttbl where stud_regno="+Integer.parseInt(txtStudregno.getText()));

String str="";
while(res4.next())
{
 str=res4.getString(5);
}

if(str.equals("male"))
 gender.add("female");
else
 gender.add("male");
    if(flg==0)
   JOptionPane.showMessageDialog(null,"NO SUCH RECORD");
  
    Connection con1;
    con1=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res1;
    Statement st1=con1.createStatement();
    res1=st1.executeQuery("select *from enrolltbl where stud_regno="+Integer.parseInt(txtStudregno.getText()));
    int p;
   while(res1.next())
     {
        p=Integer.parseInt(res1.getString(4));
        t=t+p;
     }
     Connection con2;
    con2=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res2;
    Statement st2=con2.createStatement();
    res2=st2.executeQuery("select * from feestbl where stud_regno="+Integer.parseInt(txtStudregno.getText()));
    int p1;
   while(res2.next())
     {
        p1=Integer.parseInt(res2.getString(5));
        t1=t1+p1;
     }
   int s;
    s=t-t1;
      txtStudttl.setText(""+s);
     
      }
    
   catch(Exception ee)
   {
   System.out.println("Exception :"+ee);
   }
 }
   if(e.getSource()==btnEdit)
   {
    try
     {
  //class.forName("sun.jdbc.odbc.jdbcOdbcDriver");
    Connection con;
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("select * from studenttbl");
    String str="update studenttbl set Stud_name='"+txtStudname.getText()+"',Stud_fathername='"+txtStudfathername.getText()+"',stud_dob='"+txtStuddob.getText()+"',stud_gender='"+gender.getSelectedItem()+"',stud_address='"+txtStudaddress.getText()+"',stud_contactno='"+txtStudcontactno.getText()+"',stud_doa='"+txtStuddoa.getText()+"' where Stud_regno="+txtStudregno.getText();
     PreparedStatement ps=con.prepareStatement(str);
     ps.executeUpdate();
     
     JOptionPane.showMessageDialog(null,"Updated  Successfully");
     }
     catch(Exception X)
      {
        System.out.println("Exception:"+X);
      }
   }
}
public static void main(String argv[])
throws IOException
{
student obj=new student();
}
}  
  

    
   
   
  
  
       
