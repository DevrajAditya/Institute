
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
public class tbldemo13 extends Frame implements ActionListener
{
  JButton bclose=new JButton("Close");
  JButton bnew=new JButton("New"); 
  JButton btnsearch=new JButton("Search");
  JButton bprint=new JButton("Print");   

  TextField txtbatchno=new TextField(30);
  JLabel lblbatchno=new JLabel("Enter Batch :");
  TextField txtmonth=new TextField(30);
  JLabel lblmonth=new JLabel("Enter Month :");
  JLabel lbltitle=new JLabel("");
  JLabel lbltitle1=new JLabel("");
  JLabel lblpic=new JLabel();
  JTable table1=new JTable();
  JScrollPane sp; 
  String[] col1={"S.no","Batch_no","Total classes","Reg No.","NO of present","No of absent"}; 
  String x="",m="",n="",o="",p="",q="";
  DefaultTableModel model=new DefaultTableModel(col1,0);           
   int a=0;
  
  public tbldemo13()
  {
     setLayout(null);
  
     setSize(1500,900);
     setVisible(true); 
     
     lblbatchno.setFont(new Font("monotype corsiva",Font.BOLD,20));
     lblmonth.setFont(new Font("monotype corsiva",Font.BOLD,20));
     lblpic.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/tbldemo13.jpg"));
     
     lbltitle.setFont(new Font("Harlow Solid",Font.BOLD,35));
     lbltitle.setForeground(Color.red);
     lbltitle.setText("<html><u>REPORT ON</u></html>");
     lbltitle1.setFont(new Font("Harlow Solid",Font.BOLD,35));
     lbltitle1.setForeground(Color.red);
     lbltitle1.setText("<html><u>ATTENDANCE</u></html>");
     lbltitle.setBounds(500,50,400,60);
     lbltitle1.setBounds(650,100,400,60);
     
     add(lbltitle);
     add(lbltitle1); 
     lblpic.setBounds(880,200,500,500);
     lblbatchno.setBounds(50,200,150,40);
     txtbatchno.setBounds(220,200,120,30);
     
     lblmonth.setBounds(50,250,150,40);
     txtmonth.setBounds(220,250,120,30);
   
    
     bnew.setBounds(60,320,80,30);
     btnsearch.setBounds(140,320,80,30);
     bprint.setBounds(220,320,80,30);
     bclose.setBounds(300,320,80,30);
     add(lblpic);
     add(btnsearch); 
     add(bclose); 
     add(bnew);
     add(bprint);
     add(lblbatchno);
     add(txtbatchno);
     add(lblmonth);
     add(txtmonth);          

     bclose.addActionListener(this);
     bnew.addActionListener(this);    
     btnsearch.addActionListener(this);
     bprint.addActionListener(this);    
}
public void actionPerformed(ActionEvent e)
{
  if(e.getSource()==bclose)
  {
     this.dispose();
  }
  if(e.getSource()==bnew)
  {        
     txtmonth.setText("");
     txtbatchno.setText("");  
     for(int i=model.getRowCount()-1;i>=0;i--)
     {
       model.removeRow(i);
     }
   }
  
  if(e.getSource()==btnsearch)
  {

   try
   {
      Connection con;
      con=DriverManager.getConnection("jdbc:odbc:imsdsn");
      ResultSet res1;
      Statement st1=con.createStatement();
      res1=st1.executeQuery("select DISTINCT edate from attentbl where batch_no='"+txtbatchno.getText()+"'And month='"+txtmonth.getText()+"'");
      while(res1.next())
      {
       a++;
      } 
   }
   catch(Exception eq)
   {
          System.out.println(""+eq);
   }
     
    try
    {
       int ctr=1,s=0,b=0;     
       Connection con;
       String SQL;
       SQL="select DISTINCT reg_no from attentbl where month='"+txtmonth.getText()+"'AND batch_no='"+txtbatchno.getText()+"'";
       con=DriverManager.getConnection("jdbc:odbc:imsdsn");   
       Statement st=con.createStatement();
       ResultSet res;
       res=st.executeQuery(SQL);
       
       while(res.next())
       {
         Vector v1=new Vector();
         x=""+ctr;
         m=""+txtbatchno.getText();
         n=""+a;
         o=res.getString(1);
     
         String SQL1;
         SQL1="select edate from attentbl where reg_no="+Integer.parseInt(o)+"AND batch_no='"+txtbatchno.getText()+"'AND month='"+txtmonth.getText()+"'";
         Statement st1=con.createStatement();
         ResultSet res1;
         res1=st1.executeQuery(SQL1);
         s=0;
         b=0;
         while(res1.next())
         {
           s=s+1;
         }
         p=""+s;
         b=a-s;
         q=""+b;
          
         Object [][]data={{x,m,n,o,p,q}};         
         table1=new JTable(data,col1);       
         table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         sp=new JScrollPane(table1);
         table1.setFillsViewportHeight(true);
         v1.add(x);
         v1.add(m);   
         v1.add(n);
         v1.add(o);   
         v1.add(p);
         v1.add(q);

         table1.setModel(model);
         sp.setBounds(410,250,450,400);
         table1.setBounds(410,250,450,400);               
         add(sp);
         model.addRow(v1);
          
         ctr=ctr+1;
       }
  

     }
     catch(Exception ee)
     {
          System.out.println(""+ee);
     }

//   setLayout(null);
    
     setVisible(true); 
            
  }
 if(e.getSource()==bprint)
 {
    try
    {
       PrintWriter obj=new PrintWriter("Attendance");
      obj.println("\t\t\t\t\tHACK Institute     ");
      obj.println("");
      obj.println("Month:-  "+txtmonth.getText());
      obj.println("        ___________");
      obj.println("");
      obj.println(" ________________________________________________________________________________________________");
      obj.println("|S.No. |    Batch No.   |    Total no. of class |\tReg No. |\tPresent |\tAbsent  |");
      obj.println("|_______________________________________________________________________________________________|");
      int ctr1=1,s1=0,z=0; String reg="";
      Connection con;
      con=DriverManager.getConnection("jdbc:odbc:imsdsn"); 
      ResultSet res;
      Statement st=con.createStatement();
      String str="select DISTINCT reg_no from attentbl where month='"+txtmonth.getText()+"'AND batch_no='"+txtbatchno.getText()+"'";
      res=st.executeQuery(str);
      
      String SQL1;
      ResultSet res1;
      Statement st1=con.createStatement();
     while(res.next())
     {
      reg="";
      reg=res.getString(1);
      obj.print("| "+ctr1+"    |\t"+txtbatchno.getText()+" \t|\t\t "+a+" \t|\t "+reg);
      
      
         
         SQL1="select edate from attentbl where reg_no="+reg+"AND batch_no='"+txtbatchno.getText()+"'AND month='"+txtmonth.getText()+"'";
         res1=st1.executeQuery(SQL1);
         s1=0;
         z=0;
         while(res1.next())//s1 = no of present of a student & z= no of absent of a student & reg for student's regno
         {
           s1=s1+1;
         }
         z=a-s1;
         ctr1=ctr1+1;
         obj.println("\t|\t "+s1+" \t|\t "+z+"\t|\n");
         obj.println("_________________________________________________________________________________________________");
      }
       obj.close();
       Runtime r=Runtime.getRuntime();
      r.exec("notepad c:\\amritaj\\project1\\Attendance");     
    }
    catch(Exception ee)
    {
      System.out.println("Exception :"+ee);
    }
  }
}
public static void main(String args[])
throws IOException
{
     tbldemo13 obj=new tbldemo13();
}
}
