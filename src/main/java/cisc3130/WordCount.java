/*
Matan Maimoni
CISC3130
Assignment 3

 use: java WordCount "One_More_Time.txt"
*/



import java.util.*;
import java.io.*;

public class WordCount {
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
      // Create a list from elements of HashMap
      List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

      // Sort the list
      Collections.sort(list, new java.util.Comparator<Map.Entry<String, Integer> >() {
       public int compare(Map.Entry<String, Integer> o1,
                          Map.Entry<String, Integer> o2) {
         return (o2.getValue()).compareTo(o1.getValue());
       }
      });

      // put data from sorted list to hashmap
      HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
      for (Map.Entry<String, Integer> aa : list) {
       temp.put(aa.getKey(), aa.getValue());
      }
      return temp;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // open the file
        Scanner console = new Scanner(System.in);
        String fileName = args[0];
        Scanner input = new Scanner(new File(fileName));

        // count occurrences
        HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();
        while (input.hasNext()) {                    //removes punctuation symbols
            String next = input.next().toLowerCase().replace(",","").replace(".","").replace("?","").replace("!","").replace("(","").replace(")","").replace(";","").replace(":","").replace("-",""); 
            if (!wordCounts.containsKey(next)) {
              wordCounts.put(next, 1);
            } else {
                wordCounts.put(next, wordCounts.get(next) + 1);
            }
        }
        
        System.out.println("Total words = " + wordCounts.size());

        HashMap<String, Integer> sortedMapAsc = sortByValue(wordCounts);

        // Report frequencies
        for (String word : sortedMapAsc.keySet()) {
          int count = sortedMapAsc.get(word);
          System.out.println(count + ":\t" + word);
        }
    }
}

/*
 * Lyrics:

One more time
One more time
One more time
We're gonna celebrate
Oh yeah, all right
Don't stop the dancing
One more time
We're gonna celebrate
Oh yeah, all right
Don't stop the dancing
One more time
We're gonna celebrate
Oh yeah, all right
Don't stop the dancing
One more time
We're gonna celebrate
Oh yeah
One more time
One more time
We're gonna celebrate
Oh yeah, all right
Don't stop the dancing
One more time
We're gonna celebrate
Oh yeah
Don't stop the dancing
One more time
Mmm, you know I'm just feeling
Celebration tonight
Celebrate
Don't wait too late
Mmm, no
We don't stop
You can't stop
We're gonna celebrate
One more time
One more time
One more time
Celebration
You know we're gonna do it right, tonight
Hey! Just feeling
Music's got me feeling the need
Need, yeah
Come on, all right
We're gonna celebrate
One more time
Celebrate and dance so free
Music's got me feeling so free
Celebrate and dance so free
One more time
Music's got me feeling so free
We're gonna celebrate
Celebrate and dance so free
One more time
Music's got me feeling so free
We're gonna celebrate
Celebrate and dance so free
One more time
Music's got me feeling so free
We're gonna celebrate
Celebrate and dance so free
One more time
Music's got me feeling so free
We're gonna celebrate
Celebrate and dance so free
One more time
Music's got me feeling so free
We're gonna celebrate
Celebrate and dance so free
One more time
Music's got me feeling so free
We're gonna celebrate
Celebrate and dance so free
One more time
Music's got me feeling so free
We're gonna celebrate
Celebrate and dance so free
One more time
Music's got me feeling so free
We're gonna celebrate
Celebrate and dance so free
One more time
Music's got me feeling so free
We're gonna celebrate
Celebrate and dance so free
One more time
Music's got me feeling so free
We're gonna celebrate
One more time
Music's got me feeling so free
We're gonna celebrate
Celebrate and dance so free
One more time
Music's got me feeling so free
We're gonna celebrate
Celebrate and dance so free
One more time
Music's got me feeling so free
We're gonna celebrate
Celebrate and dance so free
One more time
Music's got me feeling so free
We're gonna celebrate
Celebrate and dance so free
One more time
Music's got me feeling so free
We're gonna celebrate
Celebrate and dance so free
One more time
Music's got me feeling so free
We're gonna celebrate
Celebrate and dance so free
*/
