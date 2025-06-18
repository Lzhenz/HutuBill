package gui.panel;

import gui.Model.CategoryComboBoxModel;
import org.jdesktop.swingx.JXDatePicker;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class RecordPanel extends JPanel {
    static {
        // 使用默认主题
        GUIUtil.useLNF();
    }

    public static RecordPanel instance = new RecordPanel();

    // 定义并且初始化页面的组件

    // 1. lSpend 花费
    JLabel lSpend = new JLabel("花费(¥)");
    JLabel lCategory = new JLabel("分类");
    JLabel lComment = new JLabel("备注");
    JLabel lDate = new JLabel("日期");

    public JTextField tfSpend = new JTextField("0");

    public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
    public JComboBox<String> cbCategory = new JComboBox<>(cbModel);
    public JTextField tfComment = new JTextField();
    public JXDatePicker datePicker = new JXDatePicker();

    //


    // 提交按钮部分
    JButton bSubmit = new JButton("记一笔");

    public RecordPanel() {
        // 对已经在内存中初始化之后的组件进行渲染
        GUIUtil.setColor(Color.black, lSpend,tfSpend);

        JPanel pInput = new JPanel();
        JPanel pSubmit = new JPanel();

        int gap = 40;
        pInput.setLayout(new GridLayout(4,2,gap,gap));

        pInput.add(lSpend);
        pInput.add(tfSpend);

        pInput.add(lCategory);
        pInput.add(cbCategory);

        pInput.add(lComment);
        pInput.add(tfComment);

        pInput.add(lDate);
        pInput.add(datePicker);

        pSubmit.add(bSubmit);

        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);
        this.add(pSubmit,BorderLayout.CENTER);
    }

    // 整体布局分为北布局和中间布局
    public static void main(String[] args) {
        GUIUtil.showPanel(RecordPanel.instance);
    }

}
