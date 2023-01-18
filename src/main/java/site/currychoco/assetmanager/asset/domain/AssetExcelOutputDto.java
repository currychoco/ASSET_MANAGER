package site.currychoco.assetmanager.asset.domain;

import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
public class AssetExcelOutputDto {

    long id;
    String serialnumber;
    String assetState;
    Timestamp regDate;
    String model;
    String categoryName;
}
