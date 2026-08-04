class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        func(0,nums,ans);
        return ans;
    }
    private void func(int idx,int[] nums,List<List<Integer>> ans){
        if(idx==nums.length){
            List<Integer> ds=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums,i,idx);
            func(idx+1,nums,ans);
            swap(nums,i,idx);
        }
    }
    private void swap(int[] arr,int s,int e){
        int temp=arr[s];
        arr[s]=arr[e];
        arr[e]=temp;
    }
}