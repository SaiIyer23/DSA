class Solution {
    public String addStrings(String num1, String num2) {
        int a=num1.length()-1;
        int b=num2.length()-1;
        int carry=0;
        StringBuilder result=new StringBuilder();
        while(a>=0 || b>=0 || carry>0){
            int r1=0;
            int r2=0;
            if(a>=0){
                r1=num1.charAt(a)-'0';
            }
            if(b>=0){
                r2=num2.charAt(b)-'0';
            }
            int sum=r1+r2+carry;
            result.append(sum%10);
            carry=sum/10;
            a--;
            b--;
        }
        return result.reverse().toString();
    }
}