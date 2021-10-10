import java.util.ArrayList;
import java.util.Objects;

public class ArrayUtils {

    // Search an array for a specific value
    public static <E> boolean arrayContains(E[] array, String x){
        boolean containsValue = false;

        for (E value: array){
            if (Objects.equals(value, x) || Objects.equals(value, x.toUpperCase())) {
                containsValue = true;
                break;
            }
        }
        return containsValue;
    }

    // build an array of ordered pair objects from the given arrays. (this data comes after vector or point data)
    public static ArrayList<OrderedPair> buildOrderedPairsList (String[] array, int startPoint){
        var orderedPairs = new ArrayList<OrderedPair>();

        for (int i = startPoint; i < array.length; i += 2){
            orderedPairs.add(new OrderedPair(Double.parseDouble(array[i]), Double.parseDouble(array[i + 1])));
        }
        return orderedPairs;
    }
}
