
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
public class tbldemo9 extends Frame implements ActionListener,ItemListener
{
  JButton bclose=new JButton("Close");
  JButton bnew=new JButton("New"); 
  JButton btnsearch=new JButton("Search");
  JLabel lblpic=new JLabel();
  JLabel lbltitle=new JLabel("Table");
  JLabel lbltitle1=new JLabel("");
  
  JRadioButton address=new JRadioButton("address");
  JRadioButton batchno=new JRadioButton("Batch No");
  JRadioButton name=new JRadioButton("Name");

  TextField txt=new TextField(30);
  JLabel lbl=new JLabel("Enter Information :");
  
  String SQL;
  ButtonGroup group=new ButtonGroup();
  JTable table1=new JTable();
  JScrollPane sp; 
  String[] col1={"stud_regno","Name"}; 
  String m="",n="";
  int c=0;
  DefaultTableModel model=new DefaultTableModel(col1,0);           
     
  
  public tbldemo9()
  {
     setLayout(null);
   //setLayout(null);
     setSize(1500,900);
     setVisible(true); 
     
     lbltitle.setFont(new Font("Harlow Solid",Font.BOLD,35));
     lbltitle.setForeground(Color.red);
     lbltitle.setText("<html><u>STUDENT'S</u></html>");
     lbltitle1.setFont(new Font("Harlow Solid",Font.BOLD,35));
     lbltitle1.setForeground(Color.red);
     lbltitle1.setText("<html><u>TABLE</u></html>");
     lblpic.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/student4.jpg"));
     lbltitle.setBounds(500,50,400,60);
     lbltitle1.setBounds(650,100,400,60);
     lblpic.setBounds(750,200,600,440);
     lbl.setFont(new Font("monotype corsiva",Font.BOLD,20));
     batchno.setBounds(100,200,100,40);
     address.setBounds(100,250,100,40); 
     name.setBounds(100,300,100,40);
     lbl.setBounds(100,350,200,40);
     txt.setBounds(300,350,150,40);
     bnew.setBounds(140,430,80,30);
     btnsearch.setBounds(220,430,80,30);
     bclose.setBounds(300,430,80,30);
    
     add(btnsearch); 
     add(bclose); 
     add(bnew);
     add(lbl);
     add(txt);
     add(lblpic);
     add(lbltitle);
     add(lbltitle1);

     group.add(address);
     group.add(batchno);
     group.add(name);
     add(batchno);
     add(address);
     add(name);
     bclose.addActionListener(this);
     bnew.addActionListener(this);    
     btnsearch.addActionListener(this);
     
     address.addItemListener(this);
     batchno.addItemListener(this);
     name.addItemListener(this);
     }

public void itemStateChanged(ItemEvent ie)
{
   if(address.isSelected())
   { 
   SQL="select  * from studenttbl where Stud_address='"+txt.getText()+"'";

   }       
   if(batchno.isSelected())
   {
    SQL="select  * from enrolltbl where batch_no='"+txt.getText()+"'";

   }
   if(name.isSelected())
   {
    SQL="select  * from studenttbl where Stud_name LIKE '"+txt.getText()+"%'";
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
     txt.setText("");     
     group.clearSelection();
     
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
       Statement st=con.createStatement();
       ResultSet res;
       res=st.executeQuery(SQL);
       
       while(res.next())
       {
         Vector v1=new Vector();
         m=res.getString(1);
         n=res.getString(2);
        
         Object [][]data={{m,n}};         
         table1=new JTable(data,col1);       
         table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         sp=new JScrollPane(table1);
         table1.setFillsViewportHeight(true);
         v1.add(m);   
         v1.add(n);
        
         table1.setModel(model);
         sp.setBounds(500,250,150,400);
         table1.setBounds(500,250,250,400);               
         add(sp);
         model.addRow(v1);
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
     tbldemo9 obj=new tbldemo9();
}
}
