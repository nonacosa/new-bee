package link.newBee.util;

/**
 * data 2018-07-04   12:43
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class EntryUtil<T> {

    public EntryUtil (T entry){
        this.entry = entry;
    }

    private T entry;




    /**
     * jpa 排序用
     * @return
     */
    public Sort  getSort() {
        Sort sort  = SortTools.basicSort();
        try {
            BeanInfo beanInfo  = Introspector.getBeanInfo(this.entry.getClass());
            PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor property:properties)
            {
                if(property.getName().equals("sort"))
                {
                    Method method = property.getReadMethod();
                    method.setAccessible(true);
                    try {
                        Object obValue = method.invoke(this.entry, null);
                        if(null != obValue){
                            sort = SortTools.basicSort("asc", java.lang.String.valueOf(obValue));

                        }
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }

        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return sort;

    }




    public static <T>EntryUtil<T> instance(T entry){
        return new EntryUtil(entry);
    }



}