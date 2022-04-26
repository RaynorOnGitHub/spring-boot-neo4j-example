package guru.springframework.domain;


import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.math.BigDecimal;

/**
 * Created by jt on 1/10/17.
 */
@Node
public class Product {

    /**
     * From library javadoc documentation of org.neo4j.ogm.annotation.GraphId:
     * "Identifies the field in the domain entity which is to be
     * mapped to the id property of its backing node in the graph.
     * This annotation is not needed if the domain entity has a Long
     * field called id."
     * As of further documentation from author Vince Bickers, he proposes
     * to replace deprecated @GraphId with @Id and @GeneratedValue.
     * The default is internal usage of org.neo4j.ogm.id.InternalIdStrategy
     */
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private BigDecimal price;
    private String imageUrl;

    public Product(String description, BigDecimal price, String imageUrl) {
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Product() {
        this("", BigDecimal.valueOf(0L), "");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
