class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // trailing spaces ko skip karna hai
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // ab last word ko count karna hai
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}