// Given an array of strings, group anagrams together.
//
// Example:
//
//
// Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Output:
// [
//   ["ate","eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
//
// Note:
//
//
// 	All inputs will be in lowercase.
// 	The order of your output does not matter.
//
//


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs){
            char [] ch = s.toCharArray();
            Arrays.sort(ch);
            String mainLetter = String.valueOf(ch);
            if(!map.containsKey(mainLetter)) {
                map.put(mainLetter, new ArrayList<String>());
            }
            map.get(mainLetter).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
