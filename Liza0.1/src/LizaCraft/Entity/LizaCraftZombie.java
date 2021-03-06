package LizaCraft.Entity;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.util.Vector;

import Liza.LizaArrow;
import Liza.LizaBlock;
import Liza.LizaEgg;
import Liza.LizaEntity;
import Liza.LizaLivingEntity;
import Liza.LizaPlayer;
import Liza.LizaServer;
import Liza.LizaSnowball;
import Liza.LizaVehicle;
import Liza.LizaWorld;
import Liza.LizaZombie;
import LizaCraft.LizaCraftServer;
import LizaCraft.LizaCraftWorld;
import LizaCraft.Block.LizaCraftBlock;

/**
 *  LizaCraftZombie is the Liza entity representation of
 *  the Bukkit Zombie class.
 *  
 *  @author collinbc
 */
public class LizaCraftZombie implements LizaZombie {
	private Zombie zombie;
	
	/**
	 * LizaCraftZombie Constructor
	 * 
	 * @param zombie A Bukkit Zombie
	 */
	public LizaCraftZombie(Zombie zombie) {
		this.zombie = zombie;
	}

	@Override
	public LizaLivingEntity getTarget() {
		return new LizaCraftLivingEntity(this.zombie.getTarget());
	}

	@Override
	public void setTarget(LivingEntity target) {
		this.zombie.setTarget(target);
	}

	@Override
	public void damage(int amount) {
		this.zombie.damage(amount);
	}

	@Override
	public void damage(int amount, Entity source) {
		this.zombie.damage(amount, source);
	}

	@Override
	public double getEyeHeight() {
		return this.zombie.getEyeHeight();
	}

	@Override
	public double getEyeHeight(boolean ignoreSneaking) {
		return this.zombie.getEyeHeight(ignoreSneaking);
	}

	@Override
	public Location getEyeLocation() {
		return this.zombie.getEyeLocation();
	}

	@Override
	public int getHealth() {
		return this.zombie.getHealth();
	}


	@Override
	public LizaPlayer getKiller() {
		return new LizaCraftPlayer(this.zombie.getKiller());
	}

	@Override
	public int getLastDamage() {
		return this.zombie.getLastDamage();
	}

