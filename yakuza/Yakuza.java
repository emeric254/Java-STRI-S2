public class Yakuza extends Humain
{
    private String Clan;
    private int Reputation;
/*
    public Yakuza(String pNom, int pArgent, String pBoisson)
    {
        this(pNom, pArgent, pBoisson, "");
    }
*/
    public Yakuza(String pNom, int pArgent, String pBoisson, String nomClan)
    {
        super(pNom, pArgent, pBoisson);
        Clan = nomClan;
        Reputation = 0;
    }

    public void direBonjour()
    {
        super.direBonjour();
        parler("je fais partit du clan " + Clan);
    }

    public String getClan()
    {
        return new String(Clan);
    }

    public int getReputation()
    {
        return new Integer(Reputation);
    }

    public void extorquer(Commercant c)
    {
        gagnerArgent(c.seFaireExtorquer());
        Reputation += 1 ;
        parler("Bien ou bien le pauvre maintenant ?");
    }

    public void gagnerDuel()
    {
        Reputation += 1 ;
        parler("Victoire ! EZ win !");
    }

    public int perdreDuel()
    {
        int montant = getArgent();
        perdreArgent(montant);
        parler("J'ai perdu ...");
        return montant;
    }

}
