
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.applet.*;
import java.io.*;
import java.sql.*;
public class enquiry extends Frame implements ActionListener
{
   Choice gender=new Choice();
   Choice heard=new Choice();
   JButton btnNew=new JButton("New");
   JButton btnSave=new JButton("Submit");
   JButton btnCancel=new JButton("Cancel");
  
  
   TextField txtname=new TextField(30);
   TextField txtfathername=new TextField(30);
   TextField txtdob=new TextField(30);
   TextField txtaddress=new TextField(30);
   TextField txtcontactno=new TextField(30);
   TextField txtemailid=new TextField(30);
   TextField txtqualification=new TextField(30);
   TextField txtaboutenquiry=new TextField(30);

   JLabel lbltitle=new JLabel("Enquiry    Form");
   
   JLabel lblname=new JLabel("Name:");
   JLabel lblfathername=new JLabel("Father's Name:");
   JLabel lbldob=new JLabel("Date Of Birth:");
   JLabel lbladdress=new JLabel("Address:");
   JLabel lblgender=new JLabel("Gender:");
   JLabel lblcontactno=new JLabel("Contact NO:");
   JLabel lblemailid=new JLabel("E-mail:");
   JLabel lblqualification=new JLabel("Educational Qualification:");
  
   JLabel lblheard=new JLabel("How You Heard About Us:");
   JLabel lblaboutenquiry=new JLabel("About Enquiry:");
   JLabel lblpic=new JLabel();
  
public enquiry()
{
  setLayout(null);
  setTitle("");
  setSize(1500,750);
  setVisible(true);

  lbltitle.setFont(new Font("Harlow Solid",Font.BOLD,35));
  lbltitle.setForeground(Color.red);
  lbltitle.setText("<html><u>ENQUIRY FORM</u></html>");
  lblpic.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/enquiry1.jpg"));
  
  lblname.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lbldob.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblfathername.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblgender.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lbladdress.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblcontactno.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblemailid.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblqualification.setFont(new Font("monotype corsiva",Font.BOLD,25));
 
  lblheard.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblaboutenquiry.setFont(new Font("monotype corsiva",Font.BOLD,25));
  
  lbltitle.setBounds(500,50,400,60);
  lblpic.setBounds(900,100,700,600);
  lblname.setBounds(100,120,200,40);
  txtname.setBounds(430,120,400,30);
  lblfathername.setBounds(100,170,300,40);
  txtfathername.setBounds(430,170,400,30);
  lbldob.setBounds(100,220,200,40);
  txtdob.setBounds(430,220,400,30);
  lblgender.setBounds(100,270,300,40);
  gender.setBounds(430,270,300,40);
  lbladdress.setBounds(100,320,300,40);
  txtaddress.setBounds(430,320,400,30);
  lblcontactno.setBounds(100,370,300,40);
  txtcontactno.setBounds(430,370,400,30);
  lblemailid.setBounds(100,420,200,40);
  txtemailid.setBounds(430,420,400,30);
  lblqualification.setBounds(100,470,280,40);
 
  txtqualification.setBounds(430,470,400,30);
  lblheard.setBounds(100,520,400,40);
  heard.setBounds(430,520,400,40);
  lblaboutenquiry.setBounds(100,570,400,40);
  txtaboutenquiry.setBounds(430,570,400,100);
  btnNew.setBounds(430,680,100,40);
  btnSave.setBounds(570,680,100,40);
  btnCancel.setBounds(710,680,100,40);
  
  add(lbltitle);
  add(lblpic);
  add(lblname); 
  add(lblemailid); 
  add(lblfathername);
  add(lbldob); 
  add(lblgender);
  add(lbladdress);
  add(lblcontactno);
  add(lblqualification);
 
  add(lblheard);
  add(lblaboutenquiry);                                                     
  add(txtemailid);
  add(txtname);
  add(txtfathername);
  add(txtdob);
  add(gender);
  add(txtaddress);
  add(txtcontactno);
  add(txtqualification);
  add(heard);
  add(txtaboutenquiry);
 
  add(btnNew);
  add(btnSave);
  add(btnCancel);
  
  btnCancel.addActionListener(this);    
  btnSave.addActionListener(this);
  btnNew.addActionListener(this);    
   
 }
public void actionPerformed(ActionEvent e)
{
 
 
  if(e.getSource()==btnNew)
   {
    
 
    
    txtname.setText("");
    txtdob.setText("");
    txtfathername.setText("");
    txtaddress.setText("");
    txtcontactno.setText("");
    txtqualification.setText("");
    gender.removeAll();
    gender.add("male");
    gender.add("female");
    heard.add("Through a Friend");
    heard.add("Hack Institute Team Visited Our College");
    heard.add("From Facebook");
    heard.add("Through a Banner");
    heard.add("Through Other Social Media(Whatsapp etc.)");
    heard.add("Others");
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
    res=st.executeQuery("select *from enquirytbl");
    String str="insert into enquirytbl(sname,fathername,dob,gender,address,contactno,emailid,qualification,heard,aboutenquiry)values(?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement ps=con.prepareStatement(str);
   
    
    ps.setString(1,txtname.getText());
    ps.setString(2,txtfathername.getText());
    ps.setString(3,txtdob.getText());
    ps.setString(4,gender.getSelectedItem());
    ps.setString(5,txtaddress.getText());
    ps.setString(6,txtcontactno.getText());
    ps.setString(7,txtemailid.getText());
    ps.setString(8,txtqualification.getText());
    
    ps.setString(9,heard.getSelectedItem());
    ps.setString(10,txtaboutenquiry.getText());
    ps.executeUpdate();
    JOptionPane.showMessageDialog(null,"saved Successfully");
         
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
enquiry obj=new enquiry();
}
}  
  

    
   
   
  
  
       
