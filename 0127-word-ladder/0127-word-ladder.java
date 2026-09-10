class Solution {
    public int ladderLength(String beginWord, String endWord,
                            List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int steps = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int k = 0; k < size; k++) {

                String word = queue.poll();

                if (word.equals(endWord)) {
                    return steps;
                }

                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {

                    char original = chars[i];

                    for (char c = 'a'; c <= 'z'; c++) {

                        chars[i] = c;

                        String newWord = new String(chars);

                        if (set.contains(newWord)) {
                            queue.offer(newWord);

                            set.remove(newWord);
                        }
                    }

                    chars[i] = original;
                }
            }

            steps++;
        }

        return 0;
    }
}