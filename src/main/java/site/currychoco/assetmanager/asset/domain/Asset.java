package site.currychoco.assetmanager.asset.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
@AllArgsConstructor
public class Asset {

    private Long id;
    private String serialnumber;
    private String assetState = AssetState.AVAILABLE.name();
    private Timestamp regDate;
    private String model;
    private String categoryCode;
}