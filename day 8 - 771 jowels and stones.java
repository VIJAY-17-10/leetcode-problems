import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // Store all jewel types in a HashSet for O(1) lookup
        Set<Character> jewelSet = new HashSet<>();
        for (char j : jewels.toCharArray()) {
            jewelSet.add(j);
        }

        // Count how many stones are in the jewel set
        int count = 0;
        for (char s : stones.toCharArray()) {
            if (jewelSet.contains(s)) {
                count++;
            }
        }

        return count;
    }
}
