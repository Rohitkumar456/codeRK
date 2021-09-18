public class NQueens {
    int N;
    int[] columnHash;
    int[] leftUpDiagonalHas;
    int[] rightUpDiagonalHash;
    int count=0;
    public static void main(String[] args) {
        NQueens Nq = new NQueens();
        Nq.N = 4;
        Nq.columnHash = new int[Nq.N];
        Nq.leftUpDiagonalHas = new int[2*Nq.N];;
        Nq.rightUpDiagonalHash = new int[2*Nq.N];



        int[][] board = new int[Nq.N][Nq.N];
        boolean ans = Nq.NqueenUtil(board, 0);
        System.out.print(Nq.count);
    }


    public boolean NqueenUtil(int [][] board,int row){
        if(row==N) {count++;return true;}

        for(int col=0;col<N;col++){
            if(isSafe2(board,row,col)){
                board[row][col] = 1;

                columnHash[col]=1;
                rightUpDiagonalHash[row+col]=1;
                leftUpDiagonalHas[row-col+N]=1;

                // if(NqueenUtil(board,row+1)){
                //     return true;
                // }
                NqueenUtil(board,row+1);                    // this will find all possible solutions and we can count
                board[row][col] = 0;
                columnHash[col]=0;
                rightUpDiagonalHash[row+col]=0;
                leftUpDiagonalHas[row-col+N]=0;                //BACKTRACKING :- UNDOING our decision
            }
                
        }

        return false;
    }

    public boolean isSafe2(int[][] board,int row, int col){                 // O(1) Time complexity function

        if(columnHash[col]==1) return false;

        if(rightUpDiagonalHash[row+col]==1) return false;                   // this will give upper right diagonal vale as the sum(row+col) will always same
    
        if(leftUpDiagonalHas[row-col+N]==1) return false;                   // this will give upper left diagonal vale as the diff(row-col) will always same

        return true;

    }

    public boolean isSafe1(int[][] board,int row,int col){                  // O(n) Time complexity function

        for(int i=row-1;i>=0;i--){
            if(board[i][col]==1) return false;
        }

        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]==1) return false;
        }

        for(int i=row-1,j=col+1;i>=0&&j<N;i--,j++){
            
            if(board[i][j]==1) return false;
        }

        return true;
    }
    
}
