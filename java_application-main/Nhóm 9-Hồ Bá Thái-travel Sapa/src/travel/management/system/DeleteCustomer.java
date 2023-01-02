/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;


import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class DeleteCustomer extends JFrame {
	private JPanel contentPane;
        Choice c1;
        
         Color mainColor = new Color(5, 94, 26);
        Color bgrColor = new Color(202, 247, 227);
        Color greyColor = new Color(51, 71, 86);
        Color checkYellow = new Color(214, 169, 22);
        
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCustomer frame = new DeleteCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DeleteCustomer() throws SQLException {
		setBounds(100, 20, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/delete.png"));
                Image i3 = i1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(500,100,300,300);
                add(l1);
		
		JLabel lblName = new JLabel("XÓA TÀI KHOẢN KHÁCH HÀNG");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 300, 53);
		contentPane.add(lblName);
                
                JLabel lb3 = new JLabel("Người dùng :");
		lb3.setBounds(35, 70, 200, 14);
		contentPane.add(lb3);
                
                c1 = new Choice();
                Conn c = new Conn();
                try{

                    ResultSet rs = c.s.executeQuery("select * from travel.customer");
                    while(rs.next()){
                        c1.add(rs.getString("username"));
                    }

                    rs.close();
                }catch(SQLException e){}

                c1.setBounds(271, 70, 150, 30);
                add(c1);
                
                JLabel lblId = new JLabel("Thẻ :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);
                
                JLabel l2 = new JLabel();
		l2.setBounds(271, 110, 200, 14);
		contentPane.add(l2);
                
                JLabel lb2 = new JLabel("Mật khẩu :");
		lb2.setBounds(35, 150, 200, 14);
		contentPane.add(lb2);
                
                JTextField l3 = new JTextField();
		l3.setBounds(271, 150, 200, 14);
		contentPane.add(l3);
		
		JLabel lblName_1 = new JLabel("Tên :");
		lblName_1.setBounds(35, 190, 200, 14);
		contentPane.add(lblName_1);
		
		JLabel l4 = new JLabel();
		l4.setBounds(271, 190, 200, 14);
		contentPane.add(l4);

                
		JLabel lblGender = new JLabel("Giới tính :");
		lblGender.setBounds(35, 230, 200, 14);
		contentPane.add(lblGender);
                
                JLabel l5 = new JLabel();
		l5.setBounds(271, 230, 200, 14);
		contentPane.add(l5);
                
		JLabel lblCountry = new JLabel("Quốc tịch :");
		lblCountry.setBounds(35, 270, 200, 14);
		contentPane.add(lblCountry);
                
                JLabel l6 = new JLabel();
		l6.setBounds(271, 270, 200, 14);
		contentPane.add(l6);
		
		JLabel lblReserveRoomNumber = new JLabel("Địa chỉ tạm trú :");
		lblReserveRoomNumber.setBounds(35, 310, 200, 14);
		contentPane.add(lblReserveRoomNumber);
                
                JLabel l7 = new JLabel();
		l7.setBounds(271, 310, 200, 14);
		contentPane.add(l7);
           	
		JLabel lblCheckInStatus = new JLabel("SĐT :");
		lblCheckInStatus.setBounds(35, 350, 200, 14);
		contentPane.add(lblCheckInStatus);
                
                JLabel l8 = new JLabel();
		l8.setBounds(271, 350, 200, 14);
		contentPane.add(l8);

		
		JLabel lblDeposite = new JLabel("Email :");
		lblDeposite.setBounds(35, 390, 200, 14);
		contentPane.add(lblDeposite);
		
		JLabel l9 = new JLabel();
		l9.setBounds(271, 390, 200, 14);
		contentPane.add(l9);

		
		JButton b1 = new JButton("Kiểm tra");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            Conn c = new Conn();
                           
                            try{
                                ResultSet rs = c.s.executeQuery("select * from travel.customer where username = '"+c1.getSelectedItem()+"'");
                                if(rs.next()){
                                    l2.setText(rs.getString(2));  
//                                    l3.setText(rs.getString(3));
                                    l4.setText(rs.getString(4));  
                                    l5.setText(rs.getString(5));
                                    l6.setText(rs.getString(6));  
                                    l7.setText(rs.getString(7));
                                    l8.setText(rs.getString(8));  
                                    l9.setText(rs.getString(9));
                                }
                            }catch(Exception ee){ }
                        }
		});
		b1.setBounds(425, 70, 150, 22);
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
		contentPane.add(b1);
		

		JButton btnNewButton = new JButton("Xóa tài khoản");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                           String ktra = l3.getText().trim();
                            if(ktra.equals("")) JOptionPane.showMessageDialog(null,"Nhập mật khẩu để xác nhận: ");
                            
                            
                            Conn c = new Conn();
                            try{
                                String s1 = c1.getSelectedItem(); 

                                String searchPass  = "select * from travel.account where username = '"+s1+"'";
                                ResultSet rs = c.s.executeQuery(searchPass);
                                String key = "";
                                while(rs.next()){
                                    key = rs.getString("password");
                                }
                                String q1 = "delete from travel.customer where username = '"+s1+"'";
                                if(key.equals(ktra)){
                                 c.s.executeUpdate(q1);
                                 JOptionPane.showMessageDialog(null, "Khách hàng đã được xóa");
                                }
                                
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
                                JOptionPane.showMessageDialog(null, "Vui lòng nhập lại");

	    		}
		    	
			}
		});
		btnNewButton.setBounds(100, 430, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Trở lại");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(260, 430, 120, 30);
                btnExit.setBackground(mainColor);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(Color.WHITE);
	}
}