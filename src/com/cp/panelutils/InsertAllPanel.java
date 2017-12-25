package com.cp.panelutils;

import com.cp.dao.AllInformDAO;
import com.cp.dao.PersonalInformDAO;
import com.cp.dao.StaffDAO;
import com.cp.factory.DAOFactory;
import com.cp.model.AllInform;
import com.cp.model.PersonalInform;
import com.cp.model.Staff;
import com.cp.utils.DialogDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 徐鹏 on 2017/12/23.
 * @author 徐鹏
 * 全体通知的发送
 * 2017/12/23
 */
public class InsertAllPanel extends JPanel {
    private JPanel topPanel;
    private JButton confirmButton;
    private JButton dateButton;
    private JLabel showLabel;
    private JComboBox comboBox;
    private JTextArea textArea;
    private String dateString;
    private Staff staff;
    private List<Staff> staffList;
    private StaffDAO staffDAO = DAOFactory.getStaffDAO();
    private PersonalInformDAO personalInformDAO = DAOFactory.getPersonalInformDAO();
    private int j = 0;
    private JTextField textField;
    private AllInformDAO allInformDAO = DAOFactory.getAllInformDAO();

    public InsertAllPanel(Staff staff) {
        this.staff = staff;
        try {
            staffList = staffDAO.getAll(staff.getStaffNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setLayout(new BorderLayout());
        topPanel = new JPanel();
        confirmButton = new JButton();
        dateButton = new JButton();
        showLabel = new JLabel();
        textArea = new JTextArea();
        textField = new JTextField(10);

        textField.setVisible(true);
        textField.setText("请输入标题");


        add(topPanel,BorderLayout.NORTH);
        add(textArea,BorderLayout.CENTER);

        String[] strings = new String[staffList.size()];
        for (int i=0;i<staffList.size();i++){
            String string = staffList.get(i).getStaffNumber();
            if (string != staff.getStaffNumber()){
                strings[i] = new String(string);
            }
        }

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel(strings);
        comboBox = new JComboBox(model);


        dateButton.setText("发送时间");
        confirmButton.setText("发送");


        topPanel.setLayout(new FlowLayout());
        topPanel.add(comboBox);
        topPanel.add(dateButton);
        topPanel.add(showLabel);
        topPanel.add(textField);
        topPanel.add(confirmButton);


        init();

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String content = textArea.getText(); //内容

                String s = textField.getText(); //标题


                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                try {
                    date = sdf.parse(dateString);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                java.sql.Date sentTime = new java.sql.Date(date.getTime());//时间


                AllInform allInform = new AllInform(staff.getStaffNumber(),s,content,sentTime);
                System.out.println(allInform);
                try {

                    allInformDAO.insertAll(allInform);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });

    }



    private void init() {




        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //文本框设置输入限制
                String s = textField.getText();
                if(s.length() >= 10){
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });





        dateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField txtDate = new JTextField();
                //弹出时间选择框
                new DialogDatePicker(true, txtDate, 550, 250);
                //获得日期
                dateString = txtDate.getText();
                showLabel.setText(dateString);

            }
        });






    }


    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame("测试窗体");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        Staff staff = DAOFactory.getStaffDAO().get("20010");

        frame.add(new InsertAllPanel(staff));

        frame.setVisible(true);
    }


}