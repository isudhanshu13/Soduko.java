package com.Sudhanshu.BackTracking;

public class Sudoku {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                { 3, 1, 6, 5, 7, 8, 4, 9, 2 },
                { 5, 2, 9, 1, 3, 4, 7, 6, 8 },
                { 4, 8, 7, 6, 2, 9, 5, 3, 1 },
                { 2, 6, 3, 0, 1, 5, 9, 8, 7 },
                { 9, 7, 4, 8, 6, 0, 1, 2, 5 },
                { 8, 5, 1, 7, 9, 2, 6, 4, 3 },
                { 1, 3, 8, 0, 4, 7, 2, 0, 6 },
                { 6, 9, 2, 3, 5, 1, 8, 7, 4 },
                { 7, 4, 5, 0, 8, 6, 3, 1, 0 }

        };
    if(solve(board)==true){
        display(board);
    } else {
        System.out.println("cannot solved");
    }
    }

    static boolean solve(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptylist = true;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==0){
                    row=i;
                    col=j;
                    emptylist=false;
                    break;
                }
            }
            if(emptylist==false){
                break;
            }
        }
        if(emptylist==true){
            return true;
        }
        for(int number = 1; number <= 9 ; number++){
            if(issafe(board,row,col,number)){
                board[row][col]=number;
                if(solve(board)){
                    return true;
                }
                else{
                    board[row][col]=0;
                }
            }
        }
        return false;
    }
private static void display(int[][] board){
        for(int[] row:board){
            for(int num: row){
                System.out.print(num+" ");
            }
            System.out.println();
        }
}

static boolean issafe(int[][] board, int row, int col, int num){
        for(int i = 0 ; i<board.length; i++){
            if(board[row][col]==num){
                return false;
            }
        }
        for(int[] nums: board){
            if(nums[col] == num){
                return false;
            }
        }
        int sqrt = (int)(Math.sqrt(board.length));
        int rowstart = row - row % sqrt;
        int colstart = col - col % sqrt;

        for(int r = rowstart; r<rowstart+sqrt; r++){
            for(int c = colstart; c<colstart+sqrt; c++){
                if(board[r][c]==num){
                    return false;
                }
            }
        }
        return true;
}
}