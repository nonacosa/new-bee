package link.newBee.constant;

/**
 * data 2018-07-13   01:31
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */
public class Constant {

    private Constant(){
        new AssertionError();
    }

    public static final String BASE_URL = "/newbee";

    /********* github     *********/

    public static final String GITHUB_ACCESS_TOKEN_URL = "https://github.com/login/oauth/access_token";
    public static final String GITHUB_USER_API_URL = "https://api.github.com/user";
    public static final String GITHUB_client_ID = "b371e2de74a7b1a56ca4";
    public static final String GITHUB_client_secret = "be2bbf103764e6b5a436f6830bf2a8630784fcf3";


    /********* email     *********/

    public static final String EMAIL_SMTP_KEY = "mail.smtp.host";
    public static final String EMAIL_SMTP_HOST = "smtp.gitrue.com";
    public static final String EMAIL_Account = "admin@gitrue.com";

    /********* activity  *********/

    public static final String AVTIVITI_COMMENT = "comment";
    public static final String AVTIVITI_COMMEND = "commend";

}
