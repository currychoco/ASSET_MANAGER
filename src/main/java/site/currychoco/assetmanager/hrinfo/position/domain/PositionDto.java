package site.currychoco.assetmanager.hrinfo.position.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class PositionDto {

    private String positionCode;
    private String positionName;
    private String positionNameEn;
    private int positionLevel;

    public static PositionDto fromEntity(Position position){
        if(position == null){
            return null;
        }
        return new PositionDto(
                position.getPositionCode(),
                position.getPositionName(),
                position.getPositionNameEn(),
                position.getPositionLevel()
        );
    }
}
