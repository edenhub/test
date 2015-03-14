package weixin.adam.testadam.utils.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import weixin.adam.testadam.utils.ConfInfoUtil;
import weixin.adam.testadam.utils.SignUtil;

import java.io.UnsupportedEncodingException;

/**
 * Created by lab on 2015/3/8.
 */
public class TestSignUtil {

    @Test
    public void testDigestUtil() throws UnsupportedEncodingException {
        String signature = "testadam";
        System.out.println(DigestUtils.sha512Hex(signature.getBytes("UTF-8")));
    }

    @Test
    public void testToken(){
        assert "weixinadamtest".equals(ConfInfoUtil.generateToken());
    }

    @Test
    public void testSignUtil(){
        String signature="f99f75e579a3ebda70b0778c42bdde7af2b83309";
        String timestamp="1425819410";
        String nonce="1129030031";

        assert SignUtil.checkSignature(signature,timestamp,nonce) == true;
    }
}
