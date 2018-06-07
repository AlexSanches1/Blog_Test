package com.sanches.app.blogtest.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Constraint;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Post {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String text;

    private String urlImage;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @JoinTable(
            name = "post_comment",
            joinColumns = @JoinColumn(
                    name = "post_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "comment_id",
                    referencedColumnName = "id"
            )
    )
    @OneToMany
    private List<Comment> comment;
}
