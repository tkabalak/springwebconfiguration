package com.exercises.spring.springproject04.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "login", schema = "public", catalog = "task_manager")
public class LoginEntity {
    private Long idLogin;
    private String username;
    private String password;
    private String salt;
    private Timestamp added;
    private Timestamp lastUpdated;
    private Long activeUser;
    private Long deleted;
    private Long appRole;
    private Long employeeId;

    @Id
    @Column(name = "id_login")
    public Long getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Long idLogin) {
        this.idLogin = idLogin;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "added")
    public Timestamp getAdded() {
        return added;
    }

    public void setAdded(Timestamp added) {
        this.added = added;
    }

    @Basic
    @Column(name = "last_updated")
    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Basic
    @Column(name = "active_user")
    public Long getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(Long activeUser) {
        this.activeUser = activeUser;
    }

    @Basic
    @Column(name = "deleted")
    public Long getDeleted() {
        return deleted;
    }

    public void setDeleted(Long deleted) {
        this.deleted = deleted;
    }

    @Basic
    @Column(name = "app_role")
    public Long getAppRole() {
        return appRole;
    }

    public void setAppRole(Long appRole) {
        this.appRole = appRole;
    }

    @Basic
    @Column(name = "employee_id")
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginEntity that = (LoginEntity) o;

        if (idLogin != null ? !idLogin.equals(that.idLogin) : that.idLogin != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (salt != null ? !salt.equals(that.salt) : that.salt != null) return false;
        if (added != null ? !added.equals(that.added) : that.added != null) return false;
        if (lastUpdated != null ? !lastUpdated.equals(that.lastUpdated) : that.lastUpdated != null) return false;
        if (activeUser != null ? !activeUser.equals(that.activeUser) : that.activeUser != null) return false;
        if (deleted != null ? !deleted.equals(that.deleted) : that.deleted != null) return false;
        if (appRole != null ? !appRole.equals(that.appRole) : that.appRole != null) return false;
        if (employeeId != null ? !employeeId.equals(that.employeeId) : that.employeeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLogin != null ? idLogin.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (added != null ? added.hashCode() : 0);
        result = 31 * result + (lastUpdated != null ? lastUpdated.hashCode() : 0);
        result = 31 * result + (activeUser != null ? activeUser.hashCode() : 0);
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        result = 31 * result + (appRole != null ? appRole.hashCode() : 0);
        result = 31 * result + (employeeId != null ? employeeId.hashCode() : 0);
        return result;
    }
}
