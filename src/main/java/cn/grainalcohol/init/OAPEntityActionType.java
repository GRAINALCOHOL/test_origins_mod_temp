package cn.grainalcohol.init;

import cn.grainalcohol.OAPMod;
import cn.grainalcohol.action.bientity.DamageByAttributeAction;
import cn.grainalcohol.action.entity.ModifyEffectDurationAction;
import io.github.apace100.apoli.power.factory.action.ActionFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import net.minecraft.entity.Entity;
import net.minecraft.registry.Registry;
import net.minecraft.util.Pair;

public class OAPEntityActionType {
    public static final ActionFactory<Entity> MODIFY_EFFECT_DURATION =
            new ActionFactory<>(
                    OAPMod.id("modify_effect_duration"),
                    ModifyEffectDurationAction.DATA,
                    (data, entity) -> {
                        ModifyEffectDurationAction action = new ModifyEffectDurationAction();
                        action.accept(data);
                    }
            );
    public static final ActionFactory<Pair<Entity, Entity>> DAMAGE_BY_ATTRIBUTE = 
        new ActionFactory<>(
            OAPMod.id("damage_by_attribute"),
            DamageByAttributeAction.DATA,
            new DamageByAttributeAction()
        );

    public static void init() {
        // 注册为双实体动作(BIENTITY_ACTION)
        Registry.register(ApoliRegistries.BIENTITY_ACTION,
                DAMAGE_BY_ATTRIBUTE.getSerializerId(),
                DAMAGE_BY_ATTRIBUTE
        );
        Registry.register(ApoliRegistries.ENTITY_ACTION,
                MODIFY_EFFECT_DURATION.getSerializerId(),
                MODIFY_EFFECT_DURATION
        );
    }
}
