package minerforstone.blockutils.mixin;

import net.minecraft.client.render.RenderBlocks;
import net.minecraft.core.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = RenderBlocks.class, remap = false)
public abstract class RenderBlocksMixin {
	@Shadow
	public abstract boolean renderStandardBlock(Block block, int x, int y, int z);

	@Shadow
	public abstract boolean renderBlockCross(Block block, int x, int y, int z);

	/**
	 * @author
	 * MinerForStone
	 * @reason
	 * Debug/Testing
	 */
	@Overwrite()
	public boolean renderBlockByRenderType(Block block, int renderType, int x, int y, int z) {
		if (renderType == 1) {
			return this.renderBlockCross(block, x, y, z);
		}
		return this.renderStandardBlock(block, x, y, z);
	}
}
