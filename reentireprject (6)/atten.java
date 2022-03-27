import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.Calendar;
public class atten extends Frame implements ActionListener
{
   JButton btnNew=new JButton("New");
   JButton btnSave=new JButton("Save");
   JButton btnsearch=new JButton("Search");
   JButton btnsearch1=new JButton("Info");
   JButton btnCancel=new JButton("Cancel");

   TextField txtregno=new TextField(30);
   TextField txtbatchno=new TextField(30);
   TextField txtmonth=new TextField(30);
   TextField txtdate=new TextField(30);

   JLabel lblpic=new JLabel();
   
   JLabel lbltitle=new JLabel("ATTENDANCE FORM");
   JLabel lblcourseid=new JLabel("Course Id:");
   TextField txtcourseid=new TextField(30);
   JLabel lblregno=new JLabel("Reg No:");
   JLabel lblbatchno=new JLabel("Batch No:");
   JLabel lblmonth=new JLabel("Month:");
   JLabel lbldate=new JLabel("Day: ");
   JLabel lblyear=new JLabel("Year: ");
   TextField txtyear=new TextField(30);
public atten()
{
  setLayout(null);
  setTitle("");
  setSize(1500,900);
  setVisible(true);
  lblpic.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/atten1.jpg"));
  
  lbltitle.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,35));
  lbltitle.setForeground(Color.red);
  lbltitle.setText("<html><u>ATTENDANCE FORM</u></html>");

  lblregno.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblbatchno.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblmonth.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lbldate.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblcourseid.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblyear.setFont(new Font("monotype corsiva",Font.BOLD,25));

  lblpic.setBounds(850,250,900,320);
  
  lbltitle.setBounds(400,50,550,60);
  lblbatchno.setBounds(100,190,200,40);
  txtbatchno.setBounds(320,190,200,40);
  lblregno.setBounds(100,260,200,40);
  txtregno.setBounds(320,260,200,40);
  lblcourseid.setBounds(100,320,200,40);
  txtcourseid.setBounds(320,320,200,40);
  
  btnsearch.setBounds(530,190,100,30);
  lbldate.setBounds(100,380,200,40);
  txtdate.setBounds(320,380,200,40);
  lblmonth.setBounds(100,450,200,40);
  txtmonth.setBounds(320,450,200,40);
  lblyear.setBounds(100,520,200,40);
  txtyear.setBounds(320,520,200,40);
  btnNew.setBounds(300,590,100,40);
  btnSave.setBounds(400,590,100,40);
  btnsearch1.setBounds(500,590,100,40);
  btnCancel.setBounds(600,590,100,40);
   
  add(lblpic);
  add(lbltitle);
  add(lblregno); 
  add(lblbatchno);  
  add(lblmonth); 
  add(lbldate);
  add(lblcourseid);
  add(txtcourseid);
  add(txtregno);
  add(txtbatchno);
  add(txtmonth);
  add(txtdate);
  add(lblyear);
  add(txtyear);
  add(btnNew);
  add(btnSave);
  add(btnsearch);
  add(btnsearch1);
  add(btnCancel);
  btnCancel.addActionListener(this); 
  btnsearch.addActionListener(this);   
  btnSave.addActionListener(this);
  btnNew.addActionListener(this);  
  btnsearch1.addActionListener(this);  
 }
public void actionPerformed(ActionEvent e)
{

if(e.getSource()==btnCancel)
  {
    this.dispose();
  }
if(e.getSource()==btnsearch1)
  {
   tbldemo8 obj=new tbldemo8();
  }

if(e.getSource()==btnsearch)
  {
int flg=0;
 try
  {
    Connection con;
    con=DriverManager.getConnection("jdbc:odbc:imsdsn");
    ResultSet res2;
    Statement st2=con.createStatement();
    res2=st2.executeQuery("select course_id from enrolltbl where batch_no='"+txtbatchno.getText()+"'");
    while(res2.next())
    {
    txtcourseid.setText(""+res2.getString(1));
    }
  }
  catch(Exception ex)
   {
          System.out.println(""+ex);
   }
   try
     {
       Connection con1;
       con1=DriverManager.getConnection("jdbc:odbc:imsdsn");
       Statement st1=con1.createStatement();
       String SQL="select * from enrolltbl where batch_no='"+txtbatchno.getText()+"'";
       ResultSet res1;
       res1=st1.executeQuery(SQL);
       String[] col={"stud_regno"}; 
       String m="";
       JTable table1=new JTable(); 
       JScrollPane sp;    
       DefaultTableModel model=new DefaultTableModel(col,0); 

       while(res1.next())
       {
         flg=1;
         Vector v=new Vector();
         m=res1.getString(1);
         Object [][]data={{m}};         
         table1=new JTable(data,col);        
         table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         sp=new JScrollPane(table1);
         table1.setFillsViewportHeight(true);
         v.add(m);   
         table1.setModel(model);
         sp.setBounds(710,200,80,400); 
         table1.setBounds(710,200,200,400);               
         add(sp);
         model.addRow(v);
       }
     }
     catch(Exception ee)
     {
          System.out.println(""+ee);
     } 
if(flg==0)
JOptionPane.showMessageDialog(null,"InValid Batch No"); 
  }

 if(e.getSource()==btnNew)
  {
    String str;
    txtbatchno.setText("");
    txtregno.setText("");
    txtmonth.setText("");
    txtdate.setText("");
    txtcourseid.setText("");
    String months[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
    Calendar calendar=Calendar.getInstance();
    txtmonth.setText(""+(months[calendar.get(Calendar.MONTH)]));
    txtdate.setText(""+calendar.get(Calendar.DATE));
    txtyear.setText(""+calendar.get(Calendar.YEAR));
   }
  
  if(e.getSource()==btnSave)
  {
int flg=0;
   try
   {
  //class.forName("sun.jdbc.odbc.jdbcOdbcDriver");
    Connection con; 
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("select *from attentbl");
    String str="insert into attentbl(reg_no,batch_no,month,edate,course_id)values(?,?,?,?,?)";
    PreparedStatement ps=con.prepareStatement(str);
    ps.setString(1,txtregno.getText());
    ps.setString(2,txtbatchno.getText());
    ps.setString(3,txtmonth.getText());
    ps.setString(4,txtdate.getText());
    ps.setString(5,txtcourseid.getText());
    int flg1=0;
    ResultSet res2;
    Statement st2=con.createStatement();
    res2=st2.executeQuery("select *from enrolltbl where stud_regno="+Integer.parseInt(txtregno.getText())+"And batch_no='"+txtbatchno.getText()+"'And course_id='"+txtcourseid.getText()+"'");
     while(res2.next())
     {
      flg=1;
     }

    ResultSet res3;
    Statement st3=con.createStatement();
    res3=st3.executeQuery("select *from attentbl where reg_no="+Integer.parseInt(txtregno.getText())+"And batch_no='"+txtbatchno.getText()+"'And edate="+Integer.parseInt(txtdate.getText()));
     while(res3.next())
     {
      flg1=1;
     }
  if(flg==1)
{
    
  if(flg1==0)
{
    ps.executeUpdate();
    JOptionPane.showMessageDialog(null,"saved Successfully");
}
else

{
  JOptionPane.showMessageDialog(null,"Repeating attendence");
}
}
else
  JOptionPane.showMessageDialog(null,"Sry!! Either Invalid Course Id OR Batch No");

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
atten obj=new atten();

}
}  
  

    
   
   
  
  
       
