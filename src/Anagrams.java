import java.lang.reflect.Array;
import java.util.*;

public class Anagrams {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("ate", "eat", "tea", "hello", "lleoh", "toll", "ollt","java","bat");
        Map<String, ArrayList> finalMap = new HashMap<String, ArrayList>();

        ArrayList firstList = new ArrayList();
        for (String word : words) {
            Boolean found = false;
            ArrayList innerList = new ArrayList();
            List tmp = customCompare(word, words);
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String newWord = new String(letters);
            if (tmp.size() > 0) {
                found = true;
                innerList.add(tmp);

            } else {
                innerList.add(word);
            }

            if (finalMap.containsKey(newWord)) {
                List present = finalMap.get(newWord);
                if (present.size() == 0) {
                    finalMap.get(newWord).add(innerList);
                }
            } else {
                finalMap.put(newWord, innerList);

            }
        }
        System.out.println("Anagrams List  \n");
        Collection anangramList =  finalMap.values();
        Iterator iter =anangramList.iterator();
        while (iter.hasNext())
        {
            System.out.println(iter.next());
        }
    }

    private static List customCompare(String name, List<String> myList) {
        AnagramHelper anagramHelper = new AnagramHelper();
        List matchedList = new ArrayList();
        for (String word : myList) {
            if (!word.equalsIgnoreCase(name)) {
                if (name.length() == word.length()) {
                    Boolean isWordMatch = anagramHelper.isAnagram(name, word);
                    if (isWordMatch) {
                        if (!matchedList.contains(name)) {
                            matchedList.add(name);
                        }
                        matchedList.add(word);
                    }

                }
            }
        }
        return matchedList;
    }

    }




