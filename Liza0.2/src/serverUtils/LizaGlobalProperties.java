package serverUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/** 
 * This is a singleton class giving access to all global properties for Liza
 * @author kraevam
 *
 */
public enum LizaGlobalProperties {

	INSTANCE;
	
	public final static String SERVER_HOST_PROPERTY = "host";
	public final static String SERVER_PORT_PROPERTY = "port";
	public final static String SERVER_OUTFILE_PROPERTY = "serverLog";
	
	private final static String DEFAULT_HOST = "localhost";
	private final static String DEFAULT_PORT = "25565";
	private final static String DEFAULT_OUTFILE = "liza-out.txt";
	private final static String PROPERTIES_FILE = "data/liza.properties";
	
	private Map<String, String> properties;
	
	private LizaGlobalProperties() {
		properties = new HashMap<String, String>();
		readPropertiesFile();
	}
	
	private void readPropertiesFile() {
		try {
			FileReader fReader = new FileReader(PROPERTIES_FILE);
			BufferedReader reader = new BufferedReader(fReader);
			
			String line = reader.readLine();
			while(line != null) {
				StringTokenizer st = new StringTokenizer(line, "=");
				if (st.countTokens() == 2) {
					// expected pair <key>=<value>
					String key = st.nextToken();
					String value = st.nextToken();
					properties.put(key, value);
				}
				line = reader.readLine();
			}
			
			fReader.close();
			reader.close();

		} catch (IOException e) {
			// problems reading the file, use default values
			properties.put(SERVER_HOST_PROPERTY, DEFAULT_HOST);
			properties.put(SERVER_PORT_PROPERTY, DEFAULT_PORT);
			properties.put(SERVER_OUTFILE_PROPERTY, DEFAULT_OUTFILE);
		}
	}
	
	public String getProperty(String key) {
		return properties.get(key);
	}
}
