package com.github.lazyf1sh.sandbox.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "PAGE2")
public class Page2Entity {

    @Id
    @Column(name = "PAGE2_KEY")
    @GeneratedValue(generator = "page2seqgen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "page2seqgen", sequenceName = "PAGE2_SEQ", allocationSize = 1)
    private int key;

    @ManyToOne(targetEntity = Book2Entity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK2_KEY")
    private Book2Entity book2Entity;

    @Column(name = "PAGE2_NAME")
    private String name;

    @Column(name = "PAGE2_ANNOTATIONS")
    private String annotations;


    public int getKey() {
        return key;
    }

    public Book2Entity getBook2Entity() {
        return book2Entity;
    }

    public void setBook2Entity(Book2Entity book2Entity) {
        this.book2Entity = book2Entity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnotations() {
        return annotations;
    }

    public void setAnnotations(String annotations) {
        this.annotations = annotations;
    }
}
