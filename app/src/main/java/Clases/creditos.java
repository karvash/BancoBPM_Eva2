package Clases;

public class creditos{

    private int Hipotecario;
    private int Automotriz;

    // Constructor

    public creditos()
    {
        Hipotecario = 1000000;
        Automotriz = 500000;
    }

    // Accesadores

    public int getHipotecario()
    {
        return Hipotecario;
    }

    public int getAutomotriz()
    {
        return Automotriz;
    }
}
