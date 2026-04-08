package hello.demo.singleton;

// 싱글톤 개념을 이해하기 위한 클래스, 순수 객체가 아니고 학습용이기에 test 폴더 아래에 그대로 진행
public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private 으로 선언하여 외부에서 선언을 불가능하게 설정
    private SingletonService() {
        
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }



}
