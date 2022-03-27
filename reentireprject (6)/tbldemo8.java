
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
public class tbldemo8 extends Frame implements ActionListener,ItemListener
{
  JButton bclose=new JButton("Close");
  JButton bnew=new JButton("New"); 
  JButton btnsearch=new JButton("Search");
  JButton btnsearchcourseid=new JButton("Search");
  JButton btnok=new JButton("OK");
  JButton btnsearch1=new JButton("Search");
  JButton btnsearch2=new JButton("Search");
   
  JRadioButton atten=new JRadioButton("atten");
  JRadioButton nooftime=new JRadioButton("No of Time");
  JRadioButton todayproxy=new JRadioButton("Today's proxy");

  TextField txtbatchno=new TextField(30);
  JLabel lblbatchno=new JLabel("Enter Batch :");
  TextField txtcourseid=new TextField(30);
  JLabel lblcourseid=new JLabel("Enter Course_id:");
  TextField txtmonth=new TextField(30);
  JLabel lblmonth=new JLabel("Enter Month :");

  TextField txtdays=new TextField(30);
  JLabel lbldays=new JLabel("Total No Of Cls :");
  TextField txtregno=new TextField(30);
  JLabel lblregno=new JLabel("Enter RegNo :");
  TextField txtnoofdays=new TextField(30);
  JLabel lblnoofdays=new JLabel("No. Of Days Present :");
 
//buttons for "NOOFTIME"
  TextField txtregno1=new TextField(30);
  JLabel lblregno1=new JLabel("Enter RegNo :");
  TextField txtedate=new TextField(30);
  JLabel lbledate=new JLabel("Enter Date :");
  TextField txtnooftime=new TextField(30);
  JLabel lblnooftime=new JLabel("No Of Time:");
//buttons for "TODAY'S PROXY"
  
  TextField txtproxybatchno=new TextField(30);
  JLabel lblproxybatchno=new JLabel("Enter Batch :");
  TextField txtproxydate=new TextField(30);
  JLabel lblproxydate=new JLabel("Enter Date :");
  JButton btnproxysearch=new JButton("Search");
  JLabel lblproxymonth=new JLabel("Enter Month :");
  TextField txtproxymonth=new TextField(30);
 
   JLabel lblpic1=new JLabel(); 

