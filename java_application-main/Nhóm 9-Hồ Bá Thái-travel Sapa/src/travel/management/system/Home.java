/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Home extends JFrame{
    String username;
     Color mainColor = new Color(5, 94, 26);
        Color bgrColor = new Color(202, 247, 227);
        Color greyColor = new Color(51, 71, 86);
        Color checkYellow = new Color(214, 169, 22);
    public static void main(String[] args) {
        new Home("").setVisible(true);
    }
    
    public Home(String username) {
        super("Travel and Tourism Management System");
	this.username = username;
        setForeground(Color.CYAN);
        setLayout(null); 

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(0, 0, 1200, 600); 
        add(NewLabel);
        
        JLabel l1 = new JLabel("KHÁCH SẠN KHU VỰC SAPA");
	l1.setForeground(mainColor);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 60));
	l1.setBounds(100, 60, 1000, 100);
	NewLabel.add(l1);
		
		
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
        NewLabel.add(menuBar);
//        menuBar.setBounds(0,0, 1000, 100);
      
        JMenu m1 = new JMenu("Khách Hàng");
        m1.setForeground(Color.BLUE);
	menuBar.add(m1);
        JMenuItem mi1 = new JMenuItem("Thêm Khách Hàng");
	m1.add(mi1);
        
        JMenuItem mi2 = new JMenuItem("Cập Nhật Thông Tin Khách Hàng");
	m1.add(mi2);
        
        
        JMenuItem mi4 = new JMenuItem("Xóa Khách Hàng");
	m1.add(mi4);
        
        mi1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddCustomer(username).setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        mi2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new UpdateCustomer(username).setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        
        
        mi4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new DeleteCustomer().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        
		
	JMenu m2 = new JMenu("Gói Dịch Vụ");
        m2.setForeground(Color.RED);
	menuBar.add(m2);
        
        JMenuItem mi6 = new JMenuItem("Kiểm tra gói");
	m2.add(mi6);
        
        JMenuItem mi7 = new JMenuItem("Đặt gói dịch vụ");
	m2.add(mi7);
        
        JMenuItem mi5 = new JMenuItem("Xem các loại gói");
	m2.add(mi5);
        
        
        mi6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new CheckPackage().setVisible(true);
                }catch(Exception e ){}
            }
	});
        

        mi7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new BookPackage(username).setVisible(true);
                }catch(Exception e ){}
            }
	});
        

	mi5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new ViewPackage(username).setVisible(true);
                }catch(Exception e ){}
                
            }
	});
        
        
        JMenu m3 = new JMenu("Khách Sạn");
        m3.setForeground(Color.BLUE);
	menuBar.add(m3);
        
        JMenuItem mi8 = new JMenuItem("Đặt Khách Sạn");
	m3.add(mi8);
        
        JMenuItem mi9 = new JMenuItem("Xem Khách Sạn");
	m3.add(mi9);
        
        JMenuItem mi10 = new JMenuItem("Khách Sạn Đã Đặt");
	m3.add(mi10);
        
        mi8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new BookHotel(username).setVisible(true);
            }
	});
        
        
        
	mi9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new CheckHotels().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        mi10.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new ViewBookedHotel(username).setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        JMenu m4 = new JMenu("Thăm Quan");
        m4.setForeground(Color.RED);
	menuBar.add(m4);
        
        JMenuItem mi11 = new JMenuItem("Thăm Quan");
	m4.add(mi11);
        
        mi11.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Destination().setVisible(true);
            }
	});
        
        
        JMenu m5 = new JMenu("Thanh Toán");
        m5.setForeground(Color.BLUE);
	menuBar.add(m5);
        
        JMenuItem mi12 = new JMenuItem("Thanh Toán Bằng Tài Khoản Ngân Hàng");
	m5.add(mi12);
        
        mi12.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Payment(username).setVisible(true);
            }
	});
        
        JMenu m6 = new JMenu("Công Cụ");
        m6.setForeground(Color.RED);
	menuBar.add(m6);
        
        JMenuItem mi13 = new JMenuItem("Ghi Chú");
	m6.add(mi13);
        
        JMenuItem mi14 = new JMenuItem("Máy Tính");
	m6.add(mi14);
        
        mi13.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    Runtime.getRuntime().exec("notepad.exe");
                }catch(Exception e){ }
            }
	});
        
        
        mi14.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    Runtime.getRuntime().exec("calc.exe");
                }catch(Exception e){ }
            }
	});
        
        JMenu m7 = new JMenu("Thông Tin");
        m7.setForeground(Color.BLUE);
	menuBar.add(m7);
        
        JMenuItem mi15 = new JMenuItem("Thông Tin");
	m7.add(mi15);
        
        mi15.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new About().setVisible(true);
            }
	});
        
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
	setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}