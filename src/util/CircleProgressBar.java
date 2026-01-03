package util;

import javafx.scene.control.ProgressBar;

import javax.swing.*;
import java.awt.*;

public class CircleProgressBar extends JPanel {
    // 最小进度
    private int minimumProgress;
    // 最大进度
    private int maximumProgress;
    // 进度条
    private int progress;
    // 进度条显示文字
    private String progressText;
    // 进度条的背景颜色
    private Color backgroundColor;
    // 进度条的进度颜色
    private Color foregroundColor;

    public CircleProgressBar(){
        minimumProgress = 0;
        maximumProgress = 100;
        progressText = "0%";
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int size = Math.min(getWidth(), getHeight()) - 40;
        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;

        g2.setStroke(new BasicStroke(20f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        // 背景圆
        g2.setColor(backgroundColor);
        g2.drawArc(x, y, size, size, 0, 360);

        // 进度圆
        g2.setColor(foregroundColor);
        g2.drawArc(
                x, y, size, size,
                90,
                -(int) (360.0 * progress / maximumProgress)
        );

        // 文字
        int fontSize = size / 5;
        g2.setFont(new Font("黑体", Font.BOLD, fontSize));
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(progressText);
        int textAscent = fm.getAscent();

        g2.drawString(
                progressText,
                getWidth() / 2 - textWidth / 2,
                getHeight() / 2 + textAscent / 2
        );
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        if (progress >= minimumProgress && progress <= maximumProgress)
            this.progress = progress;
        if (progress > maximumProgress)
            this.progress = maximumProgress;

        this.progressText = String.valueOf(progress + "%");

        this.repaint();
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        this.repaint();
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
        this.repaint();
    }

}
