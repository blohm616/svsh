package xiezhy.basic.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * version:
 * --------------------
 * date:2016/4/28
 * author:binbin
 */
public class Pager<T> implements Serializable{

    private Pagination pagination;

    private List<T> datas;

    Pager() {}

    Pager(Pagination pagination , List<T> datas) {
        this.pagination = pagination;
        this.datas = datas != null ? datas : new ArrayList<T>();
    }

    public Pagination getPagination() {

        return this.pagination == null ? new Pagination() : this.pagination;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
