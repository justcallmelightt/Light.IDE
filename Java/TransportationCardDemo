// 하나의 파일 안에 설계도와 실행(main) 클래스를 완전히 합친 구조입니다.
// 파일 이름은 반드시 public class의 이름과 같은 'TransportationCardDemo.java'여야 합니다.

// =========================================================================
// [클래스 1] 교통카드 설계도 클래스 (인스턴스 및 정적 멤버들이 정의된 곳)
// =========================================================================
class TransportationCard {
    
    // 1. 필드 (Fields) 선언 영역
    static int totalCardsIssued = 0;   // [정적 필드] 전체 발급 수 (공유 데이터)
    static final int BASE_FARE = 1400; // [정적 필드] 기본 버스 요금 (공유 데이터)

    String ownerName;                  // [인스턴스 필드] 소유자 이름 (개별 데이터)
    int balance;                       // [인스턴스 필드] 카드 잔액 (개별 데이터)

    // 2. 생성자 (Constructor) 영역
    TransportationCard(String ownerName, int balance) {
        this.ownerName = ownerName;    // 인스턴스 필드 초기화
        this.balance = balance;        // 인스턴스 필드 초기화
        totalCardsIssued++;            // [규칙 3] 인스턴스 영역 -> 정적 필드 접근 가능!
    }

    // 3. 클래스(정적) 메서드 영역
    static void printSystemStatus() {
        System.out.println("\n===== [중앙 교통 시스템 현황] =====");
        System.out.println("▶ 현재 전국의 버스 기본 요금: " + BASE_FARE + "원"); // [규칙 1] 정적 -> 정적 필드 가능
        System.out.println("▶ 시스템에 등록된 총 발급 카드 수: " + totalCardsIssued + "개"); // [규칙 1] 정적 -> 정적 필드 가능
        
        // System.out.println(ownerName); // [규칙 2] 에러! 정적 메서드 -> 인스턴스 필드 접근 불가능
    }

    // 4. 인스턴스 메서드 영역
    void tagBus() {
        System.out.println("\n--- [" + this.ownerName + "님의 카드 태그] ---");
        
        // [규칙 3] 인스턴스 메서드 내에서 정적 필드(BASE_FARE)와 인스턴스 필드(balance) 모두 접근 가능!
        if (this.balance >= BASE_FARE) {
            this.balance -= BASE_FARE; 
            System.out.println("버스에 탑승합니다. 정상 처리되었습니다.");
            System.out.println("차감 금액: " + BASE_FARE + "원 / 남은 잔액: " + this.balance + "원");
        } else {
            System.out.println("잔액이 부족합니다! 현재 잔액: " + this.balance + "원 (기본요금: " + BASE_FARE + "원)");
        }
    }

    void chargeCard(int amount) {
        this.balance += amount;
        System.out.println("[" + this.ownerName + "] " + amount + "원 충전 완료! (현재 잔액: " + this.balance + "원)");
    }
}


// =========================================================================
// [클래스 2] 프로그램 실질적 실행 클래스 (main 메서드가 포함된 곳)
// =========================================================================
public class TransportationCardDemo {
    public static void main(String[] args) {
        
        // 1. 객체를 단 하나도 만들지 않은 상태에서 'TransportationCard'의 정적 메서드 호출
        TransportationCard.printSystemStatus();
        
        // 2. 첫 번째 인스턴스(객체) 생성 및 인스턴스 메서드 사용
        TransportationCard card1 = new TransportationCard("김민우", 3000);
        card1.tagBus(); 
        
        // 3. 두 번째 인스턴스(객체) 생성 및 인스턴스 메서드 사용
        TransportationCard card2 = new TransportationCard("이서연", 1000);
        card2.tagBus(); 
        card2.chargeCard(5000); 
        card2.tagBus(); 
        
        // 4. 모든 작업이 끝난 후 다시 'TransportationCard'의 정적 메서드 호출
        TransportationCard.printSystemStatus();
    }
}
