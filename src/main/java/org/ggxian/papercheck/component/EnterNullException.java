package org.ggxian.papercheck.component;

/**
 * @author GGXian
 * @project 个人作业
 * @createTime 2020/9/25 21:20
 * @description 自定义异常
 **/
public class EnterNullException extends Exception {
    public EnterNullException(){

    }

    public EnterNullException(String message){
        super(message);
    }
}
