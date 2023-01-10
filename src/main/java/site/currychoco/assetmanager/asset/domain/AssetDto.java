package site.currychoco.assetmanager.asset.domain;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AssetDto {

    private Long id;
    private String serialnumber;
    private AssetState assetState;
    private Timestamp regDate;
    private String model;
    private String categoryCode;

    public static AssetDto fromEntity(Asset asset){
        if(asset == null){
            return null;
        }
        return new AssetDto(
                asset.getId(),
                asset.getSerialnumber(),
                asset.getAssetState(),
                asset.getRegDate(),
                asset.getModel(),
                asset.getCategoryCode()
        );
    }
}
