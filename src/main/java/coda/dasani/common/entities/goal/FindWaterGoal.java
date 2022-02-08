package coda.dasani.common.entities.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;

// Literally vanilla's exact goal but slower, because reasons.
public class FindWaterGoal extends Goal {
   private final PathfinderMob mob;

   public FindWaterGoal(PathfinderMob p_25964_) {
      this.mob = p_25964_;
   }

   public boolean canUse() {
      return this.mob.isOnGround() && !this.mob.level.getFluidState(this.mob.blockPosition()).is(FluidTags.WATER);
   }

   public void start() {
      BlockPos blockpos = null;

      for(BlockPos blockpos1 : BlockPos.betweenClosed(Mth.floor(this.mob.getX() - 2.0D), Mth.floor(this.mob.getY() - 2.0D), Mth.floor(this.mob.getZ() - 2.0D), Mth.floor(this.mob.getX() + 2.0D), this.mob.getBlockY(), Mth.floor(this.mob.getZ() + 2.0D))) {
         if (this.mob.level.getFluidState(blockpos1).is(FluidTags.WATER)) {
            blockpos = blockpos1;
            break;
         }
      }

      if (blockpos != null) {
         this.mob.getMoveControl().setWantedPosition(blockpos.getX(), blockpos.getY(), blockpos.getZ(), 0.35D);
      }

   }
}