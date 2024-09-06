package stading.minesweeper;
import java.util.Scanner;


public class Game {
    
    public void start(){
        Scanner sc = new Scanner(System.in);     
        int h;
        int w;
        
        System.out.println("Welcome to Mine Sweeper");
        System.out.println("Enter the height of the grid:");
        h = sc.nextInt();
        System.out.println("Enter the width of the grid:");
        w = sc.nextInt();
        
        int[][] board= new int[h][w];
        Grid gr = new Grid();
        board = gr.randomFillGrid(h, w, board);
        gameLoop(h, w, board);
    }
    
    public void gameLoop(int h, int w, int[][] board){
        Scanner sc = new Scanner(System.in);
        Boolean gameOver = false;
        while (gameOver == false){
            System.out.println("There are a total of 10 mines in the mine field.");
            
            Grid grd = new Grid();
            grd.displayGrid(h, w, board);
            
            int row;
            int col;
            System.out.println("Pick a spot to check for a mine.");
            System.out.println("First enter the row number then the column number:");
            col = sc.nextInt() - 1;
            row = sc.nextInt() - 1;
            int mines = numberOfMines(row, col, w, h, board);
            gameOver = checkLocation(row, col, mines, w, h, board);
            if (gameOver == true)grd.displayGridData(h, w, board);
            
            int zeroSum = 0;
            
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(board[i][j] == 0)zeroSum++;                   
                }
            }
            if (zeroSum == 0){
                System.out.println("You Win!");
                grd.displayGrid(h, w, board);
                gameOver = true;
            }
            
        }
        
    }                

    public int numberOfMines(int row, int col, int w, int h, int[][] board){
        int sum = 0;
        if (board[row][col] == -1){
            sum = -1;
        } else{
            if (row - 1 >= 0 && col - 1 >= 0 && board[row-1][col-1] == -1)sum++;
            if (col -1 >= 0 && board[row][col-1] == -1)sum++;
            if (row + 1 <= h - 1 && col - 1 >= 0 && board[row+1][col-1]== -1)sum++;
            if (row - 1 >= 0 && board[row-1][col] == -1)sum++;
            if (row + 1 <= w - 1 && board[row+1][col] == -1)sum++;
            if (row - 1 >= 0 && col + 1 <= w - 1 && board[row-1][col+1] == -1)sum++;
            if (col + 1 <= h - 1 && board[row][col+1] == -1)sum++;
            if (row + 1 <= w - 1 && col + 1 <= h - 1 && board[row+1][col+1] == -1)sum++;
        }
        return sum;
    }
    
   
    public boolean checkLocation(int row, int col, int mines, int w, int h, int[][] board){
        if (mines == -1){
            return true;
        } else{
            int sum = 0;
                
            if (row - 1 >= 0 && col - 1 >= 0 && board[row-1][col-1] == -1)sum++;
            if (col -1 >= 0 && board[row][col-1] == -1)sum++;
            if (row + 1 <= h - 1 && col - 1 >= 0 && board[row+1][col-1]== -1)sum++;
            if (row - 1 >= 0 && board[row-1][col] == -1)sum++;
            if (row + 1 <= w - 1 && board[row+1][col] == -1)sum++;
            if (row - 1 >= 0 && col + 1 <= w - 1 && board[row-1][col+1] == -1)sum++;
            if (col + 1 <= h - 1 && board[row][col+1] == -1)sum++;
            if (row + 1 <= w - 1 && col + 1 <= h - 1 && board[row+1][col+1] == -1)sum++;

            if (board[row][col] != -1){
                board[row][col] = sum;
            }
            clearBlanks(row, col, w, h, board);
            return false;
        }
    }
    
    public void clearBlanks(int row, int col, int h, int w, int board[][]){
        if (row - 1 >= 0 && col - 1 >= 0 && board[row-1][col-1] == 0)board[row-1][col-1] = 9;
        if (col -1 >= 0 && board[row][col-1] == 0)board[row][col-1] = 9;
        if (row + 1 <= h - 1 && col - 1 >= 0 && board[row+1][col-1]== 0)board[row+1][col-1] = 9;
        if (row - 1 >= 0 && board[row-1][col] == 0)board[row-1][col] = 9;
        if (board[row][col] == 0)board[row][col] = 9;
        if (row + 1 <= w - 1 && board[row+1][col] == 0)board[row+1][col] = 9;
        if (row - 1 >= 0 && col + 1 <= w - 1 && board[row-1][col+1] == 0)board[row-1][col+1] = 9;
        if (col + 1 <= h - 1 && board[row][col+1] == 0)board[row][col+1] = 9;
        if (row + 1 <= w - 1 && col + 1 <= h - 1 && board[row+1][col+1] == 0 )board[row+1][col+1] = 9;
    }
}
