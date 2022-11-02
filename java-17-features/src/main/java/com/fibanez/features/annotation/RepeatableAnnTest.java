package com.fibanez.features.annotation;

@ChangeLogRepeatable(date = "09/18/2017",
        comments = "Declared the class")
@ChangeLogRepeatable(date = "10/22/2017",
        comments = "Added the main() method")
public class RepeatableAnnTest {
    public static void main(String[] args) {
        Class<RepeatableAnnTest> mainClass = RepeatableAnnTest.class;
        Class<ChangeLogRepeatable> annClass = ChangeLogRepeatable.class;
        // Access annotations using the  ChangeLogRepeatable type
        System.out.println("Using the  ChangeLogRepeatable type...");
        ChangeLogRepeatable[] annList = mainClass.getAnnotationsByType(ChangeLogRepeatable.class);
        for (ChangeLogRepeatable log : annList) {
            System.out.println("Date=" + log.date() + ", Comments=" + log.comments());
        }
        // Access annotations using the  ChangeLogRepeatables
        // containing annotation type
        System.out.println("\nUsing the  ChangeLogRepeatables type...");
        Class<ChangeLogs> containingAnnClass = ChangeLogs.class;
        ChangeLogs logs = mainClass.getAnnotation(containingAnnClass);
        for (ChangeLogRepeatable log : logs.value()) {
            System.out.println("Date=" + log.date() +
                    ", Comments=" + log.comments());
        }
    }
}
