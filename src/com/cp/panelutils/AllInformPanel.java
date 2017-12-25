package com.cp.panelutils;

import com.cp.dao.AllInformDAO;
import com.cp.factory.DAOFactory;
import com.cp.model.AllInform;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Iterator;

/**
 * @author 徐鹏
 * 全体通知的查看
 * 2017/12/20
 */
public class AllInformPanel extends JPanel {
    private JPanel buttonPanel;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel dtm;
    private JButton viewButton;
    private java.util.List<AllInform> allInforms;
    private AllInformDAO allInformDAO = DAOFactory.getAllInformDAO();
    private int[] rows;

    public AllInformPanel() {


        setBackground(Color.white);
        setVisible(true);
        setLayout(new BorderLayout());


        buttonPanel = new JPanel();
        scrollPane = new JScrollPane();
        viewButton = new JButton();
        table = new JTable();

        scrollPane.setBackground(Color.white);
//        scrollPane.add(table);
        scrollPane.setViewportView(table);

        buttonPanel.add(viewButton);
        add(scrollPane,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);
        viewButton.setText("查看");

        init();

    }

   public void init() {
        showInformTable();


       table.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               //选中多行
               rows = table.getSelectedRows();
           }
       });

       viewButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               int count = table.getSelectedRow();
               String getcontent = table.getValueAt(count,3).toString();
//               JOptionPane.showMessageDialog(null,getcontent);
               //JOptionPane.showConfirmDialog(viewButton,getcontent,"标题",JOptionPane.YES_NO_OPTION);

               //创建新的窗口
               JFrame frame = new JFrame("新窗口");
               //设置在屏幕的位置
               frame.setLocation(100,50);
                  // 窗体大小
               frame.setSize(200,200);
               // 显示窗体
               frame.setVisible(true);
               JTextArea textArea = new JTextArea(getcontent);
               frame.setLayout(new BorderLayout());
               frame.add(textArea,BorderLayout.CENTER);

           }
       });

//        setOpaque(false);


    }

    private void showInformTable() {
        dtm = new DefaultTableModel();
        String[] titles = {"序号","发送人","标题","内容","时间"};
        dtm.setColumnIdentifiers(titles);
        table.setModel(dtm);
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);
        // 将表头居中
        DefaultTableCellRenderer r1 = new DefaultTableCellRenderer();
        r1.setHorizontalAlignment(JLabel.CENTER);
        r1.setBackground(Color.LIGHT_GRAY);
        table.getTableHeader().setDefaultRenderer(r1);
        //内容字符串数组
        String[] content = new String[5];

        try {
            allInforms = allInformDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Iterator<AllInform> iterator = allInforms.iterator();
        while (iterator.hasNext()){
            AllInform allInform = iterator.next();
            content[0] = allInform.getId().toString();
            content[1] = allInform.getSenderNumber();
            content[2] = allInform.getInformTitle();
            content[3] = allInform.getInformContent();
            content[4] = allInform.getSendDate().toString();
            dtm.addRow(content);
        }
        scrollPane.revalidate();





    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("测试窗体");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.add(new AllInformPanel());
        frame.setVisible(true);
    }

}