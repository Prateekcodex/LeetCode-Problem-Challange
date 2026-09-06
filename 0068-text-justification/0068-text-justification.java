import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();

        int i = 0;

        while (i < words.length) {

            List<String> line = new ArrayList<>();
            int letters = 0;

            while (i < words.length &&
                   letters + words[i].length() + line.size() <= maxWidth) {

                line.add(words[i]);
                letters += words[i].length();
                i++;
            }

            if (i == words.length || line.size() == 1) {
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < line.size(); j++) {
                    if (j > 0) {
                        sb.append(" ");
                    }
                    sb.append(line.get(j));
                }

                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }

                ans.add(sb.toString());
                continue;
            }
 
            int gaps = line.size() - 1;
            
            int totalSpaces = maxWidth - letters;

            int spacesPerGap = totalSpaces / gaps;

            
            int extraSpaces = totalSpaces % gaps;

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < line.size() - 1; j++) {
                sb.append(line.get(j));

                int spaces = spacesPerGap;

                if (j < extraSpaces) {
                    spaces++;
                }

                sb.append(" ".repeat(spaces));
            }

            sb.append(line.get(line.size() - 1));

            ans.add(sb.toString());
        }

        return ans;
    }
}