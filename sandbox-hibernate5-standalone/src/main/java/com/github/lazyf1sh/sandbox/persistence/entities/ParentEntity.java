package com.github.lazyf1sh.sandbox.persistence.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PARENTTABLE")
public class ParentEntity
{
	@Id
	@Column(name = "PARENTTABLE_KEY", unique = true, nullable = false)
	private int id;

	@Column(name = "PARENTTABLE_NAME")
	private String name;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "parent")
	private Set<ChildEntity> childs;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Set<ChildEntity> getChilds()
	{
		return childs;
	}

	public void setChilds(final Set<ChildEntity> childs)
	{
		this.childs = new HashSet(childs);
	}
}
