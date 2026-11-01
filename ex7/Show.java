import java.util.Collections;
import java.util.Iterator;

/**
 * Ex 6.7: thay đổi interface Show — mọi Show đều Iterable<Show>.
 * Phương thức default trả về iterator rỗng, nên các lớp lá
 * (Movie, Concert) không phải sửa gì.
 */
public interface Show extends Iterable<Show> {
    String description();
    int runningTime();
    Show copy();

    @Override
    default Iterator<Show> iterator() {
        return Collections.emptyIterator();
    }
}
