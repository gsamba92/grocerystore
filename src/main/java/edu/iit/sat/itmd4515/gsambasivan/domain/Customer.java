/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.gsambasivan.domain;

import edu.iit.sat.itmd4515.gsambasivan.domain.security.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Swathi
 */
@Entity
@Table(name = "Customer")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "select p from Customer p")
    ,
    @NamedQuery(name = "Customer.findByEmail", query = "select p from Customer p where p.email = :email"),
    @NamedQuery(name = "Customer.findByUsername", query = "select p from Customer p where p.user.userName = :username")
})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
     @NotNull(message = "First Name can not be null")
    private String firstName;
      @NotNull(message = "Middle Name can not be null")
    private String middleName;
       @NotNull(message = "Last Name can not be null")
    private String lastName;
        @NotNull(message = "User Name can not be null")
//    private String userName;
//    private String password;
            @Column(unique = true)
    private String email;
    private String gender;
    private String contactNo;
    @Temporal(TemporalType.DATE)    
    private Date dob;
    private boolean isAdmin;
    @OneToMany
    private List<Order> order = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
    
    public void addOrder(Order order) {
        this.order.add(order);
    }
    
    public Customer() {
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String usereName) {
//        this.userName = usereName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Customer(String firstName, String middleName, String lastName, String email, String gender, String contactNo, Date dob, boolean isAdmin) {

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
//        this.userName = userName;
//        this.password = password;
        this.email = email;
        this.gender = gender;
        this.contactNo = contactNo;
        this.dob = dob;
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Person{" + "personId=" + personId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + ", contactNo=" + contactNo + ", dob=" + dob + ", isAdmin=" + isAdmin + '}';
    }

}
