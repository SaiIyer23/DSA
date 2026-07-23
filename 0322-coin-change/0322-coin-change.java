class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,-2);
        return helper(coins,amount,dp); 
    }
    private int helper(int[] coins,int rem,int[] dp){
        
        if(rem==0)return 0;
        if(rem<0)return -1;
        if(dp[rem]!=-2)return dp[rem];
        int mini=Integer.MAX_VALUE;
        for(int coin:coins){
            int res=helper(coins,rem-coin,dp);
            if(res>=0 && res<mini){
                mini=1+res;
            }
        }
        dp[rem]=(mini==Integer.MAX_VALUE)?-1:mini;
        return dp[rem];
    }
}