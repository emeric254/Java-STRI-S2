public class Humain
{
    private String Nom;
    private int Argent;
    public String Boisson;

    public Humain()
    {
    }

    public void parler(String texte)
    {
        System.out.println(Nom + texte);
    }

    public void direBonjour()
    {
        parler("Bonjour! Je m’appelle " + Nom + " et j’aime boire du " + Boisson);
    }

    public void boire()
    {
        parler("Ahhh, un bon verre de " + Boisson + " ! GLOUPS!");
    }

    public int getArgent()
    {
        // new pour proteger la var de toute modif pirate
        return new Integer(Argent);
    }

    public String getBoisson()
    {
        // new pour proteger la var de toute modif pirate
        return new String(Boisson);
    }

    public String getNom()
    {
        // new pour proteger la var de toute modif pirate
        return new String(Nom);
    }

    public void gagnerArgent(int gain)
    {
        Argent += gain;
    }

    public void perdreArgent(int perte)
    {
        Argent -= perte;
    }
}
