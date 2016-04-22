package xiezhy.basic.entity;

import javafx.beans.DefaultProperty;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

/**
 * version:
 * --------------------
 * date:2016/4/21
 * author:binbin
 */
@MappedSuperclass
public class BasicEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "create_time",nullable = false,columnDefinition = "DATE")
    private Date createTime;

    @Column(name = "is_delete",nullable = false,length = 2)
    @ColumnDefault("N")
    private char isDelete;

    @Column(name = "order_num",nullable = false,length = 10)
    @ColumnDefault("0")
    private Long orderNum;

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public char getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(char isDelete) {
        this.isDelete = isDelete;
    }
}
