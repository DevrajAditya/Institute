import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.sql.*;
public class batch extends Frame implements ActionListener
{
    Choice txtstatus=new Choice();
   JButton btnNew=new JButton("New");
   JButton btnSave=new JButton("Save");
   JButton btnEdit=new JButton("Edit");
   JButton btnSearch=new JButton("Search");
   JButton btnCancel=new JButton("Cancel");
   JButton btnTable=new JButton("Table");
   JButton btnCsearch=new JButton("Csearch");
   TextField txtbatchno=new TextField(30);
   TextField txtfacultyno=new TextField(30);
   TextField txtbatchtimming=new TextField(30);
   TextField txtbatchstartdate=new TextField(30);
   TextField txtbatchenddate=new TextField(30);
   TextField txtcid=new TextField(30);

   JLabel lbltitle=new JLabel("Batch FORM");
   JLabel lblcid=new JLabel("Course Id:");
   TextField txtcduration=new TextField(30);
   JLabel lblcduration=new JLabel("Course Duration:");
   JLabel lblbatchno=new JLabel("Batch No:");
   JLabel lblfacultyno=new JLabel("Faculty No:");
   JLabel lblbatchtimming=new JLabel("Batch Timming:");
   JLabel lblbatchstartdate=new JLabel("Batch StartDate:");
   JLabel lblbatchenddate=new JLabel("Batch EndDate:");
   JLabel lblstatus=new JLabel("Status:");
   


   JLabel lblpic=new JLabel();
public batch()
{
  setLayout(null);
  setTitle("");
  setSize(1500,1000);
  setVisible(true);
  lbltitle.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,35));
  lbltitle.setForeground(Color.red);
  lbltitle.setText("<html><u>BATCH FORM</u></html>");
  lblpic.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/batch1.jpg"));
  lblbatchno.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblbatchtimming.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblbatchstartdate.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblbatchenddate.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblcid.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblcduration.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblstatus.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblfacultyno.setFont(new Font("monotype corsiva",Font.BOLD,25));
  
  lbltitle.setBounds(400,50,400,40);
  lblpic.setBounds(650,10,900,700);
  lblbatchno.setBounds(100,140,200,40);
  txtbatchno.setBounds(320,140,200,40);
  lblcid.setBounds(100,210,200,40);
  txtcid.setBounds(320,210,200,40);
  lblfacultyno.setBounds(100,270,200,40);
  txtfacultyno.setBounds(320,270,200,40);
  btnCsearch.setBounds(550,330,100,40);
  lblcduration.setBounds(100,330,200,40);
  txtcduration.setBounds(320,330,200,40);
  lblbatchtimming.setBounds(100,390,200,40);
  txtbatchtimming.setBounds(320,390,200,40);
  lblbatchstartdate.setBounds(100,450,200,40);
  txtbatchstartdate.setBounds(320,450,200,40);
  lblbatchenddate.setBounds(100,510,200,40);
  txtbatchenddate.setBounds(320,510,200,40);
  lblstatus.setBounds(100,570,200,40);
  txtstatus.setBounds(320,570,200,40); 

  btnNew.setBounds(100,610,100,40);
  btnSave.setBounds(200,610,100,40);
  btnSearch.setBounds(300,610,100,40);
  btnEdit.setBounds(400,610,100,40);
  btnCancel.setBounds(500,610,100,40);
  btnTable.setBounds(600,610,100,40);
 
  add(lblpic);
  add(lbltitle);
  add(lblbatchtimming); 
  add(lblbatchno); 
  add(lblfacultyno);
  add(txtfacultyno); 
  add(lblbatchstartdate); 
  add(lblbatchenddate);
  add(txtbatchno);
  add(txtbatchtimming);
  add(txtbatchstartdate);
  add(txtbatchenddate);
  add(txtcid);
  add(lblcid);
  add(txtcduration);
  add(lblcduration);
  add(lblstatus);
  add(txtstatus);
  
  add(btnNew);
  add(btnSave);
  add(btnSearch); 
  add(btnEdit); 
  add(btnCancel);
  add(btnTable);
  add(btnCsearch);

  btnCancel.addActionListener(this);    
  btnSave.addActionListener(this);
  btnNew.addActionListener(this);    
  btnEdit.addActionListener(this);    
  btnSearch.addActionListener(this);
  btnTable.addActionListener(this);    
  btnCsearch.addActionListener(this);   
 }
