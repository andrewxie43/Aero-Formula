import java.util.Scanner;

public class isa
{
  //density in kg/m^3, pressure in pa, temperature in k, distance in m

  //input parameters
  private int density;
  private int pressure;
  private int temp;
  private int alt;

  //Sea level/atmosphere constants
  private static int seaLevelDensity = 1.225;
  private static int seaLevelPressure = 101325;
  private static int seaLevelTemp = 288.15;
  private static int gasConstant = 287;


  //atmosphere layers
  private static int troposphereMin = 0; //Troposphere
  private static int troposphereMax = 11000;
  private static int troposphereTemp = 288.15;
  private static int troposphereTempChange = -0.0065; //in K/m

  private static int tropopauseMin = 11000; //Tropopause
  private static int tropopauseMax = 20000;
  private static int tropopauseTemp = 216.65; //Double Check value
  private static int tropopauseTempChange = 0;

  private static int lowStratosphereMin = 20000; //Lower Stratosphere
  private static int lowStratosphereMax = 32000;
  private static int lowStratosphereTemp = 216.65; //Double Check value
  private static int lowStratosphereTempChange = 0.001;

  private static int highStratosphereMin = 32000; //Higher Stratosphere
  private static int highStratosphereMax = 47000;
  private static int highStratosphereTemp = 228.65; //Double Check value
  private static int highStratosphereTempChange = 0.0028;

  private static int stratopauseMin = 47000; //Stratopause
  private static int stratopauseMax = 51000;
  private static int stratopauseTemp = 270.65; //Double Check value
  private static int stratopauseTempChange = 0;





  public isa()
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Input variables: if unknown, input 'N/A'. \n");
    System.out.println("Density:");
    String dense = sc.nextLine();
    System.out.println("Pressure");
    String press = sc.nextLine();
    System.out.println("Temperature:");
    String temper = sc.nextLine();
    System.out.println("Altitude:");
    String alti = sc.nextLine();

    if (dense == 'N/A')
    {
      pressure = Integer.parseInt(press);
      temp = Integer.parseInt(temper);
      alt = Integer.parseInt(alti);

    } else if (press = 'N/A')
    {
      density = Integer.parseInt(dense);
      temp = Integer.parseInt(temper);
      alt = Integer.parseInt(alti);

    } else if (temper = 'N/A')
    {
      density = Integer.parseInt(dense);
      pressure = Integer.parseInt(press);
      alt = Integer.parseInt(alti);

    } else if (alti = 'N/A')
    {
      pressure = Integer.parseInt(press);
      density = Integer.parseInt(dense);
      temp = Integer.parseInt(temper);

    }
  }


  public int




}
