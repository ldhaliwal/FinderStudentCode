public class HashMap {
    int DEFAULT_TABLE_SIZE = 100;
    static final int RADIX = 256;
    int tableSize;
    int numEntries;
    String[] keys;
    String[] values;
    private static final String INVALID = "INVALID KEY";

    public HashMap() {
        tableSize = DEFAULT_TABLE_SIZE;
        keys = new String[tableSize];
        values = new String[tableSize];
        numEntries = 0;
    }

    public void add(String key, String value){
        // Checks if we need to re-size the table
        checkSize();

        int index = hash(key);
        while(keys[index] != null){
            index = (index + 1) % tableSize;
        }
        keys[index] = key;
        values[index] = value;
        numEntries++;
    }

    public String get(String key) {
        int start = hash(key);
        for (int i = start; i < tableSize; i++) {
            if (key.equals(keys[i])) {
                return values[i];
            }
        }
        return INVALID;
    }

    public void checkSize(){
        if ((double) (numEntries/tableSize) >= 0.5){
            resize();
        }
    }

    public void resize(){
        tableSize *= 2;

        String[] oldKeys = keys;
        String[] oldValues = values;

        keys = new String[tableSize];
        values = new String[tableSize];

        for(int i = 0; i < tableSize/2; i++){
            if(oldKeys != null){
                add(oldKeys[i], oldValues[i]);
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
