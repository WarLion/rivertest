package info.warlion.riverfarma.model;

public class Products {

    private int id;
    private String name ;
    private String url_image;
    private String description;
    private String pdf ;
    private String youtube;
    private String code;
    private String categoria;
    private String ParentCategoria;

    public Products() {
    }

    public Products(String name, String url_image, String description, String pdf, String youtube, String code, String categoria, String parentCategoria) {
        this.id = id;
        this.name = name;
        this.url_image = url_image;
        this.description = description;
        this.pdf = pdf;
        this.youtube = youtube;
        this.code = code;
        this.categoria = categoria;
        ParentCategoria = parentCategoria;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl_image() {
        return url_image;
    }

    public String getDescription() {
        return description;
    }

    public String getPdf() {
        return pdf;
    }

    public String getYoutube() {
        return youtube;
    }

    public String getCode() {
        return code;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getParentCategoria() {
        return ParentCategoria;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setUrl_image(String url_image) {
        this.url_image = "http://riverfarma.com.mx/content/up-products-images/"+ this.id +"/300x300/1_" + url_image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setParentCategoria(String parentCategoria) {
        ParentCategoria = parentCategoria;
    }
}