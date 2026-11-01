public class Movie implements Show {
    private final String aTitle;
    private final int aYear;
    private final int aRunningTime;

    public Movie(String pTitle, int pYear, int pRunningTime) {
        aTitle = pTitle; aYear = pYear; aRunningTime = pRunningTime;
    }
    @Override public String description() { return String.format("%s (%d)", aTitle, aYear); }
    @Override public int runningTime() { return aRunningTime; }
    @Override public Movie copy() { return new Movie(aTitle, aYear, aRunningTime); }
}
