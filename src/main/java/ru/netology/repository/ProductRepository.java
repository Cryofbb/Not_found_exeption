package ru.netology.repository;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.netology.domain.NotFoundExeption;
import ru.netology.domain.Product;


@RequiredArgsConstructor

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }
    public Product findById(int id) {
        for (Product item : items){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public void removeByID(int id) {
        if (findById(id)== null) {
            throw new NotFoundExeption("Id " + id + " not found");
        }
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }
}
