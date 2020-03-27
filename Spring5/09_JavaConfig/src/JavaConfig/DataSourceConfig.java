package JavaConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;

//当前项目的连接池的配置类
@Configuration
@PropertySource("classpath:db.properties") // 从哪里去加载配置文件
public class DataSourceConfig {
	// 通过定义字段和value注解过去配置文件信息
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	// @Value("${jdbc.initialSize}")
	// private int initialSize;

	// 通过 bean 注解配置数据库配置，相当于在 XML 文件中配置了一个数据库连接池
	@Bean
	public DataSource dataSource() {
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}

}
