package link.newBee.util;

import com.alibaba.fastjson.JSON;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.InputStream;
import java.util.UUID;

/**
 * data 2018-07-06   23:43
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */
@Component
public class QiniuUtil{

    private static final Logger logger = LoggerFactory.getLogger(QiniuUtil.class);

    public static final   String accessKey = "0CRo6nzfMaaNe8-2Df2rQqGXp-iALHfRC93b9qr0" ;

    public static final   String secretKey = "g-K0cjxogLZckJLuAcvkVg_3GXXwPpW_5Og-BHHf";

    @Value("$op0c7euw0.bkt.clouddn.com")
    public static final  String bucket = "github";

//    @Value("${qiniu.path}")
//    private String path;

    /**
     * 将图片上传到七牛云
     * @param file
     * @param key 保存在空间中的名字，如果为空会使用文件的hash值为文件名
     * @return
     */
    public static String uploadImg(InputStream file) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);

        try {
            String name = UUID.randomUUID().toString();
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket,name);
            try {
                Response response = uploadManager.put(file, name, upToken, null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
                String return_path = putRet.key;
                logger.info("保存地址={}",return_path);
                return return_path;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}