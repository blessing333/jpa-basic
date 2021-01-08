package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {
    @Id
    @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;

    @OneToMany(mappedBy = "parent")
    private List<Child> childs = new ArrayList<>();

    private String name;

    public void addChild(Child child){
            this.childs.add(child);
            child.setParent(this);
    }

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
