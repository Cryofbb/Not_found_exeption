package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)

public class Book extends Product {
    private String authorName;

    public Book(int id, String name, int price, String authorName) {
        super(id, name, price);
        this.authorName = authorName;
    }

    public Book() {
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        return authorName.contains(search);
    }
}
