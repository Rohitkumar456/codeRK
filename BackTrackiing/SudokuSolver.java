


public class SudokuSolver {
    int N;
    int count=0;
    public static void main(String[] args) {
        SudokuSolver ss = new SudokuSolver();
        ss.N = 9;
         int[][] sudoku = { {5, 3, 0, 0, 7, 0, 0, 0, 0}, 
                            {6, 0, 0, 1, 9, 5, 0, 0, 0}, 
                            {0, 9, 8, 0, 0, 0, 0, 6, 0}, 
                            {8, 0, 0, 0, 6, 0, 0, 0, 3}, 
                            {4, 0, 0, 8, 0, 3, 0, 0, 1}, 
                            {7, 0, 0, 0, 2, 0, 0, 0, 6}, 
                            {0, 6, 0, 0, 0, 0, 2, 8, 0}, 
                            {0, 0, 0, 4, 1, 9, 0, 0, 5}, 
                            {0, 0, 0, 0, 8, 0, 0, 7, 9} };
        boolean ans = ss.solve(sudoku,0,0);
        ss.print(sudoku);
        System.out.println(ans);
    }


    public boolean solve(int[][] sudoku,int row,int col){

        // if(row>=N) return true;
        if(row==N-1&& col==N) return  true;

        if(col==N){
            row++;
            col=0;
        }

        if(sudoku[row][col]!=0){
            return solve(sudoku, row, col+1);
        }

        for(int num=1;num<=9;num++){
            if(isSafe(sudoku,row,col,num)){
                sudoku[row][col] = num;
                if(solve(sudoku,row,col)){
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }            
        return false;
    }

    public boolean isSafe(int[][] sudoku, int row, int col, int num){

        for(int i=0;i<N;i++){
            if(sudoku[row][i]==num) return false;
        }

        for(int i=0;i<N;i++){
            if(sudoku[i][col]==num) return false;
        }

        int rstart = 3*(row/3);
        int colstart = 3*(col/3);

        for(int i=rstart;i<rstart+3;i++){
            for(int j=colstart;j<colstart+3;j++){
                if(sudoku[i][j]==num) return false;
            }
        }

        return true;
    }

    public void print(int[][] sudoku){
        System.out.println("===========================================================");
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
}
