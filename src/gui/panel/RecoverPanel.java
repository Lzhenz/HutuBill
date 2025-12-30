package gui.panel;

import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;

public class RecoverPanel extends JPanel {

    static {
        GUIUtil.useLNF();
    }

    public static RecoverPanel instance = new RecoverPanel();

    // 加入按钮
    public JButton bRecover = new JButton("恢复");

    public RecoverPanel(){
        // 把按钮在初始化的时候进行
        GUIUtil.setColor(ColorUtil.blueColor , bRecover);
        this.add(bRecover);
    }

    // 测试
    public static void main(String[] args) {
        GUIUtil.showPanel(RecoverPanel.instance);
    }

}
