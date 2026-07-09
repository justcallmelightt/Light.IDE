/**
 * [학습 포인트: 클래스 멤버(static) vs 인스턴스 멤버]
 * * 1. static (클래스/정적 멤버):
 * - JVM이 프로그램을 시작할 때, 클래스 로더가 이 클래스를 읽어 '메서드 영역(Method Area)'에 바로 메모리를 할당합니다.
 * - 객체(new)를 생성하지 않아도 클래스 이름만으로 접근이 가능하며, 모든 객체가 '공유'하는 자원입니다.
 * * 2. non-static (인스턴스 멤버):
 * - 반드시 `new` 연산자를 통해 객체가 생성되어야만 '힙 영역(Heap Area)'에 메모리가 할당됩니다.
 * - 각 객체마다 독립적인 메모리 공간을 가집니다.
 */
public class PersonWithStatic {
    // 1. static 변수 (클래스 변수, 공유 변수)
    // JVM 메모리의 메서드 영역에 단 1개만 생성됨. 모든 Person 객체가 이 값을 공유.
    public static int count = 0; 
    public static String hello = "Hello";
    
    // 배열도 객체이므로 static으로 선언하면 프로그램 시작 시 참조 변수와 배열 공간이 생성되어 공유됨.
    public static int[] numbers = new int[5]; 

    // 2. 인스턴스 변수 (객체 변수)
    // new PersonWithStatic()을 할 때마다 힙(Heap) 메모리에 독립적으로 생성됨.
    // 객체마다 서로 다른 이름을 가질 수 있음.
    public String name;

    // 3. static 메서드 (클래스 메서드)
    /**
     * [중요 컴파일 오류 원인]
     * static 메서드는 객체가 생성되지 않은 상태(힙 메모리에 아무것도 없는 상태)에서도 호출할 수 있습니다.
     * 반면 인스턴스 변수(name)는 객체가 생성되어야만 힙에 존재합니다.
     * * 따라서 static 메서드가 실행되는 시점에는 name 변수가 메모리에 없을 수 있기 때문에,
     * static 메서드 내부에서는 인스턴스 변수(name)나 객체 자신을 뜻하는 'this' 키워드를 절대 사용할 수 없습니다.
     */
    public static int getCount() {
        // System.out.println(this.name); 
        // 👆 [컴파일 에러!] "Cannot make a static reference to the non-static field name"
        
        // static 메서드 안에서는 같은 static 멤버(hello, count)만 자유롭게 접근할 수 있습니다.
        System.out.println(hello + "! 현재 등록된 총 인원 수를 반환합니다.");
        return count;
    }

    // 4. 생성자 (Constructor)
    /**
     * JVM 메커니즘 관점에서의 생성자:
     * 개발자가 `new PersonWithStatic("홍길동")`을 호출하면, 
     * JVM은 힙 메모리에 name 공간을 만들고 이 생성자 코드를 실행합니다.
     * 이때 static 변수인 count는 이미 메서드 영역에 존재하므로, 생성자 안에서 접근하여 값을 1씩 증가(공유 데이터 누적)시킬 수 있습니다.
     */
    public PersonWithStatic(String name) {
        this.name = name; // 인스턴스 변수 초기화
        count++;          // 클래스 변수(공유 자원) 값 증가
    }
}
