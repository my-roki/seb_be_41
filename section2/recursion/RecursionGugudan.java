package section2.recursion;

public class RecursionGugudan {
    public static void main(String[] args) {
        RecursionGugudan gugudan = new RecursionGugudan();
        System.out.println("----- For Loop -----");
        gugudan.GugudanForLoop(9);

        System.out.println("----- Recursion -----");
        gugudan.GugudanRecursion(8, 0);
    }

    // 반복문으로 구현한 구구단 메서드
    public void GugudanForLoop(int level) {
        for(int count = 0; count < 9; count++) {
            System.out.printf("%d x %d = %d\n", level, count, level * count);
        }
    }

    // 재귀 호출로 구현한 구구단 메서드
    public void GugudanRecursion(int level, int count) {
        if(count > 9) {
            return;
        }
        System.out.printf("%d x %d = %d\n", level, count, level*count);
        GugudanRecursion(level, ++count);
    }
}