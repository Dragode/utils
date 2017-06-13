package dragode.utils;

import org.apache.commons.lang3.Validate;

import java.lang.reflect.Field;

/**
 * <p>类工具</p>
 *
 * @author Dragon(300116)
 * @version 1.0
 * @date 2017/6/13 0013
 */
public class ClassUtils {

    /**
     * 判断类中是否有该字段
     *
     * @param clazz     类
     * @param fieldName 字段名
     * @return
     */
    public static Boolean hasField(Class clazz, String fieldName) {
        Validate.notNull(clazz);
        Validate.notBlank(fieldName);

        try {
            clazz.getDeclaredField(fieldName);
            return true;
        } catch (NoSuchFieldException e) {
            return false;
        }
    }

    /**
     * 获取属性的类型
     *
     * @param clazz
     * @param fieldName
     * @return
     */
    public static Class getFieldClass(Class clazz, String fieldName) {
        Validate.notNull(clazz);
        Validate.notBlank(fieldName);

        try {
            Field declaredField = clazz.getDeclaredField(fieldName);
            return declaredField.getType();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
