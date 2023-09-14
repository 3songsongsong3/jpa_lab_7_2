package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 영속성 전이: CASCADE
 * 특정 엔티티를 영속 상태로 만들 때 연관된 엔티티도 함께 영속 상태로 만들고 싶으면 영속성 전이 기능을 사용하면 된다.
 * 영속성 전이를 사용하면 부모 엔티티를 저장할 때 자식 엔티티도 함께 저장할 수 있다.
 */
@Entity
public class Parent {

    @Id @GeneratedValue
    private Long id;

    // 부모를 영속화할 때 연관된 자식들도 함께 영속화 하는 옵션
    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST)
    private List<Child> children = new ArrayList<>();


}
