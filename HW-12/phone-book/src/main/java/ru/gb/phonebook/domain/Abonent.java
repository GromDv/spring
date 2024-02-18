package ru.gb.phonebook.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Класс сущности Абонент
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "abonents")
public class Abonent {
    private static int counter = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
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
