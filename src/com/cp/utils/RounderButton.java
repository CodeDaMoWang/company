package com.cp.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * @author jzy
 * @date 2017/12/18
 * 自定义圆角按钮
 */
public class RounderButton extends JButton {
    private Shape shape = null;
    private Color click = new Color(71, 164, 119);
    private Color quit = new Color(92, 184, 92);
    private Integer arc = 35;


    public RounderButton(String text) {
        super(text);
        setContentAreaFilled(false);
    }

    public RounderButton() {
        super();
    }

//    public RounderButton(String text, Icon icon) {
//        super(text, icon);
//    }
//
//    public RounderButton(Icon icon) {
//        super(icon);
//    }

    public void setColor(Color c, Color q) {
        click = c;
        quit = q;
    }


    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(click);
        } else {
            g.setColor(quit);
        }
        g.setFont(getFont());
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, arc, arc);
        super.paintComponent(g);
    }

    @Override
    public void paintBorder(Graphics g) {
        g.setColor(new Color(69, 146, 236));
        g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, arc, arc);
        g.dispose();
    }

    @Override
    public boolean contains(int x, int y) {
        //判断X,Y是否在按钮内
        if (shape == null || !(shape.getBounds().equals(getBounds()))) {
            shape = new RoundRectangle2D.Float(0, 0, getSize().width, getSize().height, arc, arc);
        }
        return shape.contains(x, y);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(400, 300);
        Font font = new Font("微软雅黑", Font.PLAIN, 15);
        RounderButton rounderButton = new RounderButton("nihao");
        rounderButton.setFont(font);
        rounderButton.setPreferredSize(new Dimension(150, 50));
        JPanel jPanel = new JPanel(new FlowLayout());
        f.getContentPane().add(rounderButton, BorderLayout.NORTH);
        f.getContentPane().setBackground(Color.WHITE);
        f.getContentPane().add(jPanel);
        jPanel.add(rounderButton);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

}
