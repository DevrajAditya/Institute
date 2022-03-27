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

public class tbldemo5 extends Frame implements ActionListener
{
  JButton bclose=new JButton("Close");
  JLabel lblpic=new JLabel();
   JLabel lbltitle=new JLabel("");
  JLabel lbltitle1=new JLabel("");
  public tbldemo5()
  {
     setLayout(null);
     lbltitle.setFont(new Font("Harlow Solid",Font.BOLD,35));
     lbltitle.setForeground(Color.red);
     lbltitle.setText("<html><u>COURSE'S</u></html>");
     lbltitle1.setFont(new Font("Harlow Solid",Font.BOLD,35));
     lbltitle1.setForeground(Color.red);
     lbltitle1.setText("<html><u>TABLE</u></html>");
     lblpic.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/course4.jpg"));
     lbltitle.setBounds(500,50,400,60);
     lbltitle1.setBounds(650,100,400,60);
     bclose.setBounds(660,580,80,40);
     lblpic.setBounds(850,200,500,500);
     add(bclose); 
     add(lblpic);
     add(lbltitle);
     add(lbltitle1); 
     try
     {
       Connection con;
       con=DriverManager.getConnection("jdbc:odbc:imsdsn");
       Statement st=con.createStatement();
       String SQL="select * from enrolltbl ORDER BY course_id";
       ResultSet res;
       res=st.executeQuery(SQL);
       String[] col={"stud_regno","course_id","adate","course_fees","batch_no"}; 
       String m="",n="",o="",p="",q="";
       JTable table1=new JTable();
       JScrollPane sp;  
       DefaultTableModel model=new DefaultTableModel(col,0); 
       while(res.next())
       {
         Vector v=new Vector();
         m=res.getString(1);
         n=res.getString(2);
         o=res.getString(3);
         p=res.getString(4);
         q=res.getString(5);
         Object [][]data={{m,n,o,p,q}};         
         table1=new JTable(data,col);        
         table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         sp=new JScrollPane(table1);
         table1.setFillsViewportHeight(true);
         v.add(m);   
         v.add(n);
         v.add(o);
         v.add(p); 
         v.add(q);   
         table1.setModel(model);
         sp.setBounds(280,230,380,400); 
         table1.setBounds(280,230,400,400);               
         add(sp);
         model.addRow(v);
       }
     }
     catch(Exception ee)
     {
          System.out.println(""+ee);
     }
//     setLayout(null);
     setSize(1500,900);
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
     tbldemo5 obj=new tbldemo5();
}
}
