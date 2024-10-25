#include <iostream>
#include <vector>

// Function to solve the 0/1 Knapsack problem
int knapsack(int W, std::vector<int>& weights, std::vector<int>& values) {
    int n = weights.size();  // Number of items

    // Create a 2D array to store the dynamic programming table
    std::vector<std::vector<int>> dp(n + 1, std::vector<int>(W + 1, 0));

    // Fill the dynamic programming table
    for (int i = 0; i <= n; i++) {
        for (int w = 0; w <= W; w++) {
            if (i == 0 || w == 0) {
                // Base case: If there are no items or no capacity, the value is 0.
                dp[i][w] = 0;
            } else if (weights[i - 1] <= w) {
                // If the current item can fit in the knapsack:
                // Calculate the maximum value either by including or excluding the current item.
                dp[i][w] = std::max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
            } else {
                // If the current item is too heavy to fit, we can't include it.
                // So, the maximum value is the same as if we didn't include it.
                dp[i][w] = dp[i - 1][w];
            }
        }
    }

    // The final value in the dynamic programming table is the maximum value that can be obtained.
    return dp[n][W];
}

int main() {
    // Define the values and weights of the items
    std::vector<int> values = {60, 100, 120};
    std::vector<int> weights = {10, 20, 30};
    int W = 50;  // Maximum weight the knapsack can hold

    // Call the knapsack function to calculate the maximum value
    int maxValue = knapsack(W, weights, values);

    // Print the maximum value that can be obtained
    std::cout << "Maximum value in the knapsack: " << maxValue << std::endl;

    return 0;
}
