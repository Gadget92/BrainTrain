import java.io.BufferedReader;
import java.io.IOException;
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

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))){

            while (true)  {

                clearConsole();
                System.out.print("Enter result ");

                // Generate count and value expression
                value = getSumValue();

                currentTime = System.currentTimeMillis();
                // Read user input
                String input = buffer.readLine().toLowerCase().trim();
                operationTime = System.currentTimeMillis() - currentTime;

                int inputValue = 0;
                try {
                    if (!input.equals("exit")) {
                        inputValue = Integer.valueOf(input);
                    }else {
                        if (!attemptsCounter.equals(0))
                            System.out.println("avg operation time = " + convertMilisecToTime(sumTime / attemptsCounter));
                        break;
                    }
                }catch (Exception e){
                    System.out.println("Wrong answer fortmat");
                }

                if (inputValue == value ){
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

    public static int getSumValue(){
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        int count = 0;
        int sumValue = 0;
        int buffValue = 0;

        StringBuilder builder = new StringBuilder();

        count =  2 + random.nextInt(3);

        Integer loopCount = 0;
        do {
            loopCount ++;
            buffValue = random.nextInt(1000);
            sumValue += buffValue;
            builder.append(buffValue);
            if (!loopCount.equals(count)) {
                builder.append(" + ");
            }


        }while ( !loopCount.equals(count));
            builder.append(" = ");
        System.out.print(builder.toString());

        return sumValue;
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
