package com.mashibing.annotation;

import java.lang.annotation.*;
@SuppressWarnings(value = "all")
@MyAnnotation
public class MetaAnnotation {


    public void test(){

    }
}
//target用来声明当前自定义的注解适合适用于什么地方，类，方法，变量，包....
@Target({ElementType.TYPE,ElementType.METHOD})
//注解在什么时候生效，Runtime，SOURCE，class，一般都是运行时环境
@Retention(RetentionPolicy.RUNTIME)
//表示注解是否是显示在javadoc中
@Documented
//表示当前注解是否能够被继承
@Inherited
@interface MyAnnotation{

    //定义的方式看起来是方法，范式实际上使用在使用注解的时候填写的参数的名称，默认的名称是value
    //自定义注解中填写的所有方法需要在使用注解的时候，添加值，很麻烦，因此包含默认值
    String name() default "zhangdan";
    int age() default 12;
    int id() default 1001;
    String[] likes() default {"a","b","c"};
}
