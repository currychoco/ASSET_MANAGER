package site.currychoco.assetmanager.asset.domain;

public enum AssetState {
    AVAILABLE("사용가능"), BREAK("파손"), LOSE("망실"), RENTED("대여중");

    final private String name;
    public String getName() {
        return name;
    }
    private AssetState(String name){
        this.name = name;
    }

    public AssetStateDto toDto() {
        return new AssetStateDto(this.name(), this.name);
    }
}

