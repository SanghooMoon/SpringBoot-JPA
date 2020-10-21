package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {
	// 메인 메서드, 스프링부트 실행 메서드
	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}
}
