package LizaCraft;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ThreadServerApplication;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Liza.LizaEventListener;

public class LizaCraftServer {
    private static final String MINECRAFT_SERVER_THREAD_NAME = "Server thread";
    private static final String MINECRAFT_SERVER_FIELD_NAME = "a";

    private CraftServer cs;
    private LizaServerThread lst;
    protected static LizaPlugin spoof;
    private LizaCraftEventListener lel;

    public LizaCraftServer() {
        this.lst = new LizaServerThread("Liza Server Thread");
        this.lst.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {

        }

        this.cs = getCraftServer();
        this.lel = new LizaCraftEventListener(this);

        spoof = new LizaPlugin();
    }

    private CraftServer getCraftServer() {
        ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();

        while (rootGroup.getParent() != null) {
            rootGroup = rootGroup.getParent();
        }

        Thread threads[] = new Thread[rootGroup.activeCount()];

        // activeCount() only provides an estimate for the number of
        // running threads, so this loop ensures that all threads are
        // captured.
        while (rootGroup.enumerate(threads, true) >= threads.length) {
            threads = new Thread[threads.length * 2];
        }

        // This is the Minecraft thread that is running the server
        ThreadServerApplication tsa = null;

        for (Thread t : threads) {
            if (t != null && t.getName() != null
                    && t.getName().equals(MINECRAFT_SERVER_THREAD_NAME)) {
                tsa = (ThreadServerApplication) t;
                break;
            }
        }

        Class<? extends ThreadServerApplication> c = tsa.getClass();
        Field f;
        MinecraftServer ms = null;
        try {
            f = c.getDeclaredField(MINECRAFT_SERVER_FIELD_NAME);
            f.setAccessible(true);
            ms = (MinecraftServer) f.get(tsa);
        } catch (Exception e) { // lol

        }

        return ms.server;
    }

    @SuppressWarnings("unchecked")
    public void enableLizaPlugin() {
        Class<? extends PluginManager> c = ((SimplePluginManager) cs
                .getPluginManager()).getClass();
        Field f;
        List<Plugin> plugs;
        PluginLoader loader = null;
        try {
            // add spoof plugin to list of plugins
            f = c.getDeclaredField("plugins");
            f.setAccessible(true);
            plugs = (List<Plugin>) f.get(cs.getPluginManager());
            plugs.add(spoof);
            f.set(cs.getPluginManager(), plugs);

            // get the plugin loader
            f = c.getDeclaredField("fileAssociations");
            f.setAccessible(true);
            Map<Pattern, PluginLoader> fileAssociations = ((HashMap) f.get(cs
                    .getPluginManager()));
            Set<Pattern> filters = fileAssociations.keySet();
            System.out.println(filters);
            for (Pattern filter : filters) {
                Matcher match = filter.matcher(".jar");
                if (match.find()) {
                    loader = fileAssociations.get(filter);

                    System.out.println(loader);
                }
            }

        } catch (Exception e) { // lol again
            System.out.println("Ooops!");
            e.printStackTrace();
        }

        Class<? extends JavaPlugin> cp = spoof.getClass();
        try {
            f = cp.getSuperclass().getDeclaredField("isEnabled");
            f.setAccessible(true);
            f.set(spoof, true);

            f = cp.getSuperclass().getDeclaredField("server");
            f.setAccessible(true);
            f.set(spoof, this.cs);

            f = cp.getSuperclass().getDeclaredField("loader");
            f.setAccessible(true);
            f.set(spoof, loader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(spoof.isEnabled());
        spoof.onEnable();
    }

    public void stop() {
        cs.shutdown();
        lst.interrupt();
    }

    public int broadcastMessage(String message) {
        return cs.broadcastMessage(message);
    }

    public Player[] getOnlinePlayers() {
        return (cs.getOnlinePlayers());
    }

    public PluginManager getPluginManager() {
        return cs.getPluginManager();
    }
    
    public LizaEventListener getEventListener() {
        return this.lel;
    }

}