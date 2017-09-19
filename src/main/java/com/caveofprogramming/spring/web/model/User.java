package com.caveofprogramming.spring.web.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.caveofprogramming.spring.web.validator.ValidEmail;

import java.util.Set;

@Entity
@Table(name = "user")
public class User {
	
    private Long id;
	
	@NotBlank
	@Size(min=8, max=15)
	@Pattern(regexp="^\\w{8,}$")
    private String username;
	
	@NotBlank
	//@Size(min=8, max=32)
	//@Pattern(regexp="^\\S+$")	
    private String password;
    
    private String passwordConfirm;
    
    
    @ValidEmail
	private String email;
    
    private Set<Role> roles;
    
    private boolean enabled = false;
    
    //private String authority;
	
    

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	/*public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}*/

}
