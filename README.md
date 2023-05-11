## Secret-Messages
This algorithm utilizes dynamic programming to decipher two strings and find the longest common subsequence (LCS) between them. The implementation is designed to provide efficient results, returning the LCS in under 1 second.

# Algorithm Description
The algorithm follows these steps:

1.  Accepts two input strings, let's call them string1 and string2.
2.  Creates a table, dp_table, with dimensions len(string1) + 1 rows and len(string2) + 1 columns to store intermediate results.
3.  Initializes the first row and column of the dp_table with zeros.
4.  Iterates over the characters of string1 and string2 using two nested loops.
5.  If the current characters of string1 and string2 are equal, the corresponding entry in dp_table is set to the value of the diagonal entry (top-left) plus one.
6.  Otherwise, the corresponding entry in dp_table is set to the maximum value between the entry above and the entry to the left.
7.  After completing the iteration, the bottom-right entry of dp_table contains the length of the LCS.
8.  To obtain the LCS itself, backtracking is performed starting from the bottom-right entry of dp_table. If the current characters of string1 and string2 are equal, the character is appended to the LCS, and the current position moves diagonally (top-left) in dp_table. Otherwise, the current position moves to the left or above, depending on the greater value in dp_table.
9.  Finally, the LCS is returned as the result of the algorithm.


# Performance
The algorithm has been optimized for efficiency and is capable of finding the LCS in under 1 second for most inputs. However, the exact performance may vary depending on the length and content of the input strings.

# Usage
To use this algorithm, follow these steps:

1.  Provide two strings, string1 and string2, as input.
2.  Call the algorithm, passing the input strings.
3.  The algorithm will return the longest common subsequence (LCS) of the input strings.
