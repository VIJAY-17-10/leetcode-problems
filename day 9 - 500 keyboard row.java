import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findWords(String[] words) {
        // Map characters to their row number (0-indexed or 1-indexed)
        int[] charToRow = new int[26];
        
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        for (char c : row1.toCharArray()) charToRow[c - 'a'] = 1;
        for (char c : row2.toCharArray()) charToRow[c - 'a'] = 2;
        for (char c : row3.toCharArray()) charToRow[c - 'a'] = 3;

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String lower = word.toLowerCase();
            int targetRow = charToRow[lower.charAt(0) - 'a'];
            boolean isValid = true;

            for (int i = 1; i < lower.length(); i++) {
                if (charToRow[lower.charAt(i) - 'a'] != targetRow) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}
