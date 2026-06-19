class VariableStudy { // VariableStudy => 클래스 이름
    public static void main(String[] args) {
        /*
        // int => 변수 타입
        // a => 변수 이름
        // = => 대입문
        // 100 => 대입할 값(리터럴)
        // 기억공간 (메모리)에 4바이트 공간을
        // 할당하고 거기에 100이라는 숫자 저장
        int a = 100;
        int b = a;
        System.out.println(a);
        System.out.println(b);

        // 숫자로 시작할수 없다
        // _Aab100$$ = 200;
        // int 1a = 100; // 오류
        // int a1 = 100; // 올바름
        // 변수 이름은 대소문자랑 숫자만 써서 짓는다. (단, 숫자로 시작 불가)
        // 자바 예약어 사용 불가
        // int int = 100; // 오류
        // int default = 100; // 오류 -> int defaultValue = 100; // 올바름
        // int AAA = 100;
        // int AaA = 200;
        // int AAa = 300;

        // 변수 이름 짓기 규칙
        // 1. 카멜 케이스 (camel Case)
        int hello = 100;
        int helloWorld = 200;
        int helloMyWorld = 300;
        // int hello_my_world = 400;

        // 2. 파스칼 케이스 (Pascal Case)
        int Hello = 200;
        int HelloWorld = 300;
        */
        
        /*
        // 참, 거짓값 저장
        // 크기는 1바이트 (00000000 ~ 11111111)
        boolean bValue = true;
        bValue = false;

        // "한 글자" 저장
        // 크기는 2바이트 (65536개의 글자 표현 가능)
        // 홀따옴표 (작은따옴표)로 감싸기
        char cValue = 'A';
        cValue = 'B';
        // cValue = "AB"; // 오류

        // 정수형 -> 숫자 저장
        // -(2^(n-1)) ~ (2^(n-1) - 1)
        // byte => 1바이트
        // 0000 0000 ~ 1111 1111
        byte byteValue = 127;
        // short => 2바이트
        short shortValue = 32767;
        // int => 4바이트
        int intValue = Integer.MIN_VALUE; // MIN_VALUE -> -2147483648, MAX_VALUE -> 2147483647
        // long => 8바이트wk    
        long longValue = Long.MAX_VALUE;
        System.out.println(intValue);
        System.out.println(longValue);
        // 실제로 코딩할때 거의 대부분 케이스에서 int 타입 (21억), long 타입 (922경)까지는 충분히 표현 가능하기 때문에 int 타입을 주로 사용한다.
        // 주로 int랑 long 타입을 사용한다. (byte, short는 거의 사용하지 않는다.)

        long test1 = 1000l; // long 타입 리터럴은 숫자 뒤에 l 또는 L을 붙여준다. (int가 아니기 때문에)
        long test2 = 2000l;
        long test3 = 999999999999l;2
        */

        // 실수형
        float fValue = 3.14f; // float 타입 리터럴은 숫자 뒤에 f 또는 F를 붙여준다. 실수는 float이 기본, 둘다 4바이트
        // double은 실수의 저장 범위도 넓고, 더 정교한 배정도 (precision)를 가짐.
        double dValue = 3.14; // double 타입 리터럴은 숫자 뒤에 아무것도 붙이지 않는다. 더 정밀한 소수점을 표현할 수 있다. 더 큰 값을 저장할때도 씀.
        
        // 31P 
        char cValue2 = '\u0041';
        cValue2 = 65;
        cValue2 = 'A';
        System.out.println(cValue2);

        // 31P 이스케이프 시퀀스 (Escape Sequence)
        // print, println (프린트 라인)
        // System.out.println("new\nline"); 
        // System.out.println("new");
        // System.out.println("line");
        // System.out.println("print, println. println은 라인을 추가");
        // System.out.println("안녕\n하세\n요"); 
        // System.out.println("안녕\t하세\t요");
        // System.out.println("탭1\t탭2\t탭3");
        System.out.println("안녕\n하세\n요");
        System.out.println("탭1\t탭2\t탭3");
        // System.out.println("H\Brllo") // \b 웬만하면 안씀 자바 기초 지필용.
        System.out.println("안녕\r\n하세\r\n요");
        System.out.println("\'작은따옴표\'쓰기"); // 굳이 이럴 필요 없음.
        System.out.println("'작은따옴표'쓰기");
        System.out.println("\"작은따옴표\"쓰기");
        
        int decimal = 26; // 2/26 = 13...0, 2/13 = 6...1, 2/6 = 3...0, 2/3 = 1...1 뒤에서 부터 앞에 있는
        int octal = 032; // 2/30 = 15...0, 2/15 = 7...1, 2/7 = 3...1, 2/3 = 1...1
        int hex = 0x1A; // 16/26 = 1...10, 16/1 = 0...1 뒤에서 부터 앞에 있는 숫자에 16의 제곱을 곱해서 더해주면 된다. (16^0, 16^1, 16^2, ...)
        int binary = 0b11010; // 8/26 = 3...2, // 1A -> 16*1, 16*A -> 16, 10 -> 16 + 10 = 26
        
        // 오버플로우, 언더플로우
        int i1 = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        System.out.println(i1);
        System.out.println(i2);
        i1 = i1 + 1;
        i2 = i2 - 1;
        System.out.println(i1); // 오버플로우 -> -2147483648
        System.out.println(i2); // 언더플로우 -> 2147483647
        
        String s1 = "Hello";
    }   
}   
