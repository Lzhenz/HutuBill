package util;

import javax.swing.*;

public class GUIUtil {

    private static String imageFolder = "";

    public static void setImageFolder(JButton b , String fileName , String tip) {
        // 识别当前电脑环境
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Windows")){
            // Win
            imageFolder = "C:/Project/imageFolder";
        } else if (osName.startsWith("Mac OS")) {
            // Mac os
            imageFolder = "/Users/zhenz/study/imageFolder";
        }
    }

    public static void main(String[] args) {
        GUIUtil.setImageFolder(new JButton() , "hello" , "hello");
    }

}
