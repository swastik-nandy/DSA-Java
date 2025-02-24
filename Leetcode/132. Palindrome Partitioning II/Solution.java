class Solution {
    public int minCut(String s) {
        int n = s.length();

        int[] c = new int[n + 1];  // Array to store the minimum cuts required for the substring up to index i
       

for (int i = 0; i <= n; i++) c[i] = i - 1;  // Initialize the cuts array : worst case, each character is a seperate palindrome
                                            // i-1 means no cut needed for empty string 

        for (int mid = 0; mid < n; mid++) {  // iterate over each character to expand around it (odd and even length palindromes)
            expand(s, c, mid, mid);    // check for odd length palindromes 
            expand(s, c, mid, mid + 1);  // check for even length palindromes
        }
        return c[n];
    }

    private void expand(String s, int[] c, int l, int r) {
        int n = s.length();

        // Expand outwards as long as it is a palindrome
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {  // Update Minimum cut required at position
            c[r + 1] = Math.min(c[r + 1], c[l] + 1);

            // Expand further
            l--; 
            r++;
        }
    }
}
