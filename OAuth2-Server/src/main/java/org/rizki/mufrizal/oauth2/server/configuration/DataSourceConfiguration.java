package org.rizki.mufrizal.oauth2.server.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 15 February 2019
 * @Time 10:17
 * @Project OAuth2-Server
 * @Package org.rizki.mufrizal.oauth2.server.configuration
 * @File DataSourceConfiguration
 */
@Configuration
public class DataSourceConfiguration {

    @Autowired
    private Environment environment;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
        hikariConfig.setJdbcUrl(environment.getRequiredProperty("spring.datasource.url"));
        hikariConfig.setUsername(environment.getRequiredProperty("spring.datasource.username"));
        hikariConfig.setPassword(environment.getRequiredProperty("spring.datasource.password"));

        hikariConfig.setMaximumPoolSize(Integer.parseInt(environment.getRequiredProperty("spring.datasource.maximumPoolSize")));
        hikariConfig.setMinimumIdle(Integer.parseInt(environment.getRequiredProperty("spring.datasource.minimumIdle")));
        hikariConfig.setConnectionTimeout(Long.parseLong(environment.getRequiredProperty("spring.datasource.connectionTimeout")));
        hikariConfig.setIdleTimeout(Long.parseLong(environment.getRequiredProperty("spring.datasource.idleTimeout")));
        hikariConfig.addDataSourceProperty("poolName", environment.getRequiredProperty("spring.datasource.poolName"));
        hikariConfig.addDataSourceProperty("cachePrepStmts", true);
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", 250);
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        return new HikariDataSource(hikariConfig);
    }

}