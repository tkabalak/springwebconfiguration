package com.exercises.spring.springproject04.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "employee", schema = "public", catalog = "task_manager")
public class EmployeeEntity {
    private Long idEmployee;
    private Timestamp addedDate;
    private Timestamp updated;
    private Long positionStat;
    private Long addressId;
    private String name;
    private String surname;
    private String pesel;
    private Long age;
    private Long phone;
    private String email;
    private Long managerId;
    private Long active;

    @Id
    @Column(name = "id_employee")
    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Basic
    @Column(name = "added_date")
    public Timestamp getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Timestamp addedDate) {
        this.addedDate = addedDate;
    }

    @Basic
    @Column(name = "updated")
    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @Basic
    @Column(name = "position_stat")
    public Long getPositionStat() {
        return positionStat;
    }

    public void setPositionStat(Long positionStat) {
        this.positionStat = positionStat;
    }

    @Basic
    @Column(name = "address_id")
    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "pesel")
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Basic
    @Column(name = "age")
    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @Basic
    @Column(name = "phone")
    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "manager_id")
    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "active")
    public Long getActive() {
        return active;
    }

    public void setActive(Long active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (idEmployee != null ? !idEmployee.equals(that.idEmployee) : that.idEmployee != null) return false;
        if (addedDate != null ? !addedDate.equals(that.addedDate) : that.addedDate != null) return false;
        if (updated != null ? !updated.equals(that.updated) : that.updated != null) return false;
        if (positionStat != null ? !positionStat.equals(that.positionStat) : that.positionStat != null) return false;
        if (addressId != null ? !addressId.equals(that.addressId) : that.addressId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (pesel != null ? !pesel.equals(that.pesel) : that.pesel != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (managerId != null ? !managerId.equals(that.managerId) : that.managerId != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmployee != null ? idEmployee.hashCode() : 0;
        result = 31 * result + (addedDate != null ? addedDate.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        result = 31 * result + (positionStat != null ? positionStat.hashCode() : 0);
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (pesel != null ? pesel.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (managerId != null ? managerId.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        return result;
    }
}
