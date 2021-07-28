package ua.com.alevel.app.mapper;

import ua.com.alevel.app.annotation.CsvField;
import ua.com.alevel.app.parser.CsvParser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class CsvMapper {

    public <T> List<T> initialize(Class<T> c, CsvParser parser) {
        List<T> instances = new ArrayList<>();
        for (int i = 0; i < parser.size(); i++) {
            try {
                Constructor<T> constructor = c.getConstructor();
                T instance = constructor.newInstance();

                for (Field field : c.getDeclaredFields()) {
                    if (!field.isAnnotationPresent(CsvField.class)) {
                        continue;
                    }

                    CsvField csvField = field.getAnnotation(CsvField.class);
                    String name = csvField.name();
                    String value = parser.get(name, i);
                    if (value == null) {
                        continue;
                    }

                    Class<?> typeOfField = field.getType();

                    if(typeOfField == boolean.class || typeOfField == Boolean.class) {
                        field.set(instance, Boolean.parseBoolean(value));
                    } else if(typeOfField == byte.class || typeOfField == Byte.class) {
                        field.set(instance, Byte.parseByte(value));
                    } else if(typeOfField == short.class || typeOfField == Short.class) {
                        field.set(instance, Short.parseShort(value));
                    } else if(typeOfField == int.class || typeOfField == Integer.class) {
                        field.set(instance, Integer.parseInt(value));
                    } else if(typeOfField == long.class || typeOfField == Long.class) {
                        field.set(instance, Long.parseLong(value));
                    } else if(typeOfField == float.class || typeOfField == Float.class) {
                        field.set(instance, Float.parseFloat(value));
                    } else if(typeOfField == double.class || typeOfField == Double.class) {
                        field.set(instance, Double.parseDouble(value));
                    } else if(typeOfField == String.class) {
                        field.set(instance, value);
                    } else if(typeOfField == char.class || typeOfField == Character.class) {
                        field.set(instance, value.charAt(0));
                    } else if(typeOfField.isEnum()) {
                        field.set(instance, Enum.valueOf((Class<? extends Enum>) typeOfField, value));
                    } else {
                        throw new RuntimeException("Field " + field.getName() + " is unsupported");
                    }
                }
                instances.add(instance);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return instances;
    }
}