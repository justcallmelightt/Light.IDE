public class Random {
    public static void main(String[] args) {
        double rand = Math.random();

        int dice = (int)(Math.random() * 6) + 1;                     // 1~6
        int randInRange = (int)(Math.random() * (20 - 10 + 1)) + 10; // 10~20
    }
}
