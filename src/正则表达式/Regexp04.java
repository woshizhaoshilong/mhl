package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp04 {
    public static void main(String[] args) {
        String content="我...我要.....学学学学....编程java";
        //1.去掉所有的.
        Pattern compile = Pattern.compile("\\.");
        Matcher matcher = compile.matcher(content);
        String s = matcher.replaceAll("");
//        //2.去掉重复的字
//        //思路用.匹配所有的字 再用这个字替换掉匹配到的
//        Pattern compile1 = Pattern.compile("(.)\\1+");
//        Matcher matcher1 = compile1.matcher(s);
//        while (matcher1.find()){
//            System.out.println("找到:"+matcher1.group());
//        }
//        content=matcher1.replaceAll("$1");
//        System.out.println(content);
        String s1= Pattern.compile("(.)\\1+").matcher(s).replaceAll("$1");
        System.out.println(s1);

    }
}
