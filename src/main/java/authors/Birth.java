package authors;

import java.util.Objects;

public class Birth {
    private String date;
    private String country;
    private String city;

    public Birth(String date, String country, String city) {
        this.date = date;
        this.country = country;
        this.city = city;
    }

    public Birth() {
    }

    public String getDate() {
        return date;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Birth{" +
                "date='" + date + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Birth)) return false;
        Birth birth = (Birth) o;
        return getDate().equals(birth.getDate()) && getCountry().equals(birth.getCountry()) && getCity().equals(birth.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getCountry(), getCity());
    }
}
