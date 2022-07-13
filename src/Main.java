import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        HashSet<String> calcioMeanings = new HashSet<>();
        calcioMeanings.add("sport di squadra");
        calcioMeanings.add("Elemento chimico");
        dictionary.insertWord("Calcio", calcioMeanings);
        dictionary.insertMeaningByWord("Calcio", "colpo sferrato con il piede");
        dictionary.print();
    }
}
