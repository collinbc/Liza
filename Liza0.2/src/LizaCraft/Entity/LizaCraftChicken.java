package LizaCraft.Entity;

import org.bukkit.entity.Chicken;

import LizaInterface.LizaChicken;

/**
 *  LizaCraftChicken is the Liza entity representation of
 *  the Bukkit CraftChicken class.
 *  
 * @author collinbc
 */
public class LizaCraftChicken extends LizaCraftAnimals implements LizaChicken {

	/**
	 * LizaCraftChicken Constructor.
	 *
	 * @param chicken A Bukkit Chicken
	 */
	public LizaCraftChicken(Chicken chicken) {
		super(chicken);
	}
	
	/* (non-Javadoc)
	 * @see LizaCraft.Entity.LizaCraftAnimals#getBukkitHandle()
	 */
	@Override
	public Chicken getBukkitHandle() {
		return (Chicken)this.entity;
	}
	
}
