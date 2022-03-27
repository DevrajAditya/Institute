import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.sql.*;
public class faculty extends Frame implements ActionListener
{
   JButton btnNew=new JButton("New");
   JButton btnSave=new JButton("Save");
   JButton btnEdit=new JButton("Edit");
   JButton btnSearch=new JButton("Search");
   JButton btnCancel=new JButton("Cancel");
   JButton btnTable=new JButton("Table");
  
   TextField txtfacultyno=new TextField(30);
   TextField txtfacultyname=new TextField(30);
   TextField txtfacultyaddress=new TextField(30);
   TextField txtfacultyqualification=new TextField(30);
   TextField txtfacultygender=new TextField(30);
   TextField txtfacultyextraquali=new TextField(30);
   TextField txtfacultycontactno=new TextField(30);
   TextField txtfacultyemailid=new TextField(30);
   TextField txtfacultyworkex=new TextField(30);

    JLabel lbltitle=new JLabel("FACULTY FORM");
   
   JLabel lblfacultyno=new JLabel("Faculty No:");
   JLabel lblfacultyname=new JLabel("Faculty Name:");
   JLabel lblfacultyaddress=new JLabel("Faculty Address:");
   JLabel lblfacultyqualification=new JLabel("Faculty Qualification:");
   JLabel lblfacultygender=new JLabel("Faculty Gender:");
   JLabel lblfacultyextraquali=new JLabel("Faculty Extra Qualification:");
   JLabel lblfacultycontactno=new JLabel("Faculty Contact No:");
   JLabel lblfacultyemailid=new JLabel("Faculty Email Id:");
   JLabel lblfacultyworkex=new JLabel("Faculty Work Ex.");
   JLabel lblpic=new JLabel();
public faculty()
{
  setLayout(null);
  setTitle("");
  setSize(1500,900);
  setVisible(true);
  
  lbltitle.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,35));
  lbltitle.setForeground(Color.red);
  lbltitle.setText("<html><u>FACULTY FORM</u></html>");

  lblpic.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/faculty1.jpeg"));
  lblfacultyno.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblfacultyname.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblfacultyaddress.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblfacultyqualification.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblfacultygender.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblfacultyextraquali.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblfacultycontactno.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblfacultyemailid.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblfacultyworkex.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblpic.setBounds(850,10,950,750);
  lbltitle.setBounds(400,50,400,40);
  lblfacultyno.setBounds(100,140,200,40);
  txtfacultyno.setBounds(430,140,400,40);
  lblfacultyname.setBounds(100,210,200,40);
  txtfacultyname.setBounds(430,210,400,40);
  lblfacultyaddress.setBounds(100,270,200,40);
  txtfacultyaddress.setBounds(430,270,400,40);
  lblfacultyqualification.setBounds(100,330,300,40);
  txtfacultyqualification.setBounds(430,330,400,40);
  lblfacultygender.setBounds(100,390,200,40);
  txtfacultygender.setBounds(430,390,400,40);
  lblfacultyextraquali.setBounds(100,450,300,40);
  txtfacultyextraquali.setBounds(430,450,400,40);
  lblfacultycontactno.setBounds(100,510,300,40);
  txtfacultycontactno.setBounds(430,510,400,40);
  lblfacultyemailid.setBounds(100,570,200,40);
  txtfacultyemailid.setBounds(430,570,400,40);
  lblfacultyworkex.setBounds(100,630,200,40);
  txtfacultyworkex.setBounds(430,630,400,40);
 
  btnNew.setBounds(220,680,100,40);
  btnSave.setBounds(320,680,100,40);
  btnSearch.setBounds(420,680,100,40);
  btnEdit.setBounds(520,680,100,40);
  btnCancel.setBounds(620,680,100,40);
  btnTable.setBounds(720,680,100,40);
  
  add(lblpic); 
  add(lbltitle);
  add(lblfacultyno); 
  add(lblfacultyname);  
  add(lblfacultyaddress); 
  add(lblfacultyqualification);
  add(lblfacultygender);
  add(lblfacultyextraquali);
  add(lblfacultycontactno);
  add(lblfacultyemailid);
  add(lblfacultyworkex);
  add(txtfacultyno);
  add(txtfacultyname);
  add(txtfacultyaddress);
  add(txtfacultyqualification);
  add(txtfacultygender);
  add(txtfacultyextraquali);
  add(txtfacultycontactno);
  add(txtfacultyemailid);
  add(txtfacultyworkex);
  
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
   
 }
