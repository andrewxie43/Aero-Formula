import java.util.Scanner;
import java.lang.Math;

public class isa
{
  //density in kg/m^3, pressure in pa, temperature in k, distance in m

  //input parameters
  private int density;
  private int pressure;
  private int temp;
  private int alt;

  //Sea level/atmosphere constants
  private static double seaLevelDensity = 1.225;
  private static int seaLevelPressure = 101325;
  private static double seaLevelTemp = 288.15;
  private static int gasConstant = 287;


  //atmosphere layers
  private static int troposphereMin = 0; //Troposphere
  private static int troposphereMax = 11000;
  private static double troposphereTemp = 288.15;
  private static double troposphereTempChange = -0.0065; //in K/m

  private static int tropopauseMin = 11000; //Tropopause
  private static int tropopauseMax = 20000;
  private static double tropopauseTemp = 216.65; //Double Check value
  private static double tropopauseTempChange = 0;

  private static int lowStratosphereMin = 20000; //Lower Stratosphere
  private static int lowStratosphereMax = 32000;
  private static double lowStratosphereTemp = 216.65; //Double Check value
  private static double lowStratosphereTempChange = 0.001;

  private static int highStratosphereMin = 32000; //Higher Stratosphere
  private static int highStratosphereMax = 47000;
  private static double highStratosphereTemp = 228.65; //Double Check value
  private static double highStratosphereTempChange = 0.0028;

  private static int stratopauseMin = 47000; //Stratopause
  private static int stratopauseMax = 51000;
  private static double stratopauseTemp = 270.65; //Double Check value
  private static double stratopauseTempChange = 0;





  public isa() //Figure out how to input variables in the call
  {

  }

  public double findTempAlt(double alti)
  {
    double gradient = troposphereTempChange;
    double startTemp = troposphereTemp;
    double startAlt = troposphereMin;
    double temp = 0;
    if (alti <= troposphereMax) //troposphere
    {
      gradient = troposphereTempChange;
      startTemp = troposphereTemp;
      startAlt = troposphereMin;
      temp = 0;
    }
    else if (alti > troposphereMax && alti <=tropopauseMax) //tropopause
    {
      return tropopauseTemp;
    }
    else if (alti > tropopauseMax && alti <= lowStratosphereMax) //low Strato
    {
      gradient = lowStratosphereTempChange;
      startTemp = lowStratosphereTemp;
      startAlt = lowStratosphereMin;
    }
    else if (alti > lowStratosphereMax && alti <= highStratosphereMax) //high Strato
    {
      gradient = highStratosphereTempChange;
      startTemp = highStratosphereTemp;
      startAlt = highStratosphereMin;
    }
    else if (alti > highStratosphereMax && alti <= stratopauseMax) //stratopause
    {
      return stratopauseTemp;
    }
    else
    {
      System.out.println("Invalid Altitude.");
    }

    temp = startTemp + (gradient * (alti - startAlt));
    return temp;
  }
  public double findPressureAlt(double alti)
  {
    double temp = findTempAlt(alti);
    double gravity = 9.8;
    double gradient = 0;
    if (alti <= troposphereMax) //troposphere
    {
      gradient = troposphereTempChange;
    }

    else if (alti > tropopauseMax && alti <= lowStratosphereMax) //low Strato
    {
      gradient = lowStratosphereTempChange;
    }
    else if (alti > lowStratosphereMax && alti <= highStratosphereMax) //high Strato
    {
      gradient = highStratosphereTempChange;
    }
    else if ((alti > troposphereMax && alti <=tropopauseMax)) //tropopause and stratopause
    {
      gradient = 0;
      double startAlt = tropopauseMin;
    }
    else if (alti > highStratosphereMax && alti <= stratopauseMax)
    {
      gradient = 0;
      double startAlt = stratopauseMin;
    }
    else
    {
      System.out.println("Invalid Altitude.");
    }
    if (gradient != 0)
    {
      double gar = (-gravity)/(gradient*gasConstant)-1;
      return Math.pow((temp/seaLevelTemp), gar);
    }
    else
    {
      double grt
    }



  }





}
