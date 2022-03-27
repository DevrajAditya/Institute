import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class tbldemo1 extends Frame implements ActionListener
{
  JButton bclose=new JButton("Close");
  JLabel lblpic=new JLabel();
   //JLabel lblpic1=new JLabel();
  public tbldemo1()
  {
     setLayout(null);
     setBackground(new Color(234,255,229));
     lblpic.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/course2.jpg"));
     //lblpic1.setIcon(new ImageIcon("c:/amritaj/project1/image/course3.jpg"));
     lblpic.setBounds(350,80,600,200);
     //lblpic1.setBounds(900,400,400,400);
     bclose.setBounds(800,670,80,40);
     add(lblpic);
    // add(lblpic1);
     add(bclose); 
     try
     {
       Connection con;
       con=DriverManager.getConnection("jdbc:odbc:imsdsn");
       Statement st=con.createStatement();
       String SQL="select * from coursetbl";
       ResultSet res;
       res=st.executeQuery(SQL);
       String[] col={"course_id","Course_name","course_duration","course_fees"}; 
       String m="",n="",o="",p="";
       JTable table1 =new JTable();
       JScrollPane sp;  
       DefaultTableModel model=new DefaultTableModel(col,0); 
       while(res.next())
       {
         Vector v=new Vector();
         m=res.getString(1);
         n=res.getString(2);
         o=res.getString(3);
         p=res.getString(4);
         Object [][]data={{m,n,o,p}};         
         table1=new JTable(data,col);        
         table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         sp=new JScrollPane(table1);
         table1.setFillsViewportHeight(true);
         v.add(m);   
         v.add(n);
         v.add(o);
         v.add(p);    
         table1.setModel(model);
         sp.setBounds(500,320,300,400); 
         table1.setBounds(500,320,300,500);               
         add(sp);
         model.addRow(v);
       }
     }
     catch(Exception ee)
     {
          System.out.println(""+ee);
     }
//     setLayout(null);
     setSize(1500,1000);
     setVisible(true); 
     
     bclose.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
  if(e.getSource()==bclose)
  {
     this.dispose();
  }
}
public static void main(String args[])
throws IOException
{
     tbldemo1 obj=new tbldemo1();
}
}
