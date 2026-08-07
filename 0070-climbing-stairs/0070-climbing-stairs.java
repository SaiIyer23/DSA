class Solution {
    public int climbStairs(int n) {
        if(n==0||n==1)return 1;
        Map<Integer,Integer> dp=new HashMap<>();
        return solve(n,0,dp);
    }
    private int solve(int n, int stair, Map<Integer,Integer> dp){

    if(stair == n) return 1;
    if(stair > n) return 0;

    if(dp.containsKey(stair))
        return dp.get(stair);

    int one = solve(n, stair + 1, dp);
    int two = solve(n, stair + 2, dp);

    dp.put(stair, one + two);

    return dp.get(stair);
}
}