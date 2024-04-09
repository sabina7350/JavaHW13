import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void successRemoving() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Сумка", 10_000);
        Product product2 = new Product(2, "Духи", 7_000);
        Product product3 = new Product(3, "Очки", 3_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Сумка", 10_000);
        Product product2 = new Product(2, "Духи", 7_000);
        Product product3 = new Product(3, "Очки", 3_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(5)
        );
    }
}
