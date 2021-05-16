package com.element.hydrogen.utils.common.pwd;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName MD5Util
 * @Description 加密工具类
 * @Author yanyu
 * @Date 2020/9/15 23:49
 * @Version 1.0
 */
public class MD5Util {


    public static final String KEY_MD5 = "MD5";

    /***
     * MD5加密（生成唯一的MD5值）
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryMD5(byte[] data) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
        md5.update(data);
        System.out.println("密码："+md5.digest().toString());
        return md5.digest();
    }


    /**
     * MD5方法
     *
     * @param text 明文
     * @param key 密钥
     * @return 密文
     * @throws Exception
     */
    public static String md5(String text, String key) throws Exception {
        //加密后的字符串
        //String encodeStr=DigestUtils.md5Hex(text + key);
        //System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        return "";//encodeStr;
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param key 密钥
     * @param md5 密文
     * @return true/false
     * @throws Exception
     */
    public static boolean verify(String text, String key, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = md5(text, key);
        if(md5Text.equalsIgnoreCase(md5))
        {
            System.out.println("MD5验证通过");
            return true;
        }

        return false;
    }
//[B@5d099f62
//[B@5d099f62
        // 测试主函数
/*        public static void main(String args[]) throws NoSuchAlgorithmException {
            String KEY_MD5 = "MD5222";
            String aaa = encryptToMD5(KEY_MD5);

            System.out.println("密码：----->>"+aaa.toString());
        }*/

    /**
     * 进行MD5加密
     *
     * @param info
     *            要加密的信息
     * @return String 加密后的字符串
     */
    //0:7f;1:13;2:8a;3:09;4:16;5:9b;6:25;7:0e;8:9d;9:cb;10:37;11:81;12:40;13:90;14:73;15:78;
    public static String encryptToMD5(String info) {
        byte[] digesta = null;
        try {
            // 得到一个md5的消息摘要
            MessageDigest alga = MessageDigest.getInstance("MD5");
            // 添加要进行计算摘要的信息
            alga.update(info.getBytes());
            // 得到该摘要
            digesta = alga.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 将摘要转为字符串
        String rs = bytesToHexString(digesta);
        System.out.println("rrrrrrrrrrssssss:"+rs);
        return rs;
    }


    /**
     * 二进制转十六进制
     * @param src
     * @return
     */
    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);

            stringBuilder.append(i);

            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 十六进制转二进制
     * @param hex
     * @return
     */
    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    private static byte toByte(char c) {
        byte b = (byte) "0123456789abcdef".indexOf(c);
        return b;
    }
}
