import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class tbldemo3 extends Frame implements ActionListener
{
  JButton bclose=new JButton("Close");
  JLabel lblpic=new JLabel();
  JLabel lbltitle=new JLabel("");
  JLabel lbltitle1=new JLabel("");
  public tbldemo3()
  {
     setLayout(null);
    // lblpic.setIcon(new ImageIcon("D:\Drive file\impfile\java project\reentireprject (1)/faculty1.jpg"));
     //lblpic.setBounds(850,200,500,500);
     lbltitle.setFont(new Font("Harlow Solid",Font.BOLD,35));
     lbltitle.setForeground(Color.red);
     lbltitle.setText("<html><u>Faculty'S</u></html>");
     lbltitle1.setFont(new Font("Harlow Solid",Font.BOLD,35));
     lbltitle1.setForeground(Color.red);
     lbltitle1.setText("<html><u>TABLE</u></html>");
     lbltitle.setBounds(500,50,400,60);
     lbltitle1.setBounds(650,100,400,60);
    // add(lblpic);
     add(lbltitle);
     add(lbltitle1); 

     bclose.setBounds(880,650,80,40);
     add(bclose); 
     try
     {
       Connection con;
       con=DriverManager.getConnection("jdbc:odbc:imsdsn");
       Statement st=con.createStatement();
       String SQL="select * from facultytbl";
       ResultSet res;
       res=st.executeQuery(SQL);
       String[] col={"faculty_no","faculty_name","faculty_address","faculty_qualification","fgender","extra quali","contact no","email id","wrkexp"}; 
       String m="",n="",o="",p="",q="",r="",s="",t="",u="";
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
         q=res.getString(5);
         r=res.getString(6);
         s=res.getString(7);
         t=res.getString(8);
         u=res.getString(9);
        
         Object [][]data={{m,n,o,p,q,r,s,t,u}};         
         table1=new JTable(data,col);        
         table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         sp=new JScrollPane(table1);
         table1.setFillsViewportHeight(true);
         v.add(m);   
         v.add(n);
         v.add(o);
         v.add(p); 
         v.add(q);   
         v.add(r);
         v.add(s);
         v.add(t);    
         v.add(u);   
         table1.setModel(model);
         sp.setBounds(300,250,680,400); 
         table1.setBounds(300,250,1200,400);               
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
     tbldemo3 obj=new tbldemo3();
}
}
