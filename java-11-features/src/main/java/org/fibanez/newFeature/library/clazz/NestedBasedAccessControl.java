package org.fibanez.newFeature.library.clazz;

import java.lang.reflect.Field;

/**
 *  Inner classes can now access fields and methods from outer classes without additional work from the compiler.
 */
public class NestedBasedAccessControl {

    private static final String level = "outer";

    public static class Inner {

        public static String getOuterViaRegularFieldAccess() {
            return NestedBasedAccessControl.level;
        }

        public static String getOuterViaReflection() {
            try {
                Field levelField = NestedBasedAccessControl.class.getDeclaredField("level");
                // levelField.setAccessible(true);
                return levelField.get(null).toString();
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("getOuterViaRegularFieldAccess: " + Inner.getOuterViaRegularFieldAccess());
        System.out.println("getOuterViaReflection: " + Inner.getOuterViaReflection());
    }
}
