package util;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GUIUtil {

    private static String imageFolder = "";
    static {
        // 识别当前电脑环境
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Windows")){
            // Win
            imageFolder = "C:/Project/imageFolder";
        } else if (osName.startsWith("Mac OS")) {
            // Mac os
            imageFolder = "/Users/zhenz/study/HutuBill/img";
        }
    }
    public static void setImageFolder(JButton b , String fileName , String tip) {
        ImageIcon imageIcon = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
        b.setIcon(imageIcon);
        b.setPreferredSize(new Dimension(61,81));
        b.setToolTipText(tip);
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }

    public static void setColor(Color color , JComponent... cs) {
        for (JComponent c : cs){
            c.setForeground(color);
        }
    }

    /**
     * 输入一个面板和伸缩的比例，先new一个Frame框架，设置固定的大小。
     * 在获取一个居中组件，将组件放到框架中。
     * 最后同时显示框架和组件
     * @param p
     * @param strechRate
     */
    public static void showPanel(JPanel p , double strechRate) {
        GUIUtil.useLNF();
        JFrame f = new JFrame();
        f.setSize(500 ,500);
        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(strechRate);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        cp.show(p);
    }

    /**
     * 固定比例的组件
     * @param p
     */
    public static void showPanel(JPanel p) {
        showPanel(p , 0.85);
    }

    /**
     * 检查是否是数字
     * @param tf
     * @param input
     * @return
     */
    public static boolean checkNumber(JTextField tf , String input) {
        if (!checkEmpty(tf, input)){
            return false;
        }
        String text = tf.getText().trim();
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(null, input + "需要是整数");
            tf.grabFocus();
            return false;
        }
    }

    public static boolean checkZero(JTextField tf , String input) {
        if (checkNumber(tf , input)){
            return false;
        }
        String text = tf.getText().trim();

        if (0 == Integer.parseInt(text)){
            JOptionPane.showMessageDialog(null, input + " 不能为零");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    public static boolean checkEmpty(JTextField tf , String input) {
        String text = tf.getText().trim();
        if (0 == text.length()){
            JOptionPane.showMessageDialog(null, input + "不能为空");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    public static void useLNF() {
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void setImageIcon(JButton b, String fileName, String tip){
        ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
        b.setIcon(i);
        b.setPreferredSize(new Dimension(61,81));
        b.setToolTipText(tip);
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }

    public static void main(String[] args) {
        GUIUtil.setImageFolder(new JButton() , "hello" , "hello");
    }

}
