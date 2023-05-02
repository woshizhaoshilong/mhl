package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp03 {
    public static void main(String[] args) {
        String a="ABCabc1237777789666";
        Pattern compile = Pattern.compile("(?i)abc");
        //"a(?i)bc"bc不区分大小写  "a((?i)b)c" b不区分下大小写
        Pattern.compile("(?i)abc",Pattern.CASE_INSENSITIVE);//不区分大小写
        String content="hello jack1111 hello33333,tom222,yyy";

        Matcher matcher = compile.matcher(a);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
        //正则要求输入为汉字
        //String regSrt="^[\u0391-\uffe5]+$"
        //邮政编码 要求为1-9开头的六位数
        //String regSrt="^[1-9]\\d{5}$"
        String regstr ="(\\d)\\1{4}";
        Pattern pattern = Pattern.compile(regstr);
        Matcher matcher1 = pattern.matcher(content);
        while (matcher1.find()){
            System.out.println("找到:"+matcher1.group());
        }


    }
}
