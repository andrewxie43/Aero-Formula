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

  //Misc constants
  private static double gravity = -9.8;

  //Sea level/atmosphere constants
  private static double seaLevelDensity = 1.225;
  private static double seaLevelPressure = 101325;
  private static double seaLevelTemp = 288.15;
  private static double gasConstant = 287;


  //atmosphere temperature layers
  private static double troposphereMin = 0; //Troposphere
  private static double troposphereMax = 11000;
  private static double troposphereTemp = 288.15;
  private static double troposphereTempChange = -0.0065; //in K/m

  private static double tropopauseMin = 11000; //Tropopause
  private static double tropopauseMax = 20000;
  private static double tropopauseTemp = 216.65; //Double Check value
  private static double tropopauseTempChange = 0;

  private static double lowStratosphereMin = 20000; //Lower Stratosphere
  private static double lowStratosphereMax = 32000;
  private static double lowStratosphereTemp = 216.65; //Double Check value
  private static double lowStratosphereTempChange = 0.001;

  private static double highStratosphereMin = 32000; //Higher Stratosphere
  private static double highStratosphereMax = 47000;
  private static double highStratosphereTemp = 228.65; //Double Check value
  private static double highStratosphereTempChange = 0.0028;

  private static double stratopauseMin = 47000; //Stratopause
  private static double stratopauseMax = 51000;
  private static double stratopauseTemp = 270.65; //Double Check value
  private static double stratopauseTempChange = 0;





  public isa() //Figure out how to input variables in the call
  {

  }

  public double findTempAlt(double alti) //Does not need recursion due to contants used. Eventually recusion should be implemented.
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
    double gradient = 0;
    double startAlt = troposphereMin;
    if (alti <= troposphereMax) //troposphere
    {
      gradient = troposphereTempChange;
      startAlt = troposphereMin;
    }

    else if (alti > tropopauseMax && alti <= lowStratosphereMax) //low Strato
    {
      gradient = lowStratosphereTempChange;
      startAlt = lowStratosphereMin;
    }
    else if (alti > lowStratosphereMax && alti <= highStratosphereMax) //high Strato
    {
      gradient = highStratosphereTempChange;
      startAlt = highStratosphereMin;
    }
    else if ((alti > troposphereMax && alti <=tropopauseMax)) //tropopause
    {
      gradient = 0;
      startAlt = tropopauseMin;
    }
    else if (alti > highStratosphereMax && alti <= stratopauseMax) //stratopause
    {
      gradient = 0;
      startAlt = stratopauseMin;
    }
    else
    {
      System.out.println("Invalid Altitude.");
    }
    if (gradient != 0)
    {
      double gar = ((gravity) / (gradient * gasConstant) );//If testing works for 9144, change to use recursion to calculate pressures up to other levels.
      double x = (temp / seaLevelTemp);
      return seaLevelPressure * Math.pow(x, gar);
    }
    else
    {
      double grt = (-gravity/(gasConstant * temp)) * (alti - startAlt);
      return Math.pow(Math.E, grt);
    }



  }





}
