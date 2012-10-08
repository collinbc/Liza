package serverUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.bukkit.craftbukkit.Main;

/**
 * The Class LizaServerThread.
 */
public class LizaServerThread extends Thread {

	/** server start args */
	private String[] args;
	
	/** The out. */
	private PrintStream out;
    
    /**
     * Instantiates a new liza server thread.
     *
     * @param name the name
     */
    public LizaServerThread(String name) {
        super(name);
        try {
        	final String filename = LizaGlobalProperties.INSTANCE.getProperty(LizaGlobalProperties.SERVER_OUTFILE_PROPERTY);
        	FileOutputStream fOut = new FileOutputStream(new File(filename), false);
            out = new PrintStream(fOut);
            
        } catch (FileNotFoundException e) {
        	final String warning = "The file set as serverLog property is a directory or could not be created. Standard System.out will be used for logging!";
            Logger.log(Logger.LogType.WARNING, warning);
        }
        args = new String[4];
        args[0] = "-h";
        args[1] = LizaGlobalProperties.INSTANCE.getProperty(LizaGlobalProperties.SERVER_HOST_PROPERTY);
        args[2] = "-p";
        args[3] = LizaGlobalProperties.INSTANCE.getProperty(LizaGlobalProperties.SERVER_PORT_PROPERTY);
    }
    
    /* (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    public void run() {
        System.setOut(this.out);
        
        Main.main(args);
    }
}
