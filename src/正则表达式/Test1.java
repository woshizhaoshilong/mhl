package 正则表达式;

import java.util.regex.Pattern;

/**
 * 验证电子邮件格式是否合法
 * */

public class Test1 {
    public static void main(String[] args) {
         String content="hsp@shu.com";
         String regstr="[\\w_-]+@([a-zA-Z]+\\.)+[a-zA-Z]+";
         //matches方法为整体匹配 格式必须完全一样
         if (content.matches(regstr)){
             System.out.println("匹配成功");
         }else {
             System.out.println("匹配失败");
         }
    }
}
