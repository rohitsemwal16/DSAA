package org.rosemwal.java.interview.serdeserialize;

import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;

import java.io.*;

public class SerDeserializeMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person person = Person.builder().name("Rohit").religion("Hindu").build();

        // Serialize (Object -> Byte Stream)
        String path = "/USERS/rohitsemwal/Downloads/a.txt";
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(person);


        // Deserialize (ByteStream -> Object)

        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream is = new ObjectInputStream(fis);
        Person a = (Person) is.readObject();
        System.out.println("Fetching values after deserializing...");
        System.out.println(a.name);
        System.out.println(a.religion);

    }
}
