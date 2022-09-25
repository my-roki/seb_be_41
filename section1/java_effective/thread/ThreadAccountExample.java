package section1.java_effective.thread;

public class ThreadAccountExample {
    public static void main(String[] args) {

        Runnable threadTask = new ThreadTask();
        Thread thread1 = new Thread(threadTask);
        Thread thread2 = new Thread(threadTask);

        thread1.setName("roki");
        thread2.setName("tiki");

        thread1.start();
        thread2.start();
    }
}

class Account {
    // 잔액을 나타내는 변수
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    // 인출 성공 시 true, 실패 시 false 반환
    public synchronized boolean withdraw(int money) {  // 메서드 전체를 임계 영역으로 지정하기.
        // 인출 가능 여부 판단 : 잔액이 인출하고자 하는 금액보다 같거나 많아야 합니다.
        if (balance >= money) {

            // if문의 실행부에 진입하자마자 해당 스레드를 일시 정지 시키고,
            // 다른 스레드에게 제어권을 강제로 넘깁니다.
            // 일부러 문제 상황을 발생시키기 위해 추가한 코드입니다.
            try {
                Thread.sleep(1000);
            } catch (Exception error) {
                throw new RuntimeException(error);
            }

            // 잔액에서 인출금을 깎아 새로운 잔액을 기록합니다.
            balance -= money;
            return true;
        }
        return false;
    }
}


class ThreadTask implements Runnable {
    Account account = new Account();

    public void run() {
        while (account.getBalance() > 0) {

            // 100 ~ 300원의 인출금을 랜덤으로 정합니다.
            int money = (int) (Math.random() * 3 + 1) * 100;

            // withdraw를 실행시키는 동시에 인출 성공 여부를 변수에 할당합니다.
            boolean denied = !account.withdraw(money);

            // 인출 결과 확인
            // 만약, withraw가 false를 리턴하였다면, 즉 인출에 실패했다면,
            // 해당 내역에 -> DENIED를 출력합니다.
            System.out.printf("Withdraw %d₩ By %s. Balance : %d %s%n",
                    money, Thread.currentThread().getName(), account.getBalance(), denied ? "-> DENIED" : "");
        }
    }
}