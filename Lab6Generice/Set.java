package set;

import java.util.ArrayList;

/**
 *
 * @author Your name
 */
public class Set<T> {

    /**
     * A list of elements contained in the set
     */
    public ArrayList<T> elements;

    /**
     * Creates a set using the elements of the ArrayList list.
     *
     * @param list the ArrayList whose elements are used to create this set.
     * @throws IllegalArgumentException if list contains a duplicity.
     */
    public Set(ArrayList<T> list) {
        elements = new ArrayList();
        int i, size = list.size();
        T elt;
        for (i = 0; i < size; i++) {
            elt = list.get(i);
            if (elements.contains(elt)) {
                throw new IllegalArgumentException("Set<T>: Duplicity not "
                        + "allowed in sets");
            }
            elements.add(elt);
        }
    }

    /**
     * Determines whether a set contains the specified element
     *
     * @param elt an element
     * @return true if elt is an element of this set; otherwise, false
     */
    public boolean isElement(T elt) {
        return elements.contains(elt);
    }

    /**
     * Determines whether a set is empty
     *
     * @return true if this set is empty; otherwise, false
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Computes the intersection of this set and the specified set.
     *
     * @return a set representing the intersection of this set and s.
     */
    public Set<T> intersect(Set<T> s) {
        T elt;
        ArrayList<T> result = new ArrayList();
        int i, size = elements.size();
        for (i = 0; i < size; i++) {
            elt = elements.get(i);
            if (s.elements.contains(elt)) {
                result.add(elt);
            }
        }
        return new Set(result);
    }

    /**
     * Computes the union of this set and the specified set.
     *
     * @return a set representing the union of this set and s.
     */
    public Set<T> union(Set<T> s) {
        T elt;
        ArrayList<T> result = new ArrayList();
        int i;
        if (s.elements.equals(elements)) {
            return new Set(s.elements);
        } else {
            for (i = 0; i < elements.size(); i++) {

                if (s.elements.contains(elements.get(i))) {
                    result.add(elements.get(i));
                }
            }

        }

        return new Set(result);
        // Implement this method
    }

    /**
     * Computes the difference of this set and the specified set.
     *
     * @return a set representing the difference of this set and s.
     */
    public Set<T> diff(Set<T> s) {
        T elt;
        ArrayList<T> result = new ArrayList();
        int i, size = s.elements.size();
        for (i = 0; i < size; i++) {
            elt = elements.get(i);
            if (!s.elements.contains(elt)) {
                result.add(elt);
            }
        }

        return new Set(result);
        // Implement this method
    }

    /**
     * Determines whether this set is equal to the specified object.
     *
     * @return false if the specified object is not equal to this set;
     * otherwise, true
     */
    public boolean equals(Object obj) {
        Set<T> other = (Set<T>) (T) obj;
        T elt;
        int i, size = elements.size();
        if (!other.getClass().isInstance(elements)) {
            return false;
        }
        if (elements.size() != other.elements.size()) {
            return false;
        } else if (elements.size() != other.elements.size()) {
            for (i = 0; i < size; i++) {
                elt = elements.get(i);
                if (elements.get(i) == other.elements.get(i)) {
                    return true;
                }
            }
        }

        return false;
        // Implement this method
    }

    /**
     * Determines whether this set is a subset of the specified set.
     *
     * @return false if this set is not a subset of the specified set;
     * otherwise, true
     */
    public boolean subset(Set<T> s) {

        int i, size = elements.size();
        for (i = 0; i < size; i++) {
            if (elements.contains(s.elements.get(i))) {
                return true;
            }
        }
        return false;
        // Implement this method
    }

    /**
     * Determines whether this set is a proper subset of the specified set.
     *
     * @return false if this set is not a proper subset of the specified set;
     * otherwise, true
     */
    public boolean properSubset(Set<T> s) {
        int i, size = elements.size();
        Set other = new Set(elements);
        for (i = 0; i < size; i++) {
            if (elements.contains(s.elements.get(i)) && other.equals(s)) {
                return true;
            }

        }
        return false;
    }

    /**
     * returns a string {x1,x2,...,xn} representing this set, where x1,x2,...,xn
     * are elements of this set.
     *
     * @return a string representation of this set formatted as specified.
     */
    public String toString() {
        String setAsString = "{";
        int size = elements.size();
        if (size > 0) {
            setAsString += elements.get(0);
            int i;
            for (i = 1; i < size; i++) {
                setAsString += ", " + elements.get(i);
            }
        }
        return setAsString + "}";
    }

}
