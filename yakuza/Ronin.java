public class Ronin extends Humain
{
    private int Honneur;

    public Ronin(String pNom, int pArgent, String pBoisson)
    {
        super(pNom, pArgent, pBoisson);
        Honneur = 1;
    }

    public void provoquer(Yakuza y)
    {
        if((Honneur*2) >= y.getReputation())
        {
            gagnerArgent(y.perdreDuel());
            Honneur += 1;
            parler("Victoire ! EZ win !");
        }
        else
        {
            y.gagnerDuel();
            Honneur -= 1;
            parler("J'ai perdu ...");
        }
    }

    public void donner(int montant, Commercant c)
    {
        perdreArgent(montant);
        parler("voila " + montant + " sous marchand !");
        c.recevoir(montant);
    }

    public int getHonneur()
    {
        return new Integer(Honneur);
    }
}
