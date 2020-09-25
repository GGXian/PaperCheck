package org.ggxian.papercheck;

import org.ggxian.papercheck.component.EnterNullException;
import org.ggxian.papercheck.pojo.Paper;
import org.ggxian.papercheck.util.CalculatorUtil;
import org.ggxian.papercheck.util.FileUtil;

import static org.ggxian.papercheck.util.FileUtil.getPercentFormat;


/**
 * @author GGXian
 * @project 个人作业
 * @createTime 2020/9/22 20:55
 * @description 程序入口
 **/
public class Main {
    public static void main(String[] args) {
        String result;
        long before = System.currentTimeMillis();
        try {
            if (args[0] == null){
                throw new EnterNullException("输入的源文件地址为空，请重新输入！");
            } else if (args[1] == null) {
                throw new EnterNullException("输入的对比文件地址为空，请重新输入！");
            }else if (args[2] == null){
                throw new EnterNullException("输出文件地址为空，请重新输入！");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return;
        }
        Paper originalText = FileUtil.readFromFile(args[0]);
        Paper modifiedText = FileUtil.readFromFile(args[1]);
        CalculatorUtil.calculate(originalText, modifiedText);
        result = "===================================\n" +
                "总字数：" + modifiedText.getSum() + "\n" +
                "重复字数：" + modifiedText.getRepetition() + "\n" +
                "重复率：" + getPercentFormat(modifiedText.getRepetitionRate()) + "\n" +
                "时间用了" + (double)(System.currentTimeMillis() - before)/1000 + "秒\n" +
                "===================================";
        FileUtil.writeInFile(args[2], result);
    }
}
