package coda.dasani.common.entities.goal;

import coda.dasani.common.entities.EpauletteSharkEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Block;

public class SharkDigGoal extends Goal {
    protected EpauletteSharkEntity entity;
    private int timer;
    private final int cooldown = 100;
    private int cooldownTimer;
    private boolean onSand;

    public SharkDigGoal(EpauletteSharkEntity entity) {
        this.entity = entity;
    }

    @Override
    public boolean canUse() {
        return entity.isInWater();
    }

    @Override
    public void tick() {
        super.tick();

        if (!entity.level.getBlockState(entity.blockPosition().below()).is(BlockTags.SAND)) {
            BlockPos pos = entity.blockPosition();
            for (int i = -8; i < 8; i++) {
                for (int j = -8; j < 8; j++) {
                    for (int k = -8; k < 8; k++) {
                        BlockPos pos1 = pos.offset(i, j, k);

                        if (entity.level.getBlockState(pos1).is(BlockTags.SAND)) {

                            BlockPos pos2 = entity.level.getBlockRandomPos(pos1.getX(), pos1.getY(), pos1.getZ(), 1);
                            entity.getNavigation().moveTo(pos2.getX(), pos2.getY(), pos2.getZ(), 1.0D);
                            onSand = true;
                            break;
                        }
                    }
                }
            }
        }
        if (onSand && canUse()) {
            if (this.cooldownTimer < cooldown) {
                this.cooldownTimer++;
            } else {
                if (this.timer <= 40 && entity.level.getBlockState(entity.blockPosition().below()).is(BlockTags.SAND)) {
                    this.timer++;
                    this.entity.setDigging(true);
                    this.entity.getNavigation().stop();
                    if (this.timer == 39) {
                        this.entity.playSound(SoundEvents.SAND_BREAK, 1.0F, 1.0F);
                        this.entity.level.levelEvent(2001, entity.blockPosition(), Block.getId(entity.level.getBlockState(entity.blockPosition().below())));
                    }
                    this.entity.getNavigation().stop();
                } else {
                    this.timer = 0;
                    this.cooldownTimer = 0;
                    this.entity.setDigging(false);
                }
            }
        } else {
            this.stop();
        }
    }

    @Override
    public void stop() {
        this.timer = 0;
        this.cooldownTimer = 0;
        this.entity.setDigging(false);
        onSand = false;
    }
}