package com.cp.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by ASUS on 2017/12/19.
 * @author jzy
 */
public class MyDialog extends JDialog {
    private String info;
    private JLabel showLabel;
    private RounderButton confirmButton;

    public MyDialog(String info){
        this.info = info;
        //设置模态框
        setModal(true);
        setSize(400,300);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);

        this.getContentPane().setBackground(new Color(25,190,243));
        showLabel = new JLabel(info);
        Style.setLabelStyle(showLabel);
        showLabel.setBounds(150,125,200,50);
        add(showLabel);
        confirmButton = new RounderButton("确认");
        Style.setBigButtonStyle(confirmButton);
        confirmButton.setBounds(275,225,100,40);
        add(confirmButton);
        confirmButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MyDialog.this.dispose();
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyDialog("登录成功");
    }

}
