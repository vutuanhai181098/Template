package com.example.ecommecerapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String slug;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Blog> blogs = new ArrayList<>();

    public Tag(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
