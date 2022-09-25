package section1.java_effective.thread;

public class ThreadExample2 {
    public static void main(String[] args) {
        System.out.println("ThreadExample2");

        ThreadTask2 thread2 = new ThreadTask2();
        thread2.start();  // 작업 스레드를 실행시켜, run() 내부의 코드를 처리하도록 합니다.

        // 반복문 추가
        for (int i = 0; i < 100; i++) {
            System.out.print("@");
        }
    }
}

// Runnable 인터페이스를 구현하는 클래스
class ThreadTask2 extends Thread {
    @Override
    public void run() {
        // run() 메서드 바디에 스레드가 수행할 작업 내용 작성
        for (int i = 0; i < 100; i++) {
            System.out.print("*");
        }
    }
}