import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Ex 6.6: chỉ CompositeShow cài đặt Iterable<Show>.
 * Interface Show không đổi, Movie/Concert không bị ảnh hưởng.
 */
public class CompositeShow implements Show, Iterable<Show> {
    private final List<Show> aShows = new ArrayList<>();

    public CompositeShow(Show... pShows) {
        for (Show show : pShows) aShows.add(show.copy());   // sao chép phòng vệ
    }

    @Override
    public String description() {
        StringBuilder result = new StringBuilder("Composite: [");
        for (int i = 0; i < aShows.size(); i++) {
            if (i > 0) result.append(", ");
            result.append(aShows.get(i).description());
        }
        return result.append("]").toString();
    }

    @Override
    public int runningTime() {
        int total = 0;
        for (Show show : aShows) total += show.runningTime();
        return total;
    }

    @Override
    public CompositeShow copy() {
        return new CompositeShow(aShows.toArray(new Show[0]));
    }

    /** Duyệt các show con; không cho client xóa phần tử qua iterator. */
    @Override
    public Iterator<Show> iterator() {
        return Collections.unmodifiableList(aShows).iterator();
    }
}
