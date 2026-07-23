class Solution {
    public String removeVowels(String s) {
        StringBuilder result = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (!isVowel(c)) {
                result.append(c);
            }
        }
        
        return result.toString();
    }
    
    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
