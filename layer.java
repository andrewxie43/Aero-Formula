public class layer{

double initAlt;
double endAlt;
double gradient;
double initPress;
double initDense;

  public layer(double ia, double ea, double g){
    initAlt = ia;
    endAlt = ea;
    gradient = g;
  }


  public double findTempAlt(double alti) //Does not need recursion due to contants used. Eventually recusion should be implemented.
  {
    double startTemp;
    double temp;

    if (initAlt == 0){ //if troposphere
      startTemp = 288.15;
    }
    else if (initAlt == 11000){
      layer troposphere = new layer(0,11000,-0.0065);
      startTemp = troposphere.findTempAlt(11000);
    }


    temp = startTemp + (gradient * (alti - initAlt)); //find startTemp
    return temp;
  }




}
