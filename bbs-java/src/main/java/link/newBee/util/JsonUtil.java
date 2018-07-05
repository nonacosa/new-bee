package link.newBee.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Message;
import com.google.protobuf.Struct;
import com.google.protobuf.util.JsonFormat;
import link.newBee.Entity.User;
import sun.misc.BASE64Decoder;

/**
 * data 2018-07-05   19:11
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */
public class JsonUtil<T> {

    public static String protobufToJson(String pb) throws Exception {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] pbByte=base64Decoder.decodeBuffer(pb);
        Message.Builder paramMessageBuilder = Struct.newBuilder();
        Message paramMessage = paramMessageBuilder.mergeFrom(pbByte).build();
        return JsonFormat.printer().print(paramMessage);
    }



    public static <T> T stringToObject(String str, Class<T> clazz)
            throws Exception {
        // 特殊字符串过滤
        ObjectMapper oMapper = new ObjectMapper();
        return oMapper.readValue(str, clazz);
    }

    public static <T> T tokenToObject(String str, Class<T> clazz)
            throws Exception {

        String json = JsonUtil.protobufToJson(str);

        return   JsonUtil.stringToObject(json,clazz);
    }




}
