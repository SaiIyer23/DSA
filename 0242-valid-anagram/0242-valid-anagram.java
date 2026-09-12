class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        //int[] count=new int[26];
        if(s.length()!=t.length())return false;
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)-1);
        }
        for(int freq:map.values()){
            if(freq!=0){
                return false;
            }
        }
        return true;
    }
}