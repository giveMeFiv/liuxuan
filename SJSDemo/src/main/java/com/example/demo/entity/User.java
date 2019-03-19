package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 

@Entity
@Table(name = "USER")
@JsonIgnoreProperties(value={"roles"})  //实体中存在一对多关系 出现了死循环
public class User implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public Boolean getEnabled() {
		return enabled;
	}



	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}



	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}



	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}



	public List<Role> getRoles() {
		return roles;
	}



	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Column(name = "USERNAME", length = 50, unique = true)
    private String username;

 

    @Column(name = "PASSWORD", length = 100)

    private String password;

 

    @Column(name = "FIRSTNAME", length = 50)

    private String firstname;

 

    @Column(name = "LASTNAME", length = 50)

    private String lastname;

 

    @Column(name = "EMAIL", length = 50)
    private String email;
    
    @Column(name="ENABLED",length =1)
    private Boolean enabled;

 

    public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Column(name = "LASTPASSWORDRESETDATE")

    @Temporal(TemporalType.TIMESTAMP)

    private Date lastPasswordResetDate;

 

    //急加载 会查询role表

    @ManyToMany(fetch = FetchType.EAGER)

    @JoinTable(

            name = "USER_ROlE",

            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},

            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})

    private List<Role> roles;

    @Override

    public Collection<? extends GrantedAuthority> getAuthorities() {

        // TODO Auto-generated method stub

        List<GrantedAuthority> auths = new ArrayList<>();

        List<Role> roles = this.getRoles();

        for (Role role : roles) {

            for(Authority aurh:role.getAuthoritys())

            auths.add(new SimpleGrantedAuthority(aurh.getName()));

        }

        return auths;

    }

 

    @Override

    public boolean isAccountNonExpired() {

        // TODO Auto-generated method stub

        return true;

    }

 

    @Override

    public boolean isAccountNonLocked() {

        // TODO Auto-generated method stub

        return true;

    }

 

    @Override

    public boolean isCredentialsNonExpired() {

        // TODO Auto-generated method stub

        return true;

    }

 

    @Override

    public boolean isEnabled() {

        // TODO Auto-generated method stub

        return true;

    }
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + username + '\'' + '}';
    }

}
