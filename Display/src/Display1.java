public class Display1 extends Display{

   public Display1(Fahrzeug auto){
      this.auto = auto;
      this.auto.attach(this);
   }

   @Override
   public void update() {
      System.out.println("Geschwindigkeit " + Fahrzeug.getState()); 
      if (Fahrzeug.getState() > 130) {
    	  System.out.println("Hallo i bims Display und i bims rot"); 
      }
   }
}
