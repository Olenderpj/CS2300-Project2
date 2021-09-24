import java.util.logging.Logger;

public class LoggingUtils {
    public static Logger logger = Logger.getAnonymousLogger();

    public static void printMissingValueError(){
        logger.severe("!!! Unable to perform processing due to missing data");
    }
}
