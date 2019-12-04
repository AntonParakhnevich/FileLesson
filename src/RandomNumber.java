import com.sun.jdi.Value;

import java.io.*;
import java.util.*;

import static java.util.Collections.*;

public class RandomNumber {
    private static final File numbers = new File("numb.txt");
    private static final File sortNumbers = new File("sortNumber.txt");

    public static void main(String[] args) throws IOException {
        Random random = new Random();
        List<Integer> randomNumb = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            randomNumb.add(i,random.nextInt(100));
        }
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(numbers))) {
            for(int b:randomNumb) {
                bufferedWriter.write(b + " ");
            }
            randomNumb.clear();
        }
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(numbers)));
             PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(sortNumbers)))) {
            while (scanner.hasNext()) {
                randomNumb.add(scanner.nextInt());
            }
            sort(randomNumb);
            for (int a : randomNumb) {
                printWriter.write(a + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}