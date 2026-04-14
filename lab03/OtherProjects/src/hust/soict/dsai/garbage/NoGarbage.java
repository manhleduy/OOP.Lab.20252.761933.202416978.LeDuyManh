package hust.soict.dsai.garbage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class NoGarbage {
    public static void main(String[] args) throws IOException {

        // Assuming 'OtherProjects' is your project root in IntelliJ
        String filename = "src/hust/soict/dsai/garbage/test.exe";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        StringBuilder outputString =  new StringBuilder();
        for ( byte b: inputBytes){
            outputString.append((char)b);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime- startTime);

    }
}