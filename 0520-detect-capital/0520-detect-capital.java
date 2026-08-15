class Solution {
    public boolean detectCapitalUse(String word) {

        int capitalCount = 0;

        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                capitalCount++;
            }
        }

        return capitalCount == 0 ||
               capitalCount == word.length() ||
               (capitalCount == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
