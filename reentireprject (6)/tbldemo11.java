import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;
public class tbldemo11 extends Frame implements ActionListener
{
   int t;
   JButton btnNew=new JButton("New");
   JButton btnsearch=new JButton("Search");
   JButton btnprint=new JButton("Fee Print");
   JButton btnCancel=new JButton("Cancel");
   JButton bclose=new JButton("Close");
  
   TextField txtamount=new TextField(30);
   TextField txtdate=new TextField(30);
 
   JLabel lblamount=new JLabel("Total Amount:");
   JLabel lblpic=new JLabel();
   JLabel lbldate=new JLabel("Date:");
   JLabel lbltitle=new JLabel("");
   JLabel lbltitle1=new JLabel("");
   String[] col={"S.No.","reg_no","fees"}; 
   String x="",m="",n="";
   JTable table1 =new JTable();
   JScrollPane sp;  
   DefaultTableModel model=new DefaultTableModel(col,0);   

public tbldemo11()
{
  setLayout(null);
  setTitle("REPORT");
  setSize(1500,900);
  setVisible(true);
     lblpic.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/tbldemo11.jpg"));
     lblpic.setBounds(750,200,700,500);
     lbltitle.setFont(new Font("Harlow Solid",Font.BOLD,35));
     lbltitle.setForeground(Color.red);
     lbltitle.setText("<html><u>FEES'S REPORT</u></html>");
     
     
  lblamount.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lbldate.setFont(new Font("monotype corsiva",Font.BOLD,25));
  lbltitle.setBounds(500,30,400,60); 
  lblamount.setBounds(400,600,150,30);
  txtamount.setBounds(560,600,60,30);
  lbldate.setBounds(10,100,100,30);
  txtdate.setBounds(120,100,100,30);
  btnNew.setBounds(350,670,80,30);
  btnsearch.setBounds(430,670,80,30);
  btnprint.setBounds(510,670,80,30);
  btnCancel.setBounds(590,670,80,30);
  add(lblpic);
  add(lbltitle);
  add(lbltitle1); 
  add(lblamount);  
  add(txtamount);
  add(lbldate);
  add(txtdate);
  add(btnNew);
  add(btnsearch);
  add(btnprint);
  add(btnCancel); 
  
  btnCancel.addActionListener(this);    
  btnsearch.addActionListener(this);
  btnprint.addActionListener(this);
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
   txtdate.setText("");
   txtamount.setText("");
   
   Calendar cal=Calendar.getInstance();
   txtdate.setText(""+cal.get(Calendar.DATE)+" / "+((cal.get(Calendar.MONTH))+1)+" / "+cal.get(Calendar.YEAR));
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
       String SQL="select * from feestbl where tdate='"+txtdate.getText()+"'";
       ResultSet res;
       res=st.executeQuery(SQL);
       while(res.next())
       {
         Vector v=new Vector();
         x=""+ctr;
         m=res.getString(3);
         n=res.getString(5);
         t=t+Integer.parseInt(n);
         Object [][]data={{x,m,n}};         
         table1=new JTable(data,col);        
         table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         sp=new JScrollPane(table1);
         table1.setFillsViewportHeight(true);
         v.add(x);
         v.add(m);   
         v.add(n);
           
         table1.setModel(model);
         sp.setBounds(400,100,240,500); 
         table1.setBounds(400,100,280,500);               
         add(sp);
         model.addRow(v);
         ctr=ctr+1;
       }
     }
     catch(Exception ee)
     {
          System.out.println(""+ee);
     }
txtamount.setText(""+t);
 }
if(e.getSource()==btnprint)
   {
    try
    {
      int ctr1=1;
      Connection con;
      con=DriverManager.getConnection("jdbc:odbc:imsdsn"); 
      ResultSet res;
      Statement st=con.createStatement();
      String str="select * from feestbl where tdate='"+txtdate.getText()+"'";
      res=st.executeQuery(str);
      PrintWriter obj=new PrintWriter("Fee Report");
      obj.println("\t\t\tHACK Institute     ");
      obj.println("");
      obj.println("Date:-  "+txtdate.getText());
      obj.println("        _______________");
      obj.println("");
      obj.println("");
      obj.println(" ________________________");
      obj.println("| S.No. |Reg No.|  Fees |");
      obj.println("|_______|_______|_______|");
      while(res.next())
      {
        obj.println("| "+ctr1+"\t|"+res.getString(3)+"\t|"+res.getString(5)+"\t|\n");
        ctr1=ctr1+1;
      }
      obj.println("|_______|_______|_______|");
      obj.println("");
      obj.println("Total Amount= "+txtamount.getText());
      obj.close();
      Runtime r=Runtime.getRuntime();
      r.exec("notepad c:\\amritaj\\project1\\Fee Report");     
     
   }
   catch(Exception ee)
   {
     System.out.println("Exception :"+ee);
   }
   }
}
public static void main(String argv[])
throws IOException
{
  tbldemo11 obj=new tbldemo11();
}
}  
 
