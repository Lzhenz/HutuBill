package util;

import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;

import javax.swing.*;
import java.awt.*;

public class ChartUtil {

    public static int max(double [] sampleValues) {
        int max = 0;
        for (double v : sampleValues) {
            if (v > max) {
                max = (int) v;
            }
        }
        return max;
    }

    private static String[] sampleLabels() {
        String[] sampleLabels = new String[30];

        for (int i = 0; i < sampleLabels.length; i++) {
            if (0 == i % 5)
                sampleLabels[i] = String.valueOf(i + 1 + "日");
        }
        return sampleLabels;
    }

    private static double[] sampleValues() {
        double [] result = new double[30];
        for (int i = 0 ; i < result.length; i++) {
            result[i] = (int) (Math.random() * 300);
        }
        return result;
    }

    public static Image getImage(int width , int height) {
        // 模拟样本数据
        double [] sampleValues = sampleValues();
        // 下方的文字
        String[] sampleLabels = sampleLabels();
        // 样本中的最大值
        int max = max(sampleValues);

        // 数据颜色
        Color[] sampleColors = {ColorUtil.blueColor};
        // 柱状图
        BarChart chart = new BarChart();

        // 设置样本个数
        chart.setSampleCount(sampleValues.length);
        // 设置样本数据
        chart.setSampleValues(0 , sampleValues);
        // 设置文字
        chart.setSampleLabels(sampleLabels);
        // 设置颜色
        chart.setSampleColors(sampleColors);
        // 设置取值范围
        chart.setRange(0 , max * 1.2);
        // 显示背景横线
        chart.setValueLinesOn(true);
        // 显示文字
        chart.setSampleLabelsOn(true);
        // 把文字写在下面
        chart.setSampleLabelStyle(Chart.BELOW);

        // 样本值的字体
        chart.setFont("rangeLabelFont", new Font("Arial" , Font.BOLD, 12));
        // 把图例说明放在左侧
        chart.setLegendPosition(Chart.LEFT);
        // 图例说明中的文字
        chart.setLegendLabels(new String[] { "月消费报表" });
        // 图例说明的字体
        chart.setFont("legendFont", new Font("Dialog", Font.BOLD, 13));
        // 下方文字的字体
        chart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));
        // 图表中间背景颜色
        chart.setChartBackground(Color.white);
        // 图表整体背景颜色
        chart.setBackground(ColorUtil.backgroundColor);
        // 把图表转换成Image类型
        Image im = chart.getImage(width, height);
        return im;
    }

    public static void main(String[] args) {
        JPanel jPanel = new JPanel();
        JLabel jLabel = new JLabel();

        Image image = ChartUtil.getImage(400, 300);
        ImageIcon icon = new ImageIcon(image);

        jLabel.setIcon(icon);
        jPanel.add(jLabel);

        GUIUtil.showPanel(jPanel);

    }

}
