package stdlib.logging;

import java.io.File;
import java.util.logging.Logger;

/**
 * <h2></h2>
 *
 * @Date 2024-01-30 23:12
 */
public class Logging
{
    public static void main()
    {
        String configPath = String.join(File.separator, System.getProperty("user.dir"), "logging.properties");
        System.out.println("config path ---" + configPath);
        System.out.println("config property ---" + System.getProperty("java.util.logging.config.file"));
        System.setProperty("java.util.logging.config.file", configPath);
        System.out.println("config property ---" + System.getProperty("java.util.logging.config.file"));
        Logger log = Logger.getLogger("test");
        System.out.println("logger ---" + log);
        System.out.println("logging level ---" + log.getLevel());
        log.finest("test logging");
        log.finer("test logging");
        log.fine("test logging");
        log.config("test logging");
        log.info("test logging");
        log.warning("test logging");
        log.severe("test logging");
    }
}