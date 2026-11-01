public class Main {
    public static void main(String[] args) {
        Show movie = new Movie("Metropolis", 1927, 153);
        Show concert = new Concert("Moonlight Sonata", "Yuja Wang", 20);
        Show inner = new CompositeShow(movie, concert);
        Show program = new CompositeShow(inner, new Movie("Nosferatu", 1922, 94));

        System.out.println(program.description());
        System.out.println("Total running time: " + program.runningTime() + " min");

        unpack(program, "");

        // Duyệt một show lá: vòng lặp chạy 0 lần, không lỗi
        int count = 0;
        for (Show s : movie) count++;
        System.out.println("Children of a Movie: " + count);
    }

    /** Không cần instanceof: mọi Show đều duyệt được. */
    static void unpack(Show pShow, String pIndent) {
        System.out.println(pIndent + "- " + pShow.getClass().getSimpleName()
                + ": " + pShow.runningTime() + " min");
        for (Show child : pShow) unpack(child, pIndent + "   ");
    }
}
