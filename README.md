# TP6DPBO2425C1
TP 6 DPBO Java Swing GUI GameDev Flappy Bird

# Janji
Saya Muhammad Rangga Nur Praditha dengan Nim 2400297 mengerjakan Tugas Praktikum 6 dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahan-Nya maka saya tidak akan melakukan kecurangan seperti yang telah di spesifikasikan. Aamiin

# Deskripsi Program
Program ini merupakan sebuah game Flappy Bird yang dibuat dengan menggunakan Java Swing GUI yang bertujuan player melewati sebanyak mungkin rintangan yaitu pipa untuk menadapatkan poin, semakin banyak pipa yang berhasil dilewati maka poin akan semakin banyak. Tetapi ketika menabrak pipa, jatuh, atau terbang terlalu tinggi maka game akan berakhir.

## Fitur Program
1. Main Menu, berisi tampilan judul game, background, serta tombol untuk memulai game dan tombol untuk keluar dari game.
2. Game Flappy Bird, permainan utama dari game ini untuk user mengendalikan burung dengan melewati rintangan pipa yang ada untuk mendapatkan skor dan mengumpulkan skor sebanyak - banyak nya.
3. Kontrol Game Keyboard, user dapat menekan tombol **spasi** untuk mengendalikan burung ke arah atas agar tidak jatuh dan melewati pipa, ketika game over player dapat menekan tombol **R** untuk mengulang permainan dan menekan tombol **M** untuk kembali ke Main Menu.

## Cara Memainkan Game
1. Mulai Game, user perlu menekan tombol **Main** di Main Menu pada tampilan awal untuk memulai permainan.
2. Game Berjalan, saat game sudah berjalan, user perlu melewati pipa untuk mendapatkan skor sebanyak - banyaknya dalam game.
3. Kontrol Burung, user menggunakan tombol spasi untuk mengkontrol burung terbang ke arah atas.
4. Game Over, ketika game over, user dapat memilih untuk mengulang permainan dengan menekan tombol **R** atau kembali ke Main Menu dengan menekan tombol **M**.

# Alur dan Desain Program
Program terdiri dari 3 bagian utama, yaitu:
1. **Main Menu**, berisi judul game dan tombol untuk memulai game dan keluar dari game. Tombol **Main** untuk memulai permainan dan tombol **Keluar** untuk keluar dari game.
2. **Flappy Bird / Permainan**, berisi dari permainan utama, user mengkontrol burung dengan menggunakan tombol spasi untuk terbang ke atas agar dapat menghindari pipa dan mendapatkan skor sebanyak - banyaknya. Jika menabrak pipa, atau burung jatuh ke bawah dan burung terbang terlalu tinggi maka akan game over dan mengakhiri game.
3. **Game Over**, berisi tampilan kata game over dan memberhentikan permainan, serta menampilkan kalimat instruksi untuk mengulang permainan dengan menekan tombol **R** dan kembali ke Main Menu dengan menekan tombol **M**.

## Penjelasan Class
Dalam program ini terdapat 7 class, yaitu:
1. **Class 'App'**, class ini berisi fungsi main yang merupakan bagian utama dari game untuk memulai game.
2. **Class 'Logic'**, class ini mengatur seluruh logika game seperti pergerakan burung, pipa, skor, tabrakan, dan kondisi game over.
3. **Class 'MainMenu'**, class ini menampilkan menu utama sebelum game dimulai, berisi tombol Main untuk memulai game dan Keluar untuk menghentikan game.
4. **Class 'Pipe'**, class ini merepresentasikan objek pipa sebagai rintangan dalam game, dengan posisi, ukuran, dan gambar pipa.
5. **Class 'Player'**, class ini merepresentasikan burung sebagai karakter utama yang dapat terbang dengan tombol spasi.
6. **Class 'Sound'**, class ini mengatur semua suara di game seperti backsound, suara lompat, tabrakan, dan game over.
7. **Class 'View'**, class ini menampilkan tampilan game ke layar seperti background, burung, pipa, skor, dan teks saat game over.

## Alur Program
1. Program dimulai dari **class 'MainMenu'**
   - Saat dijalankan, program pertama kali menampilkan menu utama berisi tombol Main dan Keluar.
   - Jika pemain menekan tombol Main, maka game akan dimulai dengan memanggil class 'App'.
   - Jika menekan tombol Keluar, program akan langsung ditutup.
2. Masuk ke **class 'App'**
   - Class ini menjalankan game utama dengan membuat jendela (window) dan memanggil class     'Logic' serta 'View' untuk mengatur jalannya permainan dan tampilannya.
3. **Class 'Logic'** mulai berjalan
   - Bagian ini mengatur semua logika permainan:
     - Posisi burung (player),
     - Pergerakan pipa (pipe),
     - Gravitasi, skor, dan kondisi game over.
   - Musik latar belakang juga mulai diputar lewat class 'Sound'.
   - Pipa baru akan muncul setiap beberapa detik secara otomatis.
4. **Class 'View'** menggambar tampilan game
   - Menampilkan latar belakang, burung, pipa, dan skor ke layar.
   - Jika pemain kalah, akan muncul tulisan "GAME OVER", serta instruksi untuk menekan **R** (mengulang permainan) atau M (Main Menu).
5. Kontrol Permainan
   - Tekan **Spasi** -> burung terbang keatas / lompat.
   - Tekan **R** -> game di reset dan memulai ulang game.
   - Tekan **M** -> kembali ke Main Menu.
6. **Class 'Sound'** mengatur suara
   - Memainkan musik latar (backsound), suara lompat, tabrakan, dan game over.
   - Musik berhenti ketika pemain kalah, dan bisa dilanjutkan lagi saat restart atau mengulang permainan.
7. **Class 'Pipe' dan 'Player'**
   - 'Pipe' menyimpan posisi, ukuran, dan gambar dari pipa yang bergerak.
   - 'Player' menyimpan posisi, kecepatan, dan gambar burung yang dikendalikan pemain.
8. Permaian berulang sampai pemain keluar
   - Selama tidak game over, permainan terus berjalan dengan pipa baru dan skor bertambah.
   - Jika kalah, pemain bisa restart (mengulang permainan) atau kembali ke Main Menu.

# Dokumentasi
https://github.com/user-attachments/assets/ee7dbd04-3249-406f-9cbc-567b923da80e

