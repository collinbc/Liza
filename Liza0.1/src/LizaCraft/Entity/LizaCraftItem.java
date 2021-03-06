package LizaCraft.Entity;

import java.util.List;
import java.util.UUID;

import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import Liza.LizaItem;


/**
 *  LizeCraftItem is the Liza entity representation of
 *  the Bukkit Item class.
 *  
 * @author geislekj
 */
public class LizaCraftItem implements LizaItem{

	private Item item;
	
	/**
	 * LizaCraftItem Constructor
	 * 
	 * @param item This is a Bukkit Item entity 
	 */
	public LizaCraftItem(Item item) {
		this.item = item;
	}

	@Override
	public ItemStack getItemStack() {
		return this.item.getItemStack();
	}

	@Override
	public int getPickupDelay() {
		return this.item.getPickupDelay();
	}

	@Override
	public void setItemStack(ItemStack arg0) {
		this.item.setItemStack(arg0);
	}

	@Override
	public void setPickupDelay(int arg0) {
		this.item.setPickupDelay(arg0);
	}

	@Override
	public boolean eject() {
		return this.item.eject();
	}

	@Override
	public int getEntityId() {
		return this.item.getEntityId();
	}

	@Override
	public float getFallDistance() {
		return this.item.getFallDistance();
	}

	@Override
	public int getFireTicks() {
		return this.item.getFireTicks();
	}

	@Override
	public EntityDamageEvent getLastDamageCause() {
		return this.item.getLastDamageCause();
	}

	@Override
	public Location getLocation() {
		return this.item.getLocation();
	}

	@Override
	public int getMaxFireTicks() {
		return this.item.getMaxFireTicks();
	}

	@Override
	public List<Entity> getNearbyEntities(double arg0, double arg1, double arg2) {
		return this.item.getNearbyEntities(arg0, arg1, arg2); 
	}

	@Override
	public Entity getPassenger() {
		return this.item.getPassenger();
	}

	@Override
	public Server getServer() {
		return this.item.getServer();
	}

	@Override
	public int getTicksLived() {
		return this.item.getTicksLived();
	}

	@Override
	public UUID getUniqueId() {
		return this.item.getUniqueId();
	}

	@Override
	public Vector getVelocity() {
		return this.item.getVelocity();
	}

	@Override
	public World getWorld() {
		return this.item.getWorld();
	}

	@Override
	public boolean isDead() {
		return this.item.isDead();
	}

	@Override
	public boolean isEmpty() {
		return this.item.isEmpty();
	}

	@Override
	public void playEffect(EntityEffect arg0) {
		this.item.playEffect(arg0);
	}

	@Override
	public void remove() {
		this.item.remove();
	}

	@Override
	public void setFallDistance(float arg0) {
		this.item.setFallDistance(arg0);
	}

	@Override
	public void setFireTicks(int arg0) {
		this.item.setFireTicks(arg0);
	}

	@Override
	public void setLastDamageCause(EntityDamageEvent arg0) {
		this.item.setLastDamageCause(arg0);
	}

	@Override
	public boolean setPassenger(Entity arg0) {
		return this.item.setPassenger(arg0);	
	}

	@Override
	public void setTicksLived(int arg0) {
		this.item.setTicksLived(arg0);
	}

	@Override
	public void setVelocity(Vector arg0) {
		this.item.setVelocity(arg0);
	}

	@Override
	public boolean teleport(Location arg0) {
		return this.item.teleport(arg0); 
	}

	@Override
	public boolean teleport(Entity arg0) {
		return this.item.teleport(arg0); 
	}

	@Override
	public boolean teleport(Location arg0, TeleportCause arg1) {
		return this.item.teleport(arg0, arg1); 
	}

	@Override
	public boolean teleport(Entity arg0, TeleportCause arg1) {
		return this.item.teleport(arg0, arg1); 
	}

}
