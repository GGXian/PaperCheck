package org.ggxian.papercheck;

import junit.framework.TestCase;
import org.ggxian.papercheck.Main;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author GGXian
 * @project 个人作业
 * @createTime 2020/9/25 0:21
 * @description Main测试类
 **/
public class TestMain {
    /**
     * 测试源文件路径为null的情况
     */
    @Test
    public void testForOriginalArticleNull(){
//        Assert.assertThrows()
        Main.main(new String[]{null,"C:\\Users\\huawei\\Desktop\\软件工程导论\\论文查重样例\\orig_0.8_add.txt","D:\\1.txt"});
    }


    /**
     * 测试对比文件路径为null的情况
     */
    @Test
    public void testForPlagiarismArticleNull(){
        Main.main(new String[]{"C:\\Users\\huawei\\Desktop\\软件工程导论\\论文查重样例\\orig.txt",null,"D:\\1.txt"});
    }

    /**
     * 测试结果输出文件路径为null的情况
     */
    @Test
    public void testForResultNull(){
        Main.main(new String[]{"C:\\Users\\huawei\\Desktop\\软件工程导论\\论文查重样例\\orig.txt","C:\\Users\\huawei\\Desktop\\软件工程导论\\论文查重样例\\orig_0.8_add.txt",null});
    }


    /**
     * 测试路径不存在的情况
     */
    @Test
    public void testForNotExistFile(){
        Main.main(new String[]{"C:\\Users\\huawei\\Desktop\\软件工程导论\\论文查重样例\\orig.txt","C:\\Users\\huawei\\Desktop\\软件工程导论\\论文查重样例\\orig_0.8_add.txt",null});
    }


    /**
     * 测试输入对比的文件内容为空的情况
     */
    @Test
    public void testForEmpty(){
        Main.main(new String[]{"C:\\Users\\huawei\\Desktop\\软件工程导论\\论文查重样例\\orig.txt","C:\\Users\\huawei\\Desktop\\软件工程导论\\论文查重样例\\orig_0.8_add.txt","D:\\1.txt"});
    }

    /**
     * 测试对比orig_0.8_add.txt
     */
    @Test
    public void testForAdd(){
        Main.main(new String[]{"C:\\Users\\huawei\\Desktop\\软件工程导论\\论文查重样例\\orig.txt","C:\\Users\\huawei\\Desktop\\软件工程导论\\论文查重样例\\orig_0.8_add.txt","D:\\1.txt"});
    }


    /**
     * 测试对比orig_0.8_del.txt
     */
    @Test
    public void testForDel(){
        Main.main(new String[]{"C:\\Users\\huawei\\Desktop\\软件工程导论\\论文查重样例\\orig.txt","C:\\Users\\huawei\\Desktop\\软件工程导论\\论文查重样例\\orig_0.8_del.txt","D:\\1.txt"});
    }

    /**
     * 测试对比orig_0.8_dis_1.txt.txt
     */
    @Test
    public void testForDis1(){
        Main.main(new String[]{"C:\\Users\\huawei\\Desktop\\软件工程导论\\论文查重样例\\orig_0.8_dis_1.txt","C:\\Users\\huawei\\Desktop\\软件工程导论\\论文查重样例\\orig_0.8_dis_1.txt","D:\\1.txt"});
    }


    /**
     * 测试对比orig_0.8_dis_10.txt
     */
    @Test
    public void testForAdd10(){
        Main.main(new String[]{"C:\\Users\\huawei\\Desktop\\软件工程导论\\论文查重样例orig_0.8_dis_1.txt","C:\\Users\\huawei\\Desktop\\软件工程导论\\论文查重样例orig_0.8_dis_10.txt","D:\\1.txt"});
    }


    /**
     * 测试对比orig_0.8_dis_15.txt
     */
    @Test
    public void testForDis15(){
        Main.main(new String[]{"C:\\Users\\huawei\\Desktop\\软件工程导论\\论文查重样例\\orig_0.8_dis_1.txt","C:\\Users\\huawei\\Desktop\\软件工程导论\\论文查重样例\\orig_0.8_dis_15.txt","D:\\1.txt"});
    }
}
