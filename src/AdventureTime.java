import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int challengeOneAnswer = challengeOne("inputOneTwo.txt");
        System.out.println(challengeOneAnswer);
        int challengeTwoAnswer = challengeTwo("inputOneTwo.txt");
        System.out.println(challengeTwoAnswer);
        int challengeThreeAnswer = challengeThree("inputThreeFour.txt");
        System.out.println(challengeThreeAnswer);
        int challengeFourAnswer = challengeFour("inputThreeFour.txt");
        System.out.println(challengeFourAnswer);
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int cnt = 0;
        int[] array = readFile(fileName);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                cnt++;
            }
            cnt = cnt;
        }
        return cnt;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int cnt = 0;
        int[] array = readFile(fileName);
        for (int i = 0; i < array.length - 3; i++) {
            int one = array[i] + array[i + 1] + array[i + 2];
            int two = array[i + 1] + array[i + 2] + array[i + 3];
            if (two > one) {
                cnt++;
            }
        }
        return cnt;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        String[] array = readStringFile(fileName);
        int one = 0;
        int two = 0;
        for (String three: array) {
            int value = Integer.parseInt(three.substring(three.length() - 1));
            if (three.contains("forward")) {
                one = one + value;
            }
            if (three.contains("down")) {
                two = two + value;
            }
            if (three.contains("up")) {
                two = two - value;
            }
        }
        return one * two;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        String[] array = readStringFile("InputThreeFour.txt");
        int one = 0;
        int two = 0;
        int four = 0;
        for (String five: array) {
            int six = Integer.parseInt(five.substring(five.length() - 1));
            if (five.contains("forward")) {
                one = one + six;
                two = two + (four * six);
            }
            if (five.contains("down")) {
                four = four + six;
            }
            if (five.contains("up")) {
                four = four - six;
            }
        }
        return one * two;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberLines = countLinesInFile(inputFilename);
        int[] total = new int[numberLines];
        int cnt = 0;
        while (scanner.hasNextLine()) {
            total[cnt++] = scanner.nextInt();
        }
        scanner.close();
        return total;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

    private static String[] readStringFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

}