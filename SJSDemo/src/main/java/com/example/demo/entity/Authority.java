package com.example.demo.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AUTHORITY")
public class Authority {

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自动生成
    @Column(name="ID")
    private Long id;

    

    private String name;

    

    private String url;

    

    private int pid;

    

    private String description;

 

    @ManyToMany(fetch = FetchType.LAZY)//懒加载   快速查询 不会查询role表  

    @JoinTable(

            name = "ROlE_Auth",

            joinColumns = {@JoinColumn(name = "auth_ID", referencedColumnName = "ID")},

            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})

    private List<Role> roles;



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



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public int getPid() {
		return pid;
	}



	public void setPid(int pid) {
		this.pid = pid;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public List<Role> getRoles() {
		return roles;
	}



	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
    

}
