import java.util.Scanner;

public class isa
{
  //density in kg/m^3, pressure in pa, temperature in k
  private int density;
  private int pressure;
  private int temp;
  private int alt;

  private static int seaLevelDensity = 1.225;
  private static int seaLevelPressure = 101325;
  private static int seaLevelTemp = 288.15;

  private static int gasConstant = 287;

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





}
