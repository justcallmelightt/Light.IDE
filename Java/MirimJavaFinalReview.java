import java.util.Scanner; // [1, 2] 키보드 입력을 받기 위한 클래스
import java.util.Arrays;  // [3, 4] 배열 조작(출력, 정렬 등)을 위한 유틸리티
import java.util.Random;  // [5, 6] 난수 생성을 위한 클래스

/**
 * [미림마이스터고 1학기 자바 프로그래밍 통합 복습 클래스]
 * 이 코드는 변수, 연산자, 제어문, 배열, 객체 지향 클래스 (OOP) 핵심 개념을 포함합니다.
 * 
 * Javadoc 주석: /**로 시작하며 HTML 문서나 IntelliJ 툴팁 생성에 사용됩니다. [7, 8]
 * @author justcallmelightt
 * @version 1.0 (2026-06-30)
 */
public class MirimJavaFinalReview {

    // --- 1. 클래스 필드와 접근 제어자 ---

    // [private]: 접근 제어자. 클래스 내부에서만 접근 가능하게 하여 데이터를 보호(캡슐화)합니다. [9-11]
    // 외부에서 필드에 직접 접근하는 것을 막아 데이터의 무결성을 유지하는 것이 핵심입니다. [11, 12]
    private String studentName;
    private int[] subjectScores; // 1차원 배열 필드 [4, 13]

    // [static]: 정적 필드. 모든 인스턴스가 공유하며, 객체 생성 없이 클래스명으로 접근 가능합니다. [9, 10, 12]
    private static int studentCount = 0; 

    // [final]: 상수 필드. 한 번 초기화하면 값을 변경할 수 없습니다. [9, 10, 12]
    private final String SCHOOL_NAME = "미림마이스터고";

    // --- 2. 생성자 (Constructor) ---

    // [기본 생성자]: 매개변수가 없는 생성자. 생성자를 정의하지 않으면 컴파일러가 자동 생성하나, 
    // 매개변수 생성자가 하나라도 있으면 직접 정의해야 합니다. [14-16]
    public MirimJavaFinalReview() {
        // [this()]: 현재 클래스의 다른 생성자를 호출하여 코드 중복을 방지합니다. [14, 15, 17]
        this("미입력", new int[]{0, 0, 0});
    }

    // [매개변수 생성자]: 객체 생성 시 필드를 초기화합니다. (생성자 오버로딩) [14, 15, 17]
    public MirimJavaFinalReview(String name, int[] scores) {
        // [this.필드명]: 매개변수와 필드 이름이 같을 때 클래스 필드임을 명시합니다. [14, 15, 17]
        this.studentName = name;
        this.subjectScores = scores;
        studentCount++; // 객체가 생성될 때마다 공유 카운트 증가 [18]
    }

    // --- 3. 게터와 세터 (Getter & Setter) ---
    // private 필드에 안전하게 접근하고 값을 수정하기 위한 통로입니다. [12, 14, 19]
    public String getStudentName() { return studentName; }
    public void setStudentName(String name) { this.studentName = name; }

    /**
     * 비트 연산자 복습 메서드
     * 컴퓨터의 내부 데이터 표현인 이진법과 2의 보수 개념을 바탕으로 합니다. [20-22]
     */
    public static void showBitwiseDemo(int a, int b) {
        // 비트 AND(&), OR(|), XOR(^), NOT(~) 연산 [23-25]
        System.out.println("비트 AND (둘 다 1일 때 1): " + (a & b));
        System.out.println("비트 OR (하나라도 1이면 1): " + (a | b));
        
        // 시프트 연산: 비트를 칸 수만큼 이동 [23, 25]
        // << (왼쪽 시프트): 값을 2배씩 증가시킴 [25, 26]
        System.out.println("왼쪽 시프트 (a << 2): " + (a << 2)); 
    }

    public static void main(String[] args) {
        // --- 4. 변수와 데이터형 ---
        // 기본형 8가지: byte(1), short(2), int(4), long(8), float(4), double(8), char(2), boolean(1) [27-29]
        int mirimAge = 17;
        long worldPop = 8000000000L; // long 리터럴은 접미사 L 필수 [29, 30]
        float weight = 55.5F;        // float 리터럴은 접미사 F 필수 [29, 31]
        char mirimGrade = 'A';       // char는 작은따옴표(' ') 사용 [29, 30]
        boolean isCodingFun = true;

        // --- 5. 입력과 형식화 출력 ---
        Scanner sc = new Scanner(System.in); // [1, 32]
        System.out.print("복습할 학생의 이름을 입력하세요: ");
        String inputName = sc.next();

        // [printf]: 형식 지정자를 사용한 출력 (%d: 정수, %f: 실수, %s: 문자열, %n: 개행) [33, 34]
        System.out.printf("[%s] 학생의 나이는 %d세이며 성적은 %c입니다.%n", inputName, mirimAge, mirimGrade);

        // --- 6. 배열과 제어문 (for, if) ---
        int[] scores = {90, 85, 95}; // 1차원 배열 선언 및 초기화 [4, 13]
        
        // Arrays.sort(): 배열의 요소를 오름차순으로 정렬합니다. [4, 13, 35]
        Arrays.sort(scores);
        System.out.println("정렬된 점수(Arrays.toString): " + Arrays.toString(scores));

        int totalSum = 0;
        // scores.length: 배열의 크기를 반환합니다. [4, 13]
        for (int i = 0; i < scores.length; i++) {
            totalSum += scores[i];
        }

        // [형변환(Casting)]: 정수 나눗셈의 소수점을 살리기 위해 double로 변환합니다. [27, 31, 36]
        double average = (double) totalSum / scores.length;

        // --- 7. 조건문 (if-else) ---
        if (average >= 90) {
            System.out.println("평균: " + average + " (우수)");
        } else {
            System.out.println("평균: " + average + " (보통)");
        }

        // --- 8. 객체 생성 및 활용 ---
     MirimJavaFinalReview student1 = new MirimJavaFinalReview(inputName, scores);
        System.out.println("생성된 객체 이름(Getter): " + student1.getStudentName());
        System.out.println("총 등록 학생 수(static): " + MirimJavaFinalReview.studentCount);

        // --- 9. 2차원 배열과 중첩 for문 ---
        int[][] classScores = { {90, 80}, {85, 75} }; // 2차원 배열 [4, 13]
        System.out.println("2차원 배열 행의 수: " + classScores.length);

        // --- 10. 랜덤값 생성 ---
        Random random = new Random(); // [5, 37]
        int luckyNum = random.nextInt(100) + 1; // 1~100 사이의 난수 [6, 37]
        System.out.println("오늘의 행운 점수: " + luckyNum);

        // --- 11. 비트 연산 테스트 ---
        showBitwiseDemo(13, 7); // 13(0b1101), 7(0b0111) [26, 38]

        sc.close(); // Scanner 자원 해제
    }
}
