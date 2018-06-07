package com.sanches.app.blogtest.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

//    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
//    private List<Post> post;
}
