package api.model.common;

import api.utility.Tools;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by khengny on 8/8/17.
 */
@MappedSuperclass
public class BaseEntity implements Serializable{
    public int id;
    public int createdBy;
    public int updatedBy;
    public byte status = Tools.DEF_STATUS;
    public Timestamp createdAt = Tools.getCurrentDate();
    public Timestamp updatedAt;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "created_by")
    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "updated_by")
    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Basic
    @Column(name = "status")
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @SuppressWarnings("unused")
    @PrePersist
    private void onInsert() {
//        this.status = Tools.toByte(Tools.checkNull(this.status, 1));
//        this.createdAt = Tools.getCurrentDate();
    }

    @SuppressWarnings("unused")
    @PreUpdate
    private void onUpdate() {
        this.updatedAt = Tools.getCurrentDate();
    }

}
