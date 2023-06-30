package com.example.familytree.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName person_event
 */
@TableName(value ="person_event")
@Data
public class PersonEvent implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer personId;

    /**
     * 
     */
    private Date eventDate;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private String desc;

    /**
     * 
     */
    private String annex;

    /**
     * 
     */
    private String isDel;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PersonEvent other = (PersonEvent) that;
        return (this.getPersonId() == null ? other.getPersonId() == null : this.getPersonId().equals(other.getPersonId()))
            && (this.getEventDate() == null ? other.getEventDate() == null : this.getEventDate().equals(other.getEventDate()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getDesc() == null ? other.getDesc() == null : this.getDesc().equals(other.getDesc()))
            && (this.getAnnex() == null ? other.getAnnex() == null : this.getAnnex().equals(other.getAnnex()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPersonId() == null) ? 0 : getPersonId().hashCode());
        result = prime * result + ((getEventDate() == null) ? 0 : getEventDate().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getDesc() == null) ? 0 : getDesc().hashCode());
        result = prime * result + ((getAnnex() == null) ? 0 : getAnnex().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", personId=").append(personId);
        sb.append(", eventDate=").append(eventDate);
        sb.append(", type=").append(type);
        sb.append(", desc=").append(desc);
        sb.append(", annex=").append(annex);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}