package com.exercises.spring.springproject04.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "employee", schema = "public", catalog = "task_manager")
@XmlRootElement
public class EmployeeEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Long idEmployee;

    @Column(name = "added_date")
//    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp addedDate;

    @Column(name = "updated")
//    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updated;

    @Column(name = "position_stat")
    private Integer positionStat;

//    @Column(name = "address_id")
//    private Integer addressId;

    @JoinColumn(name = "address_id", referencedColumnName = "id_address")
    @OneToOne()
    @XmlTransient
    private AddressEntity address;

//    @Basic(optional = false)
    @Column(name = "name")
    private String name;

//    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;

//    @Basic(optional = false)
    @Column(name = "pesel")
    private String pesel;

//    @Basic(optional = false)
    @Column(name = "age")
    private Integer age;

    @Column(name = "phone")
    private Integer phone;

    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
//    @Basic(optional = false)
    @Column(name = "email")
    private String email;

//    @Basic(optional = false)
//    @Column(name = "manager_id")
//    private Integer managerId;

    @JoinColumn(name = "manager_id", referencedColumnName = "id_employee")
    @OneToOne
    @XmlTransient
    private EmployeeEntity manager;

    @Column(name = "active")
    private Integer active;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    @XmlTransient
    private Collection<LoginEntity> loginCollection;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public EmployeeEntity(Long idEmployee, String name, String surname, String pesel, int age, String email) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.age = age;
        this.email = email;
//        this.managerId = managerId;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Timestamp getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Timestamp addedDate) {
        this.addedDate = addedDate;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public Integer getPositionStat() {
        return positionStat;
    }

    public void setPositionStat(Integer positionStat) {
        this.positionStat = positionStat;
    }

//    public Integer getAddressId() {
//        return addressId;
//    }
//
//    public void setAddressId(Integer addressId) {
//        this.addressId = addressId;
//    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeEntity getManager() {
        return manager;
    }

    public void setManager(EmployeeEntity manager) {
        this.manager = manager;
    }

    //    public int getManagerId() {
//        return managerId;
//    }
//
//    public void setManagerId(int managerId) {
//        this.managerId = managerId;
//    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

//    @XmlTransient
    public Collection<LoginEntity> getLoginCollection() {
        return loginCollection;
    }

    public void setLoginCollection(Collection<LoginEntity> loginCollection) {
        this.loginCollection = loginCollection;
    }

    @Transient
    public String getFullName(){
        return name + " " + surname;
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
//        if (addressId != null ? !addressId.equals(that.addressId) : that.addressId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (pesel != null ? !pesel.equals(that.pesel) : that.pesel != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
//        if (managerId != null ? !managerId.equals(that.managerId) : that.managerId != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmployee != null ? idEmployee.hashCode() : 0;
        result = 31 * result + (addedDate != null ? addedDate.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        result = 31 * result + (positionStat != null ? positionStat.hashCode() : 0);
//        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (pesel != null ? pesel.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
//        result = 31 * result + (managerId != null ? managerId.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        return result;
    }
}
