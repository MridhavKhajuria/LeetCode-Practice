class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, max = 0;

        for(int r = 0; r<s.length(); r++){
            char c = s.charAt(r);
            if(map.containsKey(c)){
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c,r);
            max = Math.max(max, r-left + 1);
        }
        return max;
    }
}