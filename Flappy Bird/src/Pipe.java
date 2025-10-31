import java.awt.*;

// kelas Pipe merepresentasikan rintangan1 pipa dalam game
public class Pipe {
    // posisi koordinat X dan Y pipa di layar
    private int posX;
    private int posY;
    // lebar dan tinggi pipa
    private int width;
    private int height;
    // gambar yang digunakan untuk tampilin pipa
    private Image image;
    // kecepatan gerak pipa arah kiri
    private int velocityX;
    // menandakan pipa sudah dilewati (nambah skor)
    boolean passed;

    // konstruktor untuk menginisialisasi atribut pipa
    public Pipe(int posX, int posY, int width, int height, Image image) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.image = image;

        // default kecepatan horizontal dan status belum dilewati
        this.velocityX = 0;
        this.passed = false;
    }

    // setter method
    // mengatur posisi X pipa
    public void setPosX(int posX) {
        this.posX = posX;
    }
    // mengatur posisi Y pipa
    public void setPosY(int posY) {
        this.posY = posY;
    }
    // mengatur lebar pipa
    public void setWidth(int width) {
        this.width = width;
    }
    // mengatur tinggi pipa
    public void setHeight(int height) {
        this.height = height;
    }
    // mengatur gambar yang digunakan pipa
    public void setImage(Image image) {
        this.image = image;
    }
    // mengatur kecepatan gerak pipa ke kiri
    public void setVelocityX(int velocityX) { this.velocityX = velocityX; }
    // gether method
    // mengambil posisi X pipa
    public int getPosX() {
        return this.posX;
    }
    // mengambil posisi Y pipa
    public int getPosY() {
        return this.posY;
    }
    // mengambil lebar pipa
    public int getWidth() {
        return this.width;
    }
    // mengambil tinggi pipa
    public int getHeight() {
        return this.height;
    }
    // mengambil gambar pipa
    public Image getImage() {
        return this.image;
    }
    // mengambil kecepatan horizontal pipa
    public int getVelocityX() { return this.velocityX; }
}