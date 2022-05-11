import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class Main {

    public static void main(String[] args) {
        testCaseOne();
    }

    public static HashSet generatePossibleWords(String knownLetters, char[][] yellowLetters) {
        HashSet<String> solutionSet = new HashSet<String>();
        //Will need to handle inputs in a manner that makes sense, casting double char array into something usable,
        //String type issue

        for (int i = 1; i < yellowLetters[0].length; i++) {
            int x = Character.getNumericValue(yellowLetters[0][i]);
            for (int j = 1; j < yellowLetters[1].length; j++) {
                int y = Character.getNumericValue(yellowLetters[1][j]);
                for (int k = 1; k < yellowLetters[2].length; k++) {
                    int z = Character.getNumericValue(yellowLetters[2][k]);
                    if(x != y && x != z &&  y != z) {
                        StringBuilder string = new StringBuilder(knownLetters);
                        string.setCharAt(x-1, yellowLetters[0][0]);
                        string.setCharAt(y-1, yellowLetters[1][0]);
                        string.setCharAt(z-1, yellowLetters[2][0]);
                        System.out.println("Possible Solution = " + string);
                        solutionSet.add(string.toString());
                    }
                }
            }
        }
        return solutionSet;
    }

    public static HashSet cartGenerator(String knownLetters, char[][] yellowLetters){
        ArrayList<ArrayList<Object>> combos = new ArrayList<>();
        for (int i = 0; i < yellowLetters.length; i++) {
            ArrayList<Object> list = new ArrayList<>();
            for (int j = 1; j < yellowLetters[i].length; j++){
                list.add(Character.getNumericValue(yellowLetters[i][j]));
            }
            combos.add(list);
        }
        HashSet combinations = CartesianProduct.cartesianProduct(combos);
        return combinations;
    }


    public static void testCaseOne() {

        String knownLetters = "____E";

        char[][] yellowLetters = {
                {'A','2','3','4'},
                {'R','1','3','4'},
                {'S','1','2','3'}
        };

        Set<String> solution = new HashSet<String>();
        solution.add("RAS_E");
        solution.add("SAR_E");
        solution.add("SA_RE");
        solution.add("_ASRE");
        solution.add("RSA_E");
        solution.add("S_ARE");
        solution.add("_SARE");
        solution.add("RS_AE");
        solution.add("R_SAE");
        solution.add("S_RAE");
        solution.add("_SRAE");

        if (solution.equals(generatePossibleWords(knownLetters, yellowLetters))) {
            System.out.println("Test One passed.");
        }
    }
}
