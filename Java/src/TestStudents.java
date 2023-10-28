import java.util.Scanner;

public class TestStudents {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] terms = input.split("(?=[+-])");
        double[][] array = new double[terms.length][2];
        for(int i = 0; i < terms.length; i++){
            String term = terms[i];
            int powerIndex = term.indexOf("x^");
            if(powerIndex == -1){
                array[i][0] = 0;
            }
            else{
                array[i][0] = Integer.parseInt(term.substring(powerIndex+2));
            }
            int coefficientIndex = term.indexOf("x");
            if (coefficientIndex == -1){
                array[i][1] = Integer.parseInt(term);
            }
            else{
                array[i][1] = Integer.parseInt(term.substring(0, coefficientIndex));
            }
        }

        for (int i = 0; i < array.length; i++){
            System.out.println(array[i][0] + " " + array[i][1]);
        }
    }
}