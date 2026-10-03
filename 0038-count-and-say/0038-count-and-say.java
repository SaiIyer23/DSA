class Solution {
    /*
       Builds the next Count and Say term
       from the current term.
    */
    private String buildNextTerm(String currentTerm) {
        // Stores the newly generated term efficiently.
        StringBuilder nextTerm = new StringBuilder();

        // Index is used to scan each group of equal digits.
        int index = 0;

        while (index < currentTerm.length()) {
            // This digit starts the current group.
            char digit = currentTerm.charAt(index);

            // Count stores how many times this digit appears together.
            int count = 0;

            /*
               Keep moving while the same digit continues.
               This collects one complete group.
            */
            while (index < currentTerm.length()
                   && currentTerm.charAt(index) == digit) {
                count++;
                index++;
            }

            nextTerm.append(count).append(digit);
        }

        return nextTerm.toString();
    }

    /*
       Returns the nth Count and Say term
       using the recursive definition.
    */
    public String countAndSay(int n) {
        /*
           The first term is fixed, so recursion
           stops here.
        */
        if (n == 1) {
            return "1";
        }

        // Previous term is needed to build the current term.
        String previousTerm = countAndSay(n - 1);

        return buildNextTerm(previousTerm);
    }
}

class Main {
    public static void main(String[] args) {
        // Driver code starts
        int n = 4;

        Solution obj = new Solution();
        System.out.println(obj.countAndSay(n));
    }
}