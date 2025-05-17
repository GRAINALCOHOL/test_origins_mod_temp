package cn.grainalcohol.power;

import io.github.apace100.apoli.data.ApoliDataTypes;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.calio.data.SerializableData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class ActionOnEffectGainedPower extends Power {
    public static final SerializableData DATA = new SerializableData()
            .add("condition", ApoliDataTypes.ENTITY_CONDITION, null)
            .add("entity_action", ApoliDataTypes.ENTITY_ACTION);

    private final Predicate<LivingEntity> CONDITION;
    private final Consumer<LivingEntity> ENTITY_ACTION;

    public ActionOnEffectGainedPower(PowerType<?> type, LivingEntity entity, Predicate<LivingEntity> condition, Consumer<LivingEntity> entityAction) {
        super(type, entity);
        CONDITION = condition;
        ENTITY_ACTION = entityAction;
    }

    public void onEffectGained(StatusEffectInstance effect) {
        // 检查条件是否满足(如果condition为null则直接执行)
        if(CONDITION == null || CONDITION.test(entity)) {
            ENTITY_ACTION.accept(entity);
        }
    }
}
