import java.util.*;

class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int number = 0;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }

            else if (c == '[') {
                countStack.push(number);
                stringStack.push(current.toString());

                number = 0;
                current = new StringBuilder();
            }

            else if (c == ']') {
                int count = countStack.pop();
                String previous = stringStack.pop();

                StringBuilder decoded = new StringBuilder(previous);

                for (int i = 0; i < count; i++) {
                    decoded.append(current);
                }

                current = decoded;
            }

            else {
                current.append(c);
            }
        }

        return current.toString();
    }
}