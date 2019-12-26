package me.yukuixing.springwebdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * DataSourceConfig
 *
 * @author: yukuixing
 * @since : 2019-12-24 22:59
 */
@Slf4j
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "me.yukuixing.springwebdemo.dao.master", sqlSessionFactoryRef = "masterSqlSessionFactory")
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties("druid.master")
    public DataSource masterDataSource() {
        DataSource masterDataSource = DataSourceBuilder.create().type(DruidDataSource.class).build();
        log.info("========MASTER: {}=========", masterDataSource);
        return masterDataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(@Qualifier("masterDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource,
        @Value("${mybatis.internal.mapperLocations}") String mapperLocations) throws Exception {
        return createSqlSessionFactory(dataSource, mapperLocations);
    }

    private static SqlSessionFactory createSqlSessionFactory(DataSource dataSource, String mapperLocations)
        throws Exception {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setVfs(SpringBootVFS.class);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        bean.setConfiguration(configuration);
        return bean.getObject();
    }


    @Configuration
    @MapperScan(basePackages = "me.yukuixing.springwebdemo.dao.slave", sqlSessionFactoryRef = "slaveSqlSessionFactory")
    static class SlaveMapperConfiguration {

        @Bean
        @ConfigurationProperties("druid.slave")
        public DataSource slaveDataSource() {
            DataSource slaveDataSource = DataSourceBuilder.create().type(DruidDataSource.class).build();
            log.info("========SLAVE: {}=========", slaveDataSource);
            return slaveDataSource;
        }

        @Bean
        public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slaveDataSource") DataSource dataSource,
            @Value("${mybatis.internal.mapperLocations}") String mapperLocations) throws Exception {
            return createSqlSessionFactory(dataSource, mapperLocations);
        }
    }
}
