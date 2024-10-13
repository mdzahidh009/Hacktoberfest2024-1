import java.util.Scanner;
import java.util.Random;

public class HacktoberfestAdventure {

    // Player object to track progress
    static class Player {
        String name;
        int pullRequests;
        
        Player(String name) {
            this.name = name;
            this.pullRequests = 0;
        }

        public void gainPullRequest() {
            pullRequests++;
            System.out.println("You've earned a pull request! Total: " + pullRequests);
        }

        public boolean isWinner() {
            return pullRequests >= 4;
        }
    }

    // Method to display ASCII art for adventure
    public static void displayWelcomeMessage() {
        System.out.println("**************************************");
        System.out.println("*     Welcome to Hacktoberfest 2024  *");
        System.out.println("*    Embark on a coding adventure!   *");
        System.out.println("**************************************");
        System.out.println("   Collect 4 Pull Requests to win!   \n");
    }

    // Random challenge for the player
    public static boolean codingChallenge(Player player) {
        Random rand = new Random();
        int challengeNumber = rand.nextInt(3); // Random challenge from 0-2

        switch (challengeNumber) {
            case 0:
                return solveRiddle(player);
            case 1:
                return debugCode(player);
            case 2:
                return answerTrivia(player);
            default:
                return false;
        }
    }

    // Riddle challenge
    public static boolean solveRiddle(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("CHALLENGE: Solve this riddle to earn a pull request.");
        System.out.println("I speak without a mouth and hear without ears. I have no body, but I come alive with wind. What am I?");
        System.out.print("Your answer: ");
        String answer = scanner.nextLine().trim().toLowerCase();

        if (answer.equals("echo")) {
            System.out.println("Correct! You solved the riddle.");
            player.gainPullRequest();
            return true;
        } else {
            System.out.println("Incorrect. Try again next time!");
            return false;
        }
    }

    // Code debugging challenge
    public static boolean debugCode(Player player) {
        System.out.println("CHALLENGE: Debug this piece of code to earn a pull request.");
        System.out.println("Java snippet: What will be the output?");
        System.out.println("int x = 5;\nwhile (x >= 0) {\n    System.out.println(x);\n    x--;\n}");
        System.out.println("A) 5 4 3 2 1 0\nB) 5 4 3 2 1\nC) 5 4 3 2 1 0 -1\nD) None of the above");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer: ");
        char answer = scanner.nextLine().toUpperCase().charAt(0);

        if (answer == 'A') {
            System.out.println("Correct! The loop will print 5 down to 0.");
            player.gainPullRequest();
            return true;
        } else {
            System.out.println("Incorrect. Better luck next time!");
            return false;
        }
    }

    // Trivia challenge
    public static boolean answerTrivia(Player player) {
        System.out.println("CHALLENGE: Answer this coding trivia question to earn a pull request.");
        System.out.println("Which programming language was developed by James Gosling in 1995?");
        System.out.println("A) Python\nB) C++\nC) Java\nD) Ruby");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer: ");
        char answer = scanner.nextLine().toUpperCase().charAt(0);

        if (answer == 'C') {
            System.out.println("Correct! Java was created by James Gosling in 1995.");
            player.gainPullRequest();
            return true;
        } else {
            System.out.println("Incorrect. Try again!");
            return false;
        }
    }

    // Game loop
    public static void startAdventure(Player player) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Hello, " + player.name + "! Let's start your Hacktoberfest adventure!");
        
        while (!player.isWinner()) {
            System.out.println("\nWould you like to take on a challenge? (yes/no)");
            String choice = scanner.nextLine().toLowerCase();
            
            if (choice.equals("yes")) {
                if (!codingChallenge(player)) {
                    System.out.println("No pull request earned this round.");
                }
            } else if (choice.equals("no")) {
                System.out.println("Thanks for playing! Come back later.");
                break;
            } else {
                System.out.println("Invalid choice. Type 'yes' to play or 'no' to exit.");
            }
        }

        if (player.isWinner()) {
            System.out.println("\nCongratulations, " + player.name + "! You've collected 4 pull requests and completed Hacktoberfest 2024!");
        }
    }

    public static void main(String[] args) {
        // Display welcome message and ASCII art
        displayWelcomeMessage();

        // Get player name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name, brave coder: ");
        String playerName = scanner.nextLine();
        
        // Create player
        Player player = new Player(playerName);

        // Start the adventure
        startAdventure(player);
    }
}
