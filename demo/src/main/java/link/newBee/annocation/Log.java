package link.newBee.annocation;


import java.lang.annotation.*;
/**
 * data 2018-07-01   02:53
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Log {
    /**
     * 1.日志内容
     */
    String value();
}