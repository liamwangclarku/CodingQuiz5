import java.io.*;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings(String s1, String s2) {
        // I cannot see why this is wrong
        int s1_length = s1.length();
        int s2_length = s2.length();
        if (s1_length == 0 || s2_length == 0) {
            return "NO";
        }
        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);
        if (c1 == c2) {
            return "YES";
        }
        String result = twoStrings(s1.substring(1, s1_length), s2);
        if (result.equals("YES")) {
            return result;
        }
        result = twoStrings(s1.replaceAll(c1 + "", ""), s2.substring(1, s2_length));
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = Result.twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
