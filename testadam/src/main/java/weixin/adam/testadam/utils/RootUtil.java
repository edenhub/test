package weixin.adam.testadam.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by lab on 2015/3/8.
 */
public class RootUtil {
    private static Properties pro;

    static{
        pro = new Properties();
        try {
            pro.load(RootUtil.class.getResourceAsStream("/root.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfFile generateConfFile() throws DocumentException {
        String confFileName = pro.getProperty("conf.file");

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(RootUtil.class.getResourceAsStream("/"+confFileName));

        Node token = document.selectSingleNode("/conf/weixin/token");

        ConfFile confFile = new ConfFile();
        confFile.setToken(token.getText());

        return confFile;
    }

    public static class ConfFile{
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