	@Override
	@Deprecated
	public List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent,
			int maxDistance) {
		List<Block> bl = this.zombie.getLastTwoTargetBlocks(transparent,
				maxDistance);

		for (Block b : bl) {
			bl.remove(b);
			LizaBlock lb = new LizaCraftBlock(b);
			bl.add(lb);
		}
		return bl;
	}
	
	@Override
	@Deprecated
	public List<Block> getLineOfSight(HashSet<Byte> transparent, int maxDistance) {
		List<Block> bl = this.zombie.getLastTwoTargetBlocks(transparent,
				maxDistance);

		for (Block b : bl) {
			bl.remove(b);
			LizaBlock lb = new LizaCraftBlock(b);
			bl.add(lb);
		}
		return bl;
	}

	@Override
	public int getMaxHealth() {
		return this.zombie.getMaxHealth();
	}

	@Override
	public int getMaximumAir() {
		return this.zombie.getMaximumAir();
	}

	@Override
	public int getMaximumNoDamageTicks() {
		return this.zombie.getMaximumNoDamageTicks();
	}

	@Override
	public int getNoDamageTicks() {
		return this.zombie.getNoDamageTicks();
	}

	@Override
	public int getRemainingAir() {
		return this.zombie.getRemainingAir();
	}

	@Override
	public LizaBlock getTargetBlock(HashSet<Byte> transparent, int maxDistance) {
		return new LizaCraftBlock(this.zombie.getTargetBlock(transparent,
				maxDistance));
	}

	@Override
	public LizaVehicle getVehicle() {
		return new LizaCraftVehicle(this.zombie.getVehicle());
	}

	@Override
	public boolean isInsideVehicle() {
		return this.zombie.isInsideVehicle();
	}

	/**
	 * This method performs an action and returns a value.
	 */
	@Override
	public boolean leaveVehicle() {
		return this.zombie.leaveVehicle();
	}

	@Override
	public void setHealth(int health) {
		this.zombie.setHealth(health);
	}

	@Override
	public void setLastDamage(int damage) {
		this.zombie.setLastDamage(damage);
	}

	@Override
	public void setMaximumAir(int ticks) {
		this.zombie.setMaximumAir(ticks);
	}

	@Override
	public void setMaximumNoDamageTicks(int ticks) {
		this.zombie.setMaximumNoDamageTicks(ticks);
	}

	@Override
	public void setNoDamageTicks(int ticks) {
		this.zombie.setNoDamageTicks(ticks);
	}

	@Override
	public void setRemainingAir(int ticks) {
		this.zombie.setRemainingAir(ticks);
	}

	@Override
	public LizaArrow shootArrow() {
		return new LizaCraftArrow(this.zombie.shootArrow());
	}

	@Override
	public LizaEgg throwEgg() {
		return new LizaCraftEgg(this.zombie.throwEgg());
	}

	@Override
	public LizaSnowball throwSnowball() {
		return new LizaCraftSnowball(this.zombie.throwSnowball());
	}

	/**
	 * This method performs an action and returns a value.
	 */
	@Override
	public boolean eject() {
		return this.zombie.eject();
	}

	@Override
	public int getEntityId() {
		return this.zombie.getEntityId();
	}

	@Override
	public float getFallDistance() {
		return this.zombie.getFallDistance();
	}

	@Override
	public int getFireTicks() {
		return this.zombie.getFireTicks();
	}

	@Override
	public EntityDamageEvent getLastDamageCause() {
		return this.zombie.getLastDamageCause();
	}

	@Override
	public Location getLocation() {
		return this.zombie.getLocation();
	}

	@Override
	public int getMaxFireTicks() {
		return this.zombie.getMaxFireTicks();
	}

	/**
	 * @param x
	 *            Size of the box along x axis
	 * @param y
	 *            Size of the box along y axis
	 * @param z
	 *            Size of the box along z axis
	 */
	@Override
	@Deprecated
	public List<Entity> getNearbyEntities(double x, double y, double z) {
		List<Entity> el = this.zombie.getNearbyEntities(x, y, z);

		for (Entity e : el) {
			el.remove(e);
			LizaEntity le = new LizaCraftEntity(e);
			el.add(le);
		}
		return el;
	}

	@Override
	public LizaEntity getPassenger() {
		return new LizaCraftEntity(this.zombie.getPassenger());
	}

	@Override
	public LizaServer getServer() {
		return new LizaCraftServer(this.zombie.getServer());
	}

	@Override
	public int getTicksLived() {
		return this.zombie.getTicksLived();
	}

	@Override
	public UUID getUniqueId() {
		return this.zombie.getUniqueId();
	}

	@Override
	public Vector getVelocity() {
		return this.zombie.getVelocity();
	}

	@Override
	public LizaWorld getWorld() {
		return new LizaCraftWorld(this.zombie.getWorld());
	}

	@Override
	public boolean isDead() {
		return this.zombie.isDead();
	}

	@Override
	public boolean isEmpty() {
		return this.zombie.isEmpty();
	}

	@Override
	public void playEffect(EntityEffect type) {
		this.zombie.playEffect(type);
	}

	@Override
	public void remove() {
		this.zombie.remove();
	}

	@Override
	public void setFallDistance(float distance) {
		this.zombie.setFallDistance(distance);
	}

	@Override
	public void setFireTicks(int ticks) {
		this.zombie.setFireTicks(ticks);
	}

	@Override
	public void setLastDamageCause(EntityDamageEvent event) {
		this.zombie.setLastDamageCause(event);
	}

	/**
	 * This method performs an action and returns a value.
	 */
	@Override
	public boolean setPassenger(Entity passenger) {
		return this.zombie.setPassenger(passenger);
	}

	@Override
	public void setTicksLived(int ticks) {
		this.zombie.setTicksLived(ticks);
	}

	@Override
	public void setVelocity(Vector vel) {
		this.zombie.setVelocity(vel);
	}

	/**
	 * This method performs an action and returns a value.
	 */
	@Override
	public boolean teleport(Location location) {
		return this.zombie.teleport(location);
	}

	/**
	 * This method performs an action and returns a value.
	 */
	@Override
	public boolean teleport(Entity destination) {
		return this.zombie.teleport(destination);
	}

	/**
	 * This method performs an action and returns a value.
	 */
	@Override
	public boolean teleport(Location location, TeleportCause cause) {
		return this.zombie.teleport(location, cause);
	}

	/**
	 * This method performs an action and returns a value.
	 */
	@Override
	public boolean teleport(Entity destination, TeleportCause cause) {
		return this.zombie.teleport(destination, cause);
	}

	/**
	 * @param transparent
	 * @param maxDistance
	 * @return The result of getLastTwoTargetBlocks, but as LizaBlocks.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<LizaBlock> getLastTwoTargetLizaBlocks(HashSet<Byte> transparent, int maxDistance) {
		List<Block> bl = this.zombie.getLastTwoTargetBlocks(transparent, maxDistance);
		List<LizaBlock> lbl;

		for(Block b : bl) {
			bl.remove(b);
			LizaBlock lb = new LizaCraftBlock(b);
			bl.add(lb);
		}
		lbl = (List) bl;
		
		return lbl;
	}
	
	/**
	 * @param transparent
	 * @param maxDistance
	 * @return The result of getLineOfSight, but as LizaBlocks.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<LizaBlock> getLineOfSightLiza(HashSet<Byte> transparent, int maxDistance) {
		List<Block> bl = this.zombie.getLastTwoTargetBlocks(transparent,
				maxDistance);
		List<LizaBlock> lbl;

		for(Block b : bl) {
			bl.remove(b);
			LizaBlock lb = new LizaCraftBlock(b);
			bl.add(lb);
		}
		lbl = (List) bl;
		
		return lbl;
	}
	
	/**
	 * @param x
	 *            Size of the box along x axis
	 * @param y
	 *            Size of the box along y axis
	 * @param z
	 *            Size of the box along z axis
	 * @return The result of getNearbyEntities, but as LizaEntities.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<LizaEntity> getNearbyLizaEntities(double x, double y, double z) {
		List<Entity> el = this.zombie.getNearbyEntities(x, y, z);
		List<LizaEntity> lel;

		for(Entity e : el) {
			el.remove(e);
			LizaEntity le = new LizaCraftEntity(e);
			el.add(le);
		}
		lel = (List) el;
		
		return lel;
	}
}
