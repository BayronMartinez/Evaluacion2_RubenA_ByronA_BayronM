package Clases;

public class Credito {
    private int creditoHipotecario;
    private int creditoAutomotriz;
    public Credito()
    {
        creditoHipotecario = 1000000;
        creditoAutomotriz = 500000;
    }
    public int getCreditoHipotecario()
    {
        return creditoHipotecario;
    }
    public int getCreditoAutomotriz()
    {
        return creditoAutomotriz;
    }
}
