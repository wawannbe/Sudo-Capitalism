package com.sudocapitalism.item.consumable;

import com.sudocapitalism.item.Effect;
import com.sudocapitalism.item.Item;

public class Consumable extends Item {

    protected ConsumableType consumableType;
    protected Effect effect;

    public Consumable(String name, String description, ConsumableType consumableType, Effect effect) {
        super(name, description);
        this.consumableType = consumableType;
        this.effect = effect;
    }

    public Consumable(String name, ConsumableType consumableType, Effect effect) {
        super(name);
        this.consumableType = consumableType;
        this.effect = effect;
    }

    public ConsumableType getConsumableType() {
        return consumableType;
    }

    public Effect getEffect() {
        return effect;
    }
}
