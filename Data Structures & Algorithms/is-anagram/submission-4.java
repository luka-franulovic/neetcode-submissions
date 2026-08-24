class Solution {
    public boolean isAnagram(String s, String t) {
        Hashtable<Character, Integer> first = 
        new Hashtable<Character, Integer>();
        Hashtable<Character, Integer> second = 
        new Hashtable<Character, Integer>();
        for (int i = 0; i < s.length(); i++){
            if (first.containsKey(s.charAt(i))){
                int tmp = first.get(s.charAt(i));
                first.put(s.charAt(i), tmp + 1);
            }
            else{
                first.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < t.length(); i++){
            if (second.containsKey(t.charAt(i))){
                int tmp = second.get(t.charAt(i));
                second.put(t.charAt(i), tmp + 1);
            }
            else{
                second.put(t.charAt(i), 1);
            }
        }

        if (s.length() >= t.length()){
            for (int i = 0; i < s.length(); i++){
                if (!first.get(s.charAt(i)).equals(second.get(s.charAt(i)))){
                    return false;
                }
            }
        }
        else{
            for (int i = 0; i < t.length(); i++){
                if (!second.get(t.charAt(i)).equals(first.get(t.charAt(i)))){
                    return false;
                }
            }
        }
        return true;
    }
}