  String SQL;
  ButtonGroup group=new ButtonGroup();
  JTable table1=new JTable();
  JScrollPane sp; 
  String[] col1={"stud_regno","Batch_no","Month","edate"}; 
  String m="",n="",o="",p="";
  int c=0;
  DefaultTableModel model=new DefaultTableModel(col1,0);           
     
  
  public tbldemo8()
  {
     setLayout(null);
   //setLayout(null);
     setSize(1500,900);
     setVisible(true); 
     lblpic1.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/atten2.jpg"));
     lblbatchno.setFont(new Font("monotype corsiva",Font.BOLD,20));
     lblmonth.setFont(new Font("monotype corsiva",Font.BOLD,20));
     lblregno1.setFont(new Font("monotype corsiva",Font.BOLD,20));
     lbledate.setFont(new Font("monotype corsiva",Font.BOLD,20));
     lblnooftime.setFont(new Font("monotype corsiva",Font.BOLD,20));
     lbldays.setFont(new Font("monotype corsiva",Font.BOLD,20));
     lblnoofdays.setFont(new Font("monotype corsiva",Font.BOLD,20));
     lblregno.setFont(new Font("monotype corsiva",Font.BOLD,20));
      
     lblproxybatchno.setFont(new Font("monotype corsiva",Font.BOLD,20));
     lblproxydate.setFont(new Font("monotype corsiva",Font.BOLD,20));
     lblproxymonth.setFont(new Font("monotype corsiva",Font.BOLD,20));
     lblcourseid.setFont(new Font("monotype corsiva",Font.BOLD,20));
     lblpic1.setBounds(400,50,550,150);
     lblbatchno.setBounds(600,390,200,40);
     txtbatchno.setBounds(750,390,120,30);
     lblcourseid.setBounds(600,430,200,40);
     txtcourseid.setBounds(750,430,120,30);
     lblmonth.setBounds(600,470,200,40);
     txtmonth.setBounds(750,470,120,30);
     btnsearchcourseid.setBounds(890,390,80,30);
     btnok.setBounds(750,510,100,30);

     lblregno1.setBounds(600,510,200,40);
     txtregno1.setBounds(750,510,120,30);
     lbledate.setBounds(600,550,200,40);
     txtedate.setBounds(750,550,120,30);
     lblnooftime.setBounds(600,590,200,40);
     txtnooftime.setBounds(750,590,120,30);
     lbldays.setBounds(100,500,200,40);
     txtdays.setBounds(380,500,80,30);  
     lblregno.setBounds(100,540,200,40);
     txtregno.setBounds(380,540,80,30);
     lblnoofdays.setBounds(100,580,300,40);
     txtnoofdays.setBounds(380,580,80,30);
     

     lblproxybatchno.setBounds(600,450,150,40);
     txtproxybatchno.setBounds(720,450,100,30);
     lblproxydate.setBounds(600,500,150,40);
     txtproxydate.setBounds(720,500,100,30);
     lblproxymonth.setBounds(600,550,150,40);
     txtproxymonth.setBounds(720,550,100,30);
     btnproxysearch.setBounds(840,550,80,30);

     
     bclose.setBounds(100,400,80,40);
     bnew.setBounds(600,350,80,30);
     btnsearch.setBounds(700,350,80,30);
     btnsearch1.setBounds(480,540,80,30);
     btnsearch2.setBounds(880,550,80,30);
 
     nooftime.setBounds(600,200,100,40);
     atten.setBounds(600,250,100,40); 
     todayproxy.setBounds(600,300,150,40); 
     add(lblpic1);
     add(btnsearch); 
     add(bclose); 
     add(bnew);
     add(lblmonth);
     add(txtmonth);
     add(lblcourseid);
     add(txtcourseid);
     add(btnsearchcourseid);
     add(txtproxybatchno);
     add(lblproxybatchno);
     add(txtproxydate);
     add(lblproxydate);
     add(txtproxymonth);
     add(lblproxymonth);

     lblproxybatchno.setVisible(false);
     txtproxybatchno.setVisible(false);
     lblproxydate.setVisible(false);
     txtproxydate.setVisible(false);
     lblproxymonth.setVisible(false);
     txtproxymonth.setVisible(false);  
     btnsearch.setVisible(false);   
     
     group.add(atten);
     group.add(nooftime);
     group.add(todayproxy);
     add(nooftime);
     add(atten);
     add(todayproxy);

     bclose.addActionListener(this);
     bnew.addActionListener(this);    
     btnsearch.addActionListener(this);
     lblmonth.setVisible(false);
     txtmonth.setVisible(false);
     lblcourseid.setVisible(false);
     txtcourseid.setVisible(false);
     btnsearchcourseid.setVisible(false);
     btnsearchcourseid.addActionListener(this);
     btnok.addActionListener(this);
     btnsearch1.addActionListener(this);
     btnsearch2.addActionListener(this);
     atten.addItemListener(this);
     nooftime.addItemListener(this);
     todayproxy.addItemListener(this);
     btnproxysearch.addActionListener(this);
       
}

public void itemStateChanged(ItemEvent ie)
{
   if(atten.isSelected())
   { 
    btnsearch.setVisible(true);  
   }       
   if(nooftime.isSelected())
   {
     add(lblregno1);add(txtregno1);    
     add(lbledate);add(txtedate);
     add(lblnooftime);add(txtnooftime);
     add(btnsearch2);
     btnsearch2.setVisible(true);
     lblmonth.setVisible(true);
     txtmonth.setVisible(true);

     lblregno1.setVisible(true);
     txtregno1.setVisible(true);
     lbledate.setVisible(true);
     txtedate.setVisible(true);
     lblnooftime.setVisible(true);
     txtnooftime.setVisible(true);
     
   
   }
   if(todayproxy.isSelected())
   {
     lblproxybatchno.setVisible(true);
     txtproxybatchno.setVisible(true);
     lblproxydate.setVisible(true);
     txtproxydate.setVisible(true);
     lblproxymonth.setVisible(true);
     txtproxymonth.setVisible(true);
     btnproxysearch.setVisible(true);
     add(btnproxysearch);
   }
  
}
public void actionPerformed(ActionEvent e)
{
  if(e.getSource()==bclose)
  {
     this.dispose();
  }
  if(e.getSource()==bnew)
  {       
     group.clearSelection();
     txtmonth.setText("");
     txtbatchno.setText("");
     txtdays.setText("");
     txtregno.setText("");
     txtnoofdays.setText("");
     
     txtregno1.setText("");
     txtedate.setText("");
     txtnooftime.setText("");
     btnsearch.setVisible(false);
     lblbatchno.setVisible(false);
     txtbatchno.setVisible(false);
     btnsearch2.setVisible(false);
     btnok.setVisible(false);
     lblmonth.setVisible(false);
     txtmonth.setVisible(false);
     txtdays.setVisible(false);
     lbldays.setVisible(false);
     txtregno.setVisible(false);
     lblregno.setVisible(false);
     txtnoofdays.setVisible(false);
     lblnoofdays.setVisible(false);
     
     btnsearch1.setVisible(false);
     lblregno1.setVisible(false);
     txtregno1.setVisible(false);
     lbledate.setVisible(false);
     txtedate.setVisible(false);
     lblnooftime.setVisible(false);
     txtnooftime.setVisible(false);
     lblcourseid.setVisible(false);
     txtcourseid.setVisible(false);
     btnsearchcourseid.setVisible(false);
     lblproxybatchno.setVisible(false);
     txtproxybatchno.setVisible(false);
     lblproxydate.setVisible(false);
     txtproxydate.setVisible(false);
     lblproxymonth.setVisible(false);
     txtproxymonth.setVisible(false);
     btnproxysearch.setVisible(false);

     for(int i=model.getRowCount()-1;i>=0;i--)
   {
   model.removeRow(i);
    }
  } 
 
  
  if(e.getSource()==btnsearch)
  {
     add(lblbatchno); 
     add(txtbatchno); 
     add(btnok);
     add(btnsearchcourseid);
     txtmonth.setVisible(true);
     lblmonth.setVisible(true);
     txtcourseid.setVisible(true);
     lblcourseid.setVisible(true);
     txtbatchno.setVisible(true);
     lblbatchno.setVisible(true);
     btnsearchcourseid.setVisible(true);
     btnok.setVisible(true);
  }
if(e.getSource()==btnsearchcourseid)
  {
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
  }
  if(e.getSource()==btnsearch1)
  {
   int a=0;
   try
   {
    Connection con;
    con=DriverManager.getConnection("jdbc:odbc:imsdsn");
    ResultSet res1;
    Statement st1=con.createStatement();
    res1=st1.executeQuery("select DISTINCT edate from attentbl where course_id='"+txtcourseid.getText()+"'AND reg_no="+Integer.parseInt(txtregno.getText())+"AND month='"+txtmonth.getText()+"'");
    while(res1.next())
    {
     a++;
    }

    txtnoofdays.setText(""+a);
    
   }
   catch(Exception eq)
   {
          System.out.println(""+eq);
   }
  }
if(e.getSource()==btnsearch2)
  {
    try
     {
          int z=0;
          Connection con;
          con=DriverManager.getConnection("jdbc:odbc:imsdsn");
          ResultSet res1;
          Statement st2=con.createStatement();
          res1=st2.executeQuery("select batch_no from attentbl where month='"+txtmonth.getText()+"'AND reg_no="+Integer.parseInt(txtregno1.getText())+"AND edate="+Integer.parseInt(txtedate.getText()));
         
          while(res1.next())
          
         {
          
             z++;
          }
          
          txtnooftime.setText(""+z);   
          
      }
      catch(Exception ew)
      {
          System.out.println(""+ew);
      }
//********************
   try
   {
       Connection con;
       SQL="select * from attentbl where month='"+txtmonth.getText()+"'AND reg_no="+Integer.parseInt(txtregno1.getText())+"AND edate="+Integer.parseInt(txtedate.getText());
       con=DriverManager.getConnection("jdbc:odbc:imsdsn");   
       Statement st=con.createStatement();
       ResultSet res;
       res=st.executeQuery(SQL);
       
       while(res.next())
       {
         Vector v1=new Vector();
         m=res.getString(1);
         n=res.getString(2);
         o=res.getString(3);
         p=res.getString(4);

         Object [][]data={{m,n,o,p}};         
         table1=new JTable(data,col1);       
         table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         sp=new JScrollPane(table1);
         table1.setFillsViewportHeight(true);
         v1.add(m);   
         v1.add(n);
         v1.add(o);   
         v1.add(p);


         table1.setModel(model);
         sp.setBounds(50,50,250,400);
         table1.setBounds(50,50,250,400);               
         add(sp);
         model.addRow(v1);
       }
     }
     catch(Exception ee)
     {
          System.out.println(""+ee);
     }
//********************     
  }
 if(e.getSource()==btnproxysearch)
{
 SQL="select  * from attentbl where batch_no='"+txtproxybatchno.getText()+"'And edate="+Integer.parseInt(txtproxydate.getText())+"And month='"+txtproxymonth.getText()+"'";
  Connection con;
      try
      {
       con=DriverManager.getConnection("jdbc:odbc:imsdsn");   
       Statement st=con.createStatement();
       ResultSet res;
       res=st.executeQuery(SQL);
       
       while(res.next())
       {
          Vector v1=new Vector();
          m=res.getString(1);
          n=res.getString(2);
          o=res.getString(3);
          p=res.getString(4);

         Object [][]data={{m,n,o,p}};         
         table1=new JTable(data,col1);       
         table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         sp=new JScrollPane(table1);
         table1.setFillsViewportHeight(true);
         v1.add(m); v1.add(n);v1.add(o);v1.add(p);  
        

         table1.setModel(model);
         sp.setBounds(50,50,250,400);
         table1.setBounds(50,50,250,400);               
         add(sp);
         model.addRow(v1);
       }
     }
     catch(Exception ee)
     {
          System.out.println(""+ee);
     }
}

  if(e.getSource()==btnok)
  {
     SQL="select * from attentbl where batch_no='"+txtbatchno.getText()+"'AND month='"+txtmonth.getText()+"'";
      
      add(lbldays);
      add(txtdays);
      add(lblnoofdays);
      add(txtnoofdays);
      add(lblregno);
      add(txtregno);
      add(btnsearch1);
     
      txtdays.setVisible(true);
      lbldays.setVisible(true);
      txtregno.setVisible(true);
      lblregno.setVisible(true);
      txtnoofdays.setVisible(true);
      lblnoofdays.setVisible(true);
      
      btnsearch1.setVisible(true); 
      Connection con;
      try
      {
       con=DriverManager.getConnection("jdbc:odbc:imsdsn");   
       Statement st=con.createStatement();
       ResultSet res;
       res=st.executeQuery(SQL);
       
       while(res.next())
       {
         Vector v1=new Vector();
         m=res.getString(1);
         n=res.getString(2);
         o=res.getString(3);
         p=res.getString(4);

         Object [][]data={{m,n,o,p}};         
         table1=new JTable(data,col1);       
         table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         sp=new JScrollPane(table1);
         table1.setFillsViewportHeight(true);
         v1.add(m);   
         v1.add(n);
         v1.add(o);      
         v1.add(p);

         table1.setModel(model);
         sp.setBounds(50,50,250,400);
         table1.setBounds(50,50,250,400);               
         add(sp);
         model.addRow(v1);
       }
     }
     catch(Exception ee)
     {
          System.out.println(""+ee);
     }
     try
     {
          c=0;
          con=DriverManager.getConnection("jdbc:odbc:imsdsn");
          ResultSet res1;
          Statement st2=con.createStatement();
          res1=st2.executeQuery("select DISTINCT edate from attentbl where batch_no='"+txtbatchno.getText()+"'AND month='"+txtmonth.getText()+"'");
          while(res1.next())
          {
           c++;
          }
          txtdays.setText(""+c);   
      }
      catch(Exception ew)
      {
          System.out.println(""+ew);
      }
    

          
  }
}
public static void main(String args[])
throws IOException
{
     tbldemo8 obj=new tbldemo8();
}
}
