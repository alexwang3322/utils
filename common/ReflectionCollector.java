package com.example.alex.utilstest.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by alex on 16/3/11.
 *
 * copy from F**ebookMod-20160121
 */
public class ReflectionCollector {

    public static String collectConstants(Class<?> cls) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field : cls.getFields()) {
            stringBuilder.append(field.getName()).append("=");
            try {
                stringBuilder.append(field.get(null).toString());
            } catch (Exception e) {
                stringBuilder.append("N/A");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static String collectStaticGettersResults(Class<?> cls) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Method method : cls.getMethods()) {
            if (method.getParameterTypes().length == 0 && ((method.getName().startsWith("get") || method.getName().startsWith("is")) && !method.getName().equals("getClass"))) {
                try {
                    stringBuilder.append(method.getName()).append('=').append(method.invoke(null, null)).append("\n");
                } catch (IllegalArgumentException e) {
                } catch (IllegalAccessException e2) {
                } catch (InvocationTargetException e3) {
                }
            }
        }
        return stringBuilder.toString();
    }


}
