package ohtu;

public class TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public void wonPoint(String playerName) {
        if (playerName == this.playerOneName) {
            this.playerOneScore += 1;
            return;
        }
        if (playerName == this.playerTwoName) {
            this.playerTwoScore += 1;

        }
    }

    public String getScore() {

        if (playersHaveSameScore()) {
            return mapEvenNumbertoTennisScore(playerOneScore);
        }

        if (isThereWinner()) {
            return "Win for " + winningPlayerName();
        }

        if (playerHasAdvantage()) {
            return "Advantage " + winningPlayerName();
        }

        return mapNumbertoTennisScore(playerOneScore) + "-" + mapNumbertoTennisScore(playerTwoScore);

    }

    private boolean isThereWinner() {

        if (playerTwoScore >= 4 && playerTwoScore >= playerOneScore + 2) {
            return true;

        }
        if (playerOneScore >= 4 && playerOneScore >= playerTwoScore + 2) {
            return true;
        }
        return false;

    }

    private boolean playerHasAdvantage() {
        if (playerTwoScore >= 4 && playerTwoScore == playerOneScore + 1) {
            return true;
        }
        if (playerOneScore >= 4 && playerOneScore == playerTwoScore + 1) {
            return true;
        }
        return false;

    }

    private String mapEvenNumbertoTennisScore(int number) {
        switch (number) {
            case 3:
                return "Forty-All";
            case 2:
                return "Thirty-All";
            case 1:
                return "Fifteen-All";
            case 0:
                return "Love-All";
        }
        return "Deuce";
    }

    private String mapNumbertoTennisScore(int number) {
        switch (number) {
            case 3:
                return "Forty";
            case 2:
                return "Thirty";
            case 1:
                return "Fifteen";
            case 0:
                return "Love";
        }
        return "Not tennis";
    }

    private boolean playersHaveSameScore() {
        return playerOneScore == playerTwoScore;
    }

    private String winningPlayerName() {
        if (playerTwoScore < playerOneScore) {
            return playerOneName;
        }

        if (playerTwoScore > playerOneScore) {
            return playerTwoName;
        }

        return "";
    }

}
