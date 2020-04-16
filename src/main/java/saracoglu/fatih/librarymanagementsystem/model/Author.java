package saracoglu.fatih.librarymanagementsystem.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String books;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String description;

    public Author() {
    }

    public Author(Long id, String name, String books, String description) {
        this.id = id;
        this.name = name;
        this.books = books;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books='" + books + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
