package util;


import pojo.File;

/**
 * @author GGXian
 * @project 个人作业
 * @createTime 2020/9/22 20:58
 * @description 计算工具栏
 **/
public final class Calculator {

    /**
     * 执行操作
     * @param originText 原文
     * @param modifiedText 抄袭版论文
     */
    public static void perform(File originText, File modifiedText){
        int repetitions = calculate(originText.getSentence(), modifiedText.getSentence());
        int sum = modifiedText.getSentence().length();
        modifiedText.setRepetition(repetitions);
        modifiedText.setSum(sum);
    }

    /**
     * 计算重复字数
     * @param x 原文文本
     * @param y 抄袭版论文文本
     * @return 重复字数
     */
    private static int calculate(String x, String y){
        x = " " + x;
        y = " " + y;
        //设置字符串长度,具体大小可自行设置
        int xLength = x.length();
        int yLength = y.length();
        int i = 1;
        int j;
//        // 构造二维数组记录子问题x[i]和y[i]的LCS的长度
////        int[][] opt = new int[xLength + 1][yLength + 1];
////        // 动态规划计算所有子问题
////        for (; i < xLength; i++){
////            for (j = 1; j < yLength; j++){
////                if (x.charAt(i) == y.charAt(j)) {
////                    opt[i][j] = opt[i - 1][j - 1] + 1;
////                }
////                opt[i][j] = Math.max( opt[i][j],Math.max(opt[i - 1][j], opt[i][j - 1]));
////            }
////        }
////        return opt[xLength - 1][yLength - 1];

        int pre;
        int cur;
        int[] opt = new int[yLength];
        for (; i < xLength; i++){
            pre = 0;
            for (j = 1; j < yLength; j++){
                cur = opt[j];
                if (x.charAt(i) == y.charAt(j)) {
                    opt[j] = pre + 1;
                }else{
                    opt[j] = Math.max(opt[j-1], opt[j]);
                }
                pre = cur;
            }
        }
        return opt[yLength - 1];
    }
}
