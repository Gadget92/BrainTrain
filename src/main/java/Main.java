import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) {
        Integer attemptsCounter = 0;

        long totalOperationsTime = 0;

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                clearConsole();
                System.out.print("Enter result ");

                // Generate count and randomExpressionValue expression
                int randomExpressionValue = getRandomExpressionValue();

                long timeBeforeOperation = System.currentTimeMillis();
                // Read user input
                String input = buffer.readLine().toLowerCase().trim();
                long singleOperationTime = System.currentTimeMillis() - timeBeforeOperation;

                int inputValue = 0;
                try {
                    if (!input.equals("exit")) {
                        inputValue = Integer.valueOf(input);
                    } else {
                        if (!attemptsCounter.equals(0)) {
                            System.out.println("avg operation time = " + convertMilisecToTime(totalOperationsTime / attemptsCounter));
                        }

                        break;
                    }

                } catch (Exception e){
                    System.out.println("Wrong answer fortmat");
                }

                if (inputValue == randomExpressionValue ) {
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
    public static int getRandomExpressionValue(){
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
     * Converts long value of time in milliseconds to String value of hhmmss format
     * @param timeInMilisec - time in milliseconds
     * @return - formatted time String
     */
    public static String convertMilisecToTime(long timeInMilisec){
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
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
