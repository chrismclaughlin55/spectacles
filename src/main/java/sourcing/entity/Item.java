package sourcing.entity;

        import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="items")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="item_id")
    private int itemId;
    @Column(name="ebay_id")
    private String ebayId;
    @Column(name="category")
    private String category;
    public int getItemId() {
        return this.itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public String getEbayId() {
        return ebayId;
    }
    public void setEbayId(String ebayId) {
        this.ebayId= ebayId;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}