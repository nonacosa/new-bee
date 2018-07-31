package link.newBee.util;

import io.github.biezhi.ome.OhMyEmail;
import link.newBee.constant.Constant;
import javax.mail.MessagingException;
import java.util.Properties;
import static io.github.biezhi.ome.OhMyEmail.defaultConfig;

/**
 * data 2018-07-31   19:30
 * E-mail   sis.nonacosa@gmail.com
 * 邮件服务
 * @author sis.nonacosa
 */
public class EmailUtil {

    public static Properties SMTP_GITRUE(Boolean debug) {
        Properties props = defaultConfig(debug);
        props.put(Constant.EMAIL_SMTP_KEY, Constant.EMAIL_SMTP_HOST);
        return props;
    }

    static {
        OhMyEmail.config(SMTP_GITRUE(true), Constant.EMAIL_Account, "******");
    }

    public static void sendEmail(String discription,String html) throws MessagingException {
        OhMyEmail.subject(discription)
                .from("new-bee的邮箱")
                .to("pkwenda@163.com")
//                .text(content)
                .html(html)
                .send();
    }

    public static void main(String[] args) {
        try {
            sendEmail("这是一封测试TEXT邮件","欢迎来到new-bee社区！");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
