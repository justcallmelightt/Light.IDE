// FinalAndInitBlockDemo.java
// 주제: final 필드, 인스턴스 초기화 블록, static 초기화 블록

class Circle {
    // final 필드: 한 번 초기화 후 변경 불가
    private final double PI = 3.14159;  // 선언 시 초기화
    private final double radius;        // 생성자에서 초기화 (선언 시 값 없음)

    public Circle(double radius) {
        this.radius = radius;
        // this.radius = 999;  // 컴파일 에러: final 필드는 재대입 불가
        // PI = 3.0;           // 컴파일 에러: 이미 선언 시 초기화됨
    }

    public double getArea() {
        return PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }
}

class InitBlockDemo {
    private int value;
    private int anotherValue;
    private String tag;

    // ================================================================
    // 인스턴스 초기화 블록: 모든 생성자 호출 전에 실행
    // ================================================================
    {
        value = 10;
        anotherValue = 20;
        System.out.println("인스턴스 초기화 블록 실행: value=" + value + ", anotherValue=" + anotherValue);
    }

    public InitBlockDemo() {
        System.out.println("기본 생성자 호출");
    }

    public InitBlockDemo(int value) {
        this.value = value;  // 초기화 블록의 10을 덮어씀
        System.out.println("매개변수 생성자 호출: value=" + this.value);
    }

    public InitBlockDemo(int value, String tag) {
        this.value = value;
        this.tag = tag;
        System.out.println("태그 생성자 호출: value=" + this.value + ", tag=" + tag);
    }

    public String getStatus() {
        return "value=" + value + ", anotherValue=" + anotherValue + ", tag=" + tag;
    }
}

class StaticBlockDemo {
    public int instanceValue;
    public static int staticValue;

    // ================================================================
    // static 초기화 블록: 클래스 로딩 시 딱 한 번 실행
    // 인스턴스 생성 없이도 실행됨
    // ================================================================
    static {
        staticValue = 20;
        // instanceValue = 10;  // 컴파일 에러: 인스턴스 필드 접근 불가
        System.out.println("static 초기화 블록 실행: staticValue=" + staticValue);
    }
}

public class FinalAndInitBlockDemo {
    public static void main(String[] args) {

        // ================================================================
        // 1. final 필드 - 변경 시도
        // ================================================================
        Circle c1 = new Circle(5.0);
        Circle c2 = new Circle(3.0);

        System.out.println("c1 넓이: " + c1.getArea());
        System.out.println("c2 넓이: " + c2.getArea());

        // final 필드는 각 객체마다 독립적으로 존재하지만, 한 번 설정되면 변경 불가
        System.out.println("c1 반지름: " + c1.getRadius()); // 5.0
        System.out.println("c2 반지름: " + c2.getRadius()); // 3.0

        System.out.println();

        // ================================================================
        // 2. Java 표준 라이브러리의 static final 상수들
        // ================================================================
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("Math.PI = " + Math.PI);
        System.out.println("Math.E  = " + Math.E);

        System.out.println();

        // ================================================================
        // 3. 인스턴스 초기화 블록 - 실행 순서 확인
        // ================================================================
        System.out.println("--- i1 생성 ---");
        InitBlockDemo i1 = new InitBlockDemo();

        System.out.println("--- i2 생성 ---");
        InitBlockDemo i2 = new InitBlockDemo(50);

        System.out.println("--- i3 생성 ---");
        InitBlockDemo i3 = new InitBlockDemo(99, "X");

        System.out.println();
        System.out.println("i1: " + i1.getStatus());
        System.out.println("i2: " + i2.getStatus()); // value=50으로 덮어써짐
        System.out.println("i3: " + i3.getStatus());

        System.out.println();

        // ================================================================
        // 4. static 초기화 블록 - 클래스 로딩 시 한 번만 실행
        // ================================================================
        // StaticBlockDemo를 처음 참조하는 시점에 static 블록이 실행됨
        System.out.println("StaticBlockDemo.staticValue = " + StaticBlockDemo.staticValue);
        System.out.println("StaticBlockDemo.staticValue = " + StaticBlockDemo.staticValue); // static 블록은 재실행 안 됨

        System.out.println();

        // ================================================================
        // 5. final + static 조합 - 클래스 상수 패턴
        // ================================================================
        // 일반적으로 상수는 public static final로 정의
        // Math.PI처럼 클래스 이름으로 접근하는 상수가 이 패턴
        final int MAX_RETRY = 3;    // 지역 상수: 해당 블록 안에서만 유효
        // MAX_RETRY = 5;           // 컴파일 에러
        System.out.println("MAX_RETRY = " + MAX_RETRY);
    }
}
