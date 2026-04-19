package hello.demo.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        //this.price = price; // 여기서 문제 발생
        // 문제 점을 해결하기 위해 반환값 void → int 변경
        return price;
    }

    /*
    public int getPrice() {
        return price;
    }
     */

}
