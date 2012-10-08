package serverUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Server;
import org.bukkit.event.Event;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.UnknownDependencyException;

import serverUtils.Logger.LogType;

import exceptions.LizaPluginException;

import LizaCraft.LizaCraftServer;
import LizaCraft.Events.EventEnabler;
import LizaCraft.Events.LizaPlugin;
import LizaInterface.LizaServer;

/**
 * The Class LizaCraftTestModule.
 */
public class LizaCraftPluginTester {

	private final static String DEFAULT_NAME = "LizaPluginTester";

	private ServerGrabber serverGrabber = new ServerGrabber();
	private EventEnabler eventEnabler = new EventEnabler();

	private LizaServerThread serverThread;
	private /*@ spec_public @*/ LizaServer server;

	private LizaPlugin eventListener;

	private /*@ spec_public @*/ String name;

	private /*@ spec_public @*/ boolean waiting = false;
	private /*@ spec_public @*/ Event waitingOn;

	private Map<File, Plugin> plugins = new HashMap<File, Plugin>();

	/**
	 * Instantiates a new LizaCraftPluginTester with a default name
	 */
	public LizaCraftPluginTester() {
		this(DEFAULT_NAME);
	}

	/**
	 * Instantiates a new LizaCraftPluginTester.
	 * 
	 * @param name
	 *            The name of the module
	 *@ requires name != null;
	 *@ assignable this.name;
	 */
	public LizaCraftPluginTester(String name) {
		this.name = name;

		this.eventListener = new LizaPlugin();
	}

	/**
	 * Instantiates a new LizaCraftPluginTester with an injected server. For use
	 * with testing.
	 * 
	 * @param name
	 *            The name of the module
	 * @param server
	 *            The Bukkit server
	 *@ requires name != null and server != null;
	 *@ assignable this.name this.server;
	 */
	public LizaCraftPluginTester(String name, Server server) {
		this(name);
		this.server = new LizaCraftServer(server);
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Disable listening to events on the server.
	 */
	public void disableEvents() {
		this.server.getPluginManager().disablePlugin(this.eventListener);
	}

	/**
	 * Enable listening to events on the server.
	 */
	public void enableEvents() {
		eventEnabler.enableEvents(this.server, this.eventListener);
	}

	/**
	 * Retrieves the LizaServer object.
	 * 
	 * @return the server object
	 */
	public LizaServer getServer() {
		return this.server;
	}

	/**
	 * Wait until an event occurs on the server.
	 * 
	 * Note: The event type must first be registered with the event listener.
	 * 
	 * @param event
	 *            The event type to wait on
	 * @return The event object
	 *@ require event != null;
	 *@ assignable this.waiting this.waitingOn;
	 *@ ensure \result != null;
	 */
	public Event waitForEvent(Class<? extends Event> event) {
		this.waiting = true;
		this.eventListener.waitForEvent(event, this);
		while (this.waiting) {
		}
		return this.waitingOn;
	}

	/**
	 * Release the test module from waiting on a certain event.
	 * 
	 * @param event
	 *            the event type
	 *@ require event != null;
	 *@ assignable this.waiting this.waitingOn;
	 *@ ensure this.waitingOn == event and this.waiting == false;
	 */
	public void release(Event event) {
		this.waitingOn = event;
		this.waiting = false;
	}

	/**
	 * Gets the event listener.
	 * 
	 * @return the event listener
	 *@ ensure \result != null;
	 */
	public LizaPlugin getEventListener() {
		return this.eventListener;
	}

	/**
	 * Starts the thread that runs the server.
	 */
	public void startModule() {
		this.serverThread = new LizaServerThread(this.name);
		this.serverThread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}

		this.server = new LizaCraftServer(this.serverGrabber.searchThreads());
		//@ this.server != null and this.server.getBukkitVersion() != null;
	}

	/**
	 * End module.
	 */
	public void endModule() {
		this.server.shutdown();
		this.serverThread.interrupt();
	}

	/**
	 * Spoof event.
	 * 
	 * @param e
	 *            the event
	 *@ requires e != null;
	 */
	public void spoofEvent(Event e) {
		this.server.getPluginManager().callEvent(e);
		Logger.log(Logger.LogType.MESSAGE, "Event was dispatched in the server: " + e.getEventName());
	}

	/**
	 * Load plugin.
	 * 
	 * @param file
	 *            the plugin file
	 * @return the plugin
	 *@ requires file != null;
	 */
	public Plugin loadPlugin (File file) throws LizaPluginException {
		Plugin ret = null;

		try {
			ret = this.server.getPluginManager().loadPlugin(file);
		} catch (UnknownDependencyException | InvalidPluginException
				| InvalidDescriptionException e) {
			// this is a critical error, so throw an exception to the user
			// to inform him about it
			Logger.log(Logger.LogType.ERROR, "Problem loading the plug-in!");
			Logger.log(Logger.LogType.ERROR, e.getMessage());
			LizaPluginException pluginException = new LizaPluginException(e);
			throw pluginException;
		}

		this.server.getPluginManager().enablePlugin(ret);

		if (ret != null) {
			this.plugins.put(file, ret);
			Logger.log(LogType.MESSAGE, "Plug-in successfully loaded: " + ret.getName());
		}

		return ret;
	}

	/**
	 * Enable plugin.
	 * 
	 * @param file
	 *            the plugin file
	 *@ requires file != null;
	 */
	public void enablePlugin(File file) {
		this.enablePlugin(this.plugins.get(file));
	}

	/**
	 * Enable plugin.
	 * 
	 * @param plugin
	 *            the plugin
	 *@ requires plugin != null;
	 */
	public void enablePlugin(Plugin plugin) {
		if (plugin != null) {
			this.server.getPluginManager().enablePlugin(plugin);
		}
	}

	/**
	 * Disable plugin.
	 * 
	 * @param file
	 *            the plugin file
	 *@ requires file != null;
	 */
	public void disablePlugin(final File file) {
		Plugin plugin = this.plugins.get(file);

		if (plugin != null) {
			this.server.getPluginManager().disablePlugin(plugin);
			Logger.log(LogType.MESSAGE, "Plugin disabled: " + plugin.getName());
		}
	}
}
