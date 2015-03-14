package weixin.adam.testadam.utils;

import org.apache.commons.codec.digest.DigestUtils;
import java.util.Arrays;

/**
 * Created by lab on 2015/3/8.
 */
public class SignUtil {

    private static String token = ConfInfoUtil.generateToken();

    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        boolean res = false;
        String[] arr = new String[]{token, timestamp, nonce};

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (String str : arr)
            sb.append(str);

        String tmpStr = null;
        tmpStr = DigestUtils.sha1Hex(sb.toString());
        res = tmpStr != null ? signature.equals(tmpStr) : false;
        return res;
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param digest
     * @return
     */
    private static String byteToStr(byte[] digest) {
        // TODO Auto-generated method stub
        String strDigest = "";
        for (int i = 0; i < digest.length; i++) {
            strDigest += byteToHexStr(digest[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param b
     * @return
     */
    private static String byteToHexStr(byte b) {
        // TODO Auto-generated method stub
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(b >>> 4) & 0X0F];
        tempArr[1] = Digit[b & 0X0F];

        String s = new String(tempArr);
        return s;
    }
}
