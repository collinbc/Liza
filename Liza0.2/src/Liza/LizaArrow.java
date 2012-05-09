package Liza;

import java.util.List;

import org.bukkit.entity.Arrow;

/**
 *  LizaArrow is the Liza interface representation of
 *  the Bukkit Arrow interface.
 * 
 * @author geislekj
 */
public interface LizaArrow extends Arrow{
	
	/**
	 * @param x
	 *            Size of the box along x axis
	 * @param y
	 *            Size of the box along y axis
	 * @param z
	 *            Size of the box along z axis
	 * @return The result of getNearbyEntities, but as LizaEntities.
	 */
	List<LizaEntity> getNearbyLizaEntities(double x, double y, double z);

}
