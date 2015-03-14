package weixin.adam.testadam.utils;

import org.dom4j.DocumentException;

/**
 * Created by lab on 2015/3/8.
 */
public class ConfInfoUtil {
    public static String generateToken() {
        try {
            return RootUtil.generateConfFile().getToken();
        } catch (DocumentException e) {
            e.printStackTrace();
            return null;
        }
    }
}
