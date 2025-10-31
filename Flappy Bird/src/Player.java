import java.awt.*;

// kelas player mempresentasikan bird yang dikendalikan pemain
public class Player {
    // posisi bird di layar koordinat x dan y
    private int posX;
    private int posY;
    // ukuran bird lebar dan tinggi
    private int width;
    private int height;
    // gambar yang merepresentasikan tampilan bird
    private Image image;
    // kecepatan vertikal bird atas/bawah
    private int velocityY;

    // konstruktor untuk menginisialisasi posisi, ukuran, dan gambar bird
    public Player(int posX, int posY, int width, int height, Image image) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.image = image;

        // nilai awal kecepatan Y belum gerak atas/bawah
        this.velocityY = -0; // default value yang diinisiasi di awal
    }

    // setter method
    // mengatur posisi horizontal bird sumbu X
    public void setPosX(int posX) {
        this.posX = posX;
    }
    // mengatur posisi vertikal bird sumbu Y
    public void setPosY(int posY) {
        this.posY = posY;
    }
    // mengatur lebar bird
    public void setWidth(int width) {
        this.width = width;
    }
    // mengatur tinggi bird
    public void setHeight(int height) {
        this.height = height;
    }
    // mengatur gambar bird
    public void setImage(Image image) {
        this.image = image;
    }
    // mengatur kecepatan vertikal bird, nilai positif jatuh (turun), nilai negatif terbang (atas)
    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }
    // getter method
    // mengambil posisi X bird
    public int getPosX() {
        return this.posX;
    }
    // mengambil posisi Y bird
    public int getPosY() {
        return this.posY;
    }
    // mengambil lebar bird
    public int getWidth() {
        return this.width;
    }
    // mengambil tinggi bird
    public int getHeight() {
        return this.height;
    }
    // mengambil gambar bird
    public Image getImage() {
        return this.image;
    }
    // mengambil kecepatan vertikal bird
    public int getVelocityY() {
        return this.velocityY;
    }
}