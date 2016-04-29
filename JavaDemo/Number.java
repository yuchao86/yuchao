import java.math.BigDecimal;
class MyMath{
    public static double add(double d1, double d2)
    {        
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);

        return b1.add(b2).doubleValue();
    }
    public static double sub(double d1, double d2)
    {       
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.subtract(b2).doubleValue();
    }
    public static double mul(double d1, double d2)
    {
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.multiply(b2).doubleValue();
    }
    public static double div(double d1,
            double d2, int len) {
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.divide(b2,len,BigDecimal.
                ROUND_HALF_UP).doubleValue();
    }
    public static double round(double d,
            int len) {    
        BigDecimal b1 = new BigDecimal(d);
        BigDecimal b2 = new BigDecimal(1);
        return b1.divide(b2, len,BigDecimal.
                ROUND_HALF_UP).doubleValue();
    }
}
public class Number{
    public static void main(String[] args) {
        System.out.println("add " +
                MyMath.round(MyMath.add(10.345,
                        3.333), 1));
        System.out.println("mul "
                +
                MyMath.round(MyMath.mul(10.345,
                        3.333), 3));
        System.out.println("div "
                +
                MyMath.div(10,
                    3, 10));
        System.out.println("sub "
                +
                MyMath.round(MyMath.sub(10.345,
                        3.333), 3));
    }
}
