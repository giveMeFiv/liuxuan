package com.example.demo.entity;

import java.util.List;
import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.JoinTable;

import javax.persistence.ManyToMany;

import javax.persistence.Table;

 

import com.fasterxml.jackson.annotation.JsonIgnore;

 

@Entity

@Table(name = "role")

public class Role {

 

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")

    private Long id;

    @Column(length = 25)

    private String name;

     //懒加载 不会查询role表

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)

    private List<User> users;

     //急加载 会查询role表

    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)

    private List<Authority> Authoritys;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Authority> getAuthoritys() {
		return Authoritys;
	}

	public void setAuthoritys(List<Authority> authoritys) {
		Authoritys = authoritys;
	}

 

   //get  set方法略·········

}
