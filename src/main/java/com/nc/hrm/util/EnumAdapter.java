package com.nc.hrm.util;

import java.lang.reflect.Field;

public final class EnumAdapter {

    /**
     * Returns enum constant that has specified value.
     *
     * @param <E>           enum type
     * @param constantValue the value
     * @param enumClass     enum type
     * @return enum constant
     */
    public static <E> E valueOf(int constantValue, Class<E> enumClass) {

        Field valueField = getValueField(enumClass);

        // find a constant matches specified constant value
        for (E constant : enumClass.getEnumConstants()) {
            int current = getValue(valueField, constant);
            if (constantValue == current) {
                return constant;
            }
        }

        throw new IllegalArgumentException(String.format("not found: %d of %s", constantValue, enumClass.getName()));
    }

    /**
     * getValueField
     *
     * @param <E>       enum type
     * @param enumClass enum type
     * @return field
     */
    private static <E> Field getValueField(Class<E> enumClass) {
        try {
            return enumClass.getField("value");
        } catch (NoSuchFieldException | SecurityException ex) {
            throw new IllegalArgumentException(String.format(
                    "value field is not defined: %s", enumClass.getName()), ex);
        }
    }

    /**
     * Gets the name id field.
     *
     * @param <E>       the element type
     * @param enumClass the enum class
     * @return the name id field
     */
    private static <E> Field getNameIdField(Class<E> enumClass) {
        try {
            return enumClass.getField("nameId");
        } catch (NoSuchFieldException | SecurityException ex) {
            return null;
        }
    }

    /**
     * getValue
     *
     * @param <E>        enum type
     * @param valueField value field
     * @param constant   constant
     * @return value
     */
    private static <E> int getValue(Field valueField, E constant) {
        int current;
        try {
            current = (int) valueField.get(constant);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
        return current;
    }

}

