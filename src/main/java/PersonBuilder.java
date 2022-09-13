public class PersonBuilder implements IPersonBuilder {

    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder() {
    }

    public PersonBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder(Person person) {
        this.surname = person.getSurname();
    }


    public PersonBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder age(int age) {
        this.age = age;
        validateAge(age);  // IllegalArgumentException выбрасывается, когда переданный методу аргумент некорректен.
        return this;
    }

    public PersonBuilder address(String address) {
        this.address = address;
        return this;
    }

    public Person build() {  // Возращает класс Person.
        Person person = new Person(name, surname, age, address);
        validate(person);    // IllegalStateException выбрасывается, когда текущее состояние объекта не подходит для вызываемого действия, поэтому добавил его в метод build(), если создать объект человека из такого билдера невозможно.
        return person;
    }

    // IllegalArgumentException выбрасывается, когда переданный методу аргумент некорректен.
    private Person validateAge(int age) {
        if (this.age < 0) {

            throw new IllegalArgumentException("Аргумент некорректен: ");
        }
        return null;
    }

    // IllegalStateException выбрасывается, когда текущее состояние объекта не подходит для вызываемого действия.
    private Person validate(Person person) {
        if (this.name == null || this.surname == null || this.age < 0 || this.address == null) {

            throw new IllegalStateException("Обнаружено пустое поле: ");
        }
        return null;
    }
}
