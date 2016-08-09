package com.exercises.spring.springproject04.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "progress", schema = "public", catalog = "task_manager")
public class ProgressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_progress")
    private Long idProgress;

    @Column(name = "id_task")
    private Long idTask;

    @Column(name = "added_date")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date addedDate;

    @Column(name = "description")
    private String description;

    @Column(name = "spend_hours")
    private Long spendHours;

    @Column(name = "performed")
    private Long performed;


    public Long getIdProgress() {
        return idProgress;
    }

    public void setIdProgress(Long idProgress) {
        this.idProgress = idProgress;
    }


    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }


    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Long getSpendHours() {
        return spendHours;
    }

    public void setSpendHours(Long spendHours) {
        this.spendHours = spendHours;
    }


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
