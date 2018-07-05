package link.newBee.util;

import org.springframework.data.domain.Sort;

/**
 * data 2018-07-05   12:51
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */
public class SortTools {

    public static Sort basicSort() {
        return basicSort("desc", "createTime");
    }

    public static Sort basicSort(String orderType, String ... orderField) {
        Sort sort = new Sort(Sort.Direction.fromString(orderType), orderField);
        return sort;
    }





}
