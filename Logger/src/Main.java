import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		String info = "Seb hat sich eingeloggt";
		String info2 = "Seb hat was gmacht";
		String info3 = "Seb hat nix gmacht";
		
		
		Logger.debug(info);
		Logger.setFile("hallo.txt");
		Logger.setLogLvl(level.INFO);
		
		Logger.debug(info2);
		Logger.error(info3);
		
	}

}
