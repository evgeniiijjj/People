import exceptions.IllegalArgumentException;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String city) {
        this.address = city;
        return this;
    }

    public Person build() throws Exception {
        Person instance;
        if (name == null || surname == null) {
            StringBuilder builderMessage = new StringBuilder();
            if (name == null) {
                builderMessage.append("отсутствует имя");
            }
            if (surname == null) {
                if (builderMessage.length() > 0) builderMessage.append(", ");
                builderMessage.append("отсутствует фамилия");
            }
            throw new IllegalStateException(builderMessage.toString());
        }
        instance = Person.getInstance(name, surname);
        if (!instance.setAge(age)) {
            throw new IllegalArgumentException("введено некорректное значение возраста");
        }
        instance.setAddress(address);
        return instance;
    }
}
