class Solution {
    public int beautySum(String s) {
        int n=s.length();
        int res=0;
        for(int i=0;i<n;i++){
            int[] freq=new int[26];
            for(int j=i;j<n;j++){
                int value=s.charAt(j)-'a';
                freq[value]++;

                int max=Integer.MIN_VALUE;
                int min=Integer.MAX_VALUE;
                
                for(int k=0;k<26;k++){
                    int curr=freq[k];
                    
                    if(curr>0){
                        max=Math.max(max,curr);
                        min=Math.min(min,curr);
                    }
                }
                res+=(max-min);
            }
        }
        return res;
    }
}