// Paolo T. Inocencion
// Coppin CS Coding Challenge SPR2018 #3: Due Monday, April 2, 2018 @ 5pm

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        // creates an instance of the class
        WritePoem writePoem = new WritePoem();

        // prompts user for the file path; see method documentation
        writePoem.setUserFilePath();

        // prompts user for the filename to be created,
        // see method documentation
        writePoem.setUserFileName();


        // writes the poem using the user-defined filename
        // to the user-defined file path
        writePoem.writePoemToFile();

        // prints all the contents of the file created.
        writePoem.printFileContents();

    }


}
