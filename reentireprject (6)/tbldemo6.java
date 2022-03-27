
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
public class tbldemo6 extends Frame implements ActionListener,ItemListener
{
  JButton bclose=new JButton("Close");
  JButton btnsearch=new JButton("Search");
  JButton bnew=new JButton("New"); 
  JRadioButton srchbyid=new JRadioButton("By ID");
  JRadioButton srchbyregno=new JRadioButton("RegNo");
  JRadioButton srchbybatchno=new JRadioButton("BatchNo");
  TextField txt=new TextField(30);
  JLabel lbl=new JLabel("Enter Search :");
  JLabel lblpic=new JLabel();
  JLabel lbltitle=new JLabel("");
  JLabel lbltitle1=new JLabel("");
  String SQL;
  ButtonGroup group=new ButtonGroup();
      
       JTable table1=new JTable();
       JScrollPane sp; 
       String[] col1={"stud_regno","course_id","adate","course_fees","batch_no","description"}; 
       String m="",n="",o="",p="",q="",r="";
      
       DefaultTableModel model=new DefaultTableModel(col1,0); 
            
       
  public tbldemo6()
  {
     setLayout(null);
     lbl.setFont(new Font("monotype corsiva",Font.BOLD,25));
     lblpic.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/enroll2.jpg"));
     lbltitle.setFont(new Font("Harlow Solid",Font.BOLD,35));
     lbltitle.setForeground(Color.red);
     lbltitle.setText("<html><u>ENROLL</u></html>");
     lbltitle1.setFont(new Font("Harlow Solid",Font.BOLD,35));
     lbltitle1.setForeground(Color.red);
     lbltitle1.setText("<html><u>TABLE</u></html>");
     lbltitle.setBounds(500,50,400,60);
     lbltitle1.setBounds(650,100,400,60);
     lblpic.setBounds(900,200,300,390);
     lbl.setBounds(100,200,150,40);
     txt.setBounds(260,200,50,30);
     
     bclose.setBounds(260,400,80,30);
     btnsearch.setBounds(180,400,80,30);
     add(lbl); 
     add(txt);
     add(lblpic);
     add(lbltitle);
     add(lbltitle1);
     add(btnsearch); 
     add(bclose); 
     add(bnew);
     bclose.addActionListener(this);
     bnew.addActionListener(this);    
     btnsearch.addActionListener(this);
     srchbyid.addItemListener(this);
     srchbyregno.addItemListener(this);
     srchbybatchno.addItemListener(this);
       group.add(srchbyid);
       group.add(srchbyregno);
       group.add(srchbybatchno);
       srchbybatchno.setBounds(100,250,100,40);
       srchbyid.setBounds(100,300,100,40);
       srchbyregno.setBounds(100,350,100,40);
       bnew.setBounds(100,400,80,30);
       add(srchbybatchno);
       add(srchbyid);
       add(srchbyregno);
      /* Connection con;
       con=DriverManager.getConnection("jdbc:odbc:imsdsn");
       Statement st=con.createStatement();
       ResultSet res;
       SQL="select * from enrolltbl";
       res=st.executeQuery(SQL);

       while(res.next())
       {
         Vector v=new Vector();
         m=res.getString(1);
         n=res.getString(2);
         o=res.getString(3);
         p=res.getString(4);
         q=res.getString(5);
         r=res.getString(6);
         Object [][]data={{m,n,o,p,q,r}};         
          table1=new JTable(data,col1);        
         table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
          sp=new JScrollPane(table1);
         table1.setFillsViewportHeight(true);
         v.add(m);   
         v.add(n);
         v.add(o);
         v.add(p);  
         v.add(q); 
         v.add(r); 
         table1.setModel(model);
         sp.setBounds(350,200,450,400); 
         table1.setBounds(350,200,550,400);               
         add(sp);
         model.addRow(v);
       }
 
     }
     catch(Exception ee)
     {
          System.out.println(""+ee);
     }*/
     //setLayout(null);
     setSize(1500,900);
     setVisible(true); 
     
     bclose.addActionListener(this);
}
public void itemStateChanged(ItemEvent ie)
{
   
   if(srchbyid.isSelected())
   {
     SQL="select *from enrolltbl where course_id='"+txt.getText()+"'";
    
   }
         
    if(srchbyregno.isSelected())
    {
     SQL="select *from enrolltbl where stud_regno="+Integer.parseInt(txt.getText());
    }
     if(srchbybatchno.isSelected())
    {
     SQL="select *from enrolltbl where batch_no='"+txt.getText()+"'";
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
      
     for(int i=model.getRowCount()-1;i>=0;i--)
   {
   model.removeRow(i);
    }
  } 
 
  
  if(e.getSource()==btnsearch)
  {
     try
     {
       for(int i=model.getRowCount()-1;i>=0;i--)
        model.removeRow(i);
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
         o=res.getString(3);
         p=res.getString(4);
         q=res.getString(5);
         r=res.getString(6);
         Object [][]data={{m,n,o,p,q,r}};         
           table1=new JTable(data,col1);       
         table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         sp=new JScrollPane(table1);
         table1.setFillsViewportHeight(true);
         v1.add(m);   

         v1.add(n);
         v1.add(o);
         v1.add(p); 
         v1.add(q); 
         v1.add(r);  
         table1.setModel(model);
         sp.setBounds(360,240,450,400); 
         table1.setBounds(360,240,550,400);     
         add(sp);
         model.addRow(v1);
       }
     }
     catch(Exception ee)
     {
          System.out.println(""+ee);
     }
//   setLayout(null);
     setSize(1500,900);
     setVisible(true); 
     
     bclose.addActionListener(this);
     txt.setText("");  
  }
}
public static void main(String args[])
throws IOException
{
     tbldemo6 obj=new tbldemo6();
}
}
