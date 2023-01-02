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
public class AddCustomer extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1,t2,t3,t4,t5,t6,t7,t8;
        JComboBox comboBox;
        JRadioButton r1,r2;
        Choice c1;
//        
		int a = 150;
		int input = 300;
                Color mainColor = new Color(5, 94, 26);
                Color bgrColor = new Color(202, 247, 227);
                Color greyColor = new Color(51, 71, 86);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomer frame = new AddCustomer("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddCustomer(String username) throws SQLException {
		System.out.println(username);
                setBounds(300, 0, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                contentPane.setBackground(bgrColor);
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/newcustomer.jpg"));
                Image i3 = i1.getImage().getScaledInstance(450, 500,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(450,40,450,420);
                add(l1);
		
		JLabel lblName = new JLabel("Đăng kí khách hàng mới");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 22));
		lblName.setBounds(118, 11, 260, 53);
		contentPane.add(lblName);
                
                JLabel l3 = new JLabel("Tên người dùng :");
		l3.setBounds(35, 70, 200, 14);
		contentPane.add(l3);
                
                t7 = new JTextField();
		t7.setBounds(a, 70, input, 20);
		contentPane.add(t7);
		t7.setColumns(10);
                
                JLabel lblId = new JLabel("Thẻ :");
		lblId.setBounds(35, 110, 200, 14);
		contentPane.add(lblId);
                
                comboBox = new JComboBox(new String[] {"Hộ chiếu", "Thẻ CCCD"});
		comboBox.setBounds(a, 110, input, 20);
		contentPane.add(comboBox);
                
                JLabel l2 = new JLabel("Số thẻ :");
		l2.setBounds(35, 150, 200, 14);
		contentPane.add(l2);
                
                t1 = new JTextField();
		t1.setBounds(a, 150, input, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Tên :");
		lblName_1.setBounds(35, 190, 200, 14);
		contentPane.add(lblName_1);
		
		t2 = new JTextField();
		t2.setBounds(a, 190, input, 20);
		contentPane.add(t2);
		t2.setColumns(10);

                
		JLabel lblGender = new JLabel("Giới tính :");
		lblGender.setBounds(35, 230, 200, 14);
		contentPane.add(lblGender);
                
                r1 = new JRadioButton("Nam");
                r1.setFont(new Font("Raleway", Font.BOLD, 14));
                r1.setBackground(Color.WHITE);
                r1.setBounds(a, 230, 80, 12);
                add(r1);
                
                r2 = new JRadioButton("Nữ");
                r2.setFont(new Font("Raleway", Font.BOLD, 14));
                r2.setBackground(Color.WHITE);
                r2.setBounds(350, 230, 100, 12);
		add(r2);
                
		JLabel lblCountry = new JLabel("Quốc tịch :");
		lblCountry.setBounds(35, 270, 200, 14);
		contentPane.add(lblCountry);
                
                t3 = new JTextField();
		t3.setBounds(a, 270, input, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		JLabel lblReserveRoomNumber = new JLabel("Địa chỉ tạm trú:");
		lblReserveRoomNumber.setBounds(35, 310, 200, 14);
		contentPane.add(lblReserveRoomNumber);
                
                t5 = new JTextField();
		t5.setBounds(a, 310, input, 20);
		contentPane.add(t5);
		t5.setColumns(10);
           	
		JLabel lblCheckInStatus = new JLabel("SĐT:");
		lblCheckInStatus.setBounds(35, 350, 200, 14);
		contentPane.add(lblCheckInStatus);
                
                t6 = new JTextField();
		t6.setBounds(a, 350, input, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		
		JLabel lblDeposite = new JLabel("Email :");
		lblDeposite.setBounds(35, 390, 200, 14);
		contentPane.add(lblDeposite);
		
		t8 = new JTextField();
		t8.setBounds(a, 390, input, 20);
		contentPane.add(t8);
		t8.setColumns(10);
		
		
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from account where username = '"+username+"'");
                    while(rs.next()){
                        t7.setText(rs.getString("username"));  
                        t2.setText(rs.getString("name"));
                    }
                }catch(Exception e){ }
		
		

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            Conn c = new Conn();
                            String radio = null;
                            
                            if(r1.isSelected()){ 
                                radio = "Male";
                            }
                            else if(r2.isSelected()){ 
                                radio = "Female";
                            }
                           
                          
                            try{
	    			String s9 = t7.getText(); //username
                                String s1 = (String)comboBox.getSelectedItem(); 
	    			String s2 =  t1.getText().trim();
	    			String s3 =  t2.getText().trim();
                                String s4 =  radio;
	    			String s5 =  t3.getText().trim();
	    			String s7 =  t5.getText().trim();  //address
                                String s8 =  t6.getText().trim();
                                String s10 = t8.getText().trim(); //email
                                String q1 = "insert into customer values('"+s9+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s7+"','"+s8+"','"+s10+"')";
                                int kt = 1;
                                if (s2.equals("") || s3.equals("") || s5.equals("") || s7.equals("") || s8.equals("") || s10.equals("")){
                                    q1 = "";
                                    kt = 0;
                                }
                                if( !q1.equals("")) c.s.executeUpdate(q1);
                                
	    			if(kt>0) {
                                    JOptionPane.showMessageDialog(null, "Thêm khách hàng mới thành công");
                                    setVisible(false);
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "Vui lòng nhập lại trường còn trống");
                                }
                                
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
                                JOptionPane.showMessageDialog(null, "Khách hàng đã tồn tại");
	    		}
		    		catch(NumberFormatException s){
		    			JOptionPane.showMessageDialog(null, "Vui lòng nhập lại thông tin");
			}
			}
		});
		btnNewButton.setBounds(100, 430, 120, 30);
                btnNewButton.setBackground(mainColor);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Trở lại");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(260, 430, 120, 30);
                btnExit.setBackground(greyColor);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
//                getContentPane().setBackground(Color.WHITE);
	}
}