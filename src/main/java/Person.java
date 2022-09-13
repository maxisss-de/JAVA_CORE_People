import java.util.Objects;

public class Person {
    private String name;
    private final String surname;
    private int age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasAge() {     // Возраст человека может быть неизвестен, в этом случае метод boolean hasAge()
        if (this.age < 0)
            return true;
        return false;
    }

    public boolean hasAddress() {  // Адрес может быть известен (в этом случае метод boolean hasAddress() должен вернуть true, иначе - false)
        if (address != null)
            return true;
        return false;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        if (hasAge())
            return age;
        return null;
    }

    public String getAddress() {
        if (hasAddress())
            return address;
        return null;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() { // Если возраст человека известен, то с момента создания объекта он может быть изменён только увеличением на единицу, через вызов метода happyBirthday()
        this.age++;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().surname(this.surname).address(this.address);  // Добавил, чтобы фамилия и город отображался у сына от матери

    }

    @Override
    public String toString() {
        return "Имя: " + this.name +
                ", Фамилия: " + this.surname +
                ", Возраст: " + this.age +
                ", Адрес: " + this.address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAge(), getAddress());
    }
}