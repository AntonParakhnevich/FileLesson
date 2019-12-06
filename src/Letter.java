import java.io.*;
import java.util.*;

import static java.util.Collections.sort;

public class Letter {
    private static final String alphabet="абвгдеёжзийклмнопрcтухцчшщъыьэюя";
    private static final File text=new File("Pushkin");

    public static void main(String[] args) {
        File file= new File("letter.txt");
        List<String> letters = element();
        writeToFile(quantityLetter(letters),file);
    }

    private static List<String> quantityLetter(List<String> list){

            List<String> letterUnique= new ArrayList<>();
            List<String> letter = new ArrayList<>(new HashSet<>(list));
        for (String item : letter) {
            int s = 0;
            for (String value : list) {
                if (item.equals(value)) {
                    s++;
                }
            }
            letterUnique.add(item + " " + s);
        }
        return letterUnique;
    }

    private static List<String> element(){
        List<String> letters = new ArrayList<>();
        try (Scanner scanner=new Scanner(new BufferedReader(new FileReader(Letter.text)))){
            while (scanner.hasNext()){
                String[]   word=scanner.next().split("");
                for (String s : word) {
                    String letter = s.toLowerCase();
                    if (alphabet.contains(letter)) {
                        letters.addAll(Collections.singleton(letter));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return letters;
    }

    private static void writeToFile(List<String> list, File file){
        try(PrintWriter printWriter=new PrintWriter(new BufferedWriter(new FileWriter(file)))){
            for (String s : list) {
                printWriter.write(s + " " + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
