// International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
//
// For convenience, the full table for the 26 letters of the English alphabet is given below:
//
//
// [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
//
// Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
//
// Return the number of different transformations among all words we have.
//
//
// Example:
// Input: words = ["gin", "zen", "gig", "msg"]
// Output: 2
// Explanation: 
// The transformation of each word is:
// "gin" -> "--...-."
// "zen" -> "--...-."
// "gig" -> "--...--."
// "msg" -> "--...--."
//
// There are 2 different transformations, "--...-." and "--...--.".
//
//
// Note:
//
//
// 	The length of words will be at most 100.
// 	Each words[i] will have length in range [1, 12].
// 	words[i] will only consist of lowercase letters.
//
//


class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        //TIME O(N) worst O(N^2);
        //Space O(set.size);
        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                         "....","..",".---","-.-",".-..","--","-.",
                         "---",".--.","--.-",".-.","...","-","..-",
                         "...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<> ();
        // use String[] to determine each word in morse code
        // for each word use sb to contain the morse code
        // when we finish a word transfer put in to hashset
        // hashset's size mean's unique # of morse code 
        for (String str : words){ //O(N)
            StringBuilder sb = new StringBuilder ();
            for (char c : str.toCharArray()){
                sb.append(MORSE[c - 'a']);//O(1)
            }
            set.add(sb.toString());// average O(1) worst O(N)
        }
        return set.size();
    }
}
