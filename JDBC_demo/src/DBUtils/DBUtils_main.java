package DBUtils;

import c3p0.c3p0Utils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import druid.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import pojo.User;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/5 下午4:20
 */
public class DBUtils_main {

    @Test
    public void test() throws SQLException {
        //获取连接
//        final DataSource dataSource = DruidUtil.getDataSource();
        final ComboPooledDataSource dataSource = c3p0Utils.getDataSource();
        //sql语句
        /*
        查询数据：结果集处理者接口:ResultSetHandler,使用其实现类
            单个数据：简单类型变量接收--ScalaHandler
            一行数据：POJO对象接收查询数据或者MAP对象接收--BeanHandler/MapHandler
            多行数据：List<POJO>对象接收或者List<MAP>--BeanListHandler/MapListHandler

         */
        String sql = "select count(*) from user";
        String sql2 = "select * from user where id=?";
        String sql3 = "select * from user";
        //创建QueryRunner对象,并传入连接对象
        final QueryRunner queryRunner = new QueryRunner(dataSource);

        //使用对象调用相关方法
        final Long query = (Long) queryRunner.query(sql, new ScalarHandler());
        System.out.println(query);



        //一行数据
        final User user = queryRunner.query(sql2, new BeanHandler<>(User.class), 2);

        System.out.println(user);

        //使用的反射创建User对象，所以传入类字节码
        final List<User> userList = queryRunner.query(sql3, new BeanListHandler<>(User.class));
        for (User user1 : userList) {
            System.out.println(user1);
        }
    }
}
