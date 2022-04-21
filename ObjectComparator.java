package objectcomparator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ObjectComparator {
    private ObjectComparator() {
    }

    public static <T> boolean compareObjects(T obj1, T obj2) {
        if (obj1 instanceof Comparable) {
            return callCompareTo(obj1, obj2);
        }
        return compareObjectsByFields(obj1, obj2);
    }

    public static <T> boolean contains(List<T> list, T element)
    {
        for(T current: list) {
            if(current == null && element == null) return true;
            if(current == null || element == null) continue;
            if(ObjectComparator.compareObjects(current, element)) return true;
        }
        return false;
    }

    private static boolean compareObjectsByFields(Object obj1, Object obj2) {
        Field[] fieldNames = getObjectFields(obj1.getClass());

        for (Field currentField : fieldNames) {
            currentField.setAccessible(true);

            try {
                if (!currentField.get(obj1).equals(currentField.get(obj2)))
                    return false;
            }
            catch (IllegalAccessException e) {
                return false;
            }
        }
        return true;
    }

    private static boolean callCompareTo(Object obj1, Object obj2) {
        Class<?> objectsClass = obj1.getClass();
        try {
            int result = (int) objectsClass.getMethod("compareTo", objectsClass).invoke(obj1, obj2);
            return result == 0;
        }
        catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            return false;
        }
    }

    private static Field[] getObjectFields(Class<?> objectClass) {
        Field[] classFields = objectClass.getDeclaredFields();
        Class<?> superClass = objectClass.getSuperclass();
        while (superClass != null && superClass != Object.class) {
            Field[] superClassFields = superClass.getDeclaredFields();
            Field[] newFields = new Field[superClassFields.length + classFields.length];
            System.arraycopy(superClassFields, 0, newFields, 0, superClassFields.length);
            System.arraycopy(classFields, 0, newFields, superClassFields.length, classFields.length);
            classFields = newFields;
            superClass = superClass.getSuperclass();
        }
        return classFields;
    }
}
