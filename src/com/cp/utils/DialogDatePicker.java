package com.cp.utils;

import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.JDatePanel;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xu
 * 日期选择对话框工具
 */
public class DialogDatePicker extends JDialog {
    private static final long serialVersionUID = 1L;

    /**
     * 弹出日期选择窗口
     *
     * @param modal           是否是模态窗口
     * @param txtSelectedDate 日期内容接收文本框
     * @param screenX         显示X点坐标
     * @param screenY         显示Y点坐标
     */
    public DialogDatePicker(boolean modal, final JTextField txtSelectedDate, int screenX, int screenY) {
        final JDatePanel jp = JDateComponentFactory.createJDatePanel(new UtilDateModel(new Date()));
        jp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtSelectedDate != null) {
                    try {
                        txtSelectedDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(jp.getModel().getValue()));
                    } catch (Exception ex) {
                        txtSelectedDate.setText("");
                    }
                }
            }
        });
        JPanel pnl = (JPanel) jp;
        this.add(pnl);
        this.setTitle("选择日期");
        this.setResizable(false);
        this.setModal(modal);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setBounds(screenX, screenY, 300, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        JTextField txtDate = new JTextField();
        new DialogDatePicker(true, txtDate, 300, 400);
        System.out.println(txtDate.getText());
    }
}