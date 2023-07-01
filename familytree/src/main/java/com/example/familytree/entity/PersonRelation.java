package com.example.familytree.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName person_relation
 */
@TableName(value ="person_relation")
@Data
public class PersonRelation implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer personId1;

    /**
     * 
     */
    private Integer personId2;

    /**
     * 
     */
    private Integer personTypeId;

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
        PersonRelation other = (PersonRelation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPersonId1() == null ? other.getPersonId1() == null : this.getPersonId1().equals(other.getPersonId1()))
            && (this.getPersonId2() == null ? other.getPersonId2() == null : this.getPersonId2().equals(other.getPersonId2()))
            && (this.getPersonTypeId() == null ? other.getPersonTypeId() == null : this.getPersonTypeId().equals(other.getPersonTypeId()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPersonId1() == null) ? 0 : getPersonId1().hashCode());
        result = prime * result + ((getPersonId2() == null) ? 0 : getPersonId2().hashCode());
        result = prime * result + ((getPersonTypeId() == null) ? 0 : getPersonTypeId().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", personId1=").append(personId1);
        sb.append(", personId2=").append(personId2);
        sb.append(", personTypeId=").append(personTypeId);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}