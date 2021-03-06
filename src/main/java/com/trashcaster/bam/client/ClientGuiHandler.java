package com.trashcaster.bam.client;

import com.trashcaster.bam.BroadAdditionsMod;
import com.trashcaster.bam.client.gui.GuiEditGravestone;
import com.trashcaster.bam.client.gui.GuiViewGravestone;
import com.trashcaster.bam.client.gui.inventory.GuiAccessories;
import com.trashcaster.bam.common.CommonGuiHandler;
import com.trashcaster.bam.entity.PlayerData;
import com.trashcaster.bam.inventory.ContainerAccessories;
import com.trashcaster.bam.tileentity.TileEntityGravestone;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ClientGuiHandler extends CommonGuiHandler {

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x,y,z);
		switch (ID) {
		case GUI_ACCESSORIES:
			PlayerData data = PlayerData.get(player);
			return new GuiAccessories(player, player.inventory, data.inventory);
		case GRAVESTONE_DISPLAY_GUI:
			if (world.getBlockState(pos).getBlock().equals(BroadAdditionsMod.Content.Misc.GRAVESTONE)) {
				TileEntityGravestone graveTile = (TileEntityGravestone) world.getTileEntity(pos);
				assert graveTile != null;
				return new GuiViewGravestone(player, world, x, y, z);
			}
			break;
		case GRAVESTONE_EDIT_GUI:
			if (world.getBlockState(pos).getBlock().equals(BroadAdditionsMod.Content.Misc.GRAVESTONE)) {
				TileEntityGravestone graveTile = (TileEntityGravestone) world.getTileEntity(pos);
				assert graveTile != null;
				return new GuiEditGravestone(player, world, x, y, z);
			}
			break;
		}
		return null;
	}

}
