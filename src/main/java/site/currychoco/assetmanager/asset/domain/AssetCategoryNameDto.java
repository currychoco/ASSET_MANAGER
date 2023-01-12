package site.currychoco.assetmanager.asset.domain;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AssetCategoryNameDto {

    private Long id;
    private String serialnumber;
    private String assetState;
    private Timestamp regDate;
    private String model;
    private String categoryCode;
    private String categoryName;

}
