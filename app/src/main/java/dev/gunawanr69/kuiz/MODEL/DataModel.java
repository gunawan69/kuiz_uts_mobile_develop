package dev.gunawanr69.kuiz.MODEL;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class DataModel {

    @SerializedName("kode")
    private String mKode;
    @SerializedName("id")
    private String mId;
    @SerializedName("nama")
    private String mNama;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("pemilik")
    private String mPemilik;

    public String getKode() {
        return mKode;
    }
    public void setKode(String kode) {
        mKode = kode;
    }
    public String getId() {
        return mId;
    }
    public void setId(String id) {
        mId = id;
    }
    public String getNama() {
        return mNama;
    }
    public void setNama(String nama) {
        mNama = nama;
    }
    public String getUrl() {
        return mUrl;
    }
    public void setUrl(String url) {
        mUrl = url;
    }
    public String getPemilik() {
        return mPemilik;
    }
    public void setPemilik(String pemilik) {
        mPemilik = pemilik;
    }

}
