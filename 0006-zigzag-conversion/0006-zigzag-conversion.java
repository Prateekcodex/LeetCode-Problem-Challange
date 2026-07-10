class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();

        if(numRows == 1 || len == numRows) return s;

        StringBuilder[] arr = new StringBuilder[numRows];

        for(int i = 0; i < numRows; i++) {
            arr[i] = new StringBuilder("");
        }

        int count = 0;
        int direction = 1;

        for(int i =0; i < len; i++) {
            arr[count].append(s.charAt(i));
            if(count == 0) direction = 1;
            if(count == numRows - 1) direction = -1;
            count += direction;
        }

        StringBuilder ans = new StringBuilder();

        for(StringBuilder sb : arr) {
            ans.append(sb);
        }

        return ans.toString();
    }
}