import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.sql.*;
public class MenuD extends Frame implements ActionListener
{
int flag;
MenuBar mb=new MenuBar();
Menu mnumaster=new Menu("Master");
Menu mnureport=new Menu("Report");
Menu mnutransaction=new Menu("Transaction");
Menu mnuexit=new Menu("Logout");
MenuItem mnucourse=new MenuItem("course");
MenuItem mnufaculty=new MenuItem("Faculty");
MenuItem mnustudent=new MenuItem("student");
MenuItem mnubatch=new MenuItem("Batch");
MenuItem mnuex=new MenuItem("Ok");
MenuItem mnufees=new MenuItem("Fees");
MenuItem mnuenroll=new MenuItem("Enroll");
MenuItem mnutest=new MenuItem("Test");
MenuItem mnuatten=new MenuItem("Attendance");
MenuItem mnufeesrpt=new MenuItem("Fees");
MenuItem mnubatchrpt=new MenuItem("Batch");
MenuItem mnuenquiry=new MenuItem("Enquiry");
MenuItem mnuattenrpt=new MenuItem("Attendance");
JLabel lbltitle=new JLabel("INSTITUTE");
JLabel lbltitle1=new JLabel("MANAGEMENT");      
JLabel lblpic=new JLabel();
public MenuD()
{
setLayout(null);
setSize(1500,900);
setVisible(true);
setTitle("Institute Management");
lblpic.setIcon(new ImageIcon("D:\\Drive file\\impfile\\java project\\reentireprject (1)/MenuD1.jpg"));
lbltitle.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,35));
lbltitle.setForeground(Color.orange);
lbltitle.setText("<html><u>INSTITUTE</u></html>");
lbltitle1.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,35));
lbltitle1.setForeground(Color.cyan);
lbltitle1.setText("<html><u> MANAGEMENT</u></html>");
lblpic.setBounds(180,130,1500,600);
lbltitle.setBounds(450,100,400,40);
lbltitle1.setBounds(540,150,400,40);
mnumaster.add(mnucourse);
mnumaster.add(mnustudent);
mnumaster.add(mnubatch);
mnumaster.add(mnufaculty);
mnumaster.add(mnuenquiry);
mnutransaction.add(mnufees);
mnutransaction.add(mnuenroll);
mnutransaction.add(mnutest);
mnutransaction.add(mnuatten);
mnureport.add(mnufeesrpt);
mnureport.add(mnubatchrpt);
mnureport.add(mnuattenrpt);
mnuexit.add(mnuex);
mb.add(mnumaster);
mb.add(mnutransaction);
mb.add(mnureport);
mb.add(mnuexit);
add(lblpic);
add(lbltitle);
add(lbltitle1);
mnucourse.addActionListener(this);
mnubatch.addActionListener(this);
mnustudent.addActionListener(this);
mnufaculty.addActionListener(this);
mnuenquiry.addActionListener(this);
mnuex.addActionListener(this);
mnufees.addActionListener(this);
mnuenroll.addActionListener(this);
mnutest.addActionListener(this);
mnuatten.addActionListener(this);
mnufeesrpt.addActionListener(this);
mnubatchrpt.addActionListener(this);
mnuattenrpt.addActionListener(this);
this.setMenuBar(mb);
}
public void actionPerformed(ActionEvent e)
{
  if(e.getSource()==mnuenquiry)
   {
      enquiry obj=new enquiry();
   }
  if(e.getSource()==mnucourse)
   {
      course obj=new course();
   }
    if(e.getSource()==mnustudent)
   {
      student obj=new student();
   }
    if(e.getSource()==mnufaculty)
   {
      faculty obj=new faculty();
   }
   if(e.getSource()==mnubatch)
   {
      batch obj=new batch();
   }
   if(e.getSource()==mnufees)
   {
      fees obj=new fees();
   }
   if(e.getSource()==mnuenroll)
   {
      enroll obj=new enroll();
   }
  if(e.getSource()==mnutest)
   {
      tbldemo7 obj=new tbldemo7();
   }
  if(e.getSource()==mnuatten)
   {
      atten obj=new atten();
   }
  
  if(e.getSource()==mnufeesrpt)
   {
      tbldemo11 obj=new tbldemo11();
   }
   if(e.getSource()==mnubatchrpt)
   {
      tbldemo12 obj=new tbldemo12();
   }
   if(e.getSource()==mnuattenrpt)
   {
      tbldemo13 obj=new tbldemo13();
   }
  if(e.getSource()==mnuex)
   {
   System.exit(0);
   }
}
public static void main(String args[])
{
MenuD obj=new MenuD();
}
}





