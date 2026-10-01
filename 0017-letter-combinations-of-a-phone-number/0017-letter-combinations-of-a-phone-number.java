class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits.length()==0)return res;
        String[] phone={"","","abc", "def","ghi", "jkl", "mno","pqrs", "tuv", "wxyz"};
        func(digits,0,"",res,phone);
        return res;
    }
    public static void func(String digits,int idx,String current,List<String>res,String[] phone){
        if(idx==digits.length()){
            res.add(current);
            return;
        }
        String letters=phone[digits.charAt(idx)-'0'];//number hi mil jayega '0' sub krne se, eg. '2'-'0'=2
        for(char c:letters.toCharArray()){
            func(digits,idx+1,current+c,res,phone);
        }

    }
}