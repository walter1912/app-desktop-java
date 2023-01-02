/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;


import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Paytm extends JFrame{
    Paytm(String username){
        int thotel = 0;
        int tpackage = 0;
        JPanel mainJP = new JPanel();
        mainJP.setLayout(null);
        JLabel nhap = new JLabel("Nhập số tiền :");
        nhap.setBounds(50, 50, 200, 30);
        mainJP.add(nhap);
        JTextField tien = new JTextField();
        tien.setBounds(300, 50, 200, 30);
        mainJP.add(tien);
        JButton thanhtoan = new JButton("Thanh Toán");
        
        thanhtoan.setBounds(550, 50, 150, 30);
        mainJP.add(thanhtoan);
        JLabel bookhotel = new JLabel("Giá đặt khách sạn: ");
        bookhotel.setBounds(50, 150, 160, 50);
        mainJP.add(bookhotel);
        JLabel costhotel = new JLabel();
        costhotel.setBounds(250, 150, 600, 50);
        mainJP.add(costhotel);
        JLabel bookpackage = new JLabel("Giá đặt dịch vụ: ");
        bookpackage.setBounds(50, 200, 160, 50);
        mainJP.add(bookpackage);
        JLabel costpackage = new JLabel();
        costpackage.setBounds(250, 200, 600, 50);
        mainJP.add(costpackage);
        Conn c = new Conn();
        try{
            ResultSet rs = c.s.executeQuery("select * from bookhotel where username = '"+username+"'");
            String re = "";
            while(rs.next()){
                re +=" "+(rs.getString("price"));
                thotel += Integer.parseInt(rs.getString("price"));
            }
            costhotel.setText(re);
              rs.close();
                }catch(SQLException e){}
        try{
            ResultSet rs = c.s.executeQuery("select * from bookpackage where username = '"+username+"'");
            String re =" ";
            while(rs.next()){
                re +=" "+(rs.getString("price"));
                tpackage += Integer.parseInt(rs.getString("price"));
            }
            costpackage.setText(re);
              rs.close();
                }catch(SQLException e){}
        JLabel chiphi = new JLabel("Tổng chi phí");
        chiphi.setBounds(100,250, 160, 50);
        mainJP.add(chiphi);
        JLabel sum = new JLabel();
        sum.setBounds(300, 250, 600, 50);
        mainJP.add(sum);
        
        int tong = thotel + tpackage;
        sum.setText(String.valueOf(tong));
        JLabel conlai = new JLabel("Còn lại");
        conlai.setBounds(100, 300, 160, 50);
        mainJP.add(conlai);
        JLabel clai = new JLabel();
        clai.setBounds(300, 300, 200, 50);
        mainJP.add(clai);
        
        
        thanhtoan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Bạn đã thanh toán thành công "+tien.getText()+"");
                int thieu = tong - Integer.parseInt(tien.getText());
                clai.setText(String.valueOf(thieu));
            }
        });
        mainJP.setSize(800,600);
        mainJP.setLocation(300,20);
        mainJP.setBackground(new Login().bgrColor);
        conlai.setForeground(new Login().checkYellow);
        costhotel.setForeground(new Login().checkYellow);
        costpackage.setForeground(new Login().checkYellow);
        mainJP.setVisible(true);
        setBounds(300, 20, 800, 600);
        add(mainJP);
    }
    public static void main(String[] args){
        new Paytm("user6").setVisible(true);
    }
}