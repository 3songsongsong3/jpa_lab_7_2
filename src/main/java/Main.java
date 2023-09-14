import entity.Child;
import entity.Parent;

public class Main {

    public static void main(String[] args) {



    }
    /**
     * 영속성 전이: 저장
     */
    public static void cascadPersist() {
        // 부모 저장
        Parent parent = new Parent();
        //em.persist(parent);

        Child child1 = new Child();
        Child child2 = new Child();
        child1.setParent(child1);
        child2.setParent(parent);
        parent.getChildren().add(child1);
        //em.persist(child1);
        parent.getChildren().add(child2);
        // CASCADE 적용 후, 부모만 영속화하면 자식 엔티티까지 함께 영속화 해서 저장한다.
        em.persist(parent);
    }

    /**
     * 영속성 전이: 삭제
     */
    public static void cascadeRemove() {


        Parent findParent = em.find(Parent.class, 1L);
        Child findChild1 = em.find(Child.class, 1L);
        Child findChild2 = em.find(Child.class, 2L);

        // 영속성 전이 설정이 없을 때
        /*em.remove(findChild1);
        em.remove(findChild2);
        em.remove(findParent);*/

        // 영속성 전이 설정 후 (CascadeType.REMOVE)
        em.remove(findParent);
    }

}
