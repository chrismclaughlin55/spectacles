package sourcing.entity;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="marketplace_info")
public class MarketplaceInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "marketplace_id")
    private int marketplaceId;
    @Column(name = "source")
    private String source;

}