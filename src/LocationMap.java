import java.io.*;
import java.util.*;

//class that behaves like a map
public class LocationMap implements Map<Integer, Location> {

    private static final String LOCATIONS_FILE_NAME =  "locations.txt";
    private static final String DIRECTIONS_FILE_NAME =  "directions.txt";

    static HashMap<Integer, Location> locationHashMap = new HashMap<Integer, Location>();
    /** TODO
     * create a static locations HashMap
     */
    static {
        FileLogger fileLogger = new FileLogger();
        /** TODO
         * create a FileLogger object
         */
        ConsoleLogger consoleLogger = new ConsoleLogger();
        /** TODO
         * create a ConsoleLogger object
         */
        try {
            FileReader fileReader = new FileReader(LOCATIONS_FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            fileLogger.log("Available locations:");
            consoleLogger.log("Available locations:");
            while ((line = bufferedReader.readLine()) != null) {
                StringBuilder sb = new StringBuilder();
                String[] eLine = line.split(",", 2);
                if (eLine.length >= 2) {
                    int loc = Integer.parseInt(eLine[0]);
                    String desc = eLine[1];
                    String message = String.valueOf(sb.append(loc).append(": ").append(desc));
                    fileLogger.log(message);
                    consoleLogger.log(message);
                    Location tempLoc = new Location(loc, desc, new HashMap<String, Integer>());
                    locationHashMap.put(loc, tempLoc);
                }
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fileReader = new FileReader(DIRECTIONS_FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            fileLogger.log("Available directions:");
            consoleLogger.log("Available directions:");
            while ((line = bufferedReader.readLine()) != null) {
                String[] eLine = line.split(",", 3);
                if (eLine.length >= 3) {
                    int pos1;
                    String pos2;
                    int pos3;
                    pos1 = Integer.parseInt(eLine[0]);
                    pos2 = eLine[1];
                    pos3 = Integer.parseInt(eLine[2]);
                    String eachLine = pos1 + ": " + pos2 + ": " + pos3;
                    fileLogger.log(eachLine);
                    consoleLogger.log(eachLine);
                    locationHashMap.get(pos1).addExit(pos2, pos3);
                }
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /** TODO
         * Read from LOCATIONS_FILE_NAME so that a user can navigate from one location to another
         * use try-with-resources/catch block for the FileReader
         * extract the location and the description on each line
         * print all locations and descriptions to both console and file
         * check the ExpectedOutput files
         * put the location and a new Location object in the locations HashMap, using temporary empty hashmaps for exits
         */

        /**TODO
         * Read from DIRECTIONS_FILE_NAME so that a user can move from A to B, i.e. current location to next location
         * use try-with-resources/catch block for the FileReader
         * extract the 3 elements  on each line: location, direction, destination
         * print all locations, directions and destinations to both console and file
         * check the ExpectedOutput files
         * add the exits for each location
         */

    }

    /**TODO
     * implement all methods for Map
     * @return
     */
    @Override
    public int size() {
        //TODO
        return locationHashMap.size();
    }

    @Override
    public boolean isEmpty() {
        //TODO
        return locationHashMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        //TODO
        return locationHashMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //TODO
        return locationHashMap.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        //TODO
        return locationHashMap.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        //TODO
        return locationHashMap.put(key,value);
    }

    @Override
    public Location remove(Object key) {
        //TODO
        return locationHashMap.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        //TODO
    }

    @Override
    public void clear() {
        //TODO
    }

    @Override
    public Set<Integer> keySet() {
        //TODO
        return locationHashMap.keySet();
    }

    @Override
    public Collection<Location> values() {
        //TODO
        return locationHashMap.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        //TODO
        return locationHashMap.entrySet();
    }
}
