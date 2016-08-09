package com.exercises.spring.springproject04.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "task", schema = "public", catalog = "task_manager")
public class TaskEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task")
    private Long idTask;
    private String title;
    private String description;
    @Column(name = "added_date",insertable = false)
    private Timestamp addedDate;
    private Timestamp updated;

    @Temporal(TemporalType.TIMESTAMP)
    private Date  deadline;

    @Column(name = "active",insertable = false)
    private Long active ;
    @Column(name = "submited",insertable = false)
    private Short submited;
    @Column(name = "status",insertable = false)
    private Short status;
    @Column(name = "owner_id")
    private Long ownerId;

    @JoinColumn(name = "manager_id", referencedColumnName = "id_employee")
    @ManyToOne
    private EmployeeEntity managerId;


    @JoinColumn(name = "id_task", referencedColumnName = "id_task")
    @OneToMany(fetch = FetchType.EAGER)
    private List<ProgressEntity> progress;

    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Long getActive() {
        return active;
    }

    public void setActive(Long active) {
        this.active = active;
    }

    public Short getSubmited() {
        return submited;
    }

    public void setSubmited(Short submited) {
        this.submited = submited;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public EmployeeEntity getManagerId() {
        return managerId;
    }

    public List<ProgressEntity> getProgress() {
        return progress;
    }

    public void setProgress(List<ProgressEntity> progress) {
        this.progress = progress;
    }

    public void setManagerId(EmployeeEntity managerId) {
        this.managerId = managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskEntity that = (TaskEntity) o;

        if (idTask != null ? !idTask.equals(that.idTask) : that.idTask != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (addedDate != null ? !addedDate.equals(that.addedDate) : that.addedDate != null) return false;
        if (updated != null ? !updated.equals(that.updated) : that.updated != null) return false;
        if (deadline != null ? !deadline.equals(that.deadline) : that.deadline != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (submited != null ? !submited.equals(that.submited) : that.submited != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (ownerId != null ? !ownerId.equals(that.ownerId) : that.ownerId != null) return false;
        if (managerId != null ? !managerId.equals(that.managerId) : that.managerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTask != null ? idTask.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (addedDate != null ? addedDate.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (submited != null ? submited.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        result = 31 * result + (managerId != null ? managerId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "idTask=" + idTask +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", addedDate=" + addedDate +
                ", updated=" + updated +
                ", deadline=" + deadline +
                ", active=" + active +
                ", submited=" + submited +
                ", status=" + status +
                ", ownerId=" + ownerId +
                ", managerId=" + managerId +
                '}';
    }
}
