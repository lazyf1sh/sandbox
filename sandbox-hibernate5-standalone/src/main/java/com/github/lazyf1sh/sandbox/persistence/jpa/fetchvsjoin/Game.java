package com.github.lazyf1sh.sandbox.persistence.jpa.fetchvsjoin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Ivan Kopylov
 */
@Entity(name = "GAME")
public class Game
{
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "TITLE")
    private String title;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}
