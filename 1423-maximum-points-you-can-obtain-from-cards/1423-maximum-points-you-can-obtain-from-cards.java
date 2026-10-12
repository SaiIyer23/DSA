class Solution {

    // Finds the maximum score by shifting selections between both ends.
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        // Invalid k cannot form a valid selection.
        if (k < 0 || k > n) {
            return -1;
        }

        // Picking no cards gives a score of zero.
        if (k == 0) {
            return 0;
        }

        // Picking all cards requires the complete array sum.
        if (k == n) {
            int total = 0;

            // Add every card because all of them must be selected.
            for (int value : cardPoints) {
                total += value;
            }

            return total;
        }

        int currentScore = 0;

        // Start with all k selected cards taken from the left.
        for (int i = 0; i < k; i++) {
            currentScore += cardPoints[i];
        }

        int maxScore = currentScore;
        int rightIndex = n - 1;

        // Replace one left card with one right card in each step.
        for (int leftIndex = k - 1; leftIndex >= 0; leftIndex--) {
            currentScore -= cardPoints[leftIndex];
            currentScore += cardPoints[rightIndex];
            rightIndex--;

            // Keep the best score after each new split.
            if (currentScore > maxScore) {
                maxScore = currentScore;
            }
        }

        return maxScore;
    }
}
