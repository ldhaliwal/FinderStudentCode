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

    public String query(String key){
        return table.get(key);
    }
}