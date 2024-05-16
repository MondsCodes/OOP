import java.util.LinkedHashMap;
import java.util.Map;

public class Location {
    private final int locationId;
    private final  String description;
    private final Map<String, Integer> exits = new LinkedHashMap<>();


    /** TODO
     * declare private final locationId, description, exits
     */



    public Location(int locationId, String description, Map<String, Integer> exits) {
        this.locationId = locationId;
        this. description = description;
        if (exits != null) {
            exits.put(description, locationId);
        } else {
            exits.put("Q", 0);
        }
        /** TODO
         * set the locationId and the description
         */

        /** TODO
         * if exits are not null, set the exit
         * Note that exits should be of type LinkedHashMap to maintain the insertion order
         * otherwise, set the exits LinkedHashMap to (Q,0)
         */
    }

    protected void addExit(String direction, int location) {
        exits.put(direction, location);
        /** TODO
         * put the direction and the location in the exits LinkedHashMap
         */
    }

    public int getLocationId() {
        return locationId;
        /** TODO
         * complete getter to return the location id
         */
    }

    public String getDescription() {
        return description;
        /** TODO
         * complete getter to return the description
         */
    }

    public Map<String, Integer> getExits() {
        return this.exits;
        /** TODO
         * complete getter to return a copy of exits
         * (preventing modification of exits from outside the Location instance)
         */
    }
}
