class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        Hashtable<Character, Integer> map1 = new Hashtable<Character, Integer>();
        Hashtable<Character, Integer> map2 = new Hashtable<Character, Integer>();
        for (char x : s1.toCharArray()){
            if (!map1.containsKey(x)) map1.put(x, 1);
            else map1.put(x, map1.get(x) + 1);
        }
        for (int i = 0; i < s1.length(); i++){
            char x = s2.charAt(i);
            if (!map2.containsKey(x)) map2.put(x, 1);
            else map2.put(x, map2.get(x) + 1);
        }
        if (map1.equals(map2)) return true;
        for (int i = s1.length(); i < s2.length(); i++){
            char l = s2.charAt(i - s1.length());
            char r = s2.charAt(i);
            map2.put(l, map2.get(l) - 1);
            if (map2.get(l) == 0) map2.remove(l);
            
            if (!map2.containsKey(r)) map2.put(r, 1);
            else map2.put(r, map2.get(r) + 1);
            if (map1.equals(map2)) return true;
        }
        return false;
    }
}
