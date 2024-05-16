import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {
    private static final String FILE_LOGGER_NAME =  "StudentFileOutput.txt";

    static {
        try {
            File file = new File(FILE_LOGGER_NAME);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
        } catch(IOException e) {
            System.out.println("Something went wrong" + e);
        }
        /** TODO
         * create a new File object for FILE_LOGGER_NAME
         * if the file already exists, delete it first
         * use try/catch block
         */
    }

    @Override
    public void log (String message) {
        try {
            FileWriter fileWriter = new FileWriter(FILE_LOGGER_NAME, true);
            fileWriter.write(message +"\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.printf("Something went wrong" + e);
        }
        /** TODO
         * create a new FileWriter in append mode
         * write the message to file
         * check the ExpectedOutput files
         * use try-with-resources/catch block
         */
    }
}
