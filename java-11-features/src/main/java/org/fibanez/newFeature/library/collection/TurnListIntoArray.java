package org.fibanez.newFeature.library.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Instead of passing an array instance, you now can provide a function by using the method Collection.toArray(IntFunction<T[]>).
 */
public class TurnListIntoArray {

    public static void main(String[] args) {
        List<String> months = new ArrayList<>();
        months.add("January");
        months.add("February");
        months.add("March");

        String[] oldWay = months.toArray(new String[months.size()]);
        String[] newWay = months.toArray(String[]::new);

        System.out.println("old: " + Arrays.toString(oldWay));
        System.out.println("new: " + Arrays.toString(newWay));
        System.exit(0);
    }
}
