package LizaCraft.Entity;

import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Tameable;

import LizaInterface.LizaTameable;

/**
 *  LizaCraftTameable is the Liza entity representation of
 *  the Bukkit Tameable class.
 *  
 *  @author collinbc
 */
public class LizaCraftTameable implements LizaTameable {
	
	/** The tameable entity. */
	private Tameable tameable;
	
	/**
	 * LizaCraftTameable Constructor.
	 *
	 * @param tameable A Bukkit Tameable object
	 */
	public LizaCraftTameable(Tameable tameable) {
		this.tameable = tameable;
	}

	/**
	 *
	 * @return the owner
	 */
	@Override
	public AnimalTamer getOwner() {
		return this.tameable.getOwner();
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Tameable#isTamed()
	 */
	@Override
	public boolean isTamed() {
		return this.tameable.isTamed();
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Tameable#setOwner(org.bukkit.entity.AnimalTamer)
	 */
	@Override
	public void setOwner(AnimalTamer tamer) {
		this.tameable.setOwner(tamer);
	}

	/* (non-Javadoc)
	 * @see org.bukkit.entity.Tameable#setTamed(boolean)
	 */
	@Override
	public void setTamed(boolean tame) {
		this.tameable.setTamed(tame);
	}

}
