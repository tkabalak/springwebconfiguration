package com.exercises.spring.springproject04.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "task", schema = "public", catalog = "task_manager")
public class TaskEntity {
    private Long idTask;
    private String title;
    private String description;
    private Timestamp addedDate;
    private Timestamp updated;
    private Timestamp deadline;
    private Long active;
    private Short submited;
    private Short status;
    private Long ownerId;
    private Long managerId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_task")
    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "deadline")
    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    @Basic
    @Column(name = "active")
    public Long getActive() {
        return active;
    }

    public void setActive(Long active) {
        this.active = active;
    }

    @Basic
    @Column(name = "submited")
    public Short getSubmited() {
        return submited;
    }

    public void setSubmited(Short submited) {
        this.submited = submited;
    }

    @Basic
    @Column(name = "status")
    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @Basic
    @Column(name = "owner_id")
    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    @Basic
    @Column(name = "manager_id")
    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
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
