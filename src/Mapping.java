import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Mapping {

    public static final int INITIAL_LOCATION = 95;

    static LocationMap locationMap = new LocationMap();
    /** TODO
     * create a static LocationMap object
     */
    HashMap<String, String> vocabulary = new HashMap<String, String>();
    /** TODO
     * create a vocabulary HashMap to store all directions a user can go
     */
    FileLogger fileLogger = new FileLogger();
    /** TODO
     * create a FileLogger object
     */
    ConsoleLogger consoleLogger = new ConsoleLogger();
    /** TODO
     * create a ConsoleLogger object
     */


    public Mapping() {
        vocabulary.put("QUIT", "Q");
        vocabulary.put("UP", "U");
        vocabulary.put("DOWN", "D");
        vocabulary.put("NORTH", "N");
        vocabulary.put("NORTHEAST", "NE");
        vocabulary.put("NORTHWEST", "NW");;
        vocabulary.put("SOUTH", "S");
        vocabulary.put("SOUTHEAST", "SE");
        vocabulary.put("SOUTHWEST", "SW");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");
        //vocabulary.put("QUIT", "Q"); //example
        /** TODO
         * complete the vocabulary HashMap <Key, Value> with all directions.
         * use the directions.txt file and crosscheck with the ExpectedInput and ExpectedOutput files to find the keys and the values
         */
    }

    public void mapping() {
        Scanner sc = new Scanner(System.in);
        /** TODO
         * create a Scanner object
         */
        int location = INITIAL_LOCATION;
        /**
         * initialise a location variable with the INITIAL_LOCATION
         */

        while (true) {
            fileLogger.log(locationMap.get(location).getDescription());
            consoleLogger.log(locationMap.get(location).getDescription());
            /** TODO
             * get the location and print its description to both console and file
             * use the FileLogger and ConsoleLogger objects
             */
            int exit;
            exit = 0;
            if (location == exit) {
                break;
            }
            /** TODO
             * verify if the location is exit
             */
            Map<String, Integer> mapExit = locationMap.get(location).getExits();
            /** TODO
             * get a map of the exits for the location
             */
            StringBuilder sb = new StringBuilder();
            for (String exits: mapExit.keySet()) {
                sb.append(exits + ", ");
            }
            fileLogger.log("Available exits are " + sb);
            consoleLogger.log("Available exits are " + sb);
            /** TODO
             * print the available exits (to both console and file)
             * crosscheck with the ExpectedOutput files
             * Hint: you can use a StringBuilder to append the exits
             */
            String direction = sc.nextLine().toUpperCase();
            /** TODO
             * input a direction
             * ensure that the input is converted to uppercase
             */
            String emptyString = "";
            boolean canGo;
            canGo = true;
            if (vocabulary.containsKey(direction)) {
                emptyString = vocabulary.get(direction);
                canGo = false;
            }
            else if (vocabulary.containsValue(direction)) {
                emptyString = direction;
                canGo = false;
            }
            else {
                String[] stringArray = direction.split(" ");
                String present = "word";
                for (String j: stringArray) {
                    if (vocabulary.containsKey(j)) {
                        present = j;
                    }
                }
                if (!Objects.equals(present, "word")) {
                    canGo = false;
                    emptyString = vocabulary.get(present);
                }
            }
            if (canGo) {
                fileLogger.log("You cannot go in that direction");
                consoleLogger.log("You cannot go in that direction");
            }
            else if (mapExit.containsKey(emptyString)) {
                location = mapExit.get(emptyString);
            }
            else {
                fileLogger.log("You cannot go in that direction");
                consoleLogger.log("You cannot go in that direction");
            }

            /** TODO
             * are we dealing with a letter / word for the direction to go to?
             * available inputs are: a letter(the HashMap value), a word (the HashMap key), a string of words that contains the key
             * crosscheck with the ExpectedInput and ExpectedOutput files for examples of inputs
             * if the input contains multiple words, extract each word
             * find the direction to go to using the vocabulary mapping
             * if multiple viable directions are specified in the input, choose the last one
             */

            /** TODO
             * if user can go in that direction, then set the location to that direction
             * otherwise print an error message (to both console and file)
             * check the ExpectedOutput files
             */
        }
    }

    public static void main(String[] args) {
        Mapping play = new Mapping();
        play.mapping();
        /**TODO
         * run the program from here
         * create a Mapping object
         * start the game
         */
    }

}
