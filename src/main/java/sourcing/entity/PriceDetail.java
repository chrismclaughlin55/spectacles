package sourcing.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="price_details")
public class PriceDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "price")
    private long price;

    @Column(name = "item_condition")
    private String itemCondition;

    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    @JoinColumn
    private MarketplaceInfo marketplaceInfo;
}
