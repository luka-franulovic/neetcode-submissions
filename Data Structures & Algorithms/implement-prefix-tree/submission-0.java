class PrefixTree {

    private class TrieNode{
        private HashMap<Character, TrieNode> children = new HashMap<>();
        private boolean word;
    }

    private TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
         root.word = false;
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (cur.children.containsKey(c)){
                cur = cur.children.get(c);
            }
            else{
                cur.children.put(c, new TrieNode());
                cur = cur.children.get(c);
            }
        }
        cur.word = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) return false;
            cur = cur.children.get(c);
        }
        return cur.word;

    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if (!cur.children.containsKey(c)) return false;
            cur = cur.children.get(c);
        }
        return true;
    }
}
