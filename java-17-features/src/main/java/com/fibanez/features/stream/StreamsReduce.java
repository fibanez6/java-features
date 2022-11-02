package com.fibanez.features.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * The reduce operation combines all elements of a stream to produce a single value by applying a combining function
 * repeatedly. It is also called a reduction operation or a fold. Computing the sum, maximum, average, count, etc. of
 * elements of a stream of integers are examples of reduce operations. Collecting elements of a stream in a List, Set,
 * or Map is also an example of the reduce operation.
 *
 * The reduce operation takes two parameters called a seed (also called an initial value) and an accumulator. The accumulator
 * is a function. If the stream is empty, the seed is the result. Otherwise, the seed represents a partial result. The partial
 * result and an element are passed to the accumulator, which returns another partial result. This repeats until all elements
 * are passed to the accumulator.
 */
public class StreamsReduce {

    public static void main(String[] args) {

        // Create the list of integers
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Declare an accumulator called sum and initialize
        // (or seed) it to zero
        int sum = 0;
        for (int num : numbers) {
            // Accumulate the partial result in sum
            sum = sum + num;
        }

        // Print the result
        System.out.println(sum);


        // Declare an accumulator called sum and initialize
        // it to zero
        double sumD = 0.0;
        for(Person person : Person.persons()) {
            // Map the Person to his income double
            double income = person.getIncome();
            // Accumulate the partial result in sum
            sumD = sumD + income;
        }
        System.out.println(sumD);

        // You wanted to compute the sum of the incomes of all people. You need to map the stream of people to a stream
        // of their incomes using the map operation as follows
        double sumP1 = Person.persons()
                .stream()
                .map(Person::getIncome)
                .reduce(0.0, Double::sum);
        System.out.println(sumP1);

        // The code prints a message at several steps along with the current thread name that is performing the operation:
        // The output shows that the accumulator was sufficient to produce the result, and the combiner was never called.
        // Notice that there was only one thread named main that processed all people in the stream.
        double sumP2 = Person.persons()
                .stream()
                .reduce(0.0,
                        (Double partialSum, Person p) -> {
                            double accumulated = partialSum + p.getIncome();
                            System.out.println(
                                    Thread.currentThread().getName() +
                                            " - Accumulator: partialSum = " + partialSum + ", person = " + p + ", accumulated = " + accumulated);
                            return accumulated;
                        },
                        (a, b) -> {
                            double combined = a + b;
                            System.out.println(
                                    Thread.currentThread().getName() +
                                            " - Combiner: a = " + a + ", b = " + b + ", combined = " + combined);
                            return combined;
                        });
        System.out.println(sumP2);

        // Let’s turn the stream into a parallel stream, keeping all the debugging messages. The following code uses a
        // parallel stream to get the sum of the incomes of all people. You may get different output containing a
        // different message, but the sum value would be the same as 26000.0

        // The output shows that six threads (five fork/join worker threads and one main thread) performed the parallel
        // reduce operation. They all performed partial reduction using the accumulator to obtain partial results.
        // Finally, the partial results were combined using the combiner to get the result.
        double sumP3 = Person.persons()
                .parallelStream()
                .reduce(0.0,
                        (Double partialSum, Person p) -> {
                            double accumulated = partialSum + p.getIncome();
                            System.out.println(
                                    Thread.currentThread().getName() +
                                            " - Accumulator: partialSum = " + partialSum + ", person = " + p + ", accumulated = " + accumulated);
                            return accumulated;
                        },
                        (a, b) -> {
                            double combined = a + b;
                            System.out.println(
                                    Thread.currentThread().getName() + " - Combiner: a = " + a + ", b = " + b + ", combined = " + combined);
                            return combined;
                        });


        // MAX

        // The following snippet of code tries to get the maximum of integers in an empty stream:
        Optional<Integer> max = Stream.<Integer>empty().reduce(Integer::max);
        if (max.isPresent()) {
            System.out.println("max = " + max.get());
        } else {
            System.out.println("max is not defined.");
        }

        // The following snippet of code prints the details of the highest earner in the person’s list:
        Optional<Person> person = Person.persons()
                .stream()
                .reduce((p1, p2) ->
                        p1.getIncome() > p2.getIncome() ? p1 : p2);

        if (person.isPresent()) {
            System.out.println("Highest earner: " + person.get());
        } else {
            System.out.println("Could not get the highest earner.");
        }

        // The following snippet of code prints the sum of the incomes of all people
        double totalIncome = Person.persons()
                .stream()
                .mapToDouble(Person::getIncome)
                .sum();

        // The following snippet of code prints the details of the highest earner in a list of people:
        Optional<Person> personHigestEarner = Person.persons()
                .stream()
                .max(Comparator.comparingDouble(Person::getIncome));

        if (personHigestEarner.isPresent()) {
            System.out.println("Highest earner: " + personHigestEarner.get());
        } else {
            System.out.println("Could not get the highest earner.");
        }
    }
}
