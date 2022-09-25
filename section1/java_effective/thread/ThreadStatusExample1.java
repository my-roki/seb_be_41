package section1.java_effective.thread;

public class ThreadStatusExample1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            public void run() {
                try {
                    while (true) Thread.sleep(1000);
                } catch (Exception ignored) {
                }
                System.out.println("Woke up!");
            }
        };

        System.out.println("thread1.getState() = " + thread1.getState());
        thread1.start();
        System.out.println("thread1.getState() = " + thread1.getState());

        while (true) {
            if (thread1.getState() == Thread.State.TIMED_WAITING) {
                System.out.println("thread1.getState() = " + thread1.getState());
                break;
            }
        }

        thread1.interrupt();

        while (true) {
            if (thread1.getState() == Thread.State.RUNNABLE) {
                System.out.println("thread1.getState() = " + thread1.getState());
                break;
            }
        }

        while (true) {
            if (thread1.getState() == Thread.State.TERMINATED) {
                System.out.println("thread1.getState() = " + thread1.getState());
                break;
            }
        }
    }
}