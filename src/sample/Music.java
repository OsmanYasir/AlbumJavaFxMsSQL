package sample;

public class Music {

    private String type;
    private String style;

    public Music(String type, String style) {
        this.type   = type;
        this.style  = style;

    }
    public Music() {

    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }

    public String getInfo(){
       return type + ", " + style;
    }
}