import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static char ch = ' ';
    static class Player{
        char mark;
        Player(char mark){
            this.mark = mark;
        }
    }
    public static void printB(char[][] arr) throws IndexOutOfBoundsException{
        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[i][j] + "|");
                }
                System.out.println();
            }
        }catch ( IndexOutOfBoundsException ex) {
            System.out.println("Sorry wrong entering....loose the chance1 :(");
        }
    }
    public static boolean gameover(char[][] arr) {
        // Check rows
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] != ' ' && arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) {
                ch = arr[i][0];
                return true;
            }
        }
        // Check columns
        for (int j = 0; j < arr.length; j++) {
            if (arr[0][j] != ' ' && arr[0][j] == arr[1][j] && arr[1][j] == arr[2][j]) {
                ch = arr[0][j];
                return true;
            }
        }
        // Check diagonals
        if (arr[0][0] != ' ' && arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) {
            ch = arr[0][0];
            return true;
        }
        if (arr[0][2] != ' ' && arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]) {
            ch = arr[0][2];
            return true;
        }
        return false;
    }
    static boolean isBoardFull(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == ' ') { // If any cell is empty, return false
                    return false;
                }
            }
        }
        return true; // Board is full
    }
    static class Robot {
        char mark;
        Robot(){
            this.mark = 'X';
        }
        public void RandomInsert(char [][] arr){
            int max = 2;
            int min = 0;
            boolean t = true;
            while(t) {
                int a = (int) (Math.random() * ((max - min) + 1));
                int b = (int) (Math.random() * ((max - min) + 1));
                if (arr[a][b] == ' '&& arr[a][b] != '1') {
                    arr[a][b] = this.mark;
                    t = false;
                }
            }
        }
        public void BlockWin(char[][] arr){
            // 0th column and 2nd column
            for (int i=0; i<3; i++){
                if ((arr[i][0] != ' '&& arr[i][2]!=' ' && arr[i][1] !=' ') && (arr[i][0]==arr[i][2]|| arr[i][1]==arr[i][2]|| arr[i][0]==arr[i][1])){
                    if (arr[i][0]==arr[i][2] ) {
                        if (arr[i][1] == this.mark) {
                            RandomInsert(arr);
                            return;
                        }
                        if (arr[i][1]!='1' && arr[i][1] != this.mark) {
                            arr[i][1] = this.mark;
                        }
                    }else if (arr[i][1]==arr[i][2] ){
                        if (arr[i][0] == this.mark) {
                            RandomInsert(arr);
                            return;
                        }
                        if (arr[i][0]!='1' && arr[i][0]!=this.mark) {
                            arr[i][0] = this.mark;
                        }
                    }else{
                        if (arr[i][2] == this.mark) {
                            RandomInsert(arr);
                            return;
                        }
                        if (arr[i][2]!='1' && arr[i][2]!=this.mark) {
                            arr[i][2] = this.mark;
                        }
                    }
                }
            }
            // 0th row and 2nd row
            for (int j=0; j<3; j++){
                if ((arr[0][j] != ' '&& arr[2][j]!=' ' && arr[1][j] !=' ') && (arr[0][j]==arr[2][j]|| arr[1][j]==arr[2][j]|| arr[0][j]==arr[1][j]) ){
                    if (arr[0][j]==arr[2][j] ){
                        if (arr[1][j] == this.mark) {
                            RandomInsert(arr);
                            return;
                        }
                        if (arr[1][j]!='1' && arr[1][j]!=this.mark) {
                            arr[1][j] = this.mark;
                        }
                    }else if(arr[1][j]==arr[2][j] ){
                        if (arr[0][j] == this.mark) {
                            RandomInsert(arr);
                            return;
                        }
                        if (arr[0][j]!='1' && arr[0][j]!=this.mark) {
                            arr[0][j] = this.mark;
                        }
                    }else{
                        if (arr[2][j] == this.mark) {
                            RandomInsert(arr);
                            return;
                        }
                        if (arr[2][j]!='1' && arr[2][j]!=this.mark) {
                            arr[2][j] = this.mark;
                        }
                    }
                }
            }

            // diagonal checking
            if ((arr[0][0] != ' '&& arr[2][2]!=' ' && arr[1][1] != ' ') && (arr[0][0]== arr[2][2] ||arr[1][1]== arr[2][2]|| arr[0][0]== arr[1][1]) ){
                if (arr[0][0]== arr[2][2] ){
                    if (arr[1][1] == this.mark) {
                        RandomInsert(arr);
                        return;
                    }
                    if (arr[1][1]!='1' ) {
                        arr[1][1] = this.mark;
                    }
                }else if (arr[1][1]== arr[2][2]){
                    if (arr[0][0] == this.mark) {
                        RandomInsert(arr);
                        return;
                    }
                    if (arr[0][0]!='1') {
                        arr[0][0] = this.mark;
                    }
                }else{
                    if (arr[2][2] == this.mark) {
                        RandomInsert(arr);
                        return;
                    }
                    if (arr[2][2]!='1' ) {
                        arr[2][2] = this.mark;
                    }
                }
            }else {
                if ((arr[0][2]!=' ' && arr[1][1]!= ' ')&&(arr[0][2]== arr[1][1])){
                    if (arr[2][0]!= '1' && arr[2][0]!=this.mark) {
                        arr[2][0] = this.mark;
                    }
                }else if ((arr[1][1]!=' ' && arr[2][0]!= ' ')&&(arr[1][1]== arr[2][0])){
                    if (arr[0][2]!= '1' && arr[0][2]!=this.mark) {
                        arr[0][2] = this.mark;
                    }
                }else if ((arr[0][2] != ' ' && arr[2][0]!=' ')&&(arr[0][2]==arr[2][0])){
                    if (arr[1][1] != '1' && arr[1][1]!=this.mark){
                        arr[1][1] = this.mark;
                    }
                }else{
                    RandomInsert(arr);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe_game");
        System.out.println("Select Playing Mode: Single(1) or TwoPlayer(0)");
        int pm = sc.nextInt();
        Player player1 = new Player('1');
        if (pm == 0) {
            char[][] arr = new char[3][3];
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    arr[i][j] = ' ';

                }
            }
            printB(arr);
            Player player0 = new Player('O');

            while(!gameover(arr)){
                System.out.println("Enter the row for" + " player0");
                int r0 = sc.nextInt();
                System.out.println("Enter the column for" + " player0");
                int c0 = sc.nextInt();
                if(arr[r0][c0] == ' '){
                    arr[r0][c0] = player0.mark;
                }else{
                    System.out.println("Sorry wrong entering....loose the chance :(");
                }
                printB(arr);
                if (gameover(arr)){
                    if (ch == player0.mark){
                        System.out.println("Player 0 is the Winner!");
                    }else{
                        System.out.println("Player 1 is the Winner!");
                    }
                    break;
                }
                if (isBoardFull(arr)){
                    System.out.println("Game is Draw..");
                    break;
                }
                System.out.println("Enter the row for" + " player1");
                int r2 = sc.nextInt();
                System.out.println("Enter the column for" + " player1");
                int c2 = sc.nextInt();
                if(arr[r2][c2] == ' '){
                    arr[r2][c2] = player1.mark;
                }else{
                    System.out.println("Sorry wrong entering....loose the chance :(");
                }
                printB(arr);
                if (gameover(arr)){
                    if (ch == player0.mark){
                        System.out.println("Player 0 is the Winner!");
                    }else{
                        System.out.println("Player 1 is the Winner!");
                    }
                    break;
                }
                if (isBoardFull(arr)){
                    System.out.println("Game is Draw..");
                    break;
                }
            }
        }else{
            char[][] arr = new char[3][3];
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    arr[i][j] = ' ';
                }
            }
            printB(arr);
            System.out.println("Computer is Thinking..");
            Robot robot = new Robot();
            robot.RandomInsert(arr);
            printB(arr);
            while(!gameover(arr)){
                System.out.println("Enter the row for" + " player1");
                int r2 = sc.nextInt();
                System.out.println("Enter the column for" + " player1");
                int c2 = sc.nextInt();
                if(arr[r2][c2] == ' '){
                    arr[r2][c2] = player1.mark;
                }else{
                    System.out.println("Sorry wrong entering....loose the chance :(");
                }
                printB(arr);
                if (gameover(arr)){
                    if (ch == player1.mark){
                        System.out.println("Player 1 is the Winner!");
                    }else{
                        System.out.println("Computer is the Winner!");
                    }
                    break;
                }
                System.out.println("The Computer is thinking..");
                robot.BlockWin(arr);
                printB(arr);
                if (gameover(arr)){
                    if (ch == player1.mark){
                        System.out.println("Player 1 is the Winner!");
                    }else{
                        System.out.println("Computer is the Winner!");
                    }
                    break;
                }
            }
        }
        System.out.println("game is over :)");
    }
}