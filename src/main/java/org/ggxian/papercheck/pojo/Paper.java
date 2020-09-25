package org.ggxian.papercheck.pojo;


/**
 * @author GGXian
 * @project 个人作业
 * @createTime 2020/9/22 20:56
 * @description 论文文件模型
 **/
public class Paper {
    /**
     * 文本的总字符数
     */
    private int sum;
    /**
     * 文本的总重复字数
     */
    private int repetition;

    private String sentence;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getRepetition() {
        return repetition;
    }

    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }

    public double getRepetitionRate(){
        if(sum == 0 || repetition == 0){
            return -1;
        }
        return (double) repetition / sum;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
