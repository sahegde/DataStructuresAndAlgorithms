import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solver {
	private List<Board> l = new ArrayList<Board>();
	private List<Board> sol = new ArrayList<Board>();
	private Board initial;
	private List<Board> solutionBoards = new ArrayList<Board>();
	private int numberOfMoves;
	
	private void boardUpdate() {
		solutionBoards = new ArrayList<Board>();
		Board end = sol.get(sol.size()-1);
		System.out.println(sol.get(sol.size()-1));
		Board start = end;
		while(start != initial) {
			solutionBoards.add(start);
			start = start.getParent();
		}
		numberOfMoves = solutionBoards.size() -1;
		
	}
	
	public Solver(Board initial) {
		this.initial = initial;
		MinPQ<Board> pq = new MinPQ<Board>(new CompareManhattan());
		pq.insert(initial);
		initial.setMovesFromInitialBoard(0);
		l.add(initial);
		initial.setParent(initial);
		
		while (!pq.isEmpty()) {
			Board temp = pq.delMin();
			if (temp.isGoal()) {
				sol.add(temp);
				boardUpdate();
				return;
			}
			sol.add(temp);
			Iterable<Board> s = temp.neighbors();
			for (Board board : s) {
				if (!checkIfPresentInList(l, board)) {
					board.setMovesFromInitialBoard(calculateMoves(board,board.getN()));
					board.setParent(temp);
					pq.insert(board);
					l.add(board);
				}
			}
		}
	}

	private int calculateMoves(Board board,int N) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board.getTiles()[i][j] == 0)
					continue;
				if (board.getTiles()[i][j] - initial.getTiles()[i][j] != 0) {
					count++;
				}
			}
		}
		return count;
	}

	private boolean checkIfPresentInList(List<Board> boardList, Board board) {
		int n = board.getN();
		int size = n * n;
		for (Board b : boardList) {
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if ((b.getTiles()[i][j] != board.getTiles()[i][j])) {
						i = n;
						break;
					} else {
						count++;
					}
				}
			}
			if (count == size) {
				return true;
			}
		}
		return false;
	}

	public boolean isSolvable() {
		return true;
	}

	public int moves() {
		return numberOfMoves;
	}

	public Iterable<Board> solution() {
		return solutionBoards;
	}

	public static void main(String[] args) {
		// create initial board from file
		In in = new In(args[0]);
		int N = in.readInt();
		int[][] blocks = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				blocks[i][j] = in.readInt();
			}
		}
		Board initial = new Board(blocks);

		// solve the puzzle
		Solver solver = new Solver(initial);

		// print solution to standard output
		if (!solver.isSolvable())
			StdOut.println("No solution possible");
		else {
			//StdOut.println("Minimum number of moves = " + solver.moves());
			//for (Board board : solver.solution())
				//StdOut.println(board);
		}
	}
}

class CompareManhattan implements Comparator<Board> {

	@Override
	public int compare(Board o1, Board o2) {
		int multipleFactor = 1;
		if ((o1.manhattan()*multipleFactor + o1.getMovesFromInitialBoard()) >= (o2.manhattan()*multipleFactor + o2
				.getMovesFromInitialBoard())) {
			return 1;
		} else if ((o1.manhattan()*multipleFactor + o1.getMovesFromInitialBoard()) < (o2
				.manhattan()*multipleFactor + o2.getMovesFromInitialBoard())) {
			return -1;
		}
		return 0;
	}
}
