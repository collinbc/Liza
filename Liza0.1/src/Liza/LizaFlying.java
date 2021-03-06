package Liza;

import java.util.HashSet;
import java.util.List;

import org.bukkit.entity.Flying;

/**
 *  LizaFlying is the Liza interface representation of
 *  the Bukkit Flying interface.
 *  
 *  @author collinbc
 */
public interface LizaFlying extends Flying {

	List<LizaBlock> getLastTwoTargetLizaBlocks(HashSet<Byte> transparent,
			int maxDistance);

	List<LizaBlock> getLineOfSightLiza(HashSet<Byte> transparent,
			int maxDistance);

	List<LizaEntity> getNearbyLizaEntities(double x, double y, double z);

}
