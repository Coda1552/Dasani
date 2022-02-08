package coda.dasani.common.entities.goal;

import java.util.EnumSet;
import java.util.function.Predicate;

import coda.dasani.common.entities.EpauletteSharkEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.gameevent.GameEvent;

public class DigSandGoal extends Goal {
   private final EpauletteSharkEntity shark;
   private final Level level;
   private int timer;
   private final int cooldown = 100;
   private int cooldownTimer;

   public DigSandGoal(EpauletteSharkEntity p_25207_) {
      this.shark = p_25207_;
      this.level = p_25207_.level;
      this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
   }

   public boolean canUse() {
      BlockPos blockpos = this.shark.blockPosition();
      return /*shark.level.random.nextFloat() > 0.95F && */this.level.getBlockState(blockpos.below()).is(BlockTags.SAND) && shark.isInWater();
   }

   public void start() {
      this.level.broadcastEntityEvent(this.shark, (byte)10);
      this.shark.getNavigation().stop();
   }

   public void stop() {
      this.timer = 0;
      this.cooldownTimer = 0;
      this.shark.setDigging(false);
   }

   public void tick() {
      this.shark.setDigging(true);
      if (this.cooldownTimer < cooldown) {
         this.cooldownTimer++;
      } else {
         if (this.timer <= 40 && shark.level.getBlockState(shark.blockPosition().below()).is(BlockTags.SAND)) {
            this.timer++;
            this.shark.getNavigation().stop();
            if (this.timer == 39) {
               this.shark.playSound(SoundEvents.SAND_BREAK, 1.0F, 1.0F);
               this.shark.level.levelEvent(2001, shark.blockPosition(), Block.getId(shark.level.getBlockState(shark.blockPosition().below())));
            }
            this.shark.getNavigation().stop();
         } else {
            this.timer = 0;
            this.cooldownTimer = 0;
            this.shark.setDigging(false);
         }
      }
   }
}
