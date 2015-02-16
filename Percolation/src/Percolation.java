public class Percolation {
	private int grid[][];
	private int N;
	private WeightedQuickUnionUF w;

	private boolean isValidIndex(int i, int j) {
		return (i >= 1 && i <= N && j >= 1 && j <= N);
	}

	private void createVirtualTop(WeightedQuickUnionUF w) {
		for (int i = 1; i <= N; i++) {
			w.union(0, i);
			w.union(N * N + 1, N * N - N + i);
		}
	}

	public Percolation(int N) {
		if(N >=0) {
			grid = new int[N + 1][N + 1];
			this.N = N;
			w = new WeightedQuickUnionUF(N * N + 2);
			createVirtualTop(w);
		} else {
			throw new IndexOutOfBoundsException(
					"row index N out of bounds" + N);
		}

	}

	public boolean isOpen(int i, int j) {
		if (isValidIndex(i, j)) {
			return (grid[i][j] == 1);
		} else {
			throw new IndexOutOfBoundsException(
					"row index i or j out of bounds" + i + " " + j);
		}
	}

	private static int constructUniqueNumber(int i, int j, int N) {
		return i * N + j - N;
	}

	public void open(int i, int j) throws IndexOutOfBoundsException {
		if (isValidIndex(i, j)) {
			grid[i][j] = 1;
			int x = constructUniqueNumber(i, j, N);
			int y = 0;
			int dataArray[][] = { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };

			for (int r = 0; r < 4; r++) {
				int m = i + dataArray[r][0];
				int n = j + dataArray[r][1];
				if (isValidIndex(m, n) && isOpen(m, n)) {
					y = constructUniqueNumber(m, n, N);
					w.union(x, y);
				}
			}
		} else {
			throw new IndexOutOfBoundsException(
					"row index i or j out of bounds");
		}
	}

	public boolean isFull(int i, int j) throws IndexOutOfBoundsException {
		if (isValidIndex(i, j)) {	
			if(isOpen(i, j))
				return w.connected(0, i * N + j - N);
			else
				return false;
		} else {
			throw new IndexOutOfBoundsException(
					"row index i or j out of bounds" + i + " " + j);
		}
	}

	public boolean percolates() {

		if (w.connected(0, N * N + 1)) {
			return true;
		} else {
			return false;
		}
	}
}
