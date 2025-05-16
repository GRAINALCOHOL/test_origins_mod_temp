package cn.grainalcohol.init;

import cn.grainalcohol.TestOriginsMod;
import cn.grainalcohol.action.DamageByAttributeAction;
import io.github.apace100.apoli.power.factory.action.ActionFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import net.minecraft.entity.Entity;
import net.minecraft.registry.Registry;
import net.minecraft.util.Pair;

public class TestEntityActionType {
    public static final ActionFactory<Pair<Entity, Entity>> DAMAGE_BY_ATTRIBUTE = 
        new ActionFactory<>(
            TestOriginsMod.id("damage_by_attribute"),
            DamageByAttributeAction.DATA,
            new DamageByAttributeAction()
        );

    public static void init() {
        // 注册为双实体动作(BIENTITY_ACTION)
        Registry.register(ApoliRegistries.BIENTITY_ACTION,
                DAMAGE_BY_ATTRIBUTE.getSerializerId(),
                DAMAGE_BY_ATTRIBUTE
        );
    }
}
