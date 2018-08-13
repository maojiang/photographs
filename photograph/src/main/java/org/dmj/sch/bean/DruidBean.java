package org.dmj.sch.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 56821 on 2018/8/13.
 */
@Component
@ConfigurationProperties("db.datasource")
@Data
public class DruidBean {
    private String driver;
    private String url;
    private String username;
    private String password;
    private Integer initialSize;
    private Integer minIdle;
    private Integer maxActive;
    private Integer maxWait;
    private Integer timeBetweenEvictionRunsMillis;
    private Integer minEvictableIdleTimeMillis;
    private boolean useGlobalDataSourceStat;
    private String connectionProperties;
    private String filters;
    private Integer maxPoolPreparedStatementPerConnectionSize;
    private boolean poolPreparedStatements;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
}
