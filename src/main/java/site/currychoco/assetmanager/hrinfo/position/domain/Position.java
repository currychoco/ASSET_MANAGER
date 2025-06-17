package site.currychoco.assetmanager.hrinfo.position.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "position")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Position {
    @Id
    @Column(name = "position_code")
    private String positionCode;
    @Column(name = "position_name")
    private String positionName;
    @Column(name = "position_name_en")
    private String positionNameEn;
    @Column(name = "position_level")
    private int positionLevel;

    public Position(PositionDto positionDto){
        this.positionCode = positionDto.getPositionCode();
        this.positionName = positionDto.getPositionName();
        this.positionNameEn = positionDto.getPositionNameEn();
        this.positionLevel = positionDto.getPositionLevel();
    }

}

