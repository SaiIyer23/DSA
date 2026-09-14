class Solution {
    public int repeatedStringMatch(String A, String B) {
        int q;
        StringBuilder S = new StringBuilder(A);
        for (q=1; S.length() < B.length(); q++) S.append(A);
        if (S.indexOf(B) >= 0) return q;
        if (S.append(A).indexOf(B) >= 0) return q+1;
        return -1;
    }
}