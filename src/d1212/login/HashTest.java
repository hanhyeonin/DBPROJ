package d1212.login;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

public class HashTest {
	
	public static void main(String[] args) {
		// 해시함수 : 문자열을 전달받아서 암호화(평문->암호화된 문자열). 암호화된 메세지를 평문으로 변환하지는 못함.
		//				  패스워드를 저장할 때 해시값으로 저장. 해시값은 해시함수에 따라 고정된 길이로 생성
		//				  대표적으로 sha256, sha512 함수등은 각각 256비트 또는 512비트 길이로 해시값 생성
		//				  외부라이브러리 guava를 사용하면 sha256 메소드가 있다.
		
		// 평문 1122 를 sha256 함수로 해시값 생성하기
		String hval = Hashing.sha256()
				.hashString("1122", StandardCharsets.UTF_8).toString();
		
		System.out.println("평문 '1122'를 sha256 함수로 해시값 만들기");
		System.out.println(hval);		// 256 비트를 16진수로 표시하면 64문자
		
		// 해시값으로 평문을 예측(계산) 할 수 없는 복잡한 알고리즘의 해시함수는 이미 검증된 것을 사용.
		
	}
	
}
