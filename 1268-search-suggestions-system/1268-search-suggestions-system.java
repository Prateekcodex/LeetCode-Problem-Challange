import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
    }

    TrieNode root = new TrieNode();

    public List<List<String>> suggestedProducts(
            String[] products, String searchWord) {

        Arrays.sort(products);

        // Build Trie
        for (String product : products) {
            insert(product);
        }

        List<List<String>> result = new ArrayList<>();
        TrieNode current = root;

        for (char c : searchWord.toCharArray()) {

            int index = c - 'a';

            if (current != null && current.children[index] != null) {
                current = current.children[index];
                result.add(current.suggestions);
            } else {
                current = null;
                result.add(new ArrayList<>());
            }
        }

        return result;
    }

    private void insert(String word) {

        TrieNode current = root;

        for (char c : word.toCharArray()) {

            int index = c - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];

            // Store at most 3 suggestions
            if (current.suggestions.size() < 3) {
                current.suggestions.add(word);
            }
        }
    }
}