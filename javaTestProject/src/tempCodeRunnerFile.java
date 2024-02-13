 for (Map<Integer, Integer> map : maps) {
            // Load map with 100,000 random Integer keys and values
            for (int i = 0; i < NUM_ITEMS; i++) {
                map.put(ThreadLocalRandom.current().nextInt(0, 100000), ThreadLocalRandom.current().nextInt(0, 100000));
            }
        
            // Test add operation
            long addTime = getAddTime(map.values(), NUM_TESTS);
        
            // Test contains operation
            long containsTime = getContainsTime(map.values(), NUM_TESTS);
        
            // Test remove operation
            long removeTime = getRemoveTime(map.values(), NUM_TESTS);
        
            // Test clear operation
            long clearTime = getClearTime(map.values(), NUM_TESTS);
        
            // Display results
            System.out.println("Map: " + map.getClass().getSimpleName());
            System.out.println("Add Time: " + addTime + " ns");
            System.out.println("Contains Time: " + containsTime + " ns");
            System.out.println("Remove Time: " + removeTime + " ns");
            System.out.println("Clear Time: " + clearTime + " ns");
            System.out.println();
        }