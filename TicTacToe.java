import java.util.*;
class TicTacToe{
    static HashSet<Integer> ur_set = new HashSet<>();
    static HashSet<Integer> comp_set = new HashSet<>();
    public static void main(String args[]){
        char[][] g_board = {
            {' ', '|', ' ', '|', ' '},
            {'-', '|', '-', '|', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '|', '-', '|', '-'},
            {' ', '|', ' ', '|', ' '}
        };
        print_board(g_board);
        Scanner sc = new Scanner(System.in);
        while(true){
            //for user
            System.out.print("Enter values from 1-9: ");
            int user_pos = sc.nextInt();
            while(ur_set.contains(user_pos) || comp_set.contains(user_pos)){
                System.out.println();
                System.out.print("Retry, Enter values from 1-9: ");
                user_pos = sc.nextInt();
            }
            p_holder(g_board, user_pos, "You");

            String result = check_winner();
            if(result.length()>0){
                System.out.println(result);
                break;
            }

            //for computer
            int comp_pos = gen_random();
            while(ur_set.contains(comp_pos) || comp_set.contains(comp_pos)){
                comp_pos = gen_random();
            }
            p_holder(g_board, comp_pos, "Computer");

            result = check_winner();
            if(result.length()>0){
                System.out.println(result);
                break;
            }
        }
    }

    static String check_winner(){
        HashSet<Integer> r1 = new HashSet<>();
        r1.add(1); r1.add(2); r1.add(3);
        HashSet<Integer> r2 = new HashSet<>();
        r2.add(4); r2.add(5); r2.add(6);
        HashSet<Integer> r3 = new HashSet<>();
        r3.add(7); r3.add(8); r3.add(9);

        HashSet<Integer> c1 = new HashSet<>();
        c1.add(1); c1.add(4); c1.add(7);
        HashSet<Integer> c2 = new HashSet<>();
        c2.add(2); c2.add(5); c2.add(8);
        HashSet<Integer> c3 = new HashSet<>();
        c3.add(3); c3.add(6); c3.add(9);

        HashSet<Integer> d1 = new HashSet<>();
        d1.add(1); d1.add(5); d1.add(9);
        HashSet<Integer> d2 = new HashSet<>();
        d2.add(3); d2.add(5); d2.add(7);

        HashSet<HashSet> set = new HashSet<>();
        set.add(r1); set.add(r2); set.add(r3);
        set.add(c1); set.add(c2); set.add(c3);
        set.add(d1); set.add(d2);

        for(HashSet c: set){
            if(ur_set.containsAll(c)){
                return "You Won";
            }
            else if(comp_set.containsAll(c)){
                return "You Lost";
            }
        }
        if(ur_set.size() + comp_set.size()==9){
            return "Draw";
        }
        return "";
    }

    static int gen_random(){
        int max = 9;
        int min = 1;
        int range = max-min+1;
        int result = (int) (Math.random()*range) + min;
        return result;
    }

    static void print_board(char[][] g_board){
        System.out.println();
        for(int i=0;i<g_board.length;i++){
            for(int j=0;j<g_board[0].length;j++){
                System.out.print(g_board[i][j]);
            }
            System.out.println();
        }
    }
    static void p_holder(char[][] g_board, int pos, String user){
        char symbol = 'X';
        if(user.equals("You")){
            symbol = 'X';
            ur_set.add(pos);
        }
        else if(user.equals("Computer")){
            symbol = 'O';
            comp_set.add(pos);
        }
        switch(pos){
            case 1:
                g_board[0][0] = symbol;
                break;
            case 2:
                g_board[0][2] = symbol;
                break;
            case 3:
                g_board[0][4] = symbol;
                break;
            case 4:
                g_board[2][0] = symbol;
                break;
            case 5:
                g_board[2][2] = symbol;
                break;
            case 6:
                g_board[2][4] = symbol;
                break;
            case 7:
                g_board[4][0] = symbol;
                break;
            case 8:
                g_board[4][2] = symbol;
                break;
            case 9:
                g_board[4][4] = symbol;
                break;
            default:
                System.out.println("Invalid input");
        }
        print_board(g_board);
    }
}