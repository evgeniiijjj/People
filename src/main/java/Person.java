import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private final String name;
    private final String surname;
    private int birthYear;
    private String address;

    private Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public static Person getInstance(String name, String surname) {
        if (name != null && surname != null) {
            return new Person(name, surname);
        }
        return null;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAge(0).setAddress(address);
    }

    public boolean setAge(int age) {
        if (this.birthYear == 0 && age >= 0 && age < 120) {
            this.birthYear = LocalDate.now().getYear() - age;
            return true;
        }
        return false;
    }

    public void setAddress(String address) {
        if (address != null) {
            this.address = address;
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean hasAge() {
        return birthYear > 0;
    }

    public Integer getAge() {
        if (hasAge()) {
            return LocalDate.now().getYear() - birthYear;
        }
        return null;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return birthYear == person.birthYear && name.equals(person.name) && surname.equals(person.surname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthYear, address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                (hasAge() ? ", birthYear=" + birthYear + " г.р." : "") +
                (hasAddress() ? ", address='" + address + '\'' : "") +
                '}';
    }
}
