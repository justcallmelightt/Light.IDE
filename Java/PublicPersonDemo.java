public class PublicPersonDemo {
    public static void main(String[] args) {
        PublicPerson person = new PublicPerson("철수");
        // System.out.println(person.name);
        System.out.println(person.getName());
        // person.name = "영희";
        person.setName("영희");
        // person.greet(); // private이기 때문에 접근 불가
        person.publicgreet(); // publicgreet()이라는 메서드로는 private인 greet()를 호출할 수 있다.
    }
}
