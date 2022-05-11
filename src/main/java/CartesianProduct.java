import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CartesianProduct {
    public static Set<ArrayList<Object>> cartesianProduct(ArrayList<ArrayList<Object>> sets) {
        if (sets.size() < 2)
            throw new IllegalArgumentException(
                    "Can't have a product of fewer than two sets (got " +
                            sets.size() + ")");

        return _cartesianProduct(0, sets);
    }

    private static Set<ArrayList<Object>> _cartesianProduct(int index, ArrayList<ArrayList<Object>> sets) {
        Set<ArrayList<Object>> ret = new HashSet<>();
        if (index == sets.size()) {
            ret.add(new ArrayList<>());
        } else {
            for (Object obj : sets.get(index)) {
                for (ArrayList<Object> set : _cartesianProduct(index + 1, sets)) {
                    set.add(obj);
                    ret.add(set);
                }
            }
        }
        return ret;
    }
}
