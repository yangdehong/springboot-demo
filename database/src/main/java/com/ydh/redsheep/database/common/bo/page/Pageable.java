package com.ydh.redsheep.database.common.bo.page;

import java.util.Collections;
import java.util.List;

public class Pageable<T> implements IPageable<T> {

    private static final long serialVersionUID = -1;

    /**
     * 查询数据列表
     */
    protected List<T> datas = Collections.emptyList();
    /**
     * 总数
     */
    protected long total = 0;
    /**
     * 每页显示条数，默认 10
     */
    protected long size = 10;
    /**
     * 当前页
     */
    protected long current = 1;

    public Pageable() {
    }

    /**
     * 分页构造函数
     *
     * @param current 当前页
     * @param size    每页显示条数
     */
    public Pageable(long current, long size) {
        this(current, size, 0);
    }

    public Pageable(long current, long size, long total) {
        if (current > 1) {
            this.current = current;
        }
        this.size = size;
        this.total = total;
    }

    /**
     * 是否存在上一页
     *
     * @return true / false
     */
    public boolean hasPrevious() {
        return this.current > 1;
    }

    /**
     * 是否存在下一页
     *
     * @return true / false
     */
    public boolean hasNext() {
        return this.current < this.getPages();
    }

    public List<T> getDatas() {
        return this.datas;
    }

    public Pageable<T> setDatas(List<T> datas) {
        this.datas = datas;
        return this;
    }

    @Override
    public long getTotal() {
        return this.total;
    }

    @Override
    public Pageable<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public Pageable<T> setSize(long size) {
        this.size = size;
        return this;
    }

    @Override
    public long getCurrent() {
        return this.current;
    }

    @Override
    public Pageable<T> setCurrent(long current) {
        this.current = current;
        return this;
    }

}
