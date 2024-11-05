public class HashMap {
    public static final int DEFAULT_TABLE_SIZE = 9887;
    public static final int RADIX = 256;
    private int tableSize;
    private int numEntries;
    private Pair[] pairs;

    private static final String INVALID = "INVALID KEY";

    public HashMap() {
        tableSize = DEFAULT_TABLE_SIZE;
        pairs = new Pair[tableSize];
        numEntries = 0;
    }

    public void add(String key, String value){
        // Checks the load factor to see if we need to re-size the table
        if ((double) (numEntries/tableSize) >= 0.5){
            resize();
        }

        int index = hash(key);

        // If needed, keeps checking the next index until and empty spot is found
        while(pairs[index] != null){
            index = (index + 1) % tableSize;
        }

        // Initializes the new pair and increments the number of entries
        pairs[index] = new Pair(key, value);
        numEntries++;
    }

    public String get(String key) {
        int index = hash(key);

        // Loops through the pairs until a null spot is found
        while(pairs[index] != null){
            // Checks if the correct key is at the current spot, and if so returns the value
            if (key.equals(pairs[index].getKey())) {
                return pairs[index].getValue();
            }

            // Moves to the next index and wraps around if needed
            index += 1;
            index = index % tableSize;
        }
        return INVALID;
    }

    public void resize(){
        tableSize *= 2;


        Pair[] oldPairs = pairs;
        pairs = new Pair[tableSize];

        // Rehashes all the existing pairs and re-inserts them into the new table
        for(int i = 0; i < tableSize/2; i++){
            if(oldPairs[i] != null){
                add(oldPairs[i].getKey(), oldPairs[i].getValue());
            }
        }
    }

    private int hash(String key) {
        int hash = 0;

        for (int i = 0; i < key.length(); i++){
            hash = (hash * RADIX + key.charAt(i)) % tableSize;
        }
        return hash;
    }
}
