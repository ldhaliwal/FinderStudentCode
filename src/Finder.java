import java.io.BufferedReader;
import java.io.IOException;
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

    private static final String INVALID = "INVALID KEY";

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] columns = line.split(",");
            if (columns.length > Math.max(keyCol, valCol)) {
                String key = columns[keyCol];
                String value = columns[valCol];
                // call something here that inserts the key and values into my made up data type
            }
        }
        br.close();
    }

    public String query(String key){
        // TODO: Complete the query() function!
        long index = hash(key);

        return INVALID;
    }

    public static long hash(String text){
        long hash = 0;

        for(int i = 0; i < text.length(); i++) {
            hash = (hash * RADIX + text.charAt(i)) % PRIME;
        }
        return hash;
    }
}