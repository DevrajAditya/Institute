import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;
public class tbldemo12 extends Frame implements ActionListener
{
   int t;
   Choice status=new Choice();
   JButton btnNew=new JButton("New");
   JButton btnsearch=new JButton("Search");
   
   JButton btnCancel=new JButton("Cancel");
   JButton bclose=new JButton("Close");
   JLabel lblpic=new JLabel();
   JLabel lblstatus=new JLabel("Status:");
  
   String[] col={"S.NO","Batch_no","faculty_no","batch_timming","course_id","status"}; 
   String x="",m="",n="",o="",p="",q="";
   JTable table1 =new JTable();
   JScrollPane sp;  
   DefaultTableModel model=new DefaultTableModel(col,0);   

public tbldemo12()
{
  setLayout(null);
  setTitle("REPORT ON BATCH");
  setSize(1500,900);
  setVisible(true);
 
  lblstatus.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lblpic.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/tbldemo12.jpg"));
  lblpic.setBounds(750,100,500,500);
  
  
  lblstatus.setBounds(160,50,100,30);
  status.setBounds(260,50,100,30);
  
  btnNew.setBounds(260,670,100,30);
  btnsearch.setBounds(360,670,100,30);
  
  btnCancel.setBounds(460,670,100,30);
  
  add(lblstatus);  
  add(status);
  add(lblpic);
  add(btnNew);
  add(btnsearch);
  add(lblpic);
  add(btnCancel); 
  
  btnCancel.addActionListener(this);    
  btnsearch.addActionListener(this);
 
  btnNew.addActionListener(this);    
 
}
 public void actionPerformed(ActionEvent e)
 {
  if(e.getSource()==btnCancel)
   {
      this.dispose();
   }
  
   if(e.getSource()==btnNew)
   {
   t=0;
   status.removeAll();
   status.add("running");
   status.add("completed");
   for(int i=model.getRowCount()-1;i>=0;i--)
   {
   model.removeRow(i);
    }
   }

 if(e.getSource()==btnsearch)
 {
int ctr=1;
      try
     {
       Connection con;
       con=DriverManager.getConnection("jdbc:odbc:imsdsn");
       Statement st=con.createStatement();
       String SQL="select * from batchtbl where status='"+status.getSelectedItem()+"'";
       ResultSet res;
       res=st.executeQuery(SQL);
       while(res.next())
       {
         Vector v=new Vector();
         x=""+ctr;
         m=res.getString(1);
         n=res.getString(2);
         o=res.getString(3);
         p=res.getString(6);
         q=res.getString(8);
        
         
         Object [][]data={{x,m,n,o,p,q}};         
         table1=new JTable(data,col);        
         table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         sp=new JScrollPane(table1);
         table1.setFillsViewportHeight(true);
         v.add(x);
         v.add(m);   
         v.add(n);
         v.add(o);   
         v.add(p);
         v.add(q);   
         
           
         table1.setModel(model);
         sp.setBounds(150,100,450,550); 
         table1.setBounds(150,100,580,550);               
         add(sp);
         model.addRow(v);
         ctr=ctr+1;
       }
     }
     catch(Exception ee)
     {
          System.out.println(""+ee);
     }

 }

}
public static void main(String argv[])
throws IOException
{
  tbldemo12 obj=new tbldemo12();
}
}  
 
