import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import org.junit.Test;

import java.io.File;

public class TestOss {
    @Test
    public void saveOss(){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAIJhsyyaTevgLp";
        String accessKeySecret = "UlQI7aqO3nO36iamMolqwb6Y3oLk77";

// 创建OSSClient实例。
        OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

// 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
        ossClient.putObject("fh1911-liuyh", "test", new File("C:/Users/lenovo/Desktop/MyBatis.doc"));

// 关闭OSSClient。
        ossClient.shutdown();
    }
}
