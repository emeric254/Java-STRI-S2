import java.util.*;

public class GrandMere extends Humain
{
    private ArrayList<Humain> memoire;

    public GrandMere(String pNom)
    {
        super(pNom, 0,  "Tisane");
        memoire = new ArrayList<Humain>();
    }

    public void direBonjour()
    {
        parler("Bonjour! Je m’appelle " + getNom() + " et j’aime boire du " + getBoisson() + ", je n'ai pas d'argent et je radote !");
    }

    public void faireConnaissanceAvec(Humain h)
    {

    }

    public void ragoter()
    {
        for(Humain h : memoire)
        {
            if(h instanceof Traitre)
            {
                parler("Je sait que " + h.getNom() + " est un TRAITRE !!");
            }
            else
            {
                parler(h.getNom() + " est-il " + humainHasard() + " ? ... ");
            }
        }
    }

    private String humainHasard()
    {
        Random r = new Random();
        switch(r.nextInt() % 4)
        {
            case 0:
                return "Yakuza";
            case 1:
                return "Ronin";
            case 2:
                return "Commercant";
            case 3:
                return "Samourai";
            default:
                return "Humain";
        }
    }
}
