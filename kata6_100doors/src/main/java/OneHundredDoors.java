public class OneHundredDoors {

    public static boolean[] doors;

    public static void crossingTheDoorsOneHundredOfTimes() {
        doors = new boolean[100];
        int passage = 1;
        while (passage <= 100) {
            for (int door = passage-1; door < doors.length; door= door + passage) {
                doors[door] = !doors[door];
            }
            passage++;
        }
    }
}
