package be.faros.flags.web.dto;

public abstract class ScalableLayerDTO extends SingleColourLayerDTO {
    private double scale; //from .5 to 2

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }
}
