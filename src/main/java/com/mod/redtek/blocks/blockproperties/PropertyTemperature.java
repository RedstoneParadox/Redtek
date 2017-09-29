package com.mod.redtek.blocks.blockproperties;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import net.minecraft.block.properties.PropertyHelper;
import net.minecraftforge.common.property.IUnlistedProperty;

import java.util.Collection;
import java.util.Set;

/**
 * Created by RedstoneParadox on 9/26/2017.
 */
public class PropertyTemperature extends PropertyHelper<Integer> implements IUnlistedProperty<PropertyTemperature> {

    private String propName = "temperature";
    private final ImmutableSet<Integer> allowedValues;

    public PropertyTemperature(String name, int min, int max) {
        super(name, Integer.class);

        if (min < 0) {
            throw new IllegalArgumentException("Min value of " + name + " must be 0 or greater");
        }
        else if (max <= min) {
            throw new IllegalArgumentException("Max value of " + name + " must be greater than min (" + min + ")");
        }
        else {
            Set<Integer> set = Sets.<Integer>newHashSet();

            for (int i = min; i <= max; i++) {
                set.add(Integer.valueOf(i));
            }

            this.allowedValues = ImmutableSet.copyOf(set);
        }
    }

    @Override
    public String getName() {
        return this.propName;
    }

    @Override
    public Collection<Integer> getAllowedValues() {
        return null;
    }

    @Override
    public Optional<Integer> parseValue(String value) {
        return null;
    }

    @Override
    public String getName(Integer value) {
        return null;
    }


    @Override
    public boolean isValid(PropertyTemperature value) {
        return value != null;
    }

    @Override
    public Class getType() {
        return getClass();
    }

    @Override
    public String valueToString(PropertyTemperature value) {
        if (value == null) {
            return "";
        }
        else {
            value.getClass();
        }
        return null;
    }

    public static PropertyTemperature create(String name, int min, int max) {
        return new PropertyTemperature(name, min, max);
    }
}
