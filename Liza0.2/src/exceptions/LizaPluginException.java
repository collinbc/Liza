package exceptions;

/**
 * An Exception subclass. Used when there is a problem with loading a plug-in
 * @author kraevam
 *
 */
public class LizaPluginException extends Exception {

	/**
	 * Default serial version UID
	 */
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_MESSAGE = "Exception in loading the plug-in!";
	
	public LizaPluginException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}
	

}
