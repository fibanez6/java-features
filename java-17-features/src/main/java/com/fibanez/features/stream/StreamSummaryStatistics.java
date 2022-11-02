package com.fibanez.features.stream;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

/**
 * In a data-centric application, you need to compute the summary statistics on a group of numeric data. For example,
 * you may want to know the maximum, minimum, sum, average, and count of the incomes of all people. The java.util
 * package contains three classes to collect statistics:
 * <p>
 * DoubleSummaryStatistics
 * LongSummaryStatistics
 * IntSummaryStatistics
 **/
public class StreamSummaryStatistics {

    public static void main(String[] args) {

        // Computing Summary Statistics on a Group of Numeric Data
        DoubleSummaryStatistics stats = new DoubleSummaryStatistics();
        stats.accept(100.0);
        stats.accept(500.0);
        stats.accept(400.0);
        // Get stats
        long count = stats.getCount();
        double sum = stats.getSum();
        double min = stats.getMin();
        double avg = stats.getAverage();
        double max = stats.getMax();
        System.out.printf("count=%d, sum=%.2f, min=%.2f, max=%.2f, average=%.2f%n", count, sum, min, max, avg);

        // The summary statistics classes were designed to be used with streams.
        // They contain a combine() method that combines two summary statistics.
        DoubleSummaryStatistics incomeStats01 =
                Person.persons()
                        .stream()
                        .map(Person::getIncome)
                        .collect(DoubleSummaryStatistics::new,
                                DoubleSummaryStatistics::accept,
                                DoubleSummaryStatistics::combine);
        System.out.println(incomeStats01);


        // The Collectors class contains methods to obtain a collector to compute the summary statistics of the specific type of numeric data
        DoubleSummaryStatistics incomeStats02 =
                Person.persons()
                        .stream()
                        .collect(Collectors.summarizingDouble(Person::getIncome));
        System.out.println(incomeStats02);
    }
}
