#include <stdio.h>
#include <stdlib.h>

int tc;
int N;
#define MAX 50
int ARR[MAX][MAX];
int CNT;

#define TRY_MAX MAX*MAX*4
int find(int i, int j, int size) {

	if (i == size || j == size || i < 0 || j < 0)
		return 0;
	if (CNT > TRY_MAX) {
		CNT = 0;
		return 0;
	}

	CNT++;

	if (ARR[i][j] == 1)
		find(i, j+1, size);
	if (ARR[i][j] == 2)
		find(i+1, j, size);
	if (ARR[i][j] == 3)
		find(i, j-1, size);
	if (ARR[i][j] == 4)
		find(i-1, j, size);

	if (ARR[i][j] == 0) {
		CNT = CNT -1; // do not count when the position is 0.0
		return 0;
	}

	return 0;
}

int solve(void) {
	int i, j, k;
	freopen("input.txt", "r", stdin);

	scanf("%d", &tc);

	for (i=0 ; i<tc; i++) {
		scanf("%d", &N);
		for (j=0; j<N; j++) {
			for (k=0; k<N; k++) {
				scanf("%d", &ARR[j][k]);
			}
		}

		find(0, 0, N);
		printf("#%d %d\n", i+1, CNT);
	}
	return EXIT_SUCCESS;
}


int main(void) {
	solve();
	return 0;
}
