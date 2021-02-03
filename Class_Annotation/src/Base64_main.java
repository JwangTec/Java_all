import java.util.Base64;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION:
 * @USER: jwang
 * @DATE: 2021/2/3 下午6:32
 */
public class Base64_main {
    /**
     * 获取编码器：getDecoder --解码器 getMimeDecoder..
     *          getEncoder --编码器
     * 解码器方法
     *          encodeToString(byte[] bs) 编码
     *          decode(String s) 解码
     */

    public static void main(String[] args) {
        Base64.Encoder encoder = Base64.getEncoder();

        String str = "所属首次";

        final String s = encoder.encodeToString(str.getBytes());

        System.out.println("编码后"+s);
        final Base64.Decoder decoder = Base64.getDecoder();

        final byte[] bytes = decoder.decode(s);
        System.out.println("解码"+ new String(bytes));


    }
}
