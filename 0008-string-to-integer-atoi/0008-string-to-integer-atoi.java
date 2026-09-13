class Solution {
    public int myAtoi(String s) {
        int i=0;
        int res=0;
        int sign=1;
        while(i<s.length() && s.charAt(i)==' '){
            i=i+1;
        }
        if(i<s.length()){
            if(s.charAt(i)=='-'){
                sign=-1;
                i=i+1;
            }else if(s.charAt(i)=='+'){
                i=i+1;
            }
        }
        while(i<s.length() && isDigit(s.charAt(i))){
            int digit=s.charAt(i)-'0';
            if(res==Integer.MAX_VALUE/10){
                if(sign==1){
                    if(digit>=7){
                        return Integer.MAX_VALUE;
                    }
                }else if(sign==-1){
                    if(digit>=8){
                        return Integer.MIN_VALUE;
                    }
                }
            }
            if(res>Integer.MAX_VALUE/10){
                if(sign==1){
                    return Integer.MAX_VALUE;
                }else if(sign==-1){
                    return Integer.MIN_VALUE;
                }
            }
            res=res*10+digit;
            i=i+1;
        }
        return sign*res;
    }
    public boolean isDigit(char c){
        if(c<'0'||c>'9'){
            return false;
        }
        return true;
    }
}