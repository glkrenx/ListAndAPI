package com.glkrenx.bermainlistdanapi.model.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by glkrenx on 24/06/16.
 */
public class    Records {
    @SerializedName("NAMA TAKSI")
    @Expose
    private String namaTaksi;

    @SerializedName("NAMA PERUSAHAAN")
    @Expose
    private String namaPerusahaan;

    @SerializedName("ALAMAT")
    @Expose
    private String alamt;

    public String getNamaTaksi() {
        return namaTaksi;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public String getAlamt() {
        return alamt;
    }
}
