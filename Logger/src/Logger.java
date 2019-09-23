import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalTime;

public class Logger {

	private static PrintWriter log;
	private static String file = "the-log-is-here.txt";
	private static level lvl = level.DEBUG;

	private Logger() {
		
	}

	static PrintWriter debug(String info) throws IOException {
		
		if (lvl != lvl.DEBUG) {
			return log;
		}
		
		if (log == null) {
			try {
				log = new PrintWriter(new FileWriter(file, true));
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		log.print("DEBUG");
		log.print(" | ");
		log.print(LocalTime.now());
		log.print(" | ");
		log.println(info);
		log.flush();
		return log;
	}
	
	static PrintWriter info(String info) throws IOException {
		
		if (lvl != lvl.INFO &&  lvl != lvl.DEBUG) {
			return log;
		}
		
		if (log == null) {
			try {
				log = new PrintWriter(new FileWriter(file, true));
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		log.print("INFO");
		log.print(" | ");
		log.print(LocalTime.now());
		log.print(" | ");
		log.println(info);
		log.flush();
		return log;
	}
	
	static PrintWriter warning(String info) throws IOException {
		
		if (lvl != lvl.INFO &&  lvl != lvl.DEBUG &&  lvl != lvl.WARNING) {
			return log;
		}
		
		if (log == null) {
			try {
				log = new PrintWriter(new FileWriter(file, true));
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		log.print("WARNING");
		log.print(" | ");
		log.print(LocalTime.now());
		log.print(" | ");
		log.println(info);
		log.flush();
		return log;
	}
	
	static PrintWriter error(String info) throws IOException {
		if (log == null) {
			try {
				log = new PrintWriter(new FileWriter(file, true));
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		log.print("ERROR");
		log.print(" | ");
		log.print(LocalTime.now());
		log.print(" | ");
		log.println(info);
		log.flush();
		return log;
	}
	
	static void setFile(String path) throws IOException {
		file = path;
		try {
			log = new PrintWriter(new FileWriter(path, true));
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	static void setLogLvl(level a) {
		lvl = a;
	}
	
	@Override
	protected void finalize() throws Throwable {
		log.close();
		super.finalize();
	}
}
