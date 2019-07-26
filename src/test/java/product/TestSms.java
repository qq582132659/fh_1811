package product;

import com.fh.shop.api.utils.HttpClientUtil;
import com.fh.shop.api.utils.Sha1Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-common.xml"})
public class TestSms {

    @Value("${sms.url}")
    private String url;
    @Value("${sms.mobile}")
    private String mobile;
    @Value("${sms.templateid}")
    private String templateid;
    @Value("${sms.AppKey}")
    private String appKey;
    @Value("${sms.AppSecret}")
    private String appSecret;

    @Test
    public void testSms(){
        Map<String,String> params = new HashMap<>();
        params.put("mobile",mobile);
        params.put("templateid",templateid);
        Map<String,String> headers = new HashMap<>();
        headers.put("AppKey",appKey);
        String uuidInfo = UUID.randomUUID().toString()+"";
        headers.put("Nonce",uuidInfo);
        String time = new Date().getTime() + "";
        headers.put("CurTime",time);
        headers.put("CheckSum",Sha1Util.getCheckSum(appSecret,uuidInfo,time));
        String str = HttpClientUtil.httpPost(url, params, headers);
        System.out.println(str);
    }
}
