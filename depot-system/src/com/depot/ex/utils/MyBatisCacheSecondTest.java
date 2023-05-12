// 
// 
// 

package com.depot.ex.utils;

import org.junit.Test;
import com.depot.ex.admin.entity.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.depot.ex.admin.service.UserService;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-web.xml", "classpath:spring/spring-service.xml", "classpath:spring/spring-dao.xml" })
public class MyBatisCacheSecondTest
{
    private static final Logger logger;
    @Autowired
    private UserService service;
    
    static {
        logger = LoggerFactory.getLogger((Class)MyBatisCacheSecondTest.class);
    }
    
    @Test
    public void testCache2() {
        final User page1 = this.service.findUserByUsername("zhangsan");
        MyBatisCacheSecondTest.logger.info(page1.getName());
        final User page2 = this.service.findUserByUsername("zhangsan");
        MyBatisCacheSecondTest.logger.info(page2.getName());
    }
}
