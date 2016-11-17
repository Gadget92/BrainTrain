import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) {
        Integer value = 0;
        Integer attemptsCounter = 0;
        long currentTime;
        long operationTime;
        long sumTime = 0;

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                clearConsole();
                System.out.print("Enter result ");

                // Generate count and value expression
                value = getRandomExpressionValue();

                currentTime = System.currentTimeMillis();
                // Read user input
                String input = buffer.readLine().toLowerCase().trim();
                operationTime = System.currentTimeMillis() - currentTime;

                int inputValue = 0;
                try {
                    if (!input.equals("exit")) {
                        inputValue = Integer.valueOf(input);
                    } else {
                        if (!attemptsCounter.equals(0)) {
                            System.out.println("avg operation time = " + convertMilisecToTime(sumTime / attemptsCounter));
                        }

                        break;
                    }

                } catch (Exception e){
                    System.out.println("Wrong answer fortmat");
                }

                if (inputValue == value ) {
                    System.out.println("True");
                } else {
                    System.out.println("Wrong");
                    System.out.println("Correct value : " + value);
                    System.out.println("Don't worry try again");
                }

                System.out.println("Operation time = " + convertMilisecToTime(operationTime));
                sumTime += operationTime;
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

        int loopCount = 0;
        do {
            loopCount ++;
            int expressionNumber = random.nextInt(1000);
            expressionValue += expressionNumber;
            builder.append(expressionNumber);

            if (loopCount != expressionNumbersCount) {
                builder.append(" + ");
            }

        } while(loopCount != expressionNumbersCount);

        builder.append(" = ");
        System.out.print(builder.toString());

        return expressionValue;
    }

    public static String convertMilisecToTime(long timeInMilisec){
        long remaindedOfDiv;
        Long minutes;
        long sec;
        String result = "";

        remaindedOfDiv = timeInMilisec % 60000;
        minutes = TimeUnit.MILLISECONDS.toMinutes(timeInMilisec / 60000);
        sec = TimeUnit.MILLISECONDS.toSeconds(remaindedOfDiv);

        if (!minutes.equals(0L)) {
            result += minutes.toString() + " min ";
        }

        result += sec + " sec ";

        return result;
    }

    public static  void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
