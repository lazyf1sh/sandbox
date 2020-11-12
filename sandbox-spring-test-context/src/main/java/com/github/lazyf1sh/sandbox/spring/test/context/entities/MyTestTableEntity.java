package com.github.lazyf1sh.sandbox.spring.test.context.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Ivan Kopylov
 */
@Entity(name = "MY_TEST_TABLE")
public class MyTestTableEntity
{
    @Id
    private int id;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
