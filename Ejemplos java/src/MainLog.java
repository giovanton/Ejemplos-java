import org.apache.log4j.Logger;



public class MainLog {

	private final static Logger log = Logger.getLogger("mylog");

	// private final static Logger log = Logger.getRootLogger();

	public static void main(String[] args) {
		log.error("JODER CON LOS Q TOCAN!!!!!");
		log.info("Informando...");
		log.warn("Cuidaito!!!!!");
		log.debug("A es igual a 12");
		log.trace("A que no sales!");
	}

}
