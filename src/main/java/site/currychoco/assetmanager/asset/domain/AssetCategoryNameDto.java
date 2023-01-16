package site.currychoco.assetmanager.asset.domain;

import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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

    public String getRegDate() {
        Date date = new Date(this.regDate.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
