import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class tbldemo7 extends Frame implements ActionListener
{
  String str="";
  String SQL1;
  JLabel lblbatchno=new JLabel("Batch No:");
  JLabel lblpic=new JLabel();
  TextField txtbatchno=new TextField(30);
  JLabel lbltestno=new JLabel("Test No:");
  TextField txttestno=new TextField(30);
  
   JLabel lbltitle=new JLabel("TEST FORM");
   JLabel lblregno=new JLabel("Reg No:");
  TextField txtregno=new TextField(30);
  JLabel lblmarks=new JLabel("Marks:");
  TextField txtmarks=new TextField(30);
  JButton btnNew=new JButton("New");
  JButton bclose=new JButton("Close");
  JButton bsave=new JButton("Save");
  JButton btnSearch=new JButton("Search");
  String[] col={"stud_regno"}; 
       String m="";
       JTable table1=new JTable(); 
       JScrollPane sp;    
       DefaultTableModel model=new DefaultTableModel(col,0); 

  
  public tbldemo7()
  {
    setLayout(null);
    setVisible(true);

    lbltitle.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,35));
    lbltitle.setForeground(Color.red);
    lbltitle.setText("<html><u>TEST FORM</u></html>");

    lblpic.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/test1.jpg"));
    lblbatchno.setFont(new Font("monotype corsiva",Font.BOLD,25));
    lbltestno.setFont(new Font("monotype corsiva",Font.BOLD,25));
    lblregno.setFont(new Font("monotype corsiva",Font.BOLD,25));
    lblmarks.setFont(new Font("monotype corsiva",Font.BOLD,25));
   
    lbltitle.setBounds(400,60,400,40);
    lblpic.setBounds(620,100,700,600);
    
    lblbatchno.setBounds(250,150,130,30);
    txtbatchno.setBounds(400,150,80,30);
    btnSearch.setBounds(500,150,80,30);
    lbltestno.setBounds(250,210,100,30);
    txttestno.setBounds(400,210,80,30);
    lblregno.setBounds(250,270,100,30);
    txtregno.setBounds(400,270,80,30);
    txtmarks.setBounds(400,330,80,30);
    lblmarks.setBounds(250,330,100,30);
    btnNew.setBounds(250,400,80,30);
    bsave.setBounds(330,400,80,30);
    bclose.setBounds(410,400,80,30);
    add(lbltitle);
    add(lblpic);
    add(bclose);
    add(lblbatchno);
    add(txtbatchno);
    add(lbltestno);
    add(txttestno);
    add(lblregno);
    add(txtregno);
    add(lblmarks);
    add(txtmarks);
     add(btnNew);
     add(bsave);
     add(btnSearch);
     add(bclose);
  
     
   
//     setLayout(null);
     setSize(1500,900);
     setVisible(true); 
     
     bclose.addActionListener(this);
     btnNew.addActionListener(this);
     bsave.addActionListener(this);
     btnSearch.addActionListener(this);
    
}
public void actionPerformed(ActionEvent e)
{
  if(e.getSource()==bclose)
  {
     this.dispose();
  }
  if(e.getSource()==btnNew)
  {
   for(int i=model.getRowCount()-1;i>=0;i--)
   {
     model.removeRow(i);
   }
   txtbatchno.setText("");
   txttestno.setText("");
  }
  if(e.getSource()==bsave)
  {
     try
    {
    Connection con; 
    con=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    ResultSet res;
    Statement st=con.createStatement();
    res=st.executeQuery("select *from testtbl");
    String str="insert into testtbl(reg_no,batch_no,test,marks)values(?,?,?,?)";
    PreparedStatement ps=con.prepareStatement(str);
    ps.setString(1,txtregno.getText());
    ps.setString(2,txtbatchno.getText());
    ps.setString(3,txttestno.getText());
    ps.setString(4,txtmarks.getText());
//to chck dat a student z enroll in the given batch or nt

    Connection con1;
    con1=DriverManager.getConnection("jdbc:Odbc:imsdsn");
    int flg=0;
    ResultSet res1;
    Statement st1=con1.createStatement();
    res1=st1.executeQuery("select *from enrolltbl where stud_regno="+Integer.parseInt(txtregno.getText())+"AND batch_no='"+txtbatchno.getText()+"'");
   
    while(res1.next())
    {
      flg=1;
    }
    int flg1=0;
    ResultSet res2;
    Statement st2=con.createStatement();
    res2=st2.executeQuery("select *from testtbl where reg_no="+Integer.parseInt(txtregno.getText())+"AND batch_no='"+txtbatchno.getText()+"'And test='"+txttestno.getText()+"'");
   
   while(res2.next())
     {
     flg1=1;
      }

  if(flg==1)
{
  if(flg1==0)
  {
    ps.executeUpdate();
    JOptionPane.showMessageDialog(null,"saved Successfully");
    txtregno.setText("");
    txtmarks.setText("");
  }
  else
   JOptionPane.showMessageDialog(null,"You Hv Already Inserted the Marks");

}
else
   JOptionPane.showMessageDialog(null,"You Hv Nt Enroll In This Batch ");
   
     }
catch(Exception eee)
     {
          System.out.println(""+eee);
     }
 }
 if(e.getSource()==btnSearch)
  {
 
  try
     {
       Connection con1;
       con1=DriverManager.getConnection("jdbc:odbc:imsdsn");
       Statement st1=con1.createStatement();
       String SQL="select * from enrolltbl where batch_no='"+txtbatchno.getText()+"'";
       ResultSet res1;
       res1=st1.executeQuery(SQL);
       
       while(res1.next())
       {
         
         Vector v=new Vector();
         m=res1.getString(1);
         Object [][]data={{m}};         
         table1=new JTable(data,col);        
         table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         sp=new JScrollPane(table1);
         table1.setFillsViewportHeight(true);
         v.add(m);   
         table1.setModel(model);
         sp.setBounds(100,150,80,400); 
         table1.setBounds(100,150,200,400);               
         add(sp);
         model.addRow(v);
       }
     }
     catch(Exception ee)
     {
          System.out.println(""+ee);
     }
}
}
public static void main(String args[])
throws IOException
{
   tbldemo7 obj=new tbldemo7();
}
}
