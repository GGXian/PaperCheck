package main.java.util;


import main.java.pojo.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author GGXian
 * @project 个人作业
 * @createTime 2020/9/22 21:00
 * @description 文件处理工具栏
 **/
public final class FileUtil {

    /**
     * 读取论文
     * @param filePath 目标文件地址
     * @return 论文模型
     */
    public static File readFile(String filePath){
        File file = new File();
        BufferedReader reader = null;
        String tempString;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(filePath));
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                builder.append(tempString.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        tempString = builder.toString();
        file.setSentence(tempString.replaceAll("。", "")
                .replaceAll("，", "")
                .replaceAll(",", ""));
        return file;
    }

    /**
     * 确保目标文件存在
     * @param path 目标文件目录
     * @return 文件模型
     */
    public static java.io.File createFileIfNotExist(String path){
        String dir = path.substring(0, path.lastIndexOf(java.io.File.separatorChar));
        java.io.File dirs = new java.io.File(dir);
        if (!dirs.exists() || !dirs.isDirectory()) {
            if (!dirs.mkdirs()){
                try {
                    throw new Exception("无法创建文件夹！");
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        java.io.File file = new java.io.File(path);
        if (!file.exists() || !file.isFile()){
            try {
                if (!file.createNewFile()){
                    throw new Exception("无法创建文件！");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return file;
    }
}
