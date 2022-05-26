package authors;

import java.util.Objects;

public class Author {
    private Long authorId;
    private AuthorName authorName;
    private String nationality;
    private Birth birth;
    private String authorDescription;

    public Author(Long authorId, AuthorName authorName, String nationality, Birth birth, String authorDescription) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.nationality = nationality;
        this.birth = birth;
        this.authorDescription = authorDescription;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName=" + authorName +
                ", nationality='" + nationality + '\'' +
                ", birth=" + birth +
                ", authorDescription='" + authorDescription + '\'' +
                '}';
    }

    public Author() {
    }

    public Long getAuthorId() {
        return authorId;
    }

    public AuthorName getAuthorName() {
        return authorName;
    }

    public String getNationality() {
        return nationality;
    }

    public Birth getBirth() {
        return birth;
    }

    public String getAuthorDescription() {
        return authorDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return getAuthorId().equals(author.getAuthorId()) && getAuthorName().equals(author.getAuthorName()) && getNationality().equals(author.getNationality()) && getBirth().equals(author.getBirth()) && getAuthorDescription().equals(author.getAuthorDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthorId(), getAuthorName(), getNationality(), getBirth(), getAuthorDescription());
    }
}