// Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
//
// You may return the answer in any order.
//
//  
//
//
// Example 1:
//
//
// Input: ["bella","label","roller"]
// Output: ["e","l","l"]
//
//
//
// Example 2:
//
//
// Input: ["cool","lock","cook"]
// Output: ["c","o"]
//
//
//  
//
// Note:
//
//
// 	1 <= A.length <= 100
// 	1 <= A[i].length <= 100
// 	A[i][j] is a lowercase letter
//
//
//


class Solution {
    public List<String> commonChars(String[] A) {
        // use a letter arr to represent every leeter # in String
        // compare same col and add the min # which >= 1 into res;
        // Time O(2N)
        // Space O(N)
        List<String> res = new ArrayList<>();
        int [][] dict = new int[A.length][26];
        // creat the dict for ever string;
        for(int i = 0 ; i<A.length;i++){
            for(int j = 0; j < A[i].length();j++){
                int index = A[i].charAt(j) - 'a';
                dict[i][index]++;
            }
        }
        for(int j = 0; j < dict[0].length; j++){
            int x = 0;
            int count = Integer.MAX_VALUE;
            while( x < dict.length -1){
                //check same col element, get the min # which greater than 0
                if(dict[x][j] !=0 && dict[x+1][j]!=0){
                    count = Math.min(count, Math.min(dict[x][j], dict[x+1][j]));
                     x++;
                } else {
                    break;
                }             
            }
            if (x == dict.length -1){
                // unless the last one is not 0 
                // add the letter into res based the min count
                for (int i =0; i <count;i++){
                    StringBuilder sb = new StringBuilder();
                    char temp = (char) (j+'a');
                    sb.append(temp);
                    res.add(sb.toString());  
                }
            }
        }
        return res;
    }
}
