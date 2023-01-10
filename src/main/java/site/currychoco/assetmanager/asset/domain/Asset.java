package site.currychoco.assetmanager.asset.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "asset")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "serialnumber")
    private String serialnumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "asset_state")
    private AssetState assetState;
    @Column(name = "reg_date")
    private Timestamp regDate;
    @Column(name = "model")
    private String model;
    @Column(name = "category_code")
    private String categoryCode;

    public Asset(AssetDto dto) {

        this.id = dto.getId();
        this.serialnumber = dto.getSerialnumber();
        this.assetState = AssetState.AVAILABLE;
        Timestamp now = new Timestamp(System.currentTimeMillis());
        this.regDate = now;
        this.model = dto.getModel();
        this.categoryCode = dto.getCategoryCode();
    }
}
