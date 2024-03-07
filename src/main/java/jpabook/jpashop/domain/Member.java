package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter // lombok 사용해서 따로 작성 안해도 됨
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)// db가 자동으로 생성
    @Column(name = "member_id") // 기본키 테이블명
    @JsonIgnore
    private Long id;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "member_name", length = 50)
    private String name;

    @Embedded // @Embeddable과 둘 중 하나만 있어도 됨
    private Address address;

    @OneToMany(mappedBy = "member") // Order 테이블에 있는 member로 인하여 맵핑됨. 값을 넣는다고 해서 외래키가 바뀌지 않고 읽기만 가능
    private List<Order> orders = new ArrayList<>(); // 컬렉션은 바꾸지마라

//    @Builder
//    public Member(Long id, String name, Address address, )
}

