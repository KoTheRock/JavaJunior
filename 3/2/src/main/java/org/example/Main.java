package org.example;

public class Main {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();

        
        Person person = new Person();
        person.setName("John Doe");
        person.setAge(30);
        personDAO.addPerson(person);

        
        Person retrievedPerson = personDAO.getPersonById(person.getId());
        System.out.println("Retrieved Person: " + retrievedPerson);

        
        retrievedPerson.setAge(31);
        personDAO.updatePerson(retrievedPerson);

        
        personDAO.deletePerson(retrievedPerson.getId());

        personDAO.close();
    }
}