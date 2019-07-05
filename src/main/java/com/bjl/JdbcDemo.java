package com.bjl;

import java.sql.*;

public class JdbcDemo {

    String jdbcURL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
    String className = "com.mysql.jdbc.Driver";
    String user = "root";
    String password = "root";

    public Connection getConnection(){ //创捷连接
        Connection connection = null;
        try {
            //加载数据库驱动
            Class.forName(className);
            //获取数据库连接
            connection = DriverManager.getConnection(jdbcURL,user,password);
            System.out.println("连接数据库成功");
        } catch (Exception e) {
            System.out.println("连接数据库失败");
            e.printStackTrace();
        }
        return  connection;
    }

    public void closeConnection(Connection connection){ //关闭连接
        try {
            connection.close();
            System.out.println("关闭数据库连接成功");
        } catch (SQLException e) {
            System.out.println("关闭数据库连接失败！！！");
            e.printStackTrace();
        }
    }

    public void insert(){
        String sql="INSERT INTO `user`(username,`password`,age,sex)VALUES('test2','123456',18,1)";
        Connection connection = getConnection();

        try {
            //获取数据库操作类
            Statement statement = connection.createStatement();
            //执行 SQL 语句并返回结果
            int result = statement.executeUpdate(sql);
            if (result !=0){
                System.out.println("操作成功,受影响" + result + "行");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(){
        String sql="delete from user where userid = 5";
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sql);
            if (result != 0) {
                System.out.println("操作成功,受影响" + result + "行");
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        String sql = "update user set username = 'kgc' where userid = 1";
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sql);
            if (result != 0) {
                System.out.println("操作成功,受影响" + result + "行");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("操作失败");
        } finally {
            closeConnection(connection);
        }
    }

    public void select(){
        String sql = "select * from user where userid = 1";
        Connection connection = getConnection();
        try {
            //传递 SQL 语句
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("UserName = " + resultSet.getString("username"));
                System.out.println("PassWord = " + resultSet.getString("password"));
                System.out.println("UserAge = " + resultSet.getInt("age"));
                String userSex = resultSet.getInt("sex") == 1 ? "男" : "女";
                System.out.println("UserSex = " + userSex);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询操作失败");
        }finally {
            closeConnection(connection);
        }
    }


    public static boolean containsAllChars(String a, String b) {
        //a,b 若为空，则没有比较的意义了。
        if(a==null) {
            return false;
        }
        if(b==null) {
            return false;
        }
        char[] bChars = b.toCharArray();
         //提供包含标示，默认为包含
        boolean flag=true;
        for(char c:bChars) {
            //+号仅仅是将c转换成字符串。也可以用c.toString();替代。
            if(!a.contains(c+"")) {
                //只要有一个字符不包含在a串中，则置结果为false并退出循环。
                flag=false;
                break;
            }
        }
        return flag;
    }

}
