import java.util.Scanner;

public class TicTacToe2 {

    public static void main(String[] args) {

        char [] board= new char[9];

        for (int i=0;i<board.length;i++){
              board[i]=' ';
        }

        char player='x';
        boolean GameOver=false;

        Scanner sc= new Scanner(System.in);

        System.out.println("Enter Positions Like Follows: ");
        System.out.println("0| 1| 2| \n" +
                  " 3| 4 | 5 | \n" +
                  " 6|7 | 8 |");
        System.out.println("Player One is x and Player Two is o ");

        while (!GameOver){
            PrintBoard(board);
            System.out.print("\n Player"+" "+player+" "+" Enter Position: ");
            int row=sc.nextInt();
            if(row>8 || row<0){
                System.out.println("Enter From 0-8");
                System.exit(0);
            }
            
            if (board[row]==' '){
                board[row]=player;
                GameOver=HaveWon(board,player);

                if (GameOver){
                    System.out.println("Player"+" "+ player +" "+"Has Won");
                    PrintBoard(board);
                    System.exit(0);
                }else if (IsBoardFull(board)){
                    System.out.println("The Board is full and Game is Drawn");
                    PrintBoard(board);
                    System.exit(0);
                }else{
                    if (player =='x'){
                        player='o' ;
                    }else{
                        player='x';
                    }
                }
            }else{
                System.out.println("Invalid Move Place Has Been Taken");
            }
        }

        PrintBoard(board);

    }


    public static boolean HaveWon(char[] board, char player) {

        for (int row=0;row<board.length;row++){

            if (board[0]==player && board[1]==player && board[2]==player){
                return true;
            }

            if (board[3]==player && board[4]==player && board[5]==player){
                return true;
            }

            if (board[6]==player && board[7]==player && board[8]==player){
                return true;
            }

            if (board[0]==player && board[3]==player && board[6]==player){
                return true;
            }

            if (board[1]==player && board[4]==player && board[7]==player){
                return true;
            }

            if (board[2]==player && board[5]==player && board[8]==player){
                return true;
            }

            if (board[0]==player && board[4]==player && board[8]==player){
                return true;
            }

            if (board[6]==player && board[4]==player && board[2]==player){
                return true;
            }
        }

        return  false ;
    }

    public static void PrintBoard(char[] board) {
        for (int i=0;i<board.length;i++){
            System.out.print(board[i]+"|");
            if (i==2 ||i==5){
                System.out.println();
            }
        }
    }

    public static boolean IsBoardFull(char[] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == ' ') {
                return false;
            }
        }
        return true;
    }
}