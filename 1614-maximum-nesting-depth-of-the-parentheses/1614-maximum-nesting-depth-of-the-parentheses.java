class Solution {
    public int maxDepth(String s) {
        int cnt=0;
        int maxcount=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                cnt++;
            }else if(s.charAt(i)==')'){
                cnt--;
            }
            maxcount=Math.max(cnt,maxcount);
        }
        return maxcount;
    }
}