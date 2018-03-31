import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Scanner;

/**
 * Represents a Poem to be written in file.
 *
 * @author Paolo T. Inocencion
 * @author www.techinologic.com
 * @version 1.0
 * @since 1.0
 */
public class WritePoem {

    private static final String alphabets = "a b c d e f g h i j k l m n o p q r s t u v w x y z";

    // set poem content here
    private static final String myPoem =
            "Sweet Little Angel by B.B. King \n\n" +
                    "I've got a sweet little angel \n" +
                    "I love the way she spread her wings \n" +
                    "Yes got a sweet little angel \n" +
                    "I love the way she spread her wings \n" +
                    "Yes, when she spreads her wings around me \n" +
                    "I get joy, and everything \n" +

                    "You know I asked my baby for a nickel \n" +
                    "And she gave me a $20 bill \n" +
                    "Oh yes, I asked my baby for a nickel \n" +
                    "And she gave me a $20 bill \n" +
                    "Whoah, you know I ask her to buy a little drink of liquor \n" +
                    "And she gave me a whiskey still \n" +

                    "Oh, if my baby should quit me \n" +
                    "I believe I would die \n" +
                    "Oh if my baby should quit me \n" +
                    "Lord I do believe I would die \n" +
                    "Yes if you don't love me little angel \n" +
                    "Please tell me the reason why \n\n" +
                    "Writer(s): Jules Bihari, Riley B. King \n\n";

    /**
     * Represents the file's path
     */
    private static String userFilePath = "";
    /**
     * Represents the filename
     */
    private static String userFileName = "";

    /**
     * Method to write all the alphabets in a file.
     *
     * @return void
     */
    public static void writeAlphabetsToFile() {

        try {
            Files.write(Paths.get(userFilePath + userFileName),
                    alphabets.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method writes the filename, filepath, filesize, date of creation,
     * and the poem string in a file.
     * <p>
     * It builds and combines all the file details above using the
     * StringBuilder class, creates a new file in a user-defined file path
     * and named using a user-defined filename then appends the myPoem
     * string defined above.
     *
     * Issue: Need a better way to get the file size of the file.
     * The one I used is quite accurate but done in a lazy way.
     *
     * @return void
     */
    public static void writePoemToFile() {

        StringBuilder sb = new StringBuilder();
        Date date = new Date();

        String filename = "File name: " + userFileName + "\n";
        String filepath = "File path: " + userFilePath + "\n";
        int myPoemDigits = String.valueOf(myPoem.length()).length();
        String filebyte = "File size:  bytes\n";
        String filedate = "Date created: " + date + "\n\n";

        int size = filename.length() + filepath.length() + filedate.length()
                + filebyte.length() + myPoem.length() + myPoemDigits;
        String fileSize = "File size: " + size + " bytes\n";

        sb.append(filename);
        sb.append(filepath);
        sb.append(fileSize);
        sb.append(filedate);

        try {
            Files.write(Paths.get(userFilePath + userFileName),
                    sb.toString().getBytes());
            Files.write(Paths.get(userFilePath + userFileName),
                    myPoem.getBytes(),StandardOpenOption.APPEND);

            System.out.println("File '" + userFileName + "' created.\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method prints the all the contents of the filename
     * created (userFilename) with exception handling.
     * <p>
     * The method uses the BufferedReader class to read a file,
     * and saves and append the read bytes into a StringBuilder class.
     * Print successfully printed if there are no errors.
     *
     * @throws IOException
     */
    public static void printFileContents() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(userFileName));
        System.out.println("Printing '" + userFileName + "'...\n");
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            System.out.println(sb.toString());
            System.out.println("File '" + userFileName + "' successfully printed.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
    }

    /**
     * This method prompts the user for the file
     * path using the Scanner class, then saves
     * the path of the filename to be created
     * into the variable called 'userFilePath'.
     *
     */
    public static void setUserFilePath() {
        System.out.print("Please enter the file path: ");
        System.out.println("e.g. /Users/pbtin/IdeaProjects/PoemWriter/");
        Scanner sc = new Scanner(System.in);
        userFilePath = sc.nextLine();
    }

    /**
     * This method prompts the user for the file
     * name using the Scanner class, then saves
     * the userinput into the variable called
     * 'userFileName'.
     *
     */
    public static void setUserFileName() {
        System.out.print("Please enter the file name: ");
        Scanner sc = new Scanner(System.in);
        userFileName = sc.nextLine();
    }

    /**
     * Standard getter for the userFilePath.
     *
     * @return userFilePath, generated by the
     * setUserFilePath() method.
     */
    public static String getUserFilePath() {
        return userFilePath;
    }

    /**
     * Standard getter for the userFileName.
     *
     * @return userFileName, generated by the
     * setUserFileName() method.
     */
    public static String getUserFileName() {
        return userFileName;
    }
}
