import pojo.File;
import util.Calculator;
import util.FileUtil;

import java.io.*;
import java.text.NumberFormat;


/**
 * @author GGXian
 * @project 个人作业
 * @createTime 2020/9/22 20:55
 * @description 程序入口
 **/
public class Main {
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        File originalText = FileUtil.readFile(args[0]);
        File modifiedText = FileUtil.readFile(args[1]);
        Calculator.perform(originalText, modifiedText);
        double repetitionRate = modifiedText.getRepetitionRate();
        java.io.File file = FileUtil.createFileIfNotExist(args[2]);
        if (file == null){
            return;
        }
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true)));
            out.write("===================================\n");
            out.write("总字数：" + modifiedText.getSum() + "\n");
            out.write("重复字数：" + modifiedText.getRepetition() + "\n");
            out.write("重复率：" + getPercentFormat(repetitionRate) + "\n");
            out.write("时间用了" + (double)(System.currentTimeMillis() - before)/1000 + "秒\n");
            out.write("===================================\n");
            out.flush();
        } catch (IOException e) {
            System.out.println("文件写入异常！");
            e.printStackTrace();
        }finally {
            try {
                if(out != null){
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("===================================");
        System.out.println("总字数：" + modifiedText.getSum());
        System.out.println("重复字数：" + modifiedText.getRepetition());
        System.out.println("重复率：" + getPercentFormat(repetitionRate));
        System.out.println("时间用了" + (double)(System.currentTimeMillis() - before)/1000 + "秒");
        System.out.println("===================================");
    }

    /**
     * 转换重复率
     * @param d 重复率的浮点数
     * @return 重复率的字符串
     */
    public static String getPercentFormat(double d){
        NumberFormat nf = java.text.NumberFormat.getPercentInstance();
        // 小数点后保留几位
        nf.setMinimumFractionDigits(2);
        return nf.format(d);
    }

}
