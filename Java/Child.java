public class Child extends Parent {
    // extends 했기 떄문에 안보이지만  String name;, int age;가 있다
    // extends -> 상속
    public void hello() {
        System.out.println(name); // 그러나 private이기 때문에 접근 불가
        System.out.println(age);
        bye()

        // protected String name; protected int age;로 바꾸면 접근 가능
    }
    
}
