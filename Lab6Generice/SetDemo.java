package set;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Your name
 */
public class SetDemo {

    public static <T> void setOperationsDemo(Set<T> s1, Set<T> s2, Set<T> s3) {

        System.out.printf("s1 = %s \n", s1);
        System.out.printf("s2 = %s \n", s2);
        System.out.printf("s3 = %s \n", s3);
        System.out.printf("(s1 - s2) u (s2 - s1) = %s \n", (s1.diff(s2)).union(s2.diff(s1)));
        System.out.printf("(s1 u s2) - (s2 n s1) = %s \n", (s1.union(s2)).diff(s2.intersect(s1)).toString());
        System.out.printf("Is (s1 - s2) n (s2 - s1) empty? %s \n", (s1.diff(s2)).diff(s2.diff(s1)).isEmpty());
        System.out.printf("Are s1 n (s2 u s3) and (s1 n s2) u (s1 n s3) equal? %s \n", s1.intersect(s2.union(s3)).equals(s1.intersect(s2).union(s1.intersect(s3))));
        System.out.printf("Are s1 n (s2 u s3) and (s1 n s2) u (s1 n s3) equal? %s \n", (s1.intersect(s2)).union(s2.intersect(s3)).equals(s1.union(s3)));
        System.out.printf("Is (s1 - s2) a subset of s2? %s \n", s1.diff(s2).subset(s2));
        System.out.printf("Is (s1 - s2) u (s2 n s3) a subset of s1? %s \n", s1.diff(s2).union(s2.intersect(s3)).subset(s1));
        System.out.printf("Is (s1 - s2) u (s2 n s3) a proper subset of s1? %s \n", s1.diff(s2).union(s2.intersect(s3)).subset(s1));
    }

    public static <T extends Comparable> T getMax(Set<T> s) {
        T max = s.elements.get(0);
        for (int j = 1; j < s.elements.size(); j++) {
            if (s.elements.get(j).compareTo(max) > 0) {
                max = s.elements.get(j);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Set<Integer> s1I = new Set(new ArrayList(Arrays.asList(4, 2, 5, 1, 3)));
        Set<Integer> s2I = new Set(new ArrayList(Arrays.asList(7, 3, 2, 9, 5)));
        Set<Integer> s3I = new Set(new ArrayList(Arrays.asList(5, 8, 3, 2, 4)));

        setOperationsDemo(s1I, s2I, s3I);

        System.out.println("Max element in s1 = " + getMax(s1I));
        System.out.println("Max element in s2 = " + getMax(s2I));
        System.out.println("Max element in s3 = " + getMax(s3I));
        System.out.println();

        Set<Character> s1C = new Set(new ArrayList(Arrays.asList('D', 'B', 'A', 'E', 'C')));
        Set<Character> s2C = new Set(new ArrayList(Arrays.asList('G', 'I', 'C', 'B', 'E')));
        Set<Character> s3C = new Set(new ArrayList(Arrays.asList('F', 'C', 'H', 'B', 'D')));
        setOperationsDemo(s1C, s2C, s3C);
        System.out.println("Max element in s1 = " + getMax(s1C));
        System.out.println("Max element in s2 = " + getMax(s2C));
        System.out.println("Max element in s3 = " + getMax(s3C));
        System.out.println();
        
        Set<String> s1S = new Set(new ArrayList(Arrays.asList("Gina", "Bob", "Jim",
                "Anna", "Mary")));
        Set<String> s2S = new Set(new ArrayList(Arrays.asList("Tom", "Hal", "Mary",
                "Bob", "Anna")));
        Set<String> s3S = new Set(new ArrayList(Arrays.asList("Hal", "Mary", "Bob",
                "Sara", "Gina")));
        setOperationsDemo(s1S, s2S, s3S);
        System.out.println("Max element in s1 = " + getMax(s1S));
        System.out.println("Max element in s2 = " + getMax(s2S));
        System.out.println("Max element in s3 = " + getMax(s3S));
    }

}
