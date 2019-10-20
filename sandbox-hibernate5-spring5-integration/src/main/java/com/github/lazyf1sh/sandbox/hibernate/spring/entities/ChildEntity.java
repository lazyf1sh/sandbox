package com.github.lazyf1sh.sandbox.hibernate.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CHILDTABLE")
public class ChildEntity
{
	@Id
	@Column(name = "CHILDTABLE_KEY", unique = true, nullable = false)
	private Integer key;

	@Column(name = "CHILDTABLE_NAME")
	private String name;

	@ManyToOne
	@JoinColumn(name = "CHILDTABLE_PARENT_KEY", unique = false, nullable = false)
	private ParentEntity parent;

	public Integer getKey()
	{
		return key;
	}

	public void setKey(Integer key)
	{
		this.key = key;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public ParentEntity getParent()
	{
		return parent;
	}

	public void setParent(ParentEntity parent)
	{
		this.parent = parent;
	}

}
