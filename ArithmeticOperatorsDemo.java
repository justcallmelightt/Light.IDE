public class ArithmeticOperatorsDemo {
    public static void main(String[] args) {

        // 1. 기본 산술 연산
        int a = 10, b = 3;
        System.out.println("a + b = " + (a + b)); // 13
        System.out.println("a - b = " + (a - b)); // 7
        System.out.println("a * b = " + (a * b)); // 30
        System.out.println("a / b = " + (a / b)); // 3  ← 정수 나눗셈!
        System.out.println("a % b = " + (a % b)); // 1
        System.out.println();

        // 2. 정수 나눗셈 vs 실수 나눗셈 (가장 많이 낚임)
        System.out.println("10 / 3   = " + (10 / 3));   // 3
        System.out.println("10 / 3.0 = " + (10 / 3.0)); // 3.3333...
        System.out.println("10.0 / 3 = " + (10.0 / 3)); // 3.3333...

        // 변수로 나눌 때 - 리터럴과 달리 실수 결과를 원하면 명시적 형변환 필요
        int x = 7, y = 2;
        System.out.println("x / y            = " + (x / y));           // 3   ← int / int, 정수 나눗셈
        // x를 명시적으로 double 변환 → 피연산자가 double이므로 y도 자동으로 double로 승격됨
        System.out.println("(double)x / y    = " + ((double) x / y));  // 3.5 ← double / double
        // 먼저 int / int 정수 나눗셈 후 결과를 double로 변환 → 소수점 이미 손실
        System.out.println("(double)(x / y)  = " + ((double)(x / y))); // 3.0 ← (int 나눗셈 결과) → double
        System.out.println();

        // 3. 오버플로우 - short 범위 초과
        short max = Short.MAX_VALUE;  // 32,767
        System.out.println("MAX_VALUE     = " + max);
        System.out.println("MAX_VALUE + 1 = " + (short)(max + 1)); // -32768 ← 오버플로우!
        System.out.println("int로 처리    = " + (max + 1));        // 정상
        System.out.println();

        // 4. 나머지 연산자 활용 (짝수/홀수 판별)
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + "은(는) " + (i % 2 == 0 ? "짝수" : "홀수"));
        }

        System.out.println();

        // 5. 문자열 + 숫자 더하기 함정
        System.out.println("결과: " + 2 + 3);   // "결과: 23"  ← 함정!
        System.out.println("결과: " + (2 + 3)); // "결과: 5"   ← 괄호로 해결
    }
}
