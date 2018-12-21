public class layer {

//initialize vars
public double initAlt;
public double endAlt;
public double gradient;
public double initDense;



//constants

public static double gravity = -9.80665;
public static double seaLevelDensity = 1.225;
public static double seaLevelPressure = 101325;
public static double seaLevelTemp = 288.15;
public static double gasConstant = 287;

//vars in methods
public double startTemp = 0;
public double temp = 0;
public double startAlt = 0;
public double tempAlt = 0;
public double P0 = 0;
public double startAltTemp;
//constructors
  public layer (double ea){ //for temporary layers
    initAlt = 0;
    endAlt = ea;
  }
  public layer(double ia, double ea){
    initAlt = ia;
    endAlt = ea;
  }
  public layer(double ia, double ea, double g){
    initAlt = ia;
    endAlt = ea;
    gradient = g;
  }

 //recursive variable initiation
  public void setVars(double alti){
    if (alti > 0 && alti <= 11000){
      startTemp = 288.15;
      gradient = -0.0065;
      startAltTemp = 0;
      P0 = seaLevelPressure;
    }
    else if (alti > 11000 && alti <= 20000){
      layer troposphere = new layer(0,11000,-0.0065);
      startTemp = troposphere.findTempAlt(11000);
      startAltTemp = 11000;
      P0 = troposphere.findPressureAlt(11000);
      gradient = 0;
    }
    else if(alti > 20000 && alti <= 32000){
      layer tropopause = new layer(11000,20000,0);
      startTemp = tropopause.findTempAlt(20000);
      startAltTemp = 20000;
      P0 = tropopause.findPressureAlt(20000);
      gradient = 0.001;
    }
    else if(alti > 32000 && alti <= 47000){
      layer lowStratosphere = new layer(20000,32000,0.001);
      startTemp = lowStratosphere.findTempAlt(32000);
      startAltTemp = 32000;
      P0 = lowStratosphere.findPressureAlt(32000);
      gradient = 0.0028;
    }
    else if(alti > 47000 && alti <= 51000){
      layer highStratosphere = new layer(32000,47000,0.0028);
      startTemp = highStratosphere.findTempAlt(47000);
      startAltTemp = 47000;
      P0 = highStratosphere.findPressureAlt(47000);
      gradient = 0;
    }
    else if(alti > 51000){ //CURRENTLY ONLY GOES TO STRATOPAUSE
      layer stratopause = new layer(47000,51000,0);
      startTemp = stratopause.findTempAlt(47000);
      startAltTemp = 51000;
      P0 = stratopause.findPressureAlt(51000);
      gradient = gradient ;//FIX WHEN MORE LAYERS ADDED
    }
  }

  public double findTempAlt(double alti)
  {
    setVars(alti);
    temp = startTemp + (gradient * (alti - initAlt));
    return temp;
  }

  public double findPressureAlt(double alti)
  {
    setVars(alti);
    layer provis = new layer(alti);

    if (gradient != 0)
    {
      double gar = ((gravity) / (gradient * gasConstant));
      double x = (provis.findTempAlt(alti) / startTemp);
      System.out.println(provis.findTempAlt(alti));
      System.out.println(startTemp); //ROUNDING PROBLEMS WITH findTempAlt DISCOVERED, MAKE OTHER VALUES MORE ACCURATE
      //return (P0 * Math.pow(x, gar));
      return 0.0;
    }
    else
    {
      return (P0 * Math.pow(Math.E,(gravity/(gasConstant*provis.findTempAlt(alti)))*(alti - startAltTemp)));
    }
  }

}
