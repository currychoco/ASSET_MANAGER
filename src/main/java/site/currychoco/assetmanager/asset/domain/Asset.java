package site.currychoco.assetmanager.asset.domain;

import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
public class Asset {

    private Long id;
    private String serialnumber;
    private String assetState;
    private Timestamp regDate;
    private String model;
    private String categoryCode;

    public Asset(String serialnumber, String model, String categoryCode) {
        this.serialnumber = serialnumber;
        this.assetState = AssetState.AVAILABLE.name();
        this.model = model;
        this.categoryCode = categoryCode;
    }
}
