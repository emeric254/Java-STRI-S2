public class Samourai extends Humain
{
    private String Seigneur;

    public Samourai(String pNom, int pArgent, String pBoisson, String pSeigneur)
    {
        super(pNom, pArgent, pBoisson);
        Seigneur = pSeigneur;
    }

}
