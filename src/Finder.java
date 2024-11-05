import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Liliana Dhaliwal
 **/

public class Finder {
    static final int RADIX = 256;
    static final long PRIME = 2147483647L;
    static final int TABLE_SIZE = 1128889;

    public static HashMap table;

    private static final String INVALID = "INVALID KEY";

    public Finder() {
        table = new HashMap();
    }

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] columns = line.split(",");
            table.add(columns[keyCol], columns[valCol]);
        }
        br.close();
    }

//    public void insert(String key, String value) {
//        long index = hash(key);
//
//        for (Pair entry : table) {
//            if (entry.key.equals(key)) {
//                entry.value = value; // Update existing key
//                return;
//            }
//        }
//    }

    public String query(String key){
        // TODO: Complete the query() function!
        return table.get(key);
    }

//    public static long hash(String text){
//        long hash = 0;
//
//        for(int i = 0; i < text.length(); i++) {
//            hash = (hash * RADIX + text.charAt(i)) % table.tableSize;
//        }
//        return hash;
//    }
}