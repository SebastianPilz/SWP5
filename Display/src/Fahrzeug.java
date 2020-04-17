import java.util.ArrayList;
import java.util.List;

public class Fahrzeug {
	
   private List<Display> displays = new ArrayList<Display>();
   private static int state;

   public static int getState() {
      return state;
   }

   public void setState(int state) {
      this.state = state;
      notifyAllDisplays();
   }

   public void attach(Display display){
      displays.add(display);		
   }

   public void notifyAllDisplays(){
      for (Display display : displays) {
         display.update();
      }
   } 	
}