package com.cp.panelutils;

import com.cp.dao.PersonalInformDAO;
import com.cp.factory.DAOFactory;
import com.cp.model.PersonalInform;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * @author 徐鹏
 * 个人通知的查看、刷新
 * 2017/12/21
 */
public class PersonalInformPanel extends JPanel {
    private JPanel buttonPanel1;
    private JScrollPane scrollPane1, scrollPane2;
    private JTable table1, table2;
    private DefaultTableModel dtm, dtm2;
    private JButton viewButton1,viewButton2,freshButton;
    private List<PersonalInform> personalInforms;
    private PersonalInformDAO personalInformDAO = DAOFactory.getPersonalInformDAO();

    public PersonalInformPanel() {

        setBackground(Color.white);
        setVisible(true);
        setLayout(new BorderLayout());


        buttonPanel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        scrollPane2 = new JScrollPane();
        viewButton1 = new JButton();
        viewButton2 = new JButton();
        freshButton = new JButton();
        table1 = new JTable();
        table2 = new JTable();

        scrollPane1.setBackground(Color.white);

        scrollPane1.setViewportView(table1);
        scrollPane2.setViewportView(table2);
        scrollPane1.setPreferredSize(new Dimension(800,250));
        scrollPane2.setPreferredSize(new Dimension(800,250));

        buttonPanel1.add(viewButton1);
        buttonPanel1.add(viewButton2);
        buttonPanel1.add(freshButton);
        add(scrollPane1, BorderLayout.NORTH);
        add(scrollPane2,BorderLayout.CENTER);
        add(buttonPanel1, BorderLayout.SOUTH);
        viewButton1.setText("查看已读");
        viewButton2.setText("查看未读");
        freshButton.setText("刷新");

        init();
    }

    private void init() {

        showSeenTable();
        showInitialTable();


        freshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });



        viewButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = table1.getSelectedRow();
                String getcontent = table1.getValueAt(count, 3).toString();
                //创建新的窗口
                JFrame frame = new JFrame("新窗口");
                //设置在屏幕的位置
                frame.setLocation(100, 50);
                // 窗体大小
                frame.setSize(200, 200);
                // 显示窗体
                frame.setVisible(true);
                JTextArea textArea = new JTextArea(getcontent);
                frame.setLayout(new BorderLayout());
                frame.add(textArea, BorderLayout.CENTER);



            }
        });

        viewButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int count1 = table2.getSelectedRow();
                String getcontent1 = table2.getValueAt(count1, 3).toString();
                //创建新的窗口
                JFrame frame1 = new JFrame("新窗口");
                //设置在屏幕的位置
                frame1.setLocation(100, 50);
                // 窗体大小
                frame1.setSize(200, 200);
                // 显示窗体
                frame1.setVisible(true);
                JTextArea textArea1 = new JTextArea(getcontent1);
                frame1.setLayout(new BorderLayout());
                frame1.add(textArea1, BorderLayout.CENTER);

            }
        });


    }

    private void showInitialTable() {
        dtm = new DefaultTableModel();
        String[] titles = {"序号", "接收人", "发送人", "内容", "日期", "状态"};
        dtm.setColumnIdentifiers(titles);
        table1.setModel(dtm);
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table1.setDefaultRenderer(Object.class, r);
        // 将表头居中
        DefaultTableCellRenderer r1 = new DefaultTableCellRenderer();
        r1.setHorizontalAlignment(JLabel.CENTER);
        r1.setBackground(Color.LIGHT_GRAY);
        table1.getTableHeader().setDefaultRenderer(r1);
        //内容字符串数组
        String[] content = new String[6];

        // personalInforms = personalInformDAO.getPI();
        try {
            personalInforms = personalInformDAO.getAllPI();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Iterator<PersonalInform> iterator = personalInforms.iterator();
        while (iterator.hasNext()) {
            PersonalInform personalInform = iterator.next();
            String flag = personalInform.getIsRead();
            if ("yes".equals(flag)) {
                content[0] = personalInform.getId().toString();
                content[1] = personalInform.getReceiverNumber();
                content[2] = personalInform.getSenderNumber();
                content[3] = personalInform.getInformContent();
                content[4] = personalInform.getSendDate().toString();
                content[5] = personalInform.getIsRead();
                dtm.addRow(content);
            }

        }
        scrollPane1.revalidate();

    }

    private void showSeenTable() {
        dtm2 = new DefaultTableModel();
        String[] titles = {"序号", "接收人", "发送人", "内容", "日期", "状态"};
        dtm2.setColumnIdentifiers(titles);
        table2.setModel(dtm2);
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table2.setDefaultRenderer(Object.class, r);
        // 将表头居中
        DefaultTableCellRenderer r1 = new DefaultTableCellRenderer();
        r1.setHorizontalAlignment(JLabel.CENTER);
        r1.setBackground(Color.LIGHT_GRAY);
        table2.getTableHeader().setDefaultRenderer(r1);
        //内容字符串数组
        String[] content = new String[6];


        try {
            personalInforms = personalInformDAO.getAllPI();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Iterator<PersonalInform> iterator = personalInforms.iterator();
        while (iterator.hasNext()) {
            PersonalInform personalInform = iterator.next();
            String flag = personalInform.getIsRead();
            if ("no".equals(flag)) {
                content[0] = personalInform.getId().toString();
                content[1] = personalInform.getReceiverNumber();
                content[2] = personalInform.getSenderNumber();
                content[3] = personalInform.getInformContent();
                content[4] = personalInform.getSendDate().toString();
                content[5] = personalInform.getIsRead();
                dtm2.addRow(content);
            }
            scrollPane2.revalidate();

        }


    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("测试窗体");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.add(new PersonalInformPanel());
        frame.setVisible(true);
    }
}