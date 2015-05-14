package com.bookstore.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;









import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Marcus
 * 
 * account is authenticated user of our system. Use can submit orders. User is identified
 * by username.
 *
 */
@Entity
@Table(name="account")
public class Account extends AbstractBaseEntity{

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 3806002449902958746L;
	
	@Pattern(regexp = "^(?=\\s*\\S).*$")
	@Column(nullable = false, length = 255)
	private String firstName;
	
	@Pattern(regexp = "^(?=\\s*\\S).*$")
	@Column(nullable = false, length = 255)
	private String lastName;
	
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Past
	@Column(nullable = false)
	private Date dateOfBirth;
	
    @Email
    @NotEmpty
    @Column(nullable = false, length = 255)
    private String emailAddress;
    
    @Column(nullable = false, length = 255)
    @Pattern(regexp= "^[0-9]+$")
    private String mobPhone;
    
    @Column(unique=true, nullable = false, length = 255)
    @Pattern(regexp = "^(?=\\s*\\S).*$")
    private String username;
   
    @NotNull
	@Min(value = 4 , message="Password must be at least 4 characters.")
	@Column(nullable = false, length = 60)
    //@Pattern(regexp = "^[0-9a-zA-Z. ]+$") //(?=.*[a-z])(?=.*[A-Z]{16,})
    private String password;
    
    /**
     * Address of account
     */
    @Column(nullable = false, length = 255)
    @Pattern(regexp = "^[0-9a-zA-Z. ]+$")
	private String street;
	@Pattern(regexp = "^(?=\\s*\\S).*$")
    private String city;
	@Pattern(regexp = "^[0-9]+$")
    private String postalCode;
    @Pattern(regexp = "^(?=\\s*\\S).*$")
    private String country;
	
    
    /**
     * Role of account
     */
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")  
    private Set<Role> role = new HashSet<>(0);  

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}	

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMobPhone() {
		return mobPhone;
	}

	public void setMobPhone(String mobPhone) {
		this.mobPhone = mobPhone;
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
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	


}
