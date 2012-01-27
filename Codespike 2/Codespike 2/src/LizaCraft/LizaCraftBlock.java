package LizaCraft;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.PistonMoveReaction;

import Liza.LizaBlock;

public class LizaCraftBlock implements LizaBlock {
	private Block block;

	public LizaCraftBlock(Block block) {
		this.block = block;
	}

	public boolean assertBlockType(Material type) {
		return this.getType().equals(type);
	}

	@Override
	public Biome getBiome() {
		return this.block.getBiome();
	}

	@Override
	public int getBlockPower() {
		return this.block.getBlockPower();
	}

	@Override
	public int getBlockPower(BlockFace arg0) {
		return this.block.getBlockPower(arg0);
	}

	@Override
	public Chunk getChunk() {
		return this.block.getChunk();
	}

	@Override
	public byte getData() {
		return this.block.getData();
	}

	@Override
	@Deprecated
	public Block getFace(BlockFace arg0) {
		return new LizaCraftBlock(this.block.getFace(arg0));
	}

	@Override
	public BlockFace getFace(Block arg0) {
		return this.block.getFace(arg0);
	}

	@Override
	public Block getFace(BlockFace arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getHumidity() {
		return this.block.getHumidity();
	}

	@Override
	public byte getLightLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PistonMoveReaction getPistonMoveReaction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getRelative(BlockFace arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getRelative(BlockFace arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getRelative(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlockState getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getTemperature() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Material getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTypeId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public World getWorld() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isBlockFaceIndirectlyPowered(BlockFace arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBlockFacePowered(BlockFace arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBlockIndirectlyPowered() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBlockPowered() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLiquid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setData(byte arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setData(byte arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setType(Material arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean setTypeId(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setTypeId(int arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setTypeIdAndData(int arg0, byte arg1, boolean arg2) {
		// TODO Auto-generated method stub
		return false;
	}

}