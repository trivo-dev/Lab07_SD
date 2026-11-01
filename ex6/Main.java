public class Main {
    public static void main(String[] args) {
        Show movie = new Movie("Metropolis", 1927, 153);
        Show concert = new Concert("Moonlight Sonata", "Yuja Wang", 20);
        Show inner = new CompositeShow(movie, concert);
        Show program = new CompositeShow(inner, new Movie("Nosferatu", 1922, 94));

        System.out.println(program.description());
        System.out.println("Tổng thời lượng: " + program.runningTime() + " phút");

        unpack(program, "");
    }

    /** Client phải kiểm tra kiểu (instanceof) mới biết có duyệt được hay không. */
    static void unpack(Show pShow, String pIndent) {
        System.out.println(pIndent + "- " + pShow.getClass().getSimpleName()
                + ": " + pShow.runningTime() + " phút");
        if (pShow instanceof CompositeShow composite) {
            for (Show child : composite) unpack(child, pIndent + "   ");
        }
    }
}
