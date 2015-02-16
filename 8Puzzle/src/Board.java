import java.util.Arrays;


public class Board {
	
	private Board parent;
	public Board getParent() {
		return parent;
	}

	public void setParent(Board parent) {
		this.parent = parent;
	}


	private int [][]tiles;
	public int[][] getTiles() {
		return tiles;
	}

	public void setTiles(int[][] tiles) {
		this.tiles = tiles;
	}


	private int N = 0;	
	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}


	private int movesFromInitialBoard;

	public int getMovesFromInitialBoard() {
		return movesFromInitialBoard;
	}

	public void setMovesFromInitialBoard(int movesFromInitialBoard) {
		this.movesFromInitialBoard = movesFromInitialBoard;
	}


	private int [][]absoluteBoard;

	public void setAbsoluteBoard() {
		absoluteBoard = new int[N][N];
		int count = 1;
    	for (int i = 0; i <N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(i == N-1 && j == N-1)
    				count = 0;
    			absoluteBoard[i][j] = count++;
    		}
		}
	}

	public Board(int[][] tiles) {
		this.tiles = tiles;
		this.N = tiles.length;
		setAbsoluteBoard();
	}
	    
    public int hamming()  {
    	int count = 0;
    	for (int i = 0; i <N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(j== N-1 && j == N-1)
    				continue;
    			if(tiles[i][j] - absoluteBoard[i][j] != 0) {
    				count++;
    			}
    		}
		}
    	return count;
    }

	public int manhattan()   {
    	int count = 0;
    	for (int i = 0; i <N; i++) {
    		for(int j = 0; j < N; j++) {
    			int val = tiles[i][j];
    			if(val != 0) {
	    			int iVal = (val-1)/N;
	    			int jVal = (val - iVal *N-1);
	    			count = count+ Math.abs(iVal - i) + Math.abs(jVal - j);
    			}
    		}
    	}
    	return count;
    }
    public boolean isGoal()  {
    	return Arrays.deepEquals(this.tiles, absoluteBoard);
    }
    public Board twin()  {
    	int temp = tiles[N-2][N-1];
    	tiles[N-2][N-1] = tiles[N-2][N-2];
    	tiles[N-2][N-2] = temp;
    	
    	return new Board(tiles);
    }
    
    public boolean equals(Object y)   {
    	return this.equals(y);
    }
    
    private int[][] copyFrom(int[][] tiles) {
    	int [][]swapBlocks = new int[N][N];
    	for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				swapBlocks[i][j] = tiles[i][j];
			}
		}
    	return swapBlocks;
    }
    
    public Iterable<Board> neighbors()  {
    	Stack<Board> s = new Stack<Board>();
    	
    	int [][]dataArray = {{-1,0},{1,0},{0,-1},{0,1}};
    	for(int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
				if(this.tiles[i][j] == 0) {
					for(int k = 0; k <4 ; k++) {
						int m = i + dataArray[k][0];
						int n = j + dataArray[k][1];
						if(m < N && n < N && m >=0 && n >=0) {
							int [][] swapBlocks = copyFrom(tiles); 
							int value = tiles[m][n];
							swapBlocks[i][j] = value;
							swapBlocks[m][n] = 0;
							s.push(new Board(swapBlocks));
						}
					}
				}
			}
    	}
    	return s;
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tiles[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }
}
