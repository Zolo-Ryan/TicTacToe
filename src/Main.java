import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        char[][] board = new char[3][3];
        for (int row = 0;row < board.length;row++)
            for(int col = 0;col < board[row].length;col++)
                board[row][col] = ' ';
        char player = 'X';
        boolean gameOver = false;

        Scanner scanf = new Scanner(System.in);

        while(!gameOver){
            printBoard(board);
            System.out.println("Player "+ player+ " enter");
            int row = scanf.nextInt();
            int col = scanf.nextInt();
            if(row>2 || col >2){
                System.out.println("Invalid input, Try again");
                continue;
            }
            if(board[row][col] == ' '){
                board[row][col] = player;
                gameOver = haveWon(board);
                if(gameOver)
                    System.out.println("Player "+ player+" has won");
                else
                    player = (player == 'X')? 'O': 'X';
            }
            else
                System.out.println("Invalid move. Try again");
        }
        printBoard(board);
        scanf.close();
    }
    public static boolean haveWon(char[][] board){
        //check rows
        for(int row = 0;row < board.length ;row++)
            if(board[row][0]!=' ' && board[row][0] == board[row][1] && board[row][1] == board[row][2])
                return true;
        for(int col = 0;col < board[0].length ; col++)
            if(board[0][col]!=' ' && board[0][col] == board[1][col] && board[1][col] == board[2][col])
                return true;
        if(board[0][0]!=' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return true;
        if(board[2][0]!=' ' && board[2][0] == board[1][1] && board[1][1] == board[0][2])
            return true;
        return false;
    }
    public static void printBoard(char[][] board){
        for(int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++)
                System.out.printf("%c%c", board[row][col], col == 2 ? ' ' : '|');
            System.out.println();
        }
    }
}
