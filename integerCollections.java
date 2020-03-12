import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
   
/**
 * This utility class consists exclusively of static methods that operate on integer collections.
 */
public class IntegerCollections {
 
/**
 * Returns {@code true} if the two specified collections have no element in common.
 * @param coll1 a collection of Integers
 * @param coll2 a collection of Integers
 * @return {@code true} if {@code coll1} and {@code coll2} have no element in common
 */
 public static boolean disjoint(Collection<Integer> coll1, Collection<Integer> coll2) {
    for (Integer elem : coll1) {
       if (coll2.contains(elem)) {
          return false;
       }
     }
     return true;
 }

    /**
     * Replaces all of the elements in the specified list with the specified value
     * @param list the list to be filled with the specified value
     * @param fillValue the value with which to fill the specified list
     */
     public static void fill(List<Integer> list, int fillValue) {
        var imusingalistiteartor = list.listIterator(0);
        while (imusingalistiteartor.hasNext()) {
    	     imusingalistiteartor.next();
    	     imusingalistiteartor.set(fillValue);
    	  }
    }	
    
    /**
     * Returns the number of elements in the specified collection equal to the specified value.
     *
     * @param values the collection in which to determine the frequency of {@code target}
     * @param target the value whose frequency is to be determined
     * @return the number of elements in {@code values} equal to {@code target}
     */
     public static int frequency(Collection<Integer> values, int target) {
        int freqCount = 0;
        var iterator = values.iterator();
        while (iterator.hasNext()) {
    	     if (iterator.next() == target)
   	          freqCount++;
        }
        return freqCount;
     }
 
    /**
     * Returns {@code true} if the specified list is sorted in ascending order.
     * @param list the list to be assessed for order
     * @return {@code true} if {@code list} is sorted in ascending order
 	   */
    public static boolean isSorted(List<Integer> list) {
       List<Integer> sortedList = new ArrayList<>(list);
       sortedList.sort(null);
       int counter = 0;
       for (Integer elem: list) {
          if (elem.equals(sortedList.get(counter))) {
             counter++;
          }
          else {
             return false;
          }
       }
  	   return true;
    }

    /**
     * Returns the largest element in the specified collection.
     *
     * @param values the collection to search
     * @return the largest element in {@code values}
     */
    public static Integer max(Collection<Integer> values) {
       Integer largest = null;
       for (Integer elem : values)
          if (largest == null || elem > largest)
             largest = elem;
       return largest;
    }

   /**
    * Returns the median value of the specified collection.
    * @param values the collection to search
    * @return the median value in {@code values} (this will be the average of the two middle
    *         elements, if the size of the collection is even)
    */
   public static double median(Collection<Integer> values) {
      ArrayList<Integer> testArr = new ArrayList<>(values);
      testArr.sort(null);
      double median = 0;
      int half = testArr.size() / 2;
         if (testArr.size() % 2 == 0)
            median += (double)(testArr.get(half) + testArr.get(half - 1)) / 2;
         else if (testArr.size() % 2 != 0)
            median += testArr.get(half);
       return median;
   }
   
   /**
    * Returns the smallest element in the specified collection.
    * @param values the collection to search
    * @return the smallest element in @{values}
    */
   public static Integer min(Collection<Integer> values) {
      Integer smallest = null;
         for (Integer elem: values)
         if (smallest == null || elem < smallest)
   	        smallest = elem;
   	     return smallest;
   }
   
   /**
    * Returns the most frequent element in the specified collection.
    * @param values the collection to search
    * @return the most frequent element in {@code values}. In the case of a tie, returns the
    *         lowest-valued tied element.
  	*/
   public static Integer mode(Collection<Integer> values) {
      ArrayList<Integer> testArr = new ArrayList<>(values);
      testArr.sort(null);
      int modeIndex = 0;
      int count = 1;
      int maxCount = 1;
      int pastIndex = 0;
      for (int i = 0; i < testArr.size(); i++) {
         if (i != testArr.size() - 1 && testArr.get(i) == testArr.get(i + 1)) {
            if (testArr.get(i) != testArr.get(pastIndex) && testArr.get(i) != testArr.get(modeIndex)) {
               count = 1;
                modeIndex = i;
            }
            count++;
            if (count > maxCount) {
               maxCount = count;
               pastIndex = i;
            }
         }
      }
      return testArr.get(pastIndex);
   }
   
   /**
    * Rotates the elements in the specified list by the specified distance. After calling this
    * method, the element at index {@code i} will be the element previously at index
    * {@code (i - distance) % list.size()}, for all values of {@code i} between {@code 0} and
    * {@code list.size() - 1}, inclusive. (This method has no effect on the size of the list.)
    * @param list the list to be rotated
    * @param distance the distance to rotate the list. There are no constraints on this value; it may
    *          be zero, negative, or greater than {@code list.size()}.
    */
   public static void rotate(List<Integer> list, int distance) {
      ArrayList<Integer> test = new ArrayList<>(list.size());
      for (int i = 0; i <= list.size() - 1; i++) {
         int index = (i - distance) % list.size();
         if (index >= 0) {
            test.add(i, list.get(index));
         }
         else if (index < 0) {
            int posIndex = list.size() + index;
            test.add(i, list.get(posIndex));
         }
      }
      list.clear();
      list.addAll(test);
   }
   
   /**
    * Returns the sum of the values in the specified collection.
    * @param values the collection to investigate
    * @return the sum of the values in the specified collection
    */
   public static long sum(Collection<Integer> values) {
      long finalSum = 0;
      for (Integer elem : values)
         finalSum += elem;
      return finalSum;
    }

    /**
     * Returns a {@code Set} of the unique values in the specified collection.
     * @param values the collection to investigate
     * @return a {@code Set} of the unique values in the specified collection
     */
    public static Set<Integer> uniqueValues(Collection<Integer> values) {
      TreeSet<Integer> num = new TreeSet<>();
      for (Integer elem : values) {
         num.add(elem);
      }
      return num;
    }
}
