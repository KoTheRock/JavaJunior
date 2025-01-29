import java.io.*;

public class Main {
    static class Person implements Serializable{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person worker = new Person("Иван", 25);

        try (FileOutputStream fos = new FileOutputStream("PersonData.bin")){
           try (ObjectOutputStream oos = new ObjectOutputStream(fos)){
               oos.writeObject(worker);
               System.out.println("Объект сериализован: " + worker);
           }
        }

        try (FileInputStream fis = new FileInputStream("PersonData.bin")){
            try (ObjectInputStream ois = new ObjectInputStream(fis)){
                worker = (Person)ois.readObject();
                System.out.println("Объект десериализован: " + worker);
            }

        }
    }
}
