package entidades;

public class Usuario{
    private int codigo_U;
    private int codigo_TU;
    private int codigo_C;
    private int codigo_P;
    private String nombre_U;
    private String password_U;
    private boolean vigencia_U;

    public int getCodigo_U() {
        return codigo_U;
    }

    public void setCodigo_U(int codigo_U) {
        this.codigo_U = codigo_U;
    }

    public int getCodigo_TU() {
        return codigo_TU;
    }

    public void setCodigo_TU(int codigo_TU) {
        this.codigo_TU = codigo_TU;
    }

    public int getCodigo_C() {
        return codigo_C;
    }

    public void setCodigo_C(int codigo_C) {
        this.codigo_C = codigo_C;
    }

    public int getCodigo_P() {
        return codigo_P;
    }

    public void setCodigo_P(int codigo_P) {
        this.codigo_P = codigo_P;
    }

    public String getNombre_U() {
        return nombre_U;
    }

    public void setNombre_U(String nombre_U) {
        this.nombre_U = nombre_U;
    }

    public String getPassword_U() {
        return password_U;
    }

    public void setPassword_U(String password_U) {
        this.password_U = password_U;
    }

    public boolean isVigencia_U() {
        return vigencia_U;
    }

    public void setVigencia_U(boolean vigencia_U) {
        this.vigencia_U = vigencia_U;
    }
}
