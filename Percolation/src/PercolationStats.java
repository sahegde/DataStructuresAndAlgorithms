public class PercolationStats {
	private int N;
	private int T;
	private double x[] = new double[T];
	private int openSites = 0;

	public PercolationStats(int N, int T) {
		if(N>=1 && T >=1) {
			this.N = N;
			this.T = T;
			x = new double[T];
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	public double mean() {
		return StdStats.mean(x);
	}

	public double stddev() {
		return StdStats.stddev(x);
	}

	public double confidenceLo() {
		return (mean() - ((1.96 * stddev()) / Math.sqrt(T)));
	}

	public double confidenceHi() {
		return (mean() + ((1.96 * stddev()) / Math.sqrt(T)));
	}

	private void performPercolationLogic() {
		int count = 0;
		while (count < T) {
			Percolation p = new Percolation(N);
			openSites = 0;

			int i = (int) (Math.random() * N) + 1;
			int j = (int) (Math.random() * N) + 1;
			while (true) {
				if (!p.isOpen(i, j)) {
					p.open(i, j);
					openSites++;
				}
				i = (int) (Math.random() * N) + 1;
				j = (int) (Math.random() * N) + 1;
				boolean percolates = p.percolates();
				if(percolates)
					break;
			}
			this.x[count] = (double) openSites / (N * N);
			count++;
		}
	}
	
	public static void main(String[] args) {
		PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		ps.performPercolationLogic();
		
		System.out.println("mean\t\t\t\t= " + ps.mean());
		System.out.println("stddev\t\t\t\t= " + ps.stddev());
		System.out.println("95% confidence interval\t\t= " + ps.confidenceLo()
				+ "," + ps.confidenceHi());
	}

}
