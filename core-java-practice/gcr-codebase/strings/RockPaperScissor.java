import java.util.Scanner;
class RockPaperScissor{
    static String computerChoice() {
        int value = (int) (Math.random() * 3);
        if (value == 0)
            return "rock";
        if (value == 1)
            return "paper";
        return "scissors";
    }

    static String findWinner(String user, String computer) {
        if (user.equals(computer))
            return "draw";
        if (user.equals("rock") && computer.equals("scissors"))
            return "user";
        if (user.equals("paper") && computer.equals("rock"))
            return "user";
        if (user.equals("scissors") && computer.equals("paper"))
            return "user";
        return "computer";
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int games = scn.nextInt();
        int userWin = 0, computerWin = 0;
        for (int round = 1; round <= games; round++) {
            String userChoice = scn.next();
            String compChoice = computerChoice();
            String result = findWinner(userChoice, compChoice);
            System.out.println("User " + userChoice + " Computer " + compChoice + " Result " + result);
            if (result.equals("user"))
                userWin++;
            if (result.equals("computer"))
                computerWin++;
        }
        double userPercent = (userWin * 100.0) / games;
        double compPercent = (computerWin * 100.0) / games;
        System.out.println("User Wins " + userWin + " Percent " + userPercent);
        System.out.println("Computer Wins " + computerWin + " Percent " + compPercent);
    }
}
