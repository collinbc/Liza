package LizaCraft.Entity;

import org.bukkit.entity.Villager;

import LizaInterface.LizaVillager;

/**
 * LizaCraftVillager is the Liza entity representation of the Bukkit Villager
 * class.
 * 
 * @author collinbc
 */
public class LizaCraftVillager extends LizaCraftNPC implements LizaVillager {

	/**
	 * LizaCraftVillager Constructor.
	 *
	 * @param villager A Bukkit Villager
	 */
	public LizaCraftVillager(Villager villager) {
		super(villager);
	}

	/* (non-Javadoc)
	 * @see LizaCraft.Entity.LizaCraftNPC#getBukkitHandle()
	 */
	@Override
	public Villager getBukkitHandle() {
		return (Villager) this.entity;
	}

}
