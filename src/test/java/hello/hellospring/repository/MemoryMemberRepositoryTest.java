package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


// MemoryMemberRepository 클래스를 테스트하기 위한 클래스
class MemoryMemberRepositoryTest {

    // 구현한 MemoryMemberRepository를 테스트하기위해 객체 생성
   MemoryMemberRepository repository = new MemoryMemberRepository();

    // 하나의 메서드(테스트)가 끝낼때마다 동작, 테스트는 순서가 없으므로 하나의 테스트가 끝날때마다 초기화 해주는 작업
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test   // 테스트를 위한 어노테이션(JUnit 프레임워크)
    public void save() {
        Member member = new Member();
        member.setName("sanghoo");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        // jUnit 메서드 assertThat(비교주체) .isEqualTo(비교대상), 비교연산은 잘 사용하지 않음.
        // Assertions.assertThat(member).isEqualTo(result); 이 원문. 객체.* 로 import하여 생략가능(Line 10)
        // ALT + Enter -> add on demand static import for ~~
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1= new Member();
        member1.setName("spring1");
        repository.save(member1);

        // shift + F6 = 변수 명 rename 꿀팁
        Member member2= new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
