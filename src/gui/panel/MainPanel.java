package gui.panel;

import util.CenterPanel;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends  JPanel{
    // 类加载的时候进行调用
    static {
        GUIUtil.useLNF();
    }
    // 单例实例化
    public static MainPanel instance = new MainPanel();
    // 工具条
    public JToolBar tb = new JToolBar();

    // 六个按钮
    public JButton bSpend = new JButton();
    public JButton bRecord = new JButton();
    public JButton bCategory = new JButton();
    public JButton bReport = new JButton();
    public JButton bConfig = new JButton();
    public JButton bBackup = new JButton();
    public JButton bRecover = new JButton();

    // 主要显示面板
    public CenterPanel workingPanel;

    // 构造函数初始化基本信息
    private MainPanel() {
        GUIUtil.setImageIcon(bSpend , "home.png" , "消费一览");
        GUIUtil.setImageIcon(bRecord , "record.png" , "记一笔");
        GUIUtil.setImageIcon(bCategory , "category2.png" , "消费分类");
        GUIUtil.setImageIcon(bReport , "report.png" , "月消费报表");
        GUIUtil.setImageIcon(bConfig , "config.png" , "设置");
        GUIUtil.setImageIcon(bBackup , "backup.png" , "消费一览");
        GUIUtil.setImageIcon(bRecover , "restore.png" , "恢");

        tb.add(bSpend);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);

        tb.setFloatable(false);
        workingPanel = new CenterPanel(0.8);

        setLayout(new BorderLayout());
        add(tb, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(MainPanel.instance,1);
    }
}
