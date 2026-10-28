class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> mappings = new HashMap<Character, String>();
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        populateMap(mappings);
        helper(0, digits, result, current, mappings);
        return result;
    }
    private void helper(int i, String digits, List<String> result, StringBuilder current, HashMap<Character, String> mappings)
    {
        if (current.length() == digits.length())
        {
            if (current.length() > 0)
                result.add(current.toString());
            return;
        }
        String mappingOfCurrent = mappings.get(digits.charAt(i));
        for (int j = 0; j < mappingOfCurrent.length(); j++)
        {
            current.append(mappingOfCurrent.charAt(j));
            helper(i + 1, digits, result, current, mappings);
            current.deleteCharAt(current.length() - 1);
        }

    }
    private void populateMap(HashMap<Character, String> mappings)
    {
        mappings.put('2', "abc");
        mappings.put('3', "def");
        mappings.put('4', "ghi");
        mappings.put('5', "jkl");
        mappings.put('6', "mno");
        mappings.put('7', "pqrs");
        mappings.put('8', "tuv");
        mappings.put('9', "wxyz");
    }
}
