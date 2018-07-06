package link.newBee.Controller;

import link.newBee.Entity.User;
import link.newBee.annocation.Log;
import link.newBee.serviceImpl.UserServiceImpl;
import link.newBee.util.QiniuUtil;
import link.newBee.util.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * data 2018-06-28   02:47
 * E-mail   sis.nonacosa@gmail.com
 * @author sis.nonacosa
 */
@RestController
@RequestMapping("/upload")
public class UploadController {


    /**
     * 上传文件到七牛云存储
     * @param multipartFile
     * @return
     * @throws IOException
     */
    @RequestMapping( path = {"/qiniu", "/qiniu/**"},consumes = {"multipart/form-data"}, method = {RequestMethod.POST, RequestMethod.PUT})
    public String uploadImgQiniu(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        FileInputStream inputStream = (FileInputStream) multipartFile.getInputStream();

        String path = QiniuUtil.uploadImg(inputStream);
        return path;
    }


}
