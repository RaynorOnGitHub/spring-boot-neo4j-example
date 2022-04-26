package guru.springframework.repositories;

import guru.springframework.domain.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductRepositoryTest {

    private static final BigDecimal BIG_DECIMAL_100 = BigDecimal.valueOf(100.00);
    private static final String ANY_PRODUCT_DESCRIPTION = "a cool product";
    private static final String ANY_IMAGE_URL = "http://an-imageurl.com/image1.jpg";

    private Product product;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() throws Exception {
        product = new Product();
        product.setDescription(ANY_PRODUCT_DESCRIPTION);
        product.setImageUrl(ANY_IMAGE_URL);
        product.setPrice(BIG_DECIMAL_100);
    }

    @AfterEach
    public void tearDown() throws Exception {
        Optional<Long> productId = Optional.ofNullable(product.getId());
        if (productId.isPresent() && productId.get() > -1L) {
            productRepository.deleteById(productId.get());
        }
    }

    @Test
    public void definedProduct_whenSaved_thenProductCanBeFetchedFromDatabase() {
        // arrange
        productRepository.save(product);

        // action
        Product fetchProduct = productRepository.findById(product.getId()).orElse(null);

        // assert
        assertNotNull(fetchProduct);
        assertThat(fetchProduct.getId()).isNotNull();

        assertEquals(ANY_PRODUCT_DESCRIPTION, fetchProduct.getDescription());
        assertEquals(BIG_DECIMAL_100.compareTo(fetchProduct.getPrice()), 0);
        assertEquals(ANY_IMAGE_URL, fetchProduct.getImageUrl());
    }
}