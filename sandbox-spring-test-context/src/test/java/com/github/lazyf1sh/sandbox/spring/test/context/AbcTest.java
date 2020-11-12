package com.github.lazyf1sh.sandbox.spring.test.context;

import com.github.lazyf1sh.sandbox.spring.test.context.entities.MyTestTableEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ContextConfiguration(locations = "classpath:spring-hibernate-test-context.xml")
@TestPropertySource("classpath:spring-hibernate-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class AbcTest
{

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Sql(value = "classpath:sql/AbcTest.run.sql")
    public void run()
    {
        MyTestTableEntity myTestTableEntity = entityManager.find(MyTestTableEntity.class, 987);
        Assert.assertEquals(987, myTestTableEntity.getId());
    }
}