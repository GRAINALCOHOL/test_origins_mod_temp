package cn.grainalcohol.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import net.minecraft.entity.LivingEntity;

import java.util.function.Consumer;
import java.util.function.Predicate;


public class ActionOnEffectGrainedPower extends Power {
    private final Predicate<LivingEntity> CONDITION;
    private final Consumer<LivingEntity> ENTITY_ACTION;

    public ActionOnEffectGrainedPower(PowerType<?> type, LivingEntity entity, Predicate<LivingEntity> condition, Consumer<LivingEntity> entityAction) {
        super(type, entity);
        CONDITION = condition;
        ENTITY_ACTION = entityAction;
    }


}
