import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/4 下午5:55
 */
public class JDBC_main {

    public void test1() throws Exception {
        //注册需要使用的驱动 --- 耦合度高
        //DriverManager.registerDriver(new Driver());
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接对象，封装工具类该地方是硬编码问题--properties文件
        String url = "jdbc:mysql://localhost:3306/jdbc_test";
        String password = "root";
        String username = "12345678";



        final Connection connection = DriverManager.getConnection(url, username, password);

        //创建执行语句的对象--该对象会出现sql注入--使用preparedStatement对象，传入的数据使用？占位
        final Statement stm = connection.createStatement();

        //sql语句,拼接会出现sql注入
        String sql = "select * from user";

        //使用stm对象的方法执行语句,查询使用executeQuery ,返回DQL查询集，executeUpdate,返回DML的影响条数
        final ResultSet result = stm.executeQuery(sql);

        //遍历 ResultSet接口的方法获取--相当于一个流，一行一行向下--while循环
        //存储用户信息-pojo-javabean对象-将查询的所有结果存入各个对象，将对象放入集合中

        //preparedStatement
        //创建预编译sql语句
        int id = 1;
        String sql1 = "select * from user where id=?";

        //获取执行语句的对象,进行预编译
        final PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        //占位赋值
        preparedStatement.setInt(1,id);
        //执行sql
        final ResultSet resultSet = preparedStatement.executeQuery();
        //取结果

        //关闭

        result.close();
        stm.close();
        connection.close();

        //注册驱动--封装在工具类--properties编写连接参数,使用
        //获取连接--封装在工具类
        //创建statement--出现注入问题--PreparedStatement对象 -- 传入预编译sql语句，再用该对象的set方法占位赋值--executeUpdate
        //执行sql语句
        //关闭资源


        //使用事务



    }

}
