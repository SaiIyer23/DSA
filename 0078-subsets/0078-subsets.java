class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        func(nums,0,ds,ans);
        return ans;
    }
    public static void func(int[] nums,int idx,List<Integer> ds,List<List<Integer>> ans){
        if(idx==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[idx]);
        func(nums,idx+1,ds,ans);
        ds.removeLast();
        func(nums,idx+1,ds,ans);

    }
}