package pl.sda.library.Configuration;


/**
 * Example of singleton pattern
 */
public class Configuration {

    private static Configuration instance;
    private Configuration() {

    }
    //synchronized (opcja) - zabezpieczenie na wypadek wielowątkowiści, jeden po drugim ją wykona
    public static synchronized Configuration getInstance() {
        if (instance==null) {
            instance = new Configuration();
        }
        return instance;
    }
}
