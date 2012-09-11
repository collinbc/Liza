package LizaCraft.Entity;

import org.bukkit.entity.EnderDragon;

import LizaInterface.LizaEnderDragon;

// TODO: Auto-generated Javadoc
/**
 *  LizaCraftEnderDragon is the Liza entity representation of
 *  the Bukkit EnderDragon class.
 *  
 *  @author collinbc
 */
public class LizaCraftEnderDragon extends LizaCraftComplexLivingEntity implements LizaEnderDragon {
	
	/**
	 * LizaCraftEnderDragon Constructor.
	 *
	 * @param enderDragon A Bukkit enderDragon
	 */
	public LizaCraftEnderDragon(EnderDragon enderDragon) {
		super(enderDragon);
	}
	
	/* (non-Javadoc)
	 * @see LizaCraft.Entity.LizaCraftComplexLivingEntity#getBukkitHandle()
	 */
	@Override
	public EnderDragon getBukkitHandle() {
		return (EnderDragon) this.entity;
	}
}
