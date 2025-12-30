package gui.frame;

import gui.panel.MainPanel;

import javax.swing.*;

public class MainFrame extends JFrame {
    private static MainFrame instance = new MainFrame();

    private MainFrame (){
        this.setSize(500 , 450);
        this.setTitle("一本糊涂账");
        this.setContentPane(MainPanel.instance);
        // 设置当前窗体的在电脑显示屏中的位置
        this.setLocationRelativeTo(null);
        // 是否允许用户拖拽改变窗体大小
        this.setResizable(false);
        // 点击右上角的关闭按钮的时候，关闭当前的程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        instance.setVisible(true);
    }
}
