package LizaInterface;

import org.bukkit.Server;

/**
 *  LizaServer is the Liza interface representation of
 *  the Bukkit Server interface.
 * 
 * @author geislekj
 *
 */
public interface LizaServer extends Server{
	
	/* (non-Javadoc)
	 * @see org.bukkit.Server#getWorld(java.lang.String)
	 */
	LizaWorld getWorld(String name);
}
