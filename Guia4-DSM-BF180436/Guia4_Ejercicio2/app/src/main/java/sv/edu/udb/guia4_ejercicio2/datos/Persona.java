package sv.edu.udb.guia4_ejercicio2.datos;

public class Persona {
    private String dui;
    private String nombre;
    private String nacimiento;
    private String genero;
    private Double peso;
    private Double altura;
    String key;

    public Persona() {
    }

    public Persona(String dui, String nombre, String nacimiento, String genero, Double peso, Double altura) {
        this.dui = dui;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.genero = genero;
        this.peso = peso;
        this.altura = altura;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNacimiento() { return nacimiento; }

    public void setNacimiento() { this.nacimiento = nacimiento; }

    public String getGenero() { return genero; }

    public void setGenero() { this.genero = genero; }

    public Double getPeso() { return peso; }

    public void setPeso() { this.peso = peso; }

    public Double getAltura() { return altura; }

    public void setAltura() { this.altura = altura; }
}