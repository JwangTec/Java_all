package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/5 下午4:57
 */
public class c3p0Utils {

    //创建datasource对象
    private static final ComboPooledDataSource dataSource;

    //创建静态代码块创建对象
    static {
        //创建
        dataSource = new ComboPooledDataSource();
    }

    public static ComboPooledDataSource getDataSource(){
        return dataSource;
    }
}
