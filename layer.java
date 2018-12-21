public class layer{

double initAlt;
double endAlt;
double gradient;
double initPress;
double initDense;

public layer(double ia, double ea){
  initAlt = ia;
  endAlt = ea;
}
  public layer(double ia, double ea, double g){
    initAlt = ia;
    endAlt = ea;
    gradient = g;
  }


  public double findTempAlt(double alti) //Does not need recursion due to contants used. Eventually recusion should be implemented.
  {
    double startTemp = 0;
    double temp = 0;

    if (alti >= 0 && alti < 11000){ //if troposphere
      startTemp = 288.15;
      gradient = -0.0065
    }
    else if (alti >= 11000 && alti < 20000){
      layer troposphere = new layer(0,11000,-0.0065);
      startTemp = troposphere.findTempAlt(11000);
    }
    else if(alti >= 20000 && alti < 32000){
      layer tropopause = new layer(11000,20000,0);
      startTemp = tropopause.findTempAlt(200000);
    }
    else if(alti >= 32000 && alti < 47000){
      layer lowStratosphere = new layer(20000,32000,0.001);
      startTemp = lowStratosphere.findTempAlt(32000);
    }
    else if(alti >= 47000 && alti < 51000){
      layer highStratosphere = new layer(32000,47000,0.0028);
      startTemp = highStratosphere.findTempAlt(47000);
    } else if(alti >= 51000){ //CURRENTLY ONLY GOES TO STRATOPAUSE
      layer stratopause = new layer(47000,51000,0);
      startTemp = stratopause.findTempAlt(47000);
    }


    temp = startTemp + (gradient * (alti - initAlt)); //find startTemp
    return temp;
  }




}
