package at.ac.fhcampuswien;

import java.util.*;

public class App {

    // Implement all methods as public static
    public static void oneMonthCalendar(int numOfDays, int firstDayOfMonth){
        int dayContinuous = 1;
        double daysPerWeek = 7.0;
        int rows = (int) Math.ceil((numOfDays+daysPerWeek-1)/daysPerWeek);

        for (int i = 0; i<rows; i++){
            for (int j = 0; j<daysPerWeek; j++){
                if (i==0) {
                    if (j < firstDayOfMonth - 1)
                        System.out.print("   ");
                    else{
                        if (dayContinuous < 10){
                            System.out.print(" "+dayContinuous+" ");
                            dayContinuous++;
                        } else{
                            System.out.print(dayContinuous+" ");
                            dayContinuous++;
                        }
                    }

                }else{
                    if(dayContinuous<=numOfDays) {
                        if (dayContinuous < 10) {
                            System.out.print(" " + dayContinuous + " ");
                            dayContinuous++;
                        } else {
                            System.out.print(dayContinuous + " ");
                            dayContinuous++;
                        }
                    }
                }
            }
            System.out.print(System.lineSeparator());
        }
    }

    public static long[] lcg(long seed){
        long[] longArray = new long[10];
        long m = (long) Math.pow(2, 31);
        int a = 1103515245;
        int c = 12345;
        longArray[0] = (a * seed + c) % m;
        for (int i = 1;i<longArray.length; i++){
            longArray[i] = (a * longArray[i - 1] + c) % m;
        }

        System.out.println(Arrays.toString(longArray));
        return longArray;
    }

    public static void guessingGame(int numberToGuess){
        Scanner scanner = new Scanner(System.in);
        int inputNum = -1;

        for (int i = 0; i<10; i++){
            System.out.print("Guess number "+(i+1)+": ");
            inputNum = scanner.nextInt();
            if (inputNum == numberToGuess || i == 9)
                break;
            else if (inputNum>numberToGuess)
                System.out.println("The number AI picked is lower than your guess.");
            else
                System.out.println("The number AI picked is higher than your guess.");


        }
        if (inputNum == numberToGuess)
            System.out.println("You won wisenheimer!");
        else
            System.out.println("You lost! Have you ever heard of divide & conquer?");

    }

    public static int randomNumberBetweenOneAndHundred(){
        return new Random().nextInt(100)+1;
    }

    public static boolean swapArrays(int[] firstArr, int[] secondArr){
        int tmpNum;
        if(firstArr.length != secondArr.length)
            return false;
        else {
            for (int i = 0; i < firstArr.length; i++) {
                tmpNum = firstArr[i];
                firstArr[i] = secondArr[i];
                secondArr[i] = tmpNum;
            }
            return true;
        }
    }

    public static String camelCase(String txt){
        //A-Z = 65 - 90
        //a-z = 92 - 122
        char[] charArr = txt.toCharArray();
        List charValList = new ArrayList();
        int asciiVal;
        boolean wordStarted = false;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i<charArr.length; i++){
            asciiVal = charArr[i];
            if (asciiVal >= 92 && asciiVal <= 122 && !wordStarted) {
                output.append(Character.toString((char) (asciiVal - 32)));
                charValList.add(asciiVal - 32);
                wordStarted = true;
            } else if (asciiVal <= 32 && asciiVal >= 28){
                wordStarted = false;
            }else if (asciiVal >= 92 && asciiVal <= 122 && wordStarted)
                output.append(Character.toString((char)asciiVal));
            else if (asciiVal>=65 && asciiVal<=95 && !wordStarted) {
                output.append(Character.toString((char) asciiVal));
                wordStarted = true;
            }
            else {
                if (asciiVal>=65 && asciiVal<=95) {
                    output.append(Character.toString((char) (asciiVal + 32)));
                    charValList.add(asciiVal + 32);
                    wordStarted = true;
                }
            }
        }
        //System.out.println("Das ist der Output:"+output);
        return output.toString();

    }

    public static int checkDigit(int[] code){
        int sumProd = 0;
        int diff;
        int keyVal;
        for(int i = 0; i < code.length; i++){
            sumProd += code[i] * (i+2);
        }
        diff = sumProd % 11;
        keyVal = 11 - diff;

        if(keyVal == 10)
            return 0;
        if(keyVal == 11)
            return 5;

        return keyVal;
    }

    public static void main(String[] args) {
        int[] digit = new int[]{4, 0, 4, 4, 4, 8, 2, 9, 3};
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
        oneMonthCalendar(28,2);
        //lcg(10);
        //guessingGame(69);
        camelCase("my name isn't Alice!");
        checkDigit(digit);
    }
}