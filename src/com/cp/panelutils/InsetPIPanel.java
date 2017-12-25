package com.cp.panelutils;

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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by 徐鹏 on 2017/12/21.
 * @author 徐鹏
 * 个人消息的发送
 */
public class InsetPIPanel extends JPanel {
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

    public InsetPIPanel(Staff staff) {
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
        topPanel.add(confirmButton);


        init();

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String content = textArea.getText(); //内容
                String reiveID = comboBox.getSelectedItem().toString();//接收者工号


                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                try {
                    date = sdf.parse(dateString);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                java.sql.Date sentTime = new java.sql.Date(date.getTime());//时间

                PersonalInform personalInform = new PersonalInform(reiveID,staff.getStaffNumber(),content,sentTime);
                System.out.println(personalInform);
                try {
                    personalInformDAO.insertPI(personalInform);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });

    }



    private void init() {





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

//    public static void main(String[] args) throws SQLException {
//
//        Staff staff = DAOFactory.getStaffDAO().get("20010");
//
//        new InsetPIPanel(staff);
//    }

    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame("测试窗体");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        Staff staff = DAOFactory.getStaffDAO().get("20010");
        frame.add(new InsetPIPanel(staff));

        frame.setVisible(true);
    }


}