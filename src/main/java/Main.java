public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .name("Анна")
                .surname("Вольф")
                .age(31)
                .address("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .name("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);
    }
}