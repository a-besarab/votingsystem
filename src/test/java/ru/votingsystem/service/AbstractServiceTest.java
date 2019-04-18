package ru.votingsystem.service;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import static org.slf4j.LoggerFactory.getLogger;

@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public abstract class AbstractServiceTest {
    protected static final Logger log = getLogger("result");
}