class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Hashtable<String, List<String>> table = new Hashtable<String, List<String>>();
        for (int i = 0; i < strs.length; i++){
            int[] count = new int[26];
            for (int j = 0; j < strs[i].length(); j++){
                count[(int)strs[i].charAt(j) - (int)'a'] += 1;
            }
            String key = Arrays.toString(count);
            if (table.containsKey(key)){
                List<String> tmp = table.get(key);
                tmp.add(strs[i]);
                table.put(key, tmp);
            }
            else {
                ArrayList<String> tmp = new ArrayList<String>();
                tmp.add(strs[i]);
                table.put(key, tmp);
            }

        }
        return new ArrayList<>(table.values());
    }
}