public void actionPerformed(ActionEvent e)
{

   if(e.getSource()==btnTable)
  {
    tbldemo3 obj=new tbldemo3();
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
      txtfacultyno.setText("F"+res.getString(3));
     }
    }
   catch(Exception ee)
   {
   System.out.println("Exception :"+ee);
   }
 
    
    txtfacultyname.setText("");
    txtfacultyaddress.setText("");
    txtfacultyqualification.setText("");
    txtfacultygender.setText("");
    txtfacultyextraquali.setText("");
    txtfacultycontactno.setText("");
    txtfacultyemailid.setText("");
    txtfacultyworkex.setText("");
    
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
    res=st.executeQuery("select *from facultytbl");
    String str="insert into facultytbl(faculty_no,faculty_name,faculty_address,faculty_qualification,faculty_gender,faculty_extraquali,faculty_contactno,faculty_emailid,faculty_workex)values(?,?,?,?,?,?,?,?,?)";
    PreparedStatement ps=con.prepareStatement(str);
    ps.setString(1,txtfacultyno.getText());
    ps.setString(2,txtfacultyname.getText());
    ps.setString(3,txtfacultyaddress.getText());
    ps.setString(4,txtfacultyqualification.getText());
    ps.setString(5,txtfacultygender.getText());
    ps.setString(6,txtfacultyextraquali.getText());
    ps.setString(7,txtfacultycontactno.getText());
    ps.setString(8,txtfacultyemailid.getText());
    ps.setString(9,txtfacultyworkex.getText());
    
    ps.executeUpdate();
    JOptionPane.showMessageDialog(null,"saved Successfully");
    txtfacultyno.setText("");   
    txtfacultyname.setText("");
    txtfacultyaddress.setText("");
    txtfacultyqualification.setText("");
    txtfacultygender.setText("");
    txtfacultyextraquali.setText("");
    txtfacultycontactno.setText("");
    txtfacultyemailid.setText("");
    txtfacultyworkex.setText("");
    
    str="update keytbl set faculty_no=faculty_no+1";
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
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    int flg=0;
    txtfacultyname.setText("");
    txtfacultyaddress.setText("");
    txtfacultyqualification.setText("");
    txtfacultygender.setText("");
    txtfacultyextraquali.setText("");
    txtfacultycontactno.setText("");
    txtfacultyemailid.setText("");
    txtfacultyworkex.setText("");
    
    ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("select *from facultytbl where faculty_no='"+txtfacultyno.getText()+"'");
   
   while(res.next())
     {
      txtfacultyname.setText(""+res.getString(2));
      txtfacultyaddress.setText(""+res.getString(3));
      txtfacultyqualification.setText(""+res.getString(4));
      txtfacultygender.setText(""+res.getString(5));
      txtfacultyextraquali.setText(""+res.getString(6));
      txtfacultycontactno.setText(""+res.getString(7));
      txtfacultyemailid.setText(""+res.getString(8));
      txtfacultyworkex.setText(""+res.getString(9));
    
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
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("select *from facultytbl");
    String str="update facultytbl set faculty_name='"+txtfacultyname.getText()+"',faculty_address='"+txtfacultyaddress.getText()+"',faculty_qualification='"+txtfacultyqualification.getText()+"',faculty_gender='"+txtfacultygender.getText()+"',faculty_extraquali='"+txtfacultyextraquali.getText()+"',faculty_contactno='"+txtfacultycontactno.getText()+"',faculty_emailid='"+txtfacultyemailid.getText()+"',faculty_workex='"+txtfacultyworkex.getText()+"' where faculty_no='"+txtfacultyno.getText()+"'";
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
faculty obj=new faculty();
}
}  
  

    
   
   
  
  
       
