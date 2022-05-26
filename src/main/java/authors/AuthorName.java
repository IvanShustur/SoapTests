package authors;

import java.util.Objects;

public class AuthorName {
    private String first;
    private String second;

    public AuthorName(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public AuthorName() {
    }

    @Override
    public String toString() {
        return "AuthorName{" +
                "first='" + first + '\'' +
                ", second='" + second + '\'' +
                '}';
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorName)) return false;
        AuthorName that = (AuthorName) o;
        return getFirst().equals(that.getFirst()) && getSecond().equals(that.getSecond());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), getSecond());
    }
}

