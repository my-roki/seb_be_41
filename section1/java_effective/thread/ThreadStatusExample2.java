package section1.java_effective.thread;

public class ThreadStatusExample2 {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.setTo(10);
        sumThread.start();

        // 메인 스레드가 sumThread의 작업이 끝날 때까지 기다립니다.
        try {
            sumThread.join();
        } catch (Exception ignored) {}

        System.out.printf("1부터 %d까지의 합 : %d%n", sumThread.getTo(), sumThread.getSum());
    }
}

class SumThread extends Thread {
    private long sum;
    private int to;

    public long getSum() {
        return sum;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public void run() {
        for (int i = 1; i <= to; i++) {
            sum += i;
        }
    }
}