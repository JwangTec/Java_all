package druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/5 下午4:06
 */
public class druid_main {

    @Test
    public void test() throws Exception {
        //加载配置文件--工厂设计模式加载

        //properties对象用流加载配置文件
        final Properties properties = new Properties();
        final InputStream resourceAsStream = druid_main.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        final DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

    }
}
