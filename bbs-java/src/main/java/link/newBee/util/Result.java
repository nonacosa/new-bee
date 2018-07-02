package link.newBee.util;

import lombok.Getter;
import lombok.Setter;

/**
 * data 2018-06-28   23:03
 * E-mail   sis.nonacosa@gmail.com
 * @author sis.nonacosa
 */

@Getter
@Setter
public class Result <T> {



    public enum Code {
        OK(200),
        ERROR(-1),
        ILLEGAL_PARAMETER(100);

        private int code;

        Code(int code) { this.code = code; }

        public int getCode() { return this.code; }
    }

    private T data;
    private String message;
    private int code;

    public Result(T data, String message, Code code ) {

        this.setData(data);
        this.setMessage(message);
        this.setCode(code.getCode());

    }




    public static <T> Result<T> ok(T data) {

            return new Result(data, "ok", Code.OK);

    }

    public static <T> Result<T> error(T data,String errorMsg) {

            return new Result(data, errorMsg, Code.ERROR );

    }

    // 其他的可预见场景，如无权限等等

}