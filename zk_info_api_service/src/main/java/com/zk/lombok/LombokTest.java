package com.zk.lombok;

/**
 * @Author Zhangk
 * @Date 15:11 2018/11/7
 * @Description
 */
public class LombokTest {
    public static void main(String []args) {
        Pojo build = new Pojo();
        build.setName("2");
        /*p.setAge(1);
        p.setName("1");*/
        //链式创建对象属性值
        //p.setName("1").setAge(1);

        //build模式
        //Pojo build = Pojo.builder().age(1).name("1").build();
        System.out.println(build.toString());

        /*String s = "{'age':1,'name':'1'}";
        Pojo pojo = GfJsonUtil.parseObject(s, Pojo.class);
        System.out.println(pojo);*/
    }
}
