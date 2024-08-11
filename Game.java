
import java.util.Random;
import java.util.Scanner;

class Guesses {
    public int num;
    public int input_number;
    public int no_of_guessess = 0;

    public int get_no_of_guesses() {
        return no_of_guessess;
    }

    public void set_no_of_guesses(int no_of_guessess) {
        this.no_of_guessess = no_of_guessess;
    }

    Guesses() {
        Random obj = new Random();
        this.num = obj.nextInt(100);
    }

    void take_user_input() {
        System.out.println("Guess the number :");
        Scanner input = new Scanner(System.in);
        input_number = input.nextInt();
    }

    boolean is_correct_number() {
        no_of_guessess++;
        if (input_number == num) {
            System.out.format("Yes you guessesd it right, it was %d attempts", num, no_of_guessess);
            return true;
        } else if (input_number < num) {
            System.out.println("Two low");
        } else if (input_number > num) {
            System.out.println("Too high");
        }
        return false;
    }
}

public class Game {
    public static void main(String[] args) {
        Guesses g = new Guesses();
        boolean b = false;
        while (!b) {
            g.take_user_input();
            b = g.is_correct_number();
        }
    }
}