package unit;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class getDataSourceUtil {
    public static DataSource getDataSource(){
        try {
            InputStream is = getDataSourceUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            return dataSource;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
