package com.exercises.spring.springproject04.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "progress", schema = "public", catalog = "task_manager")
public class ProgressEntity {
    private Long idProgress;
    private Long idTask;
    private Timestamp addedDate;
    private String description;
    private Long spendHours;
    private Long performed;

    @Id
    @Column(name = "id_progress")
    public Long getIdProgress() {
        return idProgress;
    }

    public void setIdProgress(Long idProgress) {
        this.idProgress = idProgress;
    }

    @Basic
    @Column(name = "id_task")
    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "spend_hours")
    public Long getSpendHours() {
        return spendHours;
    }

    public void setSpendHours(Long spendHours) {
        this.spendHours = spendHours;
    }

    @Basic
    @Column(name = "performed")
    public Long getPerformed() {
        return performed;
    }

    public void setPerformed(Long performed) {
        this.performed = performed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProgressEntity that = (ProgressEntity) o;

        if (idProgress != null ? !idProgress.equals(that.idProgress) : that.idProgress != null) return false;
        if (idTask != null ? !idTask.equals(that.idTask) : that.idTask != null) return false;
        if (addedDate != null ? !addedDate.equals(that.addedDate) : that.addedDate != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (spendHours != null ? !spendHours.equals(that.spendHours) : that.spendHours != null) return false;
        if (performed != null ? !performed.equals(that.performed) : that.performed != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProgress != null ? idProgress.hashCode() : 0;
        result = 31 * result + (idTask != null ? idTask.hashCode() : 0);
        result = 31 * result + (addedDate != null ? addedDate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (spendHours != null ? spendHours.hashCode() : 0);
        result = 31 * result + (performed != null ? performed.hashCode() : 0);
        return result;
    }
}
