import java.text.DecimalFormat;



public class main
{
  public static void main(String[] args)
  {
    isa w = new isa();
    //System.out.println(df.format(w.findTempAlt(9144))); //test value of 9144m should return 228.714K
    System.out.println(w.findTempAlt(2400));
    System.out.println(w.findPressureAlt(2400)); //9144m = 30082.8 Pa
    //2400m, 75614.2 Pa, 272.55 K
    //9144 m = .4583 kg/m3

  }


}
