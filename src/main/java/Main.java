import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class Main {

    public static void main(String[] args) {
        testCaseOne();
        testCaseTwo();
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
        Set<ArrayList<Object>> combinations = new HashSet<>();
        HashSet<String> solutionSet = new HashSet<String>();
        for (int i = 0; i < yellowLetters.length; i++) {
            ArrayList<Object> list = new ArrayList<>();
            for (int j = 1; j < yellowLetters[i].length; j++){
                list.add(Character.getNumericValue(yellowLetters[i][j]));
            }
            combos.add(list);
        }
        combinations = CartesianProduct.cartesianProduct(combos);
        for (ArrayList<Object> positions  : combinations){
            HashSet<Object> setCon = new HashSet<>(positions);
            if(setCon.size() == yellowLetters.length){
                //System.out.println("Carts "+ positions + " Set Conversion = " + setCon + " Count = " + setCon.size());

                StringBuilder string = new StringBuilder(knownLetters);
                for (int i = 0; i < positions.size(); i++){
                    string.setCharAt((Integer) positions.get(i) -1, yellowLetters[yellowLetters.length -1 -i][0]);
                }
                System.out.println("Possible Solution = " + string);
                solutionSet.add(string.toString());
            }
        }

        return solutionSet;
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

        if (solution.equals(cartGenerator(knownLetters, yellowLetters))) {
            System.out.println("Test One passed.");
        } else {
            System.out.println("Test Failed");
        }
    }

    public static void testCaseTwo() {

        String knownLetters = "_____";

        char[][] yellowLetters = {
                {'P', '2', '3', '4', '5'},
                {'E', '1', '3', '4', '5'},
                {'A', '1', '2', '4', '5'},
                {'R', '1', '2', '3', '5'},
                {'S', '1', '2', '3', '4'}
        };

        Set<String> solution = new HashSet<String>();
        solution.add("APESR");
        solution.add("ASEPR");
        solution.add("ARESP");
        solution.add("APSER");
        solution.add("ASPER");
        solution.add("ARSEP");
        solution.add("ASREP");
        solution.add("APRSE");
        solution.add("ARPSE");
        solution.add("ARSPE");
        solution.add("ASRPE");
        solution.add("EAPSR");
        solution.add("EASPR");
        solution.add("EARSP");
        solution.add("SAEPR");
        solution.add("RAESP");
        solution.add("SAPER");
        solution.add("RASEP");
        solution.add("SAREP");
        solution.add("RAPSE");
        solution.add("RASPE");
        solution.add("SARPE");
        solution.add("EPSAR");
        solution.add("ESPAR");
        solution.add("ERSAP");
        solution.add("ESRAP");
        solution.add("SPEAR");
        solution.add("RSEAP");
        solution.add("SREAP");
        solution.add("RPSAE");
        solution.add("SPRAE");
        solution.add("RSPAE");
        solution.add("SRPAE");
        solution.add("EPRSA");
        solution.add("ERPSA");
        solution.add("ERSPA");
        solution.add("ESRPA");
        solution.add("RPESA");
        solution.add("RSEPA");
        solution.add("SREPA");
        solution.add("RPSEA");
        solution.add("SPREA");
        solution.add("RSPEA");
        solution.add("SRPEA");
        if (cartGenerator(knownLetters, yellowLetters) == null) System.out.println("Call returns null");
        if (!solution.equals(cartGenerator(knownLetters, yellowLetters))) System.out.println("Data does not match");
    }
}


//learn loops you silly goose
//learn Set interface thoroughly (super helpful when deleting duplicate values in a collection)