import com.sun.jdi.Value;

import java.io.*;
import java.util.*;

import static java.util.Collections.*;

public class Number {
    private static final File numbers = new File("number.txt");
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> randomNumb = new ArrayList<>();
        for (int element = 0; element < 10; element++) {
            randomNumb.add(element, random.nextInt(100));
        }
        try (PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(numbers)))) {

            sort(randomNumb);
            for (int number : randomNumb) {
                printWriter.write(number + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}