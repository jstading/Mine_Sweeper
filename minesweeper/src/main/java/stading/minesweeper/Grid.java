package stading.minesweeper;

public class Grid{
    
    public int[][] randomFillGrid(int h, int w, int[][] board){
        int x;
        int y;
        int m = 0;
        
        while (m < 10){
            x = (int)(Math.random() * h);
            y = (int)(Math.random() * w);
            if (board[x][y] != -1){
                board[x][y] = -1;
                m++;
            }
        }
    return board;    
    }
    
    public void displayGrid(int h, int w, int[][]board){
        String topLine = " ";
        for(int i = 0; i < w; i++){
            int c = i + 1;
            topLine = topLine + "  " + c;
        }       
        System.out.println(topLine);

        for(int j = 0; j < h; j++){
            int c = j + 1;
            String nextLine = c + "";
            for(int i = 0; i < w; i++){
                String cell;
                cell = String.valueOf(board[i][j]);
                if(null != cell)switch (cell) {
                    case "-1":
                        cell = "*";
                        break;
                    case "9":
                        cell = " ";
                        break;
                    case "0":
                        cell = "*";
                        break;
                    default:
                        break;
                }
                
                nextLine = nextLine + "  " + cell;
            }
            System.out.println(nextLine);
        }
    }
    
    public void displayGridData(int h, int w, int[][]board){
        System.out.println(("Game Over."));
        String topLine = " ";
        for(int i = 0; i < w; i++){
            int c = i + 1;
            topLine = topLine + "  " + c;
        }       
        System.out.println(topLine);

        for(int j = 0; j < h; j++){
            int c = j + 1;
            String nextLine = c + "";
            for(int i = 0; i < w; i++){
                String cell;
                cell = String.valueOf(board[i][j]);
                if(null != cell)switch (cell) {
                    case "-1":
                        cell = "!";
                        break;
                    case "9":
                        cell = " ";
                        break;
                    case "0":
                        cell = " ";
                        break;
                    default:
                        break;
                }
                
                nextLine = nextLine + "  " + cell;
            }
            System.out.println(nextLine);
        }
    }
}