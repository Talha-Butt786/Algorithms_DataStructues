import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class File_Reader {
    public static void main(String[] args) {
        try {
            File myObj,myObj1;
            myObj = new File("src/path1000d.ans");
            myObj1 = new File("src/data.txt");
            Scanner myReader = new Scanner(myObj);
            Scanner myreder = new Scanner(myObj1);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String data1 = myreder.nextLine();
                if(!data.equals(data1)) {
                    System.out.println("could not match");
                    break;
                }
                System.out.println("matched");
            }
            myReader.close();
            myreder.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
