package com.mod.redtek.old.blocks.blockproperties;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.properties.PropertyHelper;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraftforge.common.property.IUnlistedProperty;

import java.util.Collection;
import java.util.stream.IntStream;

/**
 * Created by RedstoneParadox on 9/26/2017.
 */
public class PropertyTemperature extends PropertyHelper<Integer> implements IUnlistedProperty<PropertyTemperature> {

    private String propName = "temperature";
    private final ImmutableSet<Integer> allowedValues;

    public PropertyTemperature(String name, int min, int max) {
        super(name, Integer.class);

        this.allowedValues = IntStream.rangeClosed(min, max).boxed().collect(ImmutableSet.toImmutableSet());
    }

    @Override
    public String getName(Integer value) {
        return this.propName;
    }

    @Override
    public Collection<Integer> getAllowedValues() {
        return this.allowedValues;
    }

    @Override
    public Optional<Integer> parseValue(String value) {
        try
        {
            Integer integer = Integer.valueOf(value);
            return this.allowedValues.contains(integer) ? Optional.of(integer) : Optional.absent();
        }
        catch (NumberFormatException var3)
        {
            return Optional.<Integer>absent();
        }
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

    public boolean equals(Object p_equals_1_)
    {
        if (this == p_equals_1_)
        {
            return true;
        }
        else if (p_equals_1_ instanceof PropertyInteger && super.equals(p_equals_1_))
        {
            PropertyTemperature propertyinteger = (PropertyTemperature)p_equals_1_;
            return this.allowedValues.equals(propertyinteger.allowedValues);
        }
        else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return 31 * super.hashCode() + this.allowedValues.hashCode();
    }

}