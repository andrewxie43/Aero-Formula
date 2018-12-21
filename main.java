import java.text.DecimalFormat;
import java.lang.Math;



public class main
{
  public static void main(String[] args)
  {
    isa w = new isa();
    layer q = new layer(0,10000);
    //System.out.println(df.format(w.findTempAlt(9144))); //test value of 9144m should return 228.714K
    System.out.println(w.findTempAlt(9144));
    System.out.println(q.findTempAlt(9144));


    //9144m = 30082.8 Pa
    //2400m, 75614.2 Pa, 272.55 K
    //9144 m = .4583 kg/m3

  }


}
