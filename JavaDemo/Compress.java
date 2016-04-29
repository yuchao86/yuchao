import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Compress {
	
	public static void main(String[] args){
		try
        {
            String user_code = "5ee6c73f-4a27-11e5-8c5c-00163e002535";
            user_code  = user_code.concat("5ee6c73f-4a27-11e5-8c5c-00163e002535");
            user_code  = user_code.concat("5ee6c73f-4a27-11e5-8c5c-00163e002535");
            user_code  = user_code.concat("5ee6c73f-4a27-11e5-8c5c-00163e002535");
            user_code  = user_code.concat("5ee6c73f-4a27-11e5-8c5c-00163e002535");
            user_code  = user_code.concat("5ee6c73f-4a27-11e5-8c5c-00163e002535");
            user_code  = user_code.concat("5ee6c73f-4a27-11e5-8c5c-00163e002535");
            user_code  = user_code.concat("5ee6c73f-4a27-11e5-8c5c-00163e002535");

            String comp = compress(user_code);
            System.out.println("user_code length = "+user_code.length());
            System.out.println("comp = "+comp);
            System.out.println("comp length = "+comp.length());
            String umComp = uncompress(comp);
            System.out.println("uncomp str = "+umComp);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    
	}

    public static String compress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(str.getBytes());
        gzip.close();
        return out.toString("ISO-8859-1");
    }

    public static String uncompress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(str
                .getBytes("ISO-8859-1"));
        GZIPInputStream gunzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n;
        while ((n = gunzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }
        return out.toString();
    }

}
