package section2.daily_coding;

/*
# **primePassword**

## **문제**

다음의 조건을 만족하면서 현재의 비밀번호('curPwd')를 새 비밀번호(`newPwd`)로 변경하는 데 필요한 최소 동작의 수를 리턴해야 합니다.

- 한 번에 한 개의 숫자만 변경가능하다.
- 4자리의 소수(prime)인 비밀번호로만 변경가능하다.

정리하면, 비밀번호가 계속 소수를 유지하도록 숫자 한 개씩을 바꿔갈 때 현재 비밀번호에서 새 비밀번호로 바꾸는 데 최소 몇 개의 숫자를 변경해야 하는지를 리턴해야 합니다.

## **입력**

### **인자 1 : curPwd**

- `int` 타입의 1,000 이상 9,999 이하의 자연수

### **인자 2 : newPwd**

- `int` 타입의 1,000 이상 9,999 이하의 자연수

## **출력**

- `int` 타입을 리턴해야 합니다.

## **주의사항**

- 4자리인 소수는 1,000 이상의 소수를 말합니다.(0011, 0997 등은 제외)
- 새 비밀번호를 만들 수 없는 경우 -1을 리턴합니다.

## **입출력 예시**

```
int output = primePassword(1033, 1033);
System.out.println(output); // --> 0

output = primePassword(3733, 8779);
System.out.println(output); // --> 3 (3733 -> 3739 -> 3779 -> 8779)
```
 */

class Q_40_primePassword {
    public static void main(String[] args) {
        // write test case here
        Q_40_primePassword coplit = new Q_40_primePassword();

    }

    public int primePassword(int curPwd, int newPwd) {
        return 0;
    }

}