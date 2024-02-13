import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class App {
    
    // For classes which implement Collection interface
    
    private static long getAddTime(Collection<Integer> collection,int numTests){
        // Calculating and returning average time for adding an item to a collection
        long startTime, endTime,avgTime,totalTime = 0;
        for (int i = 0; i < numTests; i++) {
            startTime = System.nanoTime();
            collection.add(ThreadLocalRandom.current().nextInt(0, 100000));
            endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        avgTime = totalTime / numTests;
        return avgTime;
    } 
    
    private static long getContainsTime(Collection<Integer> collection, int numTests) {
        // Calculating and returning average time for checking whether an item presents in a collection
        long startTime, endTime,avgTime,totalTime = 0;
        for (int i = 0; i < numTests; i++) {
            startTime = System.nanoTime();
            collection.contains(ThreadLocalRandom.current().nextInt(0, 100000));
            endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        avgTime = totalTime / numTests;
        return avgTime;
    }
    
    private static long getRemoveTime(Collection<Integer> collection, int numTests) {
        // Calculating and returning average time for removing an item from a collection
        long startTime, endTime,avgTime,totalTime = 0;
        for (int i = 0; i < numTests; i++) {
            startTime = System.nanoTime();
            collection.remove(ThreadLocalRandom.current().nextInt(0, 100000));
            endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        avgTime = totalTime / numTests;
        return avgTime;
    }

    private static long getClearTime(Collection<Integer> collection, int numTests) {
        // Calculating and returning average time for clearing items of a collection
        long startTime, endTime,avgTime,totalTime = 0;
        for (int i = 0; i < numTests; i++) {
            startTime = System.nanoTime();
            collection.clear();
            endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        avgTime = totalTime / numTests;
        return avgTime;
    }

    // For classes which implement Map interface
    private static long getAddTime(Map<Integer, Integer> map,int numTests){
        // Calculating and returning average time for adding an item to a map
        long startTime, endTime,avgTime,totalTime = 0;
        for (int i = 0; i < numTests; i++) {
            startTime = System.nanoTime();
            map.put(ThreadLocalRandom.current().nextInt(0, 100000), i);
            endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        avgTime = totalTime / numTests;
        return avgTime;
    } 
    
    private static long getContainsTime(Map<Integer, Integer> map, int numTests) {
        // Calculating and returning average time for checking whether an item presents in a map
        long startTime, endTime,avgTime,totalTime = 0;
        for (int i = 0; i < numTests; i++) {
            startTime = System.nanoTime();
            map.get(ThreadLocalRandom.current().nextInt(0, 100000));
            endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        avgTime = totalTime / numTests;
        return avgTime;
    }
    
    private static long getRemoveTime(Map<Integer, Integer> map, int numTests) {
        // Calculating and returning average time for removing an item from a map
        long startTime, endTime,avgTime,totalTime = 0;
        for (int i = 0; i < numTests; i++) {
            startTime = System.nanoTime();
            map.remove(ThreadLocalRandom.current().nextInt(0, 100000));
            endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        avgTime = totalTime / numTests;
        return avgTime;
    }

    private static long getClearTime(Map<Integer, Integer> map, int numTests) {
        // Calculating and returning average time for clearing items of a map
        long startTime, endTime,avgTime,totalTime = 0;
        for (int i = 0; i < numTests; i++) {
            startTime = System.nanoTime();
            map.clear();
            endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }
        avgTime = totalTime / numTests;
        return avgTime;
    }




    public static void main(String[] args) throws Exception {
        
        final int NUM_ITEMS = 100000; // Number of items used for testing
        final int NUM_TESTS = 100;   // Number of tests

        List<Collection<Integer>> collections_arr = new ArrayList<>(); // Storing collections of integers as a list

        collections_arr.add(new HashSet<Integer>());
        collections_arr.add(new TreeSet<Integer>());
        collections_arr.add(new LinkedHashSet<Integer>());
        collections_arr.add(new ArrayList<Integer>());
        collections_arr.add(new LinkedList<Integer>());
        collections_arr.add(new ArrayDeque<Integer>());
        collections_arr.add(new PriorityQueue<Integer>());
        

        List<Map<Integer, Integer>> maps = new ArrayList<>(); // Storing maps of integers as a list

        maps.add(new HashMap<Integer,Integer>());
        maps.add(new TreeMap<Integer,Integer>());
        maps.add(new LinkedHashMap<Integer,Integer>()); 

        for (Collection<Integer> collection : collections_arr){
            //Initially loading each collection with 100 000 random integer objects
            for(int i = 0; i < NUM_ITEMS; i++){
                collection.add(ThreadLocalRandom.current().nextInt(0,100000));
            }
            
            // Calculating average times for add,contains,remove and clear operations
            long addTime = getAddTime(collection,NUM_TESTS);
            long containsTime = getContainsTime(collection,NUM_TESTS);
            long removeTime = getRemoveTime(collection,NUM_TESTS);
            long clearTime = getClearTime(collection,NUM_TESTS);

            // Display results
            System.out.println("Collection: " + collection.getClass().getSimpleName());
            System.out.println("Add Operations Time: " + addTime + " ns");
            System.out.println("Contains Operations Time: " + containsTime + " ns");
            System.out.println("Remove Operations Time: " + removeTime + " ns");
            System.out.println("Clear Operations Time: " + clearTime + " ns");
            System.out.println("");
        }
        
        for (Map<Integer, Integer> map : maps) {
            // Load map with 100,000 random Integer keys and values
            for (int i = 0; i < NUM_ITEMS; i++) {
                map.put(ThreadLocalRandom.current().nextInt(0, 100000), ThreadLocalRandom.current().nextInt(0, 100000));
            }
        
            // Calculating average times for add,contains,remove and clear operations
            long addTime = getAddTime(map, NUM_TESTS);
            long containsTime = getContainsTime(map, NUM_TESTS);
            long removeTime = getRemoveTime(map, NUM_TESTS);
            long clearTime = getClearTime(map, NUM_TESTS);
        
            // Display results
            System.out.println("Map: " + map.getClass().getSimpleName());
            System.out.println("Add Time: " + addTime + " ns");
            System.out.println("Contains Time: " + containsTime + " ns");
            System.out.println("Remove Time: " + removeTime + " ns");
            System.out.println("Clear Time: " + clearTime + " ns");
            System.out.println();
        }
    }
}
