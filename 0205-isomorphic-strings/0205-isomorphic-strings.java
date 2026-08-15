import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char a = s.charAt(i);
            char b = t.charAt(i);

            // Check s -> t
            if (mapST.containsKey(a) && mapST.get(a) != b) {
                return false;
            }

            // Check t -> s
            if (mapTS.containsKey(b) && mapTS.get(b) != a) {
                return false;
            }

            mapST.put(a, b);
            mapTS.put(b, a);
        }

        return true;
    }
}