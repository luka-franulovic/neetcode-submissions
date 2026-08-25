class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == 1 ) return 1;
        int l = 0;
        int r = 0;
        int maxStreak = 0;
        Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
        while (r < s.length()){
            char x = s.charAt(r); // current character
            if (!table.containsKey(x)) table.put(x, 1);
            else table.put(x, table.get(x) + 1);

            char c = mostFrequent(table);
            boolean valid = (r - l + 1) - table.get(c) <= k;
            if (valid){
                maxStreak = Math.max(maxStreak, (r - l + 1));
                r++;
            }
            else{
                while(!valid || table.size() == 0){
                    char rm = s.charAt(l);
                    table.put(rm, table.get(rm) - 1);
                    if (table.get(rm) == 0) table.remove(rm);
                    l++;
                    char newFrequent = mostFrequent(table);
                    valid = (r - l + 1) - table.get(newFrequent) <= k;
                }
                r++;
            }
            
        }
        return maxStreak;
    }
    private char mostFrequent(Hashtable<Character, Integer> table){
        int maxFrequency = 0;
        char frequent = ' ';
        for (char c : table.keySet()){
            if (table.get(c) >= maxFrequency){
                maxFrequency = table.get(c);
                frequent = c;
            }

        }
        return frequent;
    }
    
}
