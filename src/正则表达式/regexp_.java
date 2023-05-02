package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 体验正则表达式
 * */
public class regexp_ {


    public static void main(String[] args) {
        String content="Java平台由Java虚拟机(Java Virtual Machine)和Java" +
                " 应用编程接口(Application Programming Interface、简称API)构成。" +
                "Java 应用编程接口为Java应用提供了一个独立于操作系统的标准接口，可分为基本部分和扩展部分。" +
                "在硬件或操作系统平台上安装一个Java平台之后，Java应用程序就可运行。Java平台已经嵌入了几乎所有的操作系统。" +
                "这样Java程序可以只编译一次，就可以在各种系统中运行。Java应用编程接口已经从1.1x版发展到1.2版。" +
                "常用的Java平台基于Java1.8，最近版本为Java19。";
        //1. 先创建一个对象Pattern,模式对象，可以理解成为这是一个正则表达式对象
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        //2.创建一个匹配器对象
        //理解:就是matcher 匹配器按照pattern模式到content文本中去匹配
        //找到就返回true否则返回false
//        Matcher matcher = pattern.matcher(content);
//        //3.开始循环匹配
//        while (matcher.find()){
//            System.out.println(matcher.group(0));
//        }
        //\\d表示任意的数字
        //正则表达式每个括号代表分组
        Pattern compile = Pattern.compile("\\d\\d");
        Matcher matcher1 = compile.matcher(content);
        while (matcher1.find()){
            System.out.println(matcher1.group());
        }


    }
}
