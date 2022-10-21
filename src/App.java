import java.util.Scanner;

class penggajian {
    public String nomorIndukPeg;
    public String namaPeg;
    public String namaBidangPeg;
    public float gajiPokokPeg;
    public float tunjanganPeg;
    public float jamLembur;
    public float upahLemburPerJam;
    public int kodeBidangPeg;

    String bidangTeripilih (int val) {
        if (val == 1) {
            return namaBidangPeg = "Operator Produksi";
        } else if (val == 2) {
            return namaBidangPeg = "Produksi";
        } else if (val == 3) {
            return namaBidangPeg = "Packing";
        } else if (val == 3) {
            return namaBidangPeg = "Sekretaris";
        } else {
            return namaBidangPeg = "Kode Tidak Valid";
        }
    }

    Float perhitunganTunjangan (int kodeB) {
        if (kodeB == 1) {
            return tunjanganPeg = 500000;
        } else if (kodeB == 2) {
            return tunjanganPeg = 450000;
        } else if (kodeB == 3) {
            return tunjanganPeg = 400000;
        } else if (kodeB == 4) {
            return tunjanganPeg = 400000;
        } else {
            return tunjanganPeg = 0;
        }
    }

    Float perhitunganUpahPerJamLembur (int kodeB) {
        if (kodeB == 1) {
            return upahLemburPerJam = 5;
        } else if (kodeB == 2) {
            return upahLemburPerJam = 4;
        } else if (kodeB == 3) {
            return upahLemburPerJam = 4;
        } else if (kodeB == 4) {
            return upahLemburPerJam = 3;
        } else {
            return upahLemburPerJam = 0;
        }
    }

    Float perhitunganGajiPokok (int kodeB) {
        if (kodeB == 1) {
            return gajiPokokPeg = 4500000;
        } else if (kodeB == 2) {
            return gajiPokokPeg = 4300000;
        } else if (kodeB == 3) {
            return gajiPokokPeg = 4100000;
        } else if (kodeB == 4) {
            return gajiPokokPeg = 4000000;
        } else {
            return gajiPokokPeg = 0;
        }
    }

    Float perhitunganTotalLembur (float jumlahJam, float upahPerJam) {
        return jumlahJam * (upahPerJam / 100 * this.gajiPokokPeg);
    }

    void inputDataPegawai () {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nomor Induk Pegawai: ");
        nomorIndukPeg = sc.nextLine();

        System.out.print("Nama Pegawai: ");
        namaPeg = sc.nextLine();

        System.out.println("");
        System.out.println("* Pilihan Bidang Pekerjaan *");
        System.out.println("1. Backend Developer    (Kode = 1)");
        System.out.println("2. Frontend Developer   (Kode = 2)");
        System.out.println("3. Bussiness Analyist   (Kode = 3)");
        System.out.println("4. Quality Assurance    (Kode = 4)");
        System.out.println("");

        System.out.print("Masukkan Kode Bidang Pekerjaan: ");
        kodeBidangPeg = sc.nextInt();

        System.out.print("Masukkan Jumlah Jam Lembur: ");
        jamLembur = sc.nextFloat();

        this.bidangTeripilih(kodeBidangPeg);
        this.perhitunganTunjangan(kodeBidangPeg);
        this.perhitunganUpahPerJamLembur(kodeBidangPeg);
        this.perhitunganGajiPokok(kodeBidangPeg);
    }

    Float perhitunganTotalGaji (float gajiPokok, float lembur, float tunjangan) {
        return gajiPokok + lembur + tunjangan;
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        penggajian item = new penggajian();
        System.out.println("*********************************||||**********************************");
        System.out.println("");
        System.out.println("---------------------- Inputan Data Pegawai --------------------------");
        System.out.println("");
        item.inputDataPegawai();
        System.out.println("---------------------------*************------------------------------");
        System.out.println("");
        System.out.println("---------------------- Slip Gaji Pegawai ----------------------------- ");
        System.out.println("Nomor Induk Pegawai         : " + item.nomorIndukPeg);
        System.out.println("Nama Pegawai                : " + item.namaPeg);
        System.out.println("Bidang Pekerjaan            : " + item.namaBidangPeg);
        System.out.println("Jumlah Jam Lembur           : " + item.jamLembur);
        System.out.println("Gaji Pokok                  : Rp." + item.gajiPokokPeg);
        System.out.println("Tunjangan                   : Rp." + item.tunjanganPeg);
        System.out.println("Upah Lembur                 : Rp." + item.perhitunganTotalLembur(item.jamLembur, item.upahLemburPerJam));
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Total Gaji yang Diterima    : Rp." + item.perhitunganTotalGaji(item.gajiPokokPeg, item.perhitunganTotalLembur(item.jamLembur, item.upahLemburPerJam), item.tunjanganPeg));
        System.out.println("----------------------------------------------------------------------");
        System.out.println("");
        System.out.println("                                                    Penerima,");
        System.out.println("");
        System.out.println("                                                    " + item.namaPeg);
        System.out.println("*******************************||||************************************ ");
    }
}
