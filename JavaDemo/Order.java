import java.math.BigDecimal;
import java.util.Date;
import java.text.SimpleDateFormat;

class Order{
    public static void main(String[] args) {
        Date dt= new Date();
        Long time= dt.getTime();
        String s_time = time.toString();
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timeString = dataFormat.format(time);

        String mid_time = s_time.substring(s_time.length()-5,s_time.length());

        int random = (int)(Math.random()*9000+1000);
        String order_number = "DF" + timeString + mid_time+random;

        System.out.println("Time  = " +s_time);
        System.out.println("Mid Time  = " +mid_time);
        System.out.println("Order = " +order_number);
    }
}
