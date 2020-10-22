package hello.hellospring.domain;

import javax.persistence.*;

@Entity // jpa가 관리하는 Entity를 선언
public class Member {

    // 필드
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // getter, setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
