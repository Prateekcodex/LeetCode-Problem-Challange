import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        Map<String, Integer> required = new HashMap<>();

        for (String word : words) {
            required.put(word, required.getOrDefault(word, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        for (int start = 0; start < wordLen; start++) {

            int left = start;
            int right = start;
            int count = 0;

            Map<String, Integer> window = new HashMap<>();

            while (right + wordLen <= s.length()) {

                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (!required.containsKey(word)) {
                    window.clear();
                    count = 0;
                    left = right;
                    continue;
                }

                window.put(
                    word,
                    window.getOrDefault(word, 0) + 1
                );

                count++;

                while (window.get(word) > required.get(word)) {

                    String leftWord =
                        s.substring(left, left + wordLen);

                    window.put(
                        leftWord,
                        window.get(leftWord) - 1
                    );

                    left += wordLen;
                    count--;
                }

                if (count == wordCount) {
                    result.add(left);
                }
            }
        }

        return result;
    }
} 