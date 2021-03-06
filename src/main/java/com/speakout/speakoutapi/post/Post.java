package com.speakout.speakoutapi.post;


import com.speakout.speakoutapi.base_entity.BaseEntity;
import com.speakout.speakoutapi.comment.Comment;
import com.speakout.speakoutapi.customer.Customer;
import lombok.*;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post extends BaseEntity {
    private String content;
    @ManyToOne
    private Customer author;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
    @OneToMany(mappedBy = "post")
    private Set<Customer> likes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Post post = (Post) o;
        return Objects.equals(content, post.content) &&
                Objects.equals(author, post.author) &&
                Objects.equals(comments, post.comments) &&
                Objects.equals(likes, post.likes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), content, author, comments, likes);
    }
}
