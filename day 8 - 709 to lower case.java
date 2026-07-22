class Solution {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            // Check if character is an uppercase letter ('A' through 'Z')
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                // Convert to lowercase by adding 32 (or 'a' - 'A')
                chars[i] = (char) (chars[i] + 32);
            }
        }
        
        return new String(chars);
    }
}
