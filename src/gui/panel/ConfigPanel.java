package gui.panel;

import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    // 1.设置皮肤
    static {
        GUIUtil.useLNF();
    }
    // 2.设置单例
    public static ConfigPanel instance = new ConfigPanel();

    // 设置Label组件
    JLabel lBudget = new JLabel("本月预算(¥)");
    public JTextField tfBudget = new JTextField("0");

    JLabel lMysql = new JLabel("Mysql安装目录");
    public JTextField tfMysql = new JTextField("");

    // 提交按钮
    JButton bSubmit = new JButton("更新");

    // 3.构造函数
    public ConfigPanel() {
        GUIUtil.setColor(ColorUtil.grayColor, lBudget, lMysql);
        GUIUtil.setColor(ColorUtil.grayColor, tfBudget, tfMysql);
        JPanel pInput = new JPanel();
        JPanel pSubmit = new JPanel();

        // 设置布局
        int gap = 40;
        pInput.setLayout(new GridLayout(4,1,gap,gap));

        pInput.add(lBudget);
        pInput.add(tfBudget);
        pInput.add(lMysql);
        pInput.add(tfMysql);
        this.setLayout(new BorderLayout());
        this.add(pInput, BorderLayout.NORTH);

        pSubmit.add(bSubmit);
        this.add(pSubmit, BorderLayout.CENTER);

    }
    // 4.测试
    public static void main(String[] args) {
        GUIUtil.showPanel(ConfigPanel.instance);
    }
}
