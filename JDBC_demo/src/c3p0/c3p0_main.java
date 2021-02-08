package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: c3po
 * @USER: jwang
 * @DATE: 2021/2/5 下午3:25
 */
public class c3p0_main {

    @Test
    public void  method() throws SQLException {

        //配置文件方式使用c3p0连接池，自动读取--配置文件必须在resources目录或者src根目录，名字必须为c3p0-config.xml
        final ComboPooledDataSource dataSource = new ComboPooledDataSource();

        //获取连接
        final Connection connection = dataSource.getConnection();
        connection.close();
    }

}
