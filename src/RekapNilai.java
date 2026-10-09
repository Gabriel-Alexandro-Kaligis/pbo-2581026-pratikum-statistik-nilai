import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Locale;

public class RekapNilai {

    public static void main(String[] args) {


        final int SELESAI = -1;


        ArrayList<Integer> daftar = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");


        do {

            System.out.print("Nilai ke-" + (daftar.size() + 1) + ": ");
            int nilai = in.nextInt();


            if (nilai == SELESAI) {
                break;
            }


            if (nilai < 0 || nilai > 100) {
                System.out.println("  Ditolak, harus 0-100");
                continue;
            }


            daftar.add(nilai);

        } while (true);

        System.out.println();


        if (daftar.isEmpty()) {
            System.out.println("Tidak ada nilai sah yang dimasukkan.");
            in.close();
            return;
        }


        System.out.println("Nilai tersimpan : " + daftar);


        int jumlah = daftar.size();
        System.out.println("Jumlah          : " + jumlah);

        double total =0;

        for (int nilai : daftar){
            total += nilai;
        }

        double rataRata= total / jumlah;

        System.out.printf(
                Locale.forLanguageTag("id-ID"),
                "Rata-rata        : %2f%n",
                rataRata
        );

        int tertinggi = daftar.get(0);
        int terendah = daftar.get(0);

        for (int i = 0 ; i < daftar.size(); i++){
            int nilai = daftar.get(i);

            if (nilai > tertinggi){
                tertinggi = nilai;
            }
            if (nilai < terendah){
                terendah = nilai;
            }
        }

        System.out.println("Tertinggi       : " + tertinggi);
        System.out.println("Terendah        : " + terendah);

        int diAtasRataRata = 0;

        for (int nilai : daftar) {
            if (nilai > rataRata){
                diAtasRataRata++;

            }
        }

        System.out.println("Di atas rata2 : " + diAtasRataRata + " orang");

        in.close();
    }
}

