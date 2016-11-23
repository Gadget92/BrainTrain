package solutions.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.startProgram();
    }

    /**
     * Begin the main program loop. On each iteration generates
     * random sum expression, which user must evaluate.
     *
     * Prints the result of user evaluation and time it took to evaluate the random expression
     *
     * If user prints 'exit' stops the loop and prints the average time of random expressions evaluation
     */
    private void startProgram() {
        Integer attemptsCounter = 0;

        long totalOperationsTime = 0;

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                clearConsole();
                System.out.print("Enter result ");

                // Generate count and randomExpressionValue expression
                int randomExpressionValue = getRandomExpressionValue();

                long timeBeforeOperation = System.currentTimeMillis();

                // Read user input, trim it and transform it to lower case
                String userInputString = buffer.readLine().toLowerCase().trim();

                long singleOperationTime = System.currentTimeMillis() - timeBeforeOperation;

                int userInputValue;
                try {
                    if (!userInputString.equals("exit")) {
                        userInputValue = Integer.valueOf(userInputString);
                    } else {
                        if (!attemptsCounter.equals(0)) {
                            System.out.println("avg operation time = " + convertMilisecToTime(totalOperationsTime / attemptsCounter));
                        }

                        break;
                    }

                } catch (Exception e){
                    System.out.println("Wrong answer fortmat");
                    continue;
                }

                if (userInputValue == randomExpressionValue) {
                    System.out.println("True");
                } else {
                    System.out.println("Wrong");
                    System.out.println("Correct randomExpressionValue : " + randomExpressionValue);
                    System.out.println("Don't worry try again");
                }

                System.out.println("Operation time = " + convertMilisecToTime(singleOperationTime));

                totalOperationsTime += singleOperationTime;
                attemptsCounter++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates random sum expression and prints it on console
     * @return the value of expression
     */
    private int getRandomExpressionValue(){
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        StringBuilder builder = new StringBuilder();

        int expressionValue = 0;

        int expressionNumbersCount =  2 + random.nextInt(3);

        for (int i = 0; i < expressionNumbersCount; ++i) {
            int expressionNumber = random.nextInt(1000);
            expressionValue += expressionNumber;

            builder.append(expressionNumber);
            if (i != (expressionNumbersCount - 1)) {
                builder.append(" + ");
            }
        }

        builder.append(" = ");
        System.out.print(builder.toString());

        return expressionValue;
    }

    /**
     * Converts long value of time in milliseconds to String value of mmss format
     * @param timeInMilisec - time in milliseconds
     * @return - formatted time String
     */
    private String convertMilisecToTime(long timeInMilisec){
        long remaindedOfDiv = timeInMilisec % 60000;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(timeInMilisec / 60000);
        long sec = TimeUnit.MILLISECONDS.toSeconds(remaindedOfDiv);

        String result = "";

        if (minutes != 0L) {
            result += String.valueOf(minutes) + " min ";
        }

        result += sec + " sec ";

        return result;
    }

    /**
     * Clears console from character
     */
    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
//test
