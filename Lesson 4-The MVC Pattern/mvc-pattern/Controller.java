public interface Controller {
    Person retrieveBySurname(String surname);

    void addPerson(Person person);

    Person deletePerson(Person person);

    void updatePerson(Person person);
}