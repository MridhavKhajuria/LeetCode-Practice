class Solution {
    public String largestGoodInteger(String num) {
        int result = -1;
        for(int i = 0; i<num.length()-2; i++){
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)){
                result = Math.max(result, num.charAt(i) - '0');
            }
        }
        return (result == -1) ? "" : String.valueOf(result).repeat(3);
    }
}