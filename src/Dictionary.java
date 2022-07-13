import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Dictionary {
    //mappa che ha come chiave il carattere dell'alfabeto e come elemento una mappa che ha come chiave una parola
    private TreeMap<Character, TreeMap<String, HashSet<String>>> dictionary;

    //Costruttore
    public Dictionary() {
        dictionary = new TreeMap<>();
        //creo il dizionario vuoto ma già con tutti i caratteri impostati
        for (char c = 'A'; c <= 'Z'; c++)
            this.dictionary.put(c, new TreeMap<>());
    }

    public void insertWord(String word, HashSet<String> meanings) {
        if (meanings != null && meanings.size() > 0) {
            Character firstWordLetter = word.charAt(0);
            //Considero di non aggiungere una parola già esistente
            TreeMap<String, HashSet<String>> wordDetail = this.dictionary.get(firstWordLetter);
            wordDetail.put(word, meanings);
        } else {
            System.out.println("Fornire un insieme di significati valido");
        }
    }

    public void insertMeaningByWord(String word, String meaning) {
        Character firstWordLetter = word.charAt(0);
        HashSet<String> wordMeanings = this.dictionary.get(firstWordLetter).get(word);
        wordMeanings.add(meaning);
    }

    public void print() {
        String output = "";
        for (Character c : this.dictionary.keySet()) {
            TreeSet<String> words = new TreeSet<>();
            for (String word : dictionary.get(c).keySet()) {
                String meanings = String.join("; ", this.dictionary.get(c).get(word));//join concatena con ;
                words.add(word + ": " + "(" + meanings + ")");
            }
            output += c + ": [" + String.join(",", words) + "]\n";
        }
        System.out.println(output);
    }
}
