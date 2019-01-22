import java.text.DecimalFormat;
import java.lang.Math;

public class main
{
  public static void main(String[]args)
  {
    layer q = new layer(100000);
    //System.out.println("Temp at 2400: " + q.findTempAlt(2400));
    //System.out.println("EXPECTED Temp at 2400: 272.55\n");

    //System.out.println("Temp at 9144: " + q.findTempAlt(9144));
    //System.out.println("EXPECTED Temp at 9144: 228.714\n");

    //System.out.println("Pressure at 2400: " + q.findPressureAlt(2400));
    //System.out.println("EXPECTED Pressure at 2400: 75614.2\n");

    //System.out.println("Pressure at 9144: " + q.findPressureAlt(9144));
    //System.out.println("EXPECTED Pressure at 9144: 30082.8\n");


    System.out.println(q.findTempAlt(32000));
    //9144m = 30082.8 Pa, 228.714 K
    //2400m, 75614.2 Pa, 272.55 K
    //9144 m = .4583 kg/m3
  }


}
