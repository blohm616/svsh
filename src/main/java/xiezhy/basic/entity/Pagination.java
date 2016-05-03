package xiezhy.basic.entity;

import java.io.Serializable;
import java.util.List;

/**
 * version:
 * --------------------
 * date:2016/4/28
 * author:binbin
 */
public class Pagination implements Serializable{

    public static final Integer DEFAULT_MAX = Integer.valueOf(10);

    private Integer currentIndex = Integer.valueOf(0);  //代表当前从第几条数据开始展示

    private Integer max = DEFAULT_MAX;  //代表每页展示的条数

    private Integer total = Integer.valueOf(0); //代表总数

    private Integer pageNo = Integer.valueOf(1);    //代表页码

    public Pagination() {
    }
    public Pagination(Integer index, Integer total) {
        this.total = total;
        setCurrentIndex(index);
    }

    public Pagination(Integer max) {
        this.max = max;
    }

    public Integer getCurrentIndex() {
        return this.currentIndex;
    }

    public void setCurrentIndex(Integer index) {
        if (index.intValue() <= 0) {
            index = Integer.valueOf(0);
        }

        this.currentIndex = index;
    }

    public boolean hasPreviousPage() {
        return this.currentIndex.intValue() >= this.max.intValue();
    }

    public boolean hasNextPage() {
        return this.currentIndex.intValue() + this.max.intValue() < this.total.intValue();
    }

    public Integer getPreviousIndex() {
        if (hasPreviousPage()) {
            return Integer.valueOf(this.currentIndex.intValue() - this.max.intValue());
        }

        return this.currentIndex;
    }

    public Integer getNextIndex() {
        if (hasNextPage()) {
            return Integer.valueOf(this.currentIndex.intValue() + this.max.intValue());
        }

        return this.currentIndex;
    }

    public Integer getPageTotal() {
        return Integer.valueOf((this.total.intValue() + this.max.intValue() - 1) / this.max.intValue());
    }

    public Integer getMax() {
        return this.max;
    }

    public void setPageSize(Integer max) {
        if ((max != null) && (max.intValue() <= 0)) {
            max = DEFAULT_MAX;
        }

        this.max = max;
    }

    public void calcCurrentIndex(Integer max) {
        setPageSize(max);
        this.currentIndex = Integer.valueOf((this.pageNo.intValue() - 1) * max.intValue());
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getIndex(Integer pageIndex) {
        if (pageIndex.intValue() < 0)
            pageIndex = Integer.valueOf(0);
        else if (pageIndex.intValue() > getPageTotal().intValue()) {
            pageIndex = Integer.valueOf(getPageTotal().intValue() - 1);
        }

        return Integer.valueOf(pageIndex.intValue() * getMax().intValue());
    }

    public Integer getPageNo()
    {
        return Integer.valueOf(getCurrentIndex().intValue() / getMax().intValue() + 1);
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

}
