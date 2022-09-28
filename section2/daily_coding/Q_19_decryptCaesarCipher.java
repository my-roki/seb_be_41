package section2.daily_coding;

/*
decryptCaesarCipher
문제
암호화된 문자열과 암호화 키를 입력받아 복호화된 문자열을 리턴해야 합니다.
카이사르 암호(Caesar cipher)는 평문(plaintext)을 암호키 secret개만큼 (오른쪽으로) 평행이동시켜 암호화 합니다.
복호화는 암호화된 문자열을 원래의 평문으로 복원하는 것을 말합니다.

'hello'를 secret 3으로 암호화한 경우: 'khoor'
'codestates'를 secret 11로 암호화한 경우: 'nzopdelepd'

입력
인자 1 : str
String 타입의 알파벳 소문자 문자열
인자 2 : secret
int 타입의 암호화 키

출력
String 타입을 리턴해야 합니다.

주의 사항
빈 문자열을 입력받은 경우, 빈 문자열을 리턴해야 합니다.
공백은 그대로 두어야 합니다.
입력된 문자열은 모두 소문자만 입력됩니다.

입출력 예시
String output = decryptCaesarCipher("khoor", 3);
System.out.println(output); // --> hello

output = decryptCaesarCipher("zruog", 3);
System.out.println(output); // --> world
 */

public class Q_19_decryptCaesarCipher {
    public static void main(String[] args) {
        // write test case here
        Q_19_decryptCaesarCipher coplit = new Q_19_decryptCaesarCipher();
        String output = coplit.decryptCaesarCipher("khoor", 3);
        System.out.println(output); // --> hello

        output = coplit.decryptCaesarCipher("zruog", 3);
        System.out.println(output); // --> world

        output = coplit.decryptCaesarCipher("mnv xnt zqd qdzcx sn lnud sn hlldqrhud bntqrd", 25);
        System.out.println(output); // --> now you are ready to move to immersive course
    }

    public String decryptCaesarCipher(String str, int secret) {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";  // 이거 맞나...? 이 문제중에서 가장 어려운 부분이군요^^;;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (letter == ' ') {
                stringBuilder.append(" ");
                continue;
            }

            int alphabetIdx = alphabets.indexOf(letter);
            // abc같은 앞 문자열을 복호화 할 때 xyz로 넘어가야하니 idx가 음수일 때 처리하는 코드
            int decode = alphabetIdx - secret;
            while (decode < 0) decode += alphabets.length();
            stringBuilder.append(alphabets.charAt(decode));
        }
        return stringBuilder.toString();
    }
}
