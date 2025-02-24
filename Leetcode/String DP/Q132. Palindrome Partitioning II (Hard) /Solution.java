class Solution {
    public int minCut(String s) {
        int n = s.length();
        
        // Array to store the minimum cuts needed for substrings
        int[] c = new int[n + 1];  
        
        // Initialize the cut array such that c[i] represents the worst-case cuts (i - 1 cuts)
        for (int i = 0; i <= n; i++) c[i] = i - 1;  

        // Iterate through each possible center of a palindrome
        for (int mid = 0; mid < n; mid++) {
            // Expand around a single character (odd-length palindromes)
            expand(s, c, mid, mid);     

            // Expand around two consecutive characters (even-length palindromes)
            expand(s, c, mid, mid + 1);  
        }

        // The final answer is stored in c[n], which represents min cuts for the entire string
        return c[n];
    }

    private void expand(String s, int[] c, int l, int r) {
        int n = s.length();
        
        // Expand while the substring is a palindrome
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            // Update the minimum cuts required at position (r + 1)
            c[r + 1] = Math.min(c[r + 1], c[l] + 1);
            
            // Expand the palindrome boundaries
            l--; 
            r++;
        }
    }
}
