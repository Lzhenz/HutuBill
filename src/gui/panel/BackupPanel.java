package gui.panel;

import com.sun.deploy.panel.JavaPanel;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;

public class BackupPanel extends JPanel {

    static {
        GUIUtil.useLNF();
    }

    public static BackupPanel instance = new BackupPanel();
    JButton bBackup = new JButton("备份");

    public BackupPanel() {
        GUIUtil.setColor(ColorUtil.blueColor , bBackup);
        this.add(bBackup);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(BackupPanel.instance);
    }
}
