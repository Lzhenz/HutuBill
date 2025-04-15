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

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        // 开启抗锯齿
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int x = 0;
        int y = 0;
        int width = 0;
        int height = 0;
        int fontSize = 0;
        if (getWidth() >= getHeight()){
            x = (getWidth() -getHeight()) / 2 + 25;
            y = 25;
            width = getWidth() - 60;
            height = getHeight() - 50;
            fontSize = getWidth() / 8;
        } else {
            x = 25;
            y = (getHeight() - getHeight()) / 2 + 25;
            width = getWidth() - 60;
            height = getHeight() - 50;
            fontSize = getHeight() / 8;
        }
        graphics2D.setStroke(new BasicStroke(20.0f));
        graphics2D.setColor(backgroundColor);
        graphics2D.drawArc(x, y , width , height , 0 , 360);
        graphics2D.setColor(foregroundColor);
        graphics2D.drawArc(x, y , width , height , 90 , -(int) (360 * ((progress * 1.0) / (maximumProgress - minimumProgress))));
        graphics2D.setFont(new Font("黑体" , Font.BOLD , fontSize));
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        int digitalWidth = fontMetrics.stringWidth(progressText);
        int digitalAscent = fontMetrics.getAscent();
        graphics2D.setColor(foregroundColor);
        graphics2D.drawString(progressText, getWidth() / 2 - digitalWidth / 2, getHeight() / 2 + digitalAscent / 2);
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
