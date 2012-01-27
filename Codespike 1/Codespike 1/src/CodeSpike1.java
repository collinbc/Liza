import java.lang.reflect.Field;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ThreadServerApplication;

public class CodeSpike1 {
	
	public static MockServer ms;

	public static void main(String[] args) {
		ms = new MockServer("Mock Server");
		ms.start();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		
		}
		
		ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
		ThreadGroup parentGroup;
		while ( ( parentGroup = rootGroup.getParent() ) != null ) {
		    rootGroup = parentGroup;
		}
		
		Thread[] threads = new Thread[rootGroup.activeCount()];
		while ( rootGroup.enumerate( threads, true ) == threads.length ) {
		    threads = new Thread[ threads.length * 2 ];
		}
		
		ThreadServerApplication tsa = null;
		
		for (Thread t : threads) {
			if (t != null && t.getName() != null) {
				if (t.getName().equals("Server thread")) {
					System.out.println("Found!");
					tsa = (ThreadServerApplication)t;
				}
			}
		}
		
		Class<? extends ThreadServerApplication> c = tsa.getClass();
		Field f;
		MinecraftServer ms = null;
		try {
			f = c.getDeclaredField("a");
			f.setAccessible(true);
			ms = (MinecraftServer)f.get(tsa);
		} catch (Exception e) {
			
		}
		
		
	}
}