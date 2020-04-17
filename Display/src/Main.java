public class Main {
   public static void main(String[] args) {
      Fahrzeug auto = new Fahrzeug();

      new Display1(auto);
      
      for (int i = 120; i < 140; i++) {
    	  auto.setState(i);
      }
   }
}