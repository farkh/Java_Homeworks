package Iterator;
import LinkedList.*;
import Farey.*;

public interface Iterator<T> {
    boolean hasNext();
    boolean hasPrevious();
    T next();
    T previous();
    T peakNext();
    T peakPrevious();
    void insert(T element);
}
