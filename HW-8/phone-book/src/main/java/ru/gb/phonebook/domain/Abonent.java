package ru.gb.phonebook.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Класс сущности Абонент
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Abonent {
    private static int counter = 0;
    private int id;
    private String firstName;
    private String lastName;
    private long phone;
    private String address;

    public static int getCounter() {
        return ++counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Abonent abonent)) return false;

        return new EqualsBuilder().append(getFirstName(), abonent.getFirstName()).append(getLastName(), abonent.getLastName()).isEquals();
    }
}
