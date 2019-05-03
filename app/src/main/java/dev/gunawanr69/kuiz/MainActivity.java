package dev.gunawanr69.kuiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import dev.gunawanr69.kuiz.API.RestApi;
import dev.gunawanr69.kuiz.API.RetroServer;
import dev.gunawanr69.kuiz.MODEL.ResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText kode, nama, url,pemilik;
    Button btnsave, btnTampildata, btnupdate,btndelete;
    ProgressBar pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pd= (ProgressBar)findViewById(R.id.pd);
        pd.setIndeterminate(true);
        pd.setVisibility(View.GONE);
        kode = (EditText) findViewById(R.id.kode_web);
        nama = (EditText) findViewById(R.id.nama_web);
        url = (EditText) findViewById(R.id.url_web);
        pemilik = (EditText) findViewById(R.id.pemilik_web);
        btnTampildata = (Button) findViewById(R.id.btntampildata);
        btnupdate =(Button) findViewById(R.id.btnUpdate);
        btnsave = (Button) findViewById(R.id.btn_insertdata);
        btndelete=(Button) findViewById(R.id.btnhapus);
        //kondisi perubahan btn save > btn delete dan btn update
        Intent data = getIntent();
        final String iddata = data.getStringExtra("id");
        if(iddata != null) {
            btnsave.setVisibility(View.GONE);
            btnTampildata.setVisibility(View.GONE);
            btnupdate.setVisibility(View.VISIBLE);
            btndelete.setVisibility(View.VISIBLE);
            kode.setText(data.getStringExtra("kode"));
            nama.setText(data.getStringExtra("nama"));
            url.setText(data.getStringExtra("url"));
            pemilik.setText(data.getStringExtra("pemilik"));
        }
        //btn update
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setVisibility(View.VISIBLE);
                RestApi api =
                        RetroServer.getClient().create(RestApi.class);
                Call<ResponseModel> update =
                        api.updateData(iddata,kode.getText().toString(),nama.getText().toString(),url.getText().toString(),pemilik.getText().toString());
                update.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        Log.d("Retro", "Response");

                        Toast.makeText(MainActivity.this,response.body().getPesan(),Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,
                                TampilData.class));
                        pd.setVisibility(View.GONE);
                        finish();
                    }
                    @Override
                    public void onFailure(Call<ResponseModel> call,
                                          Throwable t) {
                        pd.setVisibility(View.GONE);
                        Log.d("Retro", "OnFailure");
                    }
                });
            }
        });
        //btn delete
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setVisibility(View.VISIBLE);
                RestApi api =
                        RetroServer.getClient().create(RestApi.class);
                Call<ResponseModel> del = api.deleteData(iddata);
                del.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call,
                                           Response<ResponseModel> response) {
                        pd.setVisibility(View.GONE);
                        Log.d("Retro", "onResponse");
                        Toast.makeText(MainActivity.this,
                                response.body().getPesan(),Toast.LENGTH_SHORT).show();
                        Intent gotampil = new
                                Intent(MainActivity.this,TampilData.class);
                        startActivity(gotampil);
                    }
                    @Override
                    public void onFailure(Call<ResponseModel> call,
                                          Throwable t) {
                        pd.setVisibility(View.GONE);
                        Log.d("Retro", "onFailure");
                    }
                });
            }
        });
        //btn tampil data
        btnTampildata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new
                        Intent(MainActivity.this,TampilData.class));
            }
        });
        //button insert
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String skode = kode.getText().toString();
                String snama = nama.getText().toString();
                String surl = url.getText().toString();
                String spemilik = pemilik.getText().toString();

                if (skode.isEmpty() ) {
                    kode.setError("kode perlu di isi");
                }else if (snama.isEmpty()){
                    nama.setError("nama perlu di isi");}
                else if (surl.isEmpty()){
                    url.setError("url perlu di isi");
                }
                else if (spemilik.isEmpty()){
                    pemilik.setError("pemilik perlu di isi");
                }else {
                    RestApi api =
                            RetroServer.getClient().create(RestApi.class);
                    Call<ResponseModel> sendbio =
                            api.sendWeb(skode,snama,surl,spemilik);
                    sendbio.enqueue(new Callback<ResponseModel>() {
                        @Override
                        public void onResponse(Call<ResponseModel> call,
                                               Response<ResponseModel> response) {
/*
 pd.setVisibility(View.GONE);
*/
                            Log.d("RETRO", "response : " +
                                    response.body().toString());
                            String kode1 = response.body().getKode();
                            if(kode1.equals("1"))
                            {
                                Toast.makeText(MainActivity.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                                        startActivity(new
                                                Intent(MainActivity.this, TampilData.class));
                                kode.getText().clear();
                                nama.getText().clear();
                                url.getText().clear();
                                pemilik.getText().clear();
                            }else
                            {
                                Toast.makeText(MainActivity.this, "Data Error tidakberhasil disimpan", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onFailure(Call<ResponseModel> call,
                                              Throwable t) {
/*
 pd.setVisibility(View.GONE);
*/
                            Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
                        }
                    });
                }}
        });
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("warnig");
        alert.setMessage("do you wan to exit");
        alert.setPositiveButton("yes", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int
                            i) {
                        MainActivity.this.finish();
                    }
                });
        alert.setNegativeButton("no", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int
                            i) {
                    }
                });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }
}
