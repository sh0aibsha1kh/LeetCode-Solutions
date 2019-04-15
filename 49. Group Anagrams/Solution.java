class Solution {
    /**
     * Returns a list of words categorized by having the same anagram.
     * 
     * Go through all the strings and create a unique hashkey for them based on
     * their letter frequency. Map this unique key to an ArrayList of words that
     * have the same character frequency.
     * 
     * Time complexity: O(n * c), where c is the length of the longest string
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = ""; // can be further optimized by using a StringBuilder.
            int[] frequency = new int[26];
            for (char c : s.toCharArray()) {
                frequency[Character.getNumericValue(c) - 10] += 1;
            }
            for (int i = 0; i < frequency.length; i += 1) {
                key += "#";
                key += frequency[i];
            }
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}