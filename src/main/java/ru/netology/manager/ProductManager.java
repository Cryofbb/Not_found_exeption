package ru.netology.manager;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

@RequiredArgsConstructor

public class ProductManager {
    private ProductRepository repo = new ProductRepository();

    public void save(Product product) {
        repo.save(product);
    }

    public Product[] searchBy(String search) {
        Product[] result = new Product[0];
        for (Product item : repo.findAll()) {
            if (item.matches(search)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        return result;
    }

    public void remove(int id) {
        repo.removeByID(id);
    }
}
