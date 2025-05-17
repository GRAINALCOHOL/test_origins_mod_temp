package cn.grainalcohol.init;

import cn.grainalcohol.OAPMod;
import cn.grainalcohol.power.ActionOnEffectGainedPower;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import net.minecraft.registry.Registry;

public class OAPPowerType {
    public static final PowerFactory<?> ACTION_ON_EFFECT_GAINED =
            new PowerFactory<>(
                    OAPMod.id("action_on_effect_gained"),
                    ActionOnEffectGainedPower.DATA,
                    (data) -> (type, livingEntity) -> new ActionOnEffectGainedPower(
                            type, livingEntity,
                            data.isPresent("condition") ? data.get("condition") : null,
                            data.get("entity_action")

                    )
            ).allowCondition();

    public static void init() {
        Registry.register(
                ApoliRegistries.POWER_FACTORY,
                ACTION_ON_EFFECT_GAINED.getSerializerId(),
                ACTION_ON_EFFECT_GAINED
        );
    }
}
