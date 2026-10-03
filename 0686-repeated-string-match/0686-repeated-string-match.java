class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder ans=new StringBuilder();
        int count=0;
        while(ans.length()<B.length()){
            ans.append(A);
            count++;
        }
        if(ans.toString().contains(B)){
            return count;
        }
        ans.append(A);
        count++;
        if(ans.toString().contains(B)){
            return count;
        }
        return -1;
    }
}