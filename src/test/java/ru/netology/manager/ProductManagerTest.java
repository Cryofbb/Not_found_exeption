package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundExeption;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductManagerTest {
    private ProductManager manager = new ProductManager();
    private Book item1 = new Book(1, "Harry Potter and Cursed child", 235, "J. K. Rowling");
    private Book item2 = new Book(2, "The Harry Hole series", 10, "Jo Nesbo");
    private Book item3 = new Book(3, "Hercule Poirot", 30, "Agatha Christie");
    private Book item4 = new Book(4, "Now You See Me", 202, "Sharon Bolton");
    private Smartphone item5 = new Smartphone(5, "Iphone", 500, "Apple");
    private Smartphone item6 = new Smartphone(6, "Galaxy", 300, "Samsung");
    private Smartphone item7 = new Smartphone(7, "Xperia", 200, "Sony");
    private Smartphone item8 = new Smartphone(8, "Zenphone", 100, "Asus");
    private Product item9 = new Product(9, "Milk", 100);
    private Smartphone item10 = new Smartphone(10, "IphoneXr", 5000, "Apple");
    private Book item11 = new Book(11, "Mrs. Marple", 30, "Agatha Christie");

    @BeforeEach
    public void setup() {
        manager.save(item1);
        manager.save(item2);
        manager.save(item3);
        manager.save(item4);
        manager.save(item5);
        manager.save(item6);
        manager.save(item7);
        manager.save(item8);
        manager.save(item9);
    }

    @Test
    public void shouldFindBook() {
        Product[] actual = manager.searchBy("Now You See Me");
        Product[] expected = new Product[]{item4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAuthor() {
        Product[] actual = manager.searchBy("Jo Nesbo");
        Product[] expected = new Product[]{item2};
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindModel() {
        Product[] actual = manager.searchBy("Xperia");
        Product[] expected = new Product[]{item7};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindManufacturer() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{item5};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNothing() {
        Product[] actual = manager.searchBy("Something");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void emptySearch() {
        ProductManager manager = new ProductManager();
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWithOneBook() {
        ProductManager manager = new ProductManager();
        manager.save(item2);
        Product[] actual = manager.searchBy("The Harry Hole series");
        Product[] expected = new Product[]{item2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWithOneAuthor() {
        ProductManager manager = new ProductManager();
        manager.save(item11);
        Product[] actual = manager.searchBy("Agatha Christie");
        Product[] expected = new Product[]{item11};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWithOneManufacturer() {
        ProductManager manager = new ProductManager();
        manager.save(item10);
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{item10};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchWithOneModel() {
        ProductManager manager = new ProductManager();
        manager.save(item10);
        Product[] actual = manager.searchBy("IphoneXr");
        Product[] expected = new Product[]{item10};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchMultiplyPhone() {
        manager.save(item10);
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{item5, item10};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchMultiplyBook() {
        manager.save(item11);
        Product[] actual = manager.searchBy("Agatha Christie");
        Product[] expected = new Product[]{item3, item11};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void removeById(){
        manager.remove(3);
        manager.save(item11);
        Product[] actual = manager.searchBy("Agatha Christie");
        Product[] expected = new Product[]{item11};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByWrongID(){
        assertThrows(NotFoundExeption.class, () -> {
            manager.remove(23);
        });
    }
}

