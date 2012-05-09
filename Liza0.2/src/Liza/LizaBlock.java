package Liza;

import org.bukkit.Material;
import org.bukkit.block.Block;

/**
 *  LizaBlock is the Liza interface representation of
 *  the Bukkit Block interface
 *  
 * @author kimsj
 */
public interface LizaBlock extends Block {

	/**
	 * Returns the Bukkit interface for this Block
	 * 
	 * @return the Block Bukkit interface
	 */
	public Block getBukkitBlock();
	
}