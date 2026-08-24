class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        int l = 0;
        int r = 1;
        HashSet<Character> set = new HashSet<Character>();
        set.add(s.charAt(l));
        int streak = 1;
        int maxStreak = 1;
        while (r < s.length()){
            if (!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                streak++;
                maxStreak = Math.max(streak, maxStreak);
                r++;
            }
            else{
                set.remove(s.charAt(l));
                streak--;
                l++;
            }
        }
        return maxStreak;
    }
}
