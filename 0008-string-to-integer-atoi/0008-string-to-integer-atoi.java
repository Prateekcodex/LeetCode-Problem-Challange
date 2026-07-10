class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // Skip leading whitespaces
        while (i < n && Character.isWhitespace(s.charAt(i))) {
            i++;
        }

        // String contains only spaces
        if (i == n) {
            return 0;
        }

        // Check sign
        boolean negative = false;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            negative = true;
            i++;
        }

        long value = 0;

        // Read digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            value = value * 10 + digit;

            if (!negative && value > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (negative && -value < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        if (negative) {
            value = -value;
        }

        return (int) value;
    }
}