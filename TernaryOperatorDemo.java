public class TernaryOperatorDemo {
    public static void main(String[] args) {

        // 1. 기본 삼항 연산자
        int a = 10, b = 20;
        int max = (a > b) ? a : b;
        System.out.println("max : " + max); // 20
        System.out.println();

        // 2. 낚시 포인트 - 타입 불일치 시 자동 형변환
        int x = 10;
        double result = (x > 5) ? 1 : 2.0; // 1은 int, 2.0은 double → 1도 double로 승격
        System.out.println("result : " + result); // 1.0 ← 낚시! 1 아님
        System.out.println();

        // 3. 낚시 포인트 - 중첩 삼항 연산자 (쓰지 말 것)
        int num = 75;
        // 동작은 하지만 가독성이 매우 나쁨 - 실무에서 지양
        String level = (num >= 90) ? "A" : (num >= 70) ? "B" : (num >= 50) ? "C" : "F";
        System.out.println("level : " + level);  // B
    }
}
