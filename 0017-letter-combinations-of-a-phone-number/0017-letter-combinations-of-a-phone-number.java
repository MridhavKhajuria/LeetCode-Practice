class Solution {
    String[] keypad = {
        "",     "",     "abc",  "def", "ghi", 
        "jkl",  "mno",  "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;
        helper(digits, 0, "", result);
        return result;
    }

    void helper(String digits, int index, String current, List<String> result){
        if(index == digits.length()){
            result.add(current);
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = keypad[digit];

        for(int i = 0; i<letters.length(); i++){
            char ch = letters.charAt(i);
            helper(digits, index + 1, current + ch, result);
        }
    }
}