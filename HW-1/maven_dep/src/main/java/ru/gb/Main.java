package ru.gb;

import com.google.gson.*;

public class Main {
    public static void main(String[] args) {
        Person human1 = new Person("Вася", "Иванов", 15);
        System.out.println(human1.toString());
        System.out.printf("Хеш-код объекта = %s\n", human1.hashCode());

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Person.class, new PersonSerializer())
                .create();

        String jsonStr = gson.toJson(human1);
        System.out.println(jsonStr);

        Gson gsonDes = new GsonBuilder()
                .registerTypeAdapter(Person.class, new PersonDeserializer())
                .create();

        Person humDes = gsonDes.fromJson(jsonStr, Person.class);
        System.out.println(humDes.toString());
        System.out.printf("Хеш-код объекта = %s\n", humDes.hashCode());

        System.out.print("Одинаковые объекты до и после сериализации? ");
        System.out.println(human1.equals(humDes));
        System.out.print("Равны объекты до и после сериализации? ");
        System.out.println(human1 == humDes);
    }
}