package druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/5 下午4:26
 */
public class DruidUtil {
    private static DataSource dataSource;

    static {
        try {
            //properties对象
            final Properties properties = new Properties();
            //获取流
            final InputStream resourceAsStream = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            //加载到properties对象
            properties.load(resourceAsStream);
            //工厂创建dataSource
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
}
