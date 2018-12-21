import java.text.DecimalFormat;
import java.lang.Math;

public class main
{
  public static void main(String[]args)
  {
    layer q = new layer(0,10000,1);
    //System.out.println(q.findTempAlt(9144));
    System.out.println(q.findPressureAlt(15000));


    //9144m = 30082.8 Pa, 228.714 K
    //2400m, 75614.2 Pa, 272.55 K
    //9144 m = .4583 kg/m3

  }


}
