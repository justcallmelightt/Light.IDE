public class BlockDemo {
    private int value;
    private int anotherValue;

    // 초기화 블록
    // 굳이 초기화 블록을 쓰지 않아도 된다. 생성자에서 초기화해도 된다, 실무에서 활용도가 많지않다. (완성도를 위해 배우는것)
    { 
        System.out.println("초기화 블록");
        value = 10;
        anotherValue = 20;
        System.out.println("초기화 필드에서는 " + value + " " + anotherValue);
        value = value + anotherValue;
    }

    public BlockDemo() {
        System.out.println("기본 생성자 ");
    }
}
