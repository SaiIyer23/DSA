class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;

        // Step 1: Count frequency of each number
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // bucket[i] stores numbers having frequency i
        List<Integer>[] bucket = new ArrayList[n + 1];

        for (int key : map.keySet()) {

            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] ans = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {

            if (bucket[i] != null) {
                for (int num : bucket[i]) {

                    ans[index++] = num;
                    if (index == k)
                        break;
                }
            }
        }

        return ans;
    }
}