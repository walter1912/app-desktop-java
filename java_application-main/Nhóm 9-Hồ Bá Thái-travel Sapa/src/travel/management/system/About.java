/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class About extends JFrame implements ActionListener {

    JButton b1;
    JLabel l1;
    Font f, f1, f2;
    TextArea t1;
    String s;

    public About() {

        setLayout(null);
        JButton b1 = new JButton("Exit");
        add(b1);
        b1.setBounds(180, 450, 120, 20);
        b1.addActionListener(this);

        Font f = new Font("RALEWAY", Font.BOLD, 180);
        setFont(f);

        s = "                                     About Project          \n  "
                + "\nMục tiêu của dự án Hệ thống quản lý Tham quan và Du lịch"
                + "này là phát triển một hệ thống mà nó tự động hóa các tiến trình "
                + "và các hoạt động của chuyến đi với mục đích là để thiết kế ra một "
                + "hệ thống sử dụng cái gì đó để có thể xử lý toàn bộ các hoạt động liên quan đến "
                + "du lịch.\n\n"
                + "Ứng dụng này sẽ giúp trong việc truy cập các thông liên quan "
                + "đến các chuyến du lịch đến các điểm đến cụ thể với một cách dễ dàng. "
                + "Người dùng có thể theo dõi thông tin liên quan đến các chuyến tham quan của họ "
                + "dễ dàng thông qua ứng dụng này. Bạn cũng có thể tìm được các thông tin về các "
                + "đại lý du lịch thông qua ứng dụng này.\n\n"
                
                + "\n  Cung cấp thông tin chính xác"
                + "\n  Đơn giản hóa các công việc"
                + "\n  Giảm thiểu tối đa những tài liệu liên quan đến công việc"
                + "\n  Cung cấp những thông tin mới nhất vừa cập nhật"
                + "\n  Thiên thiện với người dùng bằng việc cung cấp các tin nhắn cảnh báo."
                + "\n  Các thông tin chi tiết về khách du lịch có thể được cung cấp"
                + "\n  Thông báo xác nhận đặt vé"
                ;

        TextArea t1 = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        t1.setBackground(new Login().bgrColor);
        t1.setEditable(false);
        t1.setBounds(20, 100, 450, 300);

        add(t1);

        Font f1 = new Font("RALEWAY", Font.BOLD, 16);
        t1.setFont(f1);

        Container contentPane = this.getContentPane();
        t1 = new TextArea();

        JLabel l1 = new JLabel("About Project");
        add(l1);
        l1.setBounds(170, 10, 180, 80);
        l1.setForeground(Color.red);

        Font f2 = new Font("RALEWAY", Font.BOLD, 20);
        l1.setFont(f2);

        setBounds(300, 0, 500, 550);

        setLayout(null);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
    }

    public static void main(String args[]) {
        new About().setVisible(true);
    }

}
