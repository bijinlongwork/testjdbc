package com.bjl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    /*public static void main( String[] args )
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动类！");
            e.printStackTrace();
        }

        String url="jdbc:mysql://localhost:3306/test";
        Connection connection;
        try {
            connection = DriverManager.getConnection(url,"root","root");
            Statement stmt = connection.createStatement();
            System.out.print("成功连接到数据库！");
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
    public static void main( String[] args )
    {
        /*JdbcDemo jdbcDemo = new JdbcDemo();
        String a = "asdfgh";
        String b = "asd";
        boolean s = jdbcDemo.containsAllChars(a,b);
        System.out.println(s);*/


        for (int i = 0 ; i< 4 ; i++) {
            for (int j = 0 ; j<=i  ; j++){//打印空格
                if(j==i){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
            for (int y = 0; y<3; y++) {//打印列
                System.out.print("0");
            }
            for(int x=4;x>i;x--){
                if (x==4){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }


    }
}
