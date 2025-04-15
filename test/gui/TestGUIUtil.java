package gui;

import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class TestGUIUtil {
    public static void main(String[] args) {
        GUIUtil.useLNF();
        JPanel p = new JPanel();
        p.add(new JButton("按钮1"));
        p.add(new JButton("按钮2"));
        GUIUtil.showPanel(p);
    }
}
