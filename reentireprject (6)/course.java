import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.sql.*;
import java.sql.Connection;
public class course extends Frame implements ActionListener
{
   JButton btnNew=new JButton("New");
   JButton btnSave=new JButton("Save");
   JButton btnEdit=new JButton("Edit");
   JButton btnSearch=new JButton("Search");
   JButton btnSTable=new JButton("STable");
   JButton btnCancel=new JButton("Cancel");
   JButton btnTable=new JButton("Table");
 
   TextField txtCid=new TextField(30);
   TextField txtCname=new TextField(30);
   TextField txtCduration=new TextField(30);
   TextField txtCfees=new TextField(30);
   TextField txtnoofcls=new TextField(30);
   
   JLabel lbltitle=new JLabel("COURSE FORM");
    JLabel lblpic=new JLabel();
   JLabel lblnoofcls=new JLabel("No Of Classes:");
   JLabel lblCid=new JLabel("Course ID:");
   JLabel lblCname=new JLabel("Course Name:");
   JLabel lblCduration=new JLabel("Course Duration:");
   JLabel lblCfees=new JLabel("Course Fees");
  
   JLabel lblsave=new JLabel();
public course()
{
  setLayout(null);
  setTitle("COURSE FORM");
  setSize(1500,800);
  setVisible(true);
 lblpic.setIcon(new ImageIcon("c:/amritaj/project1/image/course1.jpg"));
  //lblsave.setIcon(new ImageIcon("D:\Drive file\impfile\java project\reentireprject (1)/course1.jpg"));
  
  lbltitle.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,25));
  lbltitle.setText("<html><u>COURSE FORM</u></html>");

  lbltitle.setForeground(Color.red);
  lblCid.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblCname.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblCduration.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblCfees.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblnoofcls.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblpic.setBounds(650,80,900,440);  
  lbltitle.setBounds(400,50,300,40);
  lblCid.setBounds(100,140,200,40);
  txtCid.setBounds(320,140,200,40);
  lblCname.setBounds(100,210,200,40);
  txtCname.setBounds(320,210,200,40);
  lblCduration.setBounds(100,270,200,40);
  txtCduration.setBounds(320,270,200,40);
  lblCfees.setBounds(100,330,200,40);
  txtCfees.setBounds(320,330,200,40);
  lblnoofcls.setBounds(100,400,200,40);
  txtnoofcls.setBounds(320,400,200,40);
  btnNew.setBounds(100,510,100,40);
  btnSave.setBounds(200,510,100,40);
  btnSearch.setBounds(300,510,100,40);
  btnEdit.setBounds(400,510,100,40);
  btnCancel.setBounds(500,510,100,40);
  btnTable.setBounds(600,510,100,40);
  btnSTable.setBounds(700,510,100,40);
  //lblsave.setBounds(265,510,40,40);
 
  btnSTable.setToolTipText("search by course_id");
 
  add(lbltitle); 
  add(lblCname); 
  add(lblCid);  
  add(lblCduration); 
  add(lblCfees);
  add(txtCid);
  add(txtCname);
  add(txtCduration);
  add(txtCfees);
  add(lblnoofcls);
  add(txtnoofcls);
  add(btnNew);
  add(btnSave);
  add(btnSearch); 
  add(btnEdit); 
  add(btnCancel);
  add(btnTable);  
  add(btnSTable);
   add(lblpic);
  add(lblsave);


  btnCancel.addActionListener(this);    
  btnSave.addActionListener(this);
  btnNew.addActionListener(this);    
  btnEdit.addActionListener(this);    
  btnSearch.addActionListener(this); 
  btnTable.addActionListener(this); 
  btnSTable.addActionListener(this); 
  repaint();
}
public void actionPerformed(ActionEvent e)
{
 if(e.getSource()==btnTable)
  {
    tbldemo1 obj=new tbldemo1();
  }
 if(e.getSource()==btnSTable)
  {
    tbldemo5 obj=new tbldemo5();
  }
 if(e.getSource()==btnNew)
  {
    Connection con;
     try
     {
     con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
     ResultSet res;
     Statement st=con.createStatement();
     res=st.executeQuery("select *from keytbl");
     while(res.next())
     {
      txtCid.setText(""+"c"+res.getString(1));
     }
    }
    catch(Exception ee)
    {
     System.out.println("Exception :"+ee);
    }   
    txtCname.setText("");
    txtCduration.setText("");
    txtCfees.setText("");
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
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adityadb", "root", "Admint@321");
    ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("select *from coursetbl");
    String str="insert into coursetbl(course_id,course_name,course_duration,course_fees,no_of_classes)values(?,?,?,?,?)";
    PreparedStatement ps=con.prepareStatement(str);
    ps.setString(1,txtCid.getText());
    ps.setString(2,txtCname.getText());
    ps.setString(3,txtCduration.getText());
    ps.setString(4,txtCfees.getText());
    ps.setString(5,txtnoofcls.getText());
    ps.executeUpdate();
    JOptionPane.showMessageDialog(null,"saved Successfully");
    txtCid.setText("");   
    txtCname.setText("");
    txtCduration.setText("");
    txtCfees.setText("");
    txtnoofcls.setText("");

    str="update keytbl set course_id=course_id+1";
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
    Connection con;
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adityadb", "root", "Admin@321");
    int flg=0;
    txtCname.setText("");
    txtCduration.setText("");
    txtCfees.setText("");
    txtnoofcls.setText("");
    ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("select *from coursetbl where course_id='"+txtCid.getText()+"'");
   
   while(res.next())
   {
      txtCname.setText(""+res.getString(2));
      txtCduration.setText(""+res.getString(3));
      txtCfees.setText(""+res.getString(4));
      txtnoofcls.setText(""+res.getString(5));
      flg=1;
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
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adityadb", "root", "Admin@321");
    ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("select *from coursetbl");
    String str="update coursetbl set course_name='"+txtCname.getText()+"',course_duration='"+txtCduration.getText()+"',course_fees="+Integer.parseInt(txtCfees.getText())+" where course_id='"+txtCid.getText()+
"'";
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
course obj=new course();

}
}  
  

    
   
   
  
  
       
