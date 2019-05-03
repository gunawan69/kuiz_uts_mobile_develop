package dev.gunawanr69.kuiz;

public class Konfigurasi {
    //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
    public static final String URL_ADD="http://172.20.10.3/kuis/tambahWeb.php";
    public static final String URL_GET_ALL = "http://172.20.10.3/kuis/tampilSemuaWeb.php";
    public static final String URL_GET_EMP = "http://172.20.10.3/kuis/tampilWeb.php?id=";
    public static final String URL_UPDATE_EMP = "http://172.20.10.3/kuis/updateWeb.php";
    public static final String URL_DELETE_EMP = "http://172.20.10.3/kuis/hapusWeb.php?id=";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_KODE = "kode";
    public static final String KEY_EMP_NAMA = "nama"; //desg itu variabel untuk posisi
    public static final String KEY_EMP_URL = "url";
    public static final String KEY_EMP_PEMILIK = "pemilik";
    //salary itu variabel untuk gajih

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_KODE = "kode";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_URL = "url";
    public static final String TAG_PEMILIK = "pemilik";

    //ID karyawan
    //emp itu singkatan dari Employee
    public static final String WEB_ID = "web_id";
}
