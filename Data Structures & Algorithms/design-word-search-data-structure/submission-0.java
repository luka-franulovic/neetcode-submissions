class WordDictionary {

    private class TrieNode{
        private HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        private boolean word;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
        root.word = false;
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()){
            if (!cur.children.containsKey(c)) cur.children.put(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.word = true;
    }

    public boolean search(String word) {
        return searchInNode(word, root);
    }

    private boolean searchInNode(String word, TrieNode node) {
        TrieNode cur = node;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : cur.children.values()) {
                    if (searchInNode(word.substring(i + 1), child)) return true;
                }
                return false;
            } else {
                if (!cur.children.containsKey(c)) return false;
                cur = cur.children.get(c);
            }
        }
        return cur.word;
    }
}