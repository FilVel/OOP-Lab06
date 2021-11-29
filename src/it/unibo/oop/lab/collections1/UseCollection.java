package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	final int start = 1_000;
    	final int finish = 2_000;
    	
    	final List<Integer> arrayList = new ArrayList<>();
    	for (int i=start; i<finish; i++) {
    		arrayList.add(i);
    	}
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	final List<Integer> linkedList = new LinkedList<>(arrayList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	final int lastPosition = arrayList.size() - 1;
    	final int lastElement = arrayList.get(lastPosition);
    	arrayList.set(lastPosition, arrayList.get(0));
    	arrayList.set(0, lastElement);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for (final int i : arrayList) {
    		System.out.println(i);
    	}
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	int limit_100_000 = 100_000;
    	
    	long timeRequired = System.nanoTime();
    	for (int i = 0; i < limit_100_000; i++) {
    		arrayList.add(0, i);
    	}
    	timeRequired = System.nanoTime() - timeRequired;
    	System.out.println("The time it took to add " + limit_100_000 + " elements as"
    			+ " the first of an ArrayList is " + timeRequired + " ns ");
    	
    	timeRequired = System.nanoTime();
    	for (int i = 0; i < limit_100_000; i++) {
    		linkedList.add(0, i);
    	}
    	timeRequired = System.nanoTime() - timeRequired;
    	System.out.println("The time it took to add " + limit_100_000 + " elements as"
    			+ " the first of a LinkedList is " + timeRequired + " ns ");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	int number_Reads = 1_000;
    	
    	timeRequired = System.nanoTime();
    	for (int i = 0; i < number_Reads; i++) {
    		arrayList.get(arrayList.size() / 2);
    	}
    	timeRequired = System.nanoTime() - timeRequired;
    	System.out.println("The time it took to read " + number_Reads + " elements in"
    			+ " the middle of an ArrayList is " + timeRequired + " ns ");
    	
    	timeRequired = System.nanoTime();
    	for (int i = 0; i < number_Reads; i++) {
    		linkedList.get(linkedList.size() / 2);
    	}
    	timeRequired = System.nanoTime() - timeRequired;
    	System.out.println("The time it took to read " + number_Reads + " elements in"
    			+ " the middle of a LinkedList is " + timeRequired + " ns ");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */

    	final long Pop_Africa = 1_110_635_000L;
    	final long Pop_Americas = 972_005_000L;
    	final long Pop_Antartica = 0L;
    	final long Pop_Asia = 4_298_723_000L;
    	final long Pop_Europe =  742_452_000L;
    	final long Pop_Oceania = 38_304_000L;
    	final Map<String,Long> world= new HashMap <> ();
    	world.put("Africa", Pop_Africa);
    	world.put("Americas", Pop_Americas);
    	world.put("Antartica", Pop_Antartica);
    	world.put("Asia", Pop_Asia);
    	world.put("Europe", Pop_Europe);
    	world.put("Oceania", Pop_Oceania);
    	
        /*
         * 8) Compute the population of the world
         */
    	
    	long totalPopulation = 0;
    	for (final long population : world.values()) {
    		totalPopulation+=population;
    	}
    	System.out.println("The population of Earth (according to the data given) is " + totalPopulation);
    }
}