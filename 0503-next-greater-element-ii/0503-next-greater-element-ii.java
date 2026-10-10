class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] st = new int[2*n];
        int idx = -1;
        for(int i=n-1; i>=0; i--)
            st[++idx] = nums[i];
        int[] res = new int[n];
        for(int i=n-1; i>=0; i--){
            while(idx >=0 && st[idx] <= nums[i])
                idx--;
            if(idx < 0)
                res[i] = -1;
            else 
                res[i] = st[idx];
            st[++idx] = nums[i];
        }
        return res;
    }
}