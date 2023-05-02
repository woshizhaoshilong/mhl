package mhl.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        System.out.println("请输入一个整数");
        int i =Utility.readNumber();
        System.out.println(i);
        Connection connection = JDBCutilsByDruid.getConnection();
        System.out.println(connection);
    }
}
