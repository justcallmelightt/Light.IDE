public class PrivatePerson {
    // 모든 필드를 전부 private로 하고 접근을 모두 getter, setter를 통해서만 접근하도록 한다.
    private String name;

    public PrivatePerson(String name) {
        this.name = name;
    }

    // Getter, Setter 거의 99.9% public , private인 경우 매우 드뭄
    // 접근을 Public 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private void greet() {
        System.out.println("");
    }

    // 간접성, publicgreet()이라는 메서드로는 private인 greet()를 호출할 수 있다.
    // 클래스 안에서 접근하는건 가능하다. {중괄호 안에서}
    public void publicgreet() {
        this.greet();
    }
}
