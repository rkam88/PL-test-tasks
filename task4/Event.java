public class Event implements Comparable<Event>{
    //the time of the event in minutes
    private int time;
    //1 for customer entry, -1 for customer exit
    private int change;

    public Event(int time, int change) {
        this.time = time;
        this.change = change;
    }

    public int getTime() {
        return time;
    }

    public int getChange() {
        return change;
    }



    @Override
    public int compareTo(Event o) {
        return this.time - o.getTime();
    }
}