public void actionPerformed(ActionEvent e)
{
   if(e.getSource()==btnTable)
  {
    tbldemo2 obj=new tbldemo2();
   }

  if(e.getSource()==btnNew)
   {
    txtstatus.removeAll();
    txtstatus.add("running");
    txtstatus.add("completed");
    Connection con;
     try
     {
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("select *from keytbl");
    while(res.next())
     {
      txtbatchno.setText(""+"B"+res.getString(4));
     }
    }
   catch(Exception ee)
   {
   System.out.println("Exception :"+ee);
   }
 
    
    txtbatchtimming.setText("");
    txtbatchstartdate.setText("");
    txtbatchenddate.setText("");
    txtcid.setText("");
    txtcduration.setText("");
    txtfacultyno.setText("");
    
    
 }
  if(e.getSource()==btnCancel)
   {
      this.dispose();
   }
    if(e.getSource()==btnCsearch)
   {
 int flg=0;
    try
   {
    Connection con;
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res1;
    Statement st1=con.createStatement();
    res1=st1.executeQuery("select *from coursetbl where course_id='"+txtcid.getText()+"'");
   
   while(res1.next())
     {
      txtcduration.setText(""+res1.getString(3));
      flg=1;
     }
    
  if(flg==0)
  {
   txtcid.setText("");
   txtcduration.setText("");
   JOptionPane.showMessageDialog(null,"INVALID COURSE ID!!");
  } 
 }
   catch(Exception ee)
   {
   System.out.println("Exception :"+ee);
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
     ResultSet res1;
    Statement st1=con.createStatement();
    res1=st1.executeQuery("select *from batchtbl where batch_no='"+txtbatchno.getText()+"'");
   
   while(res1.next())
     {
       flg=1;
      }
     if(flg==1)
     JOptionPane.showMessageDialog(null,"Batch is already created For any course!");
 
    ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("select *from batchtbl");
    String str="insert into batchtbl(batch_no,faculty_no,batch_timming,batch_startdate,batch_enddate,course_id,course_duration,status)values(?,?,?,?,?,?,?,?)";
    PreparedStatement ps=con.prepareStatement(str);
    ps.setString(1,txtbatchno.getText());
    ps.setString(2,txtfacultyno.getText());
    ps.setString(3,txtbatchtimming.getText());
    ps.setString(4,txtbatchstartdate.getText());
    ps.setString(5,txtbatchenddate.getText());
    ps.setString(6,txtcid.getText());
    ps.setString(7,txtcduration.getText());
    ps.setString(8,txtstatus.getSelectedItem());
    ps.executeUpdate();
    JOptionPane.showMessageDialog(null,"saved Successfully");
    txtbatchno.setText("");   
    txtbatchtimming.setText("");
    txtbatchstartdate.setText("");
    txtbatchenddate.setText("");
    txtcid.setText("");
    txtcduration.setText("");
    txtfacultyno.setText("");
    str="update keytbl set batch_no=batch_no+1";
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
    try
     {
    String str="";
    Connection con;
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    int flg=0;
    txtbatchtimming.setText("");
    txtbatchstartdate.setText("");
    txtbatchenddate.setText("");
    txtcid.setText("");
    txtcduration.setText("");
    txtstatus.removeAll();
    txtfacultyno.setText("");

    ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("select *from batchtbl where batch_no='"+txtbatchno.getText()+"'");
   
   while(res.next())
     {
      txtfacultyno.setText(""+res.getString(2));
      txtbatchtimming.setText(""+res.getString(3));
      txtbatchstartdate.setText(""+res.getString(4));
      txtbatchenddate.setText(""+res.getString(5));
      txtcid.setText(""+res.getString(6));
      str=res.getString(8);
      txtstatus.add(""+str);
       flg=1;
      }
//***************




if(str.equals("completed"))
 txtstatus.add("running");
else
 txtstatus.add("completed");
//***************
    ResultSet res1;
    Statement st1=con.createStatement();
    res1=st1.executeQuery("select *from coursetbl where course_id='"+txtcid.getText()+"'");
   
   while(res1.next())
     {
      txtcduration.setText(""+res1.getString(3));
     }
    
  if(flg==0)
   JOptionPane.showMessageDialog(null,"NO SUCH RECORD");
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
    res=st.executeQuery("select *from batchtbl");
    String str="update batchtbl set faculty_no='"+txtfacultyno.getText()+"',Batch_timming='"+txtbatchtimming.getText()+"',batch_startdate='"+txtbatchstartdate.getText()+"',batch_enddate='"+txtbatchenddate.getText()+"',course_id='"+txtcid.getText()+"',status='"+txtstatus.getSelectedItem()+"' where batch_no='"+txtbatchno.getText()+"'";
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
batch obj=new batch();
}
}  
  

    
   
   
  
  
       
