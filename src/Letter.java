import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Letter {
    private static final String b="абвгдеёжзийклмнопрcтухцчшщъыьэюя";
    public static void main(String[] args) {
        ArrayList<String> element = new ArrayList<>();
        try (Scanner scanner=new Scanner(new BufferedReader(new FileReader("Pushkin")))){
            while (scanner.hasNext()){
             String[]   a=scanner.next().split("");
                for (int i = 0; i <a.length ; i++) {
                    String e=a[i].toLowerCase();
                    if(b.contains(e)) {
                        element.addAll(Collections.singletonList(e));
                    }
                }
            }
            ArrayList<String> letterUnique = new ArrayList<>(new HashSet<>(element));
            System.out.println(letterUnique);
            for (int i = 0; i <letterUnique.size() ; i++) {
                int s=0;
                for (String value: element) {
                    if (letterUnique.get(i).equals(value)) {
                        s++;
                    }
                }
                    System.out.println(letterUnique.get(i) + " " + s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
