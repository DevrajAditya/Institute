import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class tbldemo4 extends Frame implements ActionListener
{
  JButton bclose=new JButton("Close");
  JLabel lblpic=new JLabel();
  JLabel lbltitle=new JLabel("Table");
  JLabel lbltitle1=new JLabel("");
  public tbldemo4()
  {
     setLayout(null);
     lbltitle.setFont(new Font("Harlow Solid",Font.BOLD,35));
     lbltitle.setForeground(Color.red);
     lbltitle.setText("<html><u>STUDENT'S</u></html>");
     lbltitle1.setFont(new Font("Harlow Solid",Font.BOLD,35));
     lbltitle1.setForeground(Color.red);
     lbltitle1.setText("<html><u>TABLE</u></html>");
     lblpic.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/student3.jpg"));
     lbltitle.setBounds(500,50,400,60);
     lbltitle1.setBounds(650,100,400,60);
     lblpic.setBounds(900,200,800,440);
     bclose.setBounds(820,650,80,40);
     add(bclose); 
     add(lblpic);
     add(lbltitle);
     add(lbltitle1);
     try
     {
       Connection con;
       con=DriverManager.getConnection("jdbc:odbc:imsdsn");
       Statement st=con.createStatement();
       String SQL="select * from studenttbl";
       ResultSet res;
       res=st.executeQuery(SQL);
       String[] col={"RegNo","Name","Father's name","DOB","gender","Address","contact no","DOA"}; 
       String m="",n="",o="",p="",q="",r="",s="",t="";
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
        
         Object [][]data={{m,n,o,p,q,r,s,t}};         
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
            
         table1.setModel(model);
         sp.setBounds(300,250,600,400); 
         table1.setBounds(300,250,900,400);               
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
     tbldemo4 obj=new tbldemo4();
}
}
