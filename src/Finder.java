import java.io.BufferedReader;
import java.io.IOException;
/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 **/

public class Finder {

    private static final String INVALID = "INVALID KEY";

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        String line;
        while ((line = br.readLine()) != null) {
            String[] columns = line.split(",");
            if (columns.length > Math.max(keyCol, valCol)) {
                String key = columns[keyCol].trim();
                String value = columns[valCol].trim();
                // call something here that inserts the key and values into my made up data type
            }
        }
        br.close();
    }

    public String query(String key){
        // TODO: Complete the query() function!
        return INVALID;
    }

    // definitely going to need a hash function at some point
}