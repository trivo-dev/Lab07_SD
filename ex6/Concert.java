public class Concert implements Show {
    private final String aTitle;
    private final String aPerformer;
    private final int aRunningTime;

    public Concert(String pTitle, String pPerformer, int pRunningTime) {
        aTitle = pTitle; aPerformer = pPerformer; aRunningTime = pRunningTime;
    }
    @Override public String description() { return String.format("%s by %s", aTitle, aPerformer); }
    @Override public int runningTime() { return aRunningTime; }
    @Override public Concert copy() { return new Concert(aTitle, aPerformer, aRunningTime); }
}
