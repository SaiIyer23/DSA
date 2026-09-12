class Solution {

    public int firstUniqChar(String s) {

        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++) {

            if(freq[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
//hashmap version(not optimal)
/*class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> count=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(count.containsKey(ch)) {
                count.put(ch, count.get(ch) + 1);
            }
            else {
                count.put(ch, 1);
            }
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(count.get(ch)==1)return i;
        }
        return -1;   
    }
}*/