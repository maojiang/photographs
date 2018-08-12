package org.dmj.sch.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Created by 56821 on 2018/8/12.
 */
@Configuration
public class ApplicationMybatisConfig {
    @Bean(name="sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] mapperXmlResource = resolver.getResources("classpath:mapper/*/*Mapper.xml");

        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(mapperXmlResource);
        sqlSessionFactory.setTypeAliasesPackage("org.dmj.sch.mapper.pojo");
        return sqlSessionFactory;
    }
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("org.dmj.sch.mapper");
        msc.setSqlSessionFactoryBeanName("sqlSessionFactory");

        return msc;

    }


}
