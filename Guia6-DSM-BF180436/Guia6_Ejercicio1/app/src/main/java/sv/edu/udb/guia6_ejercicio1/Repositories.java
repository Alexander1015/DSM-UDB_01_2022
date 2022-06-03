package sv.edu.udb.guia6_ejercicio1;

import com.google.gson.annotations.SerializedName;

public class Repositories {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    public int getId() {
        return id;
    };
    public String  getName() {
        return name;
    }
}
