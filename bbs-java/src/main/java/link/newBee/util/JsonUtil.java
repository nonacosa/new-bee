package link.newBee.util;

import com.google.protobuf.Message;
import com.google.protobuf.Struct;
import com.google.protobuf.util.JsonFormat;
import sun.misc.BASE64Decoder;

/**
 * data 2018-07-05   19:11
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */
public class JsonUtil {

    public static String protobufToJson(String pb) throws Exception {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] pbByte=base64Decoder.decodeBuffer(pb);
        Message.Builder paramMessageBuilder = Struct.newBuilder();
        Message paramMessage = paramMessageBuilder.mergeFrom(pbByte).build();
        return JsonFormat.printer().print(paramMessage);
    }
}
