package section1.java_effective.thread;

public class ThreadExample3 {
    public static void main(String[] args) {
        System.out.println("ThreadExample3");

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.print("*");
                }
            }
        });

        thread3.start();  // 작업 스레드를 실행시켜, run() 내부의 코드를 처리하도록 합니다.

        // 반복문 추가
        for (int i = 0; i < 100; i++) {
            System.out.print("@");
        }
    }
}

