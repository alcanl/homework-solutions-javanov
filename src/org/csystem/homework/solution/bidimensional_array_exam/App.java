/*----------------------------------------------------------------------------------------------------------------------
	Given a 4 x 4 matrix mat, the initial energy is 100. The task is to reach the last row of the matrix with the maximum possible energy left.

	The matrix can be traversed in the following way:

	1. Start with any cell in the first row.
	2. In each move, traverse from cell (i, j) of the i'th row and j'th column to any existing cell out of (i + 1, j - 1), (i + 1, j) or (i + 1, j + 1).
	3. Finish the traversal in the last row.

	After stepping on a cell (i, j) energy decreases by mat[i][i] units. Find the maximum possible energy left at the end of the traversal.

	Note: The final energy can be negative.

	Example:

		10 20 30 40
		60 50 20 80
		10 10 10 10
		60 50 60 50

	Possible paths:
	0 - based indexing is used.

	(0, 0) - (1, 1) - (2, 2) - (3, 3)
	(0, 1) - (1, 2) - (2, 2) - (3, 2)

	For the first path, energy left = 100 - 10 - 50 - 10 - 50 = -20
	For the second path, energy left = 100 - 20 - 20 - 10 - 60 = -10

	It can be proven that 0 is the maximum energy possible at the end of the traversal so return 0.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.homework.solution.bidimensional_array_exam;

import org.csystem.util.array.ArrayUtil;

import java.util.Scanner;


class App {
	public static void main(String [] args) {
		var kb = new Scanner(System.in);

		var arr = new int[4][4];
		for (int i = 0; i < arr.length; ++i)
			for (int k = 0; k < arr.length; ++k)
				arr[i][k] = kb.nextInt();

		int sum, i, k, n = 0;
		var results = new int[4];

		while (n < 4) {

			sum = arr[0][n];
			i = 0;
			k = n;
			while (true) {

				if (i == 3)
					break;

				if (k == 0) {

					if (arr[i + 1][k] < arr[i + 1][k + 1])
						sum += arr[++i][k];

					else
						sum += arr[++i][++k];

				}
				else if (k == arr.length - 1) {

						if (arr[i + 1][k] < arr[i + 1][k - 1])
							sum += arr[++i][k];
						else
							sum += arr[++i][--k];

				}
					else {

						if (arr[i + 1][k - 1] < arr[i + 1][k] && arr[i + 1][k - 1] < arr[i + 1][k + 1])
							sum += arr[++i][--k];

						else if (arr[i + 1][k] < arr[i + 1][k + 1] && arr[i + 1][k] < arr[i + 1][k - 1])
							sum += arr[++i][k];

						else
							sum += arr[++i][++k];
					}
			}

			results[n++] = sum;
		}

		ArrayUtil.display(results);
		System.out.println(ArrayUtil.min(results));

	}
}


