package com.ydh.redsheep.database.entity.bo;

import com.ydh.redsheep.database.common.bo.page.OrderItem;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
*
* @author : yangdehong
* @date : 2024/8/25 17:27
*/
public interface IPageable<T> extends Serializable {


    /**
     * 获取排序信息，排序的字段和正反序
     *
     * @return 排序信息
     */
    List<OrderItem> orders();

    /**
     * 自动优化 COUNT SQL【 默认：true 】
     *
     * @return true 是 / false 否
     */
    default boolean optimizeCountSql() {
        return true;
    }

    /**
     * 进行 count 查询 【 默认: true 】
     *
     * @return true 是 / false 否
     */
    default boolean isSearchCount() {
        return true;
    }

    /**
     * 计算当前分页偏移量
     */
    default long offset() {
        long current = getCurrent();
        if (current <= 1L) {
            return 0L;
        }
        return (current - 1) * getSize();
    }

    /**
     * 最大每页分页数限制,优先级高于分页插件内的 maxLimit
     *
     * @since 3.4.0 @2020-07-17
     */
    default Long maxLimit() {
        return null;
    }

    /**
     * 当前分页总页数
     */
    default long getPages() {
        if (getSize() == 0) {
            return 0L;
        }
        long pages = getTotal() / getSize();
        if (getTotal() % getSize() != 0) {
            pages++;
        }
        return pages;
    }

    /**
     * 设置是否命中count缓存
     *
     * @param hit 是否命中
     * @since 3.3.1
     * @deprecated 3.4.0 @2020-06-30 缓存遵循mybatis的一或二缓
     */
    @Deprecated
    default void hitCount(boolean hit) {

    }

    /**
     * 是否命中count缓存
     *
     * @return 是否命中count缓存
     * @since 3.3.1
     * @deprecated 3.4.0 @2020-06-30 缓存遵循mybatis的一或二缓
     */
    @Deprecated
    default boolean isHitCount() {
        return false;
    }

    /**
     * 分页记录列表
     *
     * @return 分页对象记录列表
     */
    List<T> getDatas();

    /**
     * 设置分页记录列表
     */
    IPageable<T> setDatas(List<T> datas);

    /**
     * 当前满足条件总行数
     *
     * @return 总条数
     */
    long getTotal();

    /**
     * 设置当前满足条件总行数
     */
    IPageable<T> setTotal(long total);

    /**
     * 获取每页显示条数
     *
     * @return 每页显示条数
     */
    long getSize();

    /**
     * 设置每页显示条数
     */
    IPageable<T> setSize(long size);

    /**
     * 当前页
     *
     * @return 当前页
     */
    long getCurrent();

    /**
     * 设置当前页
     */
    IPageable<T> setCurrent(long current);

    /**
     * IPage 的泛型转换
     *
     * @param mapper 转换函数
     * @param <R>    转换后的泛型
     * @return 转换泛型后的 IPage
     */
    @SuppressWarnings("unchecked")
    default <R> IPageable<R> convert(Function<? super T, ? extends R> mapper) {
        List<R> collect = this.getDatas().stream().map(mapper).collect(toList());
        return ((IPageable<R>) this).setDatas(collect);
    }

    /**
     * 老分页插件不支持
     * <p>
     * MappedStatement 的 id
     *
     * @return id
     * @since 3.4.0 @2020-06-19
     */
    default String countId() {
        return null;
    }

}
