import java.io.IOException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64 {
        public static void main(String[] args) {
                String str = "5ee6c73f-4a27-11e5-8c5c-00163e002535";
                String ret = null;
                ret = new BASE64Encoder().encode(str.getBytes());
                System.out.println("encode pre:"+str+" encode end:"+ret);
                System.out.println("end length:" + ret.length());

                String destr = "";
                try {
                    destr = new String(new BASE64Decoder().decodeBuffer(ret));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("decode pre:"+ret+" decode end:"+destr);
        }
}