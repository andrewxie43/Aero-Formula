public class CodeTest
{
  public static void main(String[] args)
  {
    isa w = new isa();
    System.out.println(w.findTempAlt(9144)); //for 9144m, 228.714K
    System.out.println(w.findPressureAlt(9144)); //for 9144m, 30082.8 Pa
    //for 9144m, 0.4583 kg/m3
  }

}
