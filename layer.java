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
public static double seaLevelTemp = 288.16;
public static double gasConstant = 287;

//vars in normal methods
public double startTemp = 0;
public double temp = 0;
public double startAlt = 0;
public double tempAlt = 0;
public double P0 = 0;
public double startAltProvis;

//vars in inverse
public double endTemp = 0;

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

 //recursive variable initiation given alti
  public void setVarsAlt(double alti)
  {
    if (alti > 0 && alti <= 11000){ //Troposphere
      startTemp = 288.15;
      gradient = -0.0065;
      startAltProvis = 0;
      P0 = seaLevelPressure;
    }
    else if (alti > 11000 && alti <= 20000){ //Tropopause
      layer troposphere = new layer(0,11000,-0.0065);
      startTemp = troposphere.findTempAlt(11000);
      startAltProvis = 11000;
      P0 = troposphere.findPressureAlt(11000);
      gradient = 0;
    }
    else if(alti > 20000 && alti <= 32000){ //Low Stratosphere //
      layer tropopause = new layer(11000,20000,0); //Pressure becomes inaccurate at this layer, due to gravity rounding?
      startTemp = tropopause.findTempAlt(20000);
      startAltProvis = 20000;
      P0 = tropopause.findPressureAlt(20000);
      gradient = 0.001;
    }
    else if(alti > 32000 && alti <= 47000){ //High Stratosphere
      layer lowStratosphere = new layer(20000,32000,0.001);
      startTemp = lowStratosphere.findTempAlt(32000);
      startAltProvis = 32000;
      P0 = lowStratosphere.findPressureAlt(32000);
      gradient = 0.0028;
    }
    else if(alti > 47000 && alti <= 51000){ // Stratopause
      layer highStratosphere = new layer(32000,47000,0.0028);
      startTemp = highStratosphere.findTempAlt(47000);
      startAltProvis = 47000;
      P0 = highStratosphere.findPressureAlt(47000);
      gradient = 0;
    }
    else if(alti > 51000 && alti <= 71000){ //Low Mesosphere
      layer stratopause = new layer(47000,51000,0);
      startTemp = stratopause.findTempAlt(47000);
      startAltProvis = 51000;
      P0 = stratopause.findPressureAlt(51000);
      gradient = -0.0028 ;
    }

    else if(alti > 71000 && alti <= 80000){ //High mesosphere
      layer lowMesosphere = new layer(51000,71000,0.0028);
      startTemp = lowMesosphere.findTempAlt(51000);
      startAltProvis = 47000;
      P0 = lowMesosphere.findPressureAlt(71000);
      gradient = -0.002;
    }
    else if (alti >= 80000 && alti <100000){
      System.out.println("You have reached space, as defined by the USAF and NASA."); //REMEMBER TO UPDATE THIS WHEN A GUI IS ADDED
    }
    else{
      System.out.println("You have reached space, as defined by the Karman line.");
    }
  }
  public void setVarsTemp(double temp) //REWRITE TO ACCOUNT FOR EQUAL TEMPS AT DIFFERENT ALTS
  {
    layer troposphere = new layer(0,11000,-0.0065);
    layer tropopause = new layer(11000,20000,0);
    layer lowStratosphere = new layer(20000,32000,0.001);
    layer highStratosphere = new layer(32000,47000,0.0028);
    layer stratopause = new layer(47000,51000,0);
    layer lowMesosphere = new layer(51000,71000,0.0028);
    layer highMesosphere = new layer(71000,80000,-0.002);

    if (temp <= 15){
      System.out.println("Less than standard sea level temp");
    } else if (temp >= troposphere.startTemp && temp < tropopause.startTemp){
      startTemp = troposphere.startTemp;
      //endTemp = tropopause.startTemp;
    } else if (temp >= tropopause.startTemp && temp < lowStratosphere.startTemp){
      startTemp = tropopause.startTemp;
      //endTemp = lowStratosphere.startTemp;
    } else if (temp >= lowStratosphere.startTemp && temp < highStratosphere.startTemp){
      startTemp = lowStratosphere.startTemp;
      //endTemp = highStratosphere.startTemp;
    } else if (temp >= highStratosphere.startTemp && temp < stratopause.startTemp){
      startTemp = highStratosphere.startTemp;
      //endTemp = stratopause.startTemp;
    } else if (temp >= stratopause.startTemp && temp < lowMesosphere.startTemp){
      startTemp = stratopause.startTemp;
      //endTemp = lowMesosphere.startTemp;
    } else if (temp >= lowMesosphere.startTemp && temp < highMesosphere.startTemp){
      startTemp = lowMesosphere.startTemp;
      //endTemp = highMesosphere.startTemp;
    } else if (temp >= lowMesosphere.startTemp && temp < highMesosphere.startTemp){
      startTemp = lowMesosphere.startTemp;
      //endTemp = highMesosphere.startTemp;
    } else {
      System.out.println("ERROR: No U");
    }




  }

  public double findTempAlt(double alti)
  {
    setVarsAlt(alti);
    temp = startTemp + (gradient * (alti - initAlt));
    return temp;
  }

  public double findPressureAlt(double alti)
  {
    setVarsAlt(alti);
    layer provis = new layer(alti);

    if (gradient != 0)
    {
      double gar = ((gravity) / (gradient * gasConstant));
      double x = (provis.findTempAlt(alti) / startTemp);
      return (P0 * Math.pow(x,gar));
    }
    else
    {
      return (P0 * Math.pow(Math.E,(gravity/(gasConstant*provis.findTempAlt(alti)))*(alti - startAltProvis)));
    }
  }



  //NEXT: Density



  public double findAltTemp(double doubleTemp, String layer){

    //setVarsTemp(temp);
    layer.toUpperCase(); //Match input layer to a setup layer, and adjust starttemp and gradient accordingly...

    double alti = ((temp - startTemp)/gradient) + initAlt;

    return alti;
  }
}
