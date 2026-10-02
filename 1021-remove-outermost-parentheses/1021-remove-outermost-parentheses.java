class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder temp=new StringBuilder();
        int value=0;
        int j=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                value+=1;
            }else if(s.charAt(i)==')'){
                value-=1;
            }
            if(value==0){
                temp.append(s.substring(j+1,i));
                j=i+1;
            }
        }
        return temp.toString();
    }
}