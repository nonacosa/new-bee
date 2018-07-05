package link.newBee.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * data 2018-07-05   13:18
 * E-mail   sis.nonacosa@gmail.com
 * 封装 spring-jpa page
 * @author sis.nonacosa
 */
public class PageableTools {

    /**
     * 获取基础分页对象
     * @param page 获取第几页
     * @param size 每页条数
     * @param sort 排序对象数组
     * @return
     */
    public static Pageable basicPage(Integer page, Integer size, Sort sort) {
        page = (page==null || page<0)?0:page;
        size = (size==null || size<=0)?20:size;
        Pageable pageable = new PageRequest(page, size, sort);
        return pageable;
    }

    /**
     * 获取基础分页对象，每页条数默认20条
     *  - 默认以id降序排序
     * @param page 获取第几页
     * @return
     */
    public static Pageable basicPage(Integer page) {
        return basicPage(page, 0, SortTools.basicSort());
    }

    /**
     * 获取基础分页对象，每页条数默认20条
     * @param page 获取第几页
     * @param sort 排序对象数组
     * @return
     */
    public static Pageable basicPage(Integer page, Sort sort) {
        return basicPage(page, 0, sort);
    }

    /**
     * 获取基础分页对象，排序方式默认降序
     * @param page 获取第几页
     * @param size 每页条数
     * @param orderField 排序字段
     * @return
     */
    public static Pageable basicPage(Integer page, Integer size, String ... orderField) {
        return basicPage(page, size,SortTools.basicSort("desc",orderField));
    }

    /**
     * 获取基础分页对象
     *  - 每页条数默认20条
     *  - 排序方式默认降序
     * @param page 获取第几页
     * @param orderField 排序字段
     * @return
     */
    public static Pageable basicPage(Integer page, String ... orderField) {
        return basicPage(page, 0, SortTools.basicSort("desc", orderField));
    }
}
 