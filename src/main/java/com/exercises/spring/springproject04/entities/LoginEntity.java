package com.exercises.spring.springproject04.entities;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "login", schema = "public", catalog = "task_manager")
public class LoginEntity implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_login")
    private Integer idLogin;

    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;

    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;

//    @Size(max = 200)
    @Column(name = "salt")
    private String salt;

    @Column(name = "added")
//    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp added;

    @Column(name = "last_updated")
//    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp lastUpdated;

    @Column(name = "active_user")
    private Integer activeUser;

    @Column(name = "deleted")
    private Integer deleted;

    @Column(name = "app_role")
    @Type(type = "com.exercises.spring.springproject04.dto.AppRoleArrayType")
    private Integer[] appRole;
//    @ElementCollection(fetch = FetchType.LAZY)
//    private Set<Integer> appRole;

    @JoinColumn(name = "employee_id", referencedColumnName = "id_employee")
    @ManyToOne(optional = false)
    private EmployeeEntity employeeId;

    public LoginEntity() {
    }

    public LoginEntity(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public LoginEntity(Integer idLogin, String username, String password) {
        this.idLogin = idLogin;
        this.username = username;
        this.password = password;
    }

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Timestamp getAdded() {
        return added;
    }

    public void setAdded(Timestamp added) {
        this.added = added;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Integer getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(Integer activeUser) {
        this.activeUser = activeUser;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

//    public Set<Integer> getAppRole() {
//        return appRole;
//    }

//    public void setAppRole(Set<Integer> appRole) {
//        this.appRole = appRole;
//    }


    public Integer[] getAppRole() {
        return appRole;
    }

    public void setAppRole(Integer[] appRole) {
        this.appRole = appRole;
    }

    public EmployeeEntity getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(EmployeeEntity employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogin != null ? idLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginEntity)) {
            return false;
        }
        LoginEntity other = (LoginEntity) object;
        if ((this.idLogin == null && other.idLogin != null) || (this.idLogin != null && !this.idLogin.equals(other.idLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LoginEntity{" +
                "employeeId=" + employeeId +
                ", idLogin=" + idLogin +
                ", username='" + username + '\'' +
                ", salt='" + salt + '\'' +
                ", added=" + added +
                ", lastUpdated=" + lastUpdated +
                ", activeUser=" + activeUser +
                ", deleted=" + deleted +
                ", appRole=" + appRole +
                '}';
    }
}
