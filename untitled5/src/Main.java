import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
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
                return true;
            }
        }
        // Check columns
        for (int j = 0; j < arr.length; j++) {
            if (arr[0][j] != ' ' && arr[0][j] == arr[1][j] && arr[1][j] == arr[2][j]) {
                return true;
            }
        }
        // Check diagonals
        if (arr[0][0] != ' ' && arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) {
            return true;
        }
        if (arr[0][2] != ' ' && arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0]) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] arr = new char[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                arr[i][j] = ' ';

            }
        }
        printB(arr);
        Player player0 = new Player('O');
        Player player1 = new Player('1');
        Scanner sc = new Scanner(System.in);
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

        }
        System.out.println("game is over :)");
        
    }
}