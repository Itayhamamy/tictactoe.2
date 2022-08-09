import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //board
       char[][] board = new char[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        //name player's
        Scanner in = new Scanner(System.in);
        System.out.println("Let's play Tic Tac Toe!");
        System.out.print("Player 1, what is your name? ");
        String p1 = in.nextLine();
        System.out.print("Player 2, what is your name? ");
        String p2 = in.nextLine();

        //start loop
        boolean player1 = true;

        boolean gameEnded = false;
        while(!gameEnded) {

            Ticetac.boardSharing(board);
            //the actors' tools
            if(player1) {
                System.out.println(p1 + " Turn (x):");
            } else {
                System.out.println(p2 + " Turn (o):");
            }

            char c = '-';
            if(player1) {
                c = 'x';
            } else {
                c = 'o';
            }
            //Column and row
            int row = 0;
            int col = 0;
            while(true) {

                System.out.print("Enter a row number (0, 1, or 2): ");
                row = in.nextInt();
                System.out.print("Enter a column number (0, 1, or 2): ");
                col = in.nextInt();
                //Limit to three
                if(row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("This position is off the bounds of the board! Try again.");
                } else if(board[row][col] != '-') {
                    System.out.println("Someone has already made a move at this position! Try again.");
                } else {
                    break;
                }
            }
            //the winner or tie
            board[row][col] = c;
            if(Ticetac.Awinningplayer(board) == 'x') {
                System.out.println("Congratulations! "+p1 + " your winner");
                gameEnded = true;
            } else if(Ticetac.Awinningplayer(board) == 'o') {
                System.out.println("Congratulations! "+p2 + " your winner");
                gameEnded = true;
            } else {
                if (Ticetac.boardIsFull(board)) {
                    System.out.println("It's a tie!");
                    gameEnded = true;
                } else {
                    player1 = !player1;
                }
            }
        }
        //final board
        Ticetac.boardSharing(board);

    }



}




