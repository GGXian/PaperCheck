import org.ggxian.papercheck.Main;
import org.junit.Test;
import org.ggxian.papercheck.pojo.Paper;
import org.ggxian.papercheck.util.CalculatorUtil;
import org.ggxian.papercheck.util.FileUtil;

import java.io.File;

import static org.ggxian.papercheck.util.FileUtil.getPercentFormat;

/**
 * @author GGXian
 * @project 个人作业
 * @createTime 2020/9/24 23:37
 * @description
 **/
public class test {

    @Test
    public void testMain(){
        long before = System.currentTimeMillis();
        String originalText1 = "src/test/resources/txtFile/orig.txt";
        String modifiedText2 = "src/test/resources/txtFile/orig.txt";
        String modifiedText3 = "src/test/resources/txtFile/orig2.txt";
        Paper originalText = FileUtil.readFromFile(originalText1);
        Paper modifiedText = FileUtil.readFromFile(modifiedText2);
        try {
            Thread.sleep(5000);
            System.out.println(34234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CalculatorUtil.calculate(originalText, modifiedText);
        double repetitionRate = modifiedText.getRepetitionRate();
        java.io.File file = FileUtil.createFileIfNotExist(modifiedText3);
        if (file == null){
            return;
        }
        String result = "===================================\n" +
                "总字数：" + modifiedText.getSum() + "\n" +
                "重复字数：" + modifiedText.getRepetition() + "\n" +
                "重复率：" + getPercentFormat(modifiedText.getRepetitionRate()) + "\n" +
                "时间用了" + (double)(System.currentTimeMillis() - before)/1000 + "秒\n" +
                "===================================";
        FileUtil.writeInFile(modifiedText3, result);
    }


    @Test
    public void testMain2(){
        Main.main(new String[]{"1.txt","C:\\Users\\huawei\\Desktop\\软件工程导论\\论文查重样例\\orig_0.8_dis_10-副本.txt","D:\\1.txt"});
    }

    @Test
    public void test(){
        System.out.println(File.separatorChar);
        System.out.println(File.pathSeparatorChar);
    }
}
