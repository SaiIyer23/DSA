class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String previousString=countAndSay(n-1);
        return buildNextString(previousString);
    }
    public static String buildNextString(String s){
        StringBuilder newString=new StringBuilder();
        int index=0;
        while(index<s.length()){
            char digit=s.charAt(index);
            int count=0;
            while(index<s.length() && s.charAt(index)==digit){
                index++;
                count++;
            }
            newString.append(count).append(digit);
        }
        return newString.toString();
    }
}