package com.avd.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.avd.service", "com.avd.dao","com.avd.service.room", "com.avd.dao.room",
                                                            "com.avd.service.booking", "com.avd.dao.booking",
                                                              "com.avd.service.guest", "com.avd.dao.guest"
})



public class SpringConfig {
    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate (getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("кщще");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

}