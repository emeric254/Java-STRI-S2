import java.util.*;
import java.io.*;

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
        if(memoire.contains(h))
            parler("Ah mais je vous connais deja !");
        else
            memoire.add(h);
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

    public void reunion()
    {
        for(Humain h : memoire)
        {
            h.direBonjour();
        }
    }

    public void sauvegarde()
    {
        ObjectOutputStream o;
        FileOutputStream f;
        try
        {
            f = new FileOutputStream(getNom());
            o = new  ObjectOutputStream(f);

            for(Humain h : memoire)
            {
                o.writeObject(h);
            }
            o.flush();
            o.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Pb fichier") ;
            e.printStackTrace();
        }
        catch (NullPointerException e)
        {
            System.out.println("Pb output nul");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            System.out.println("Pb stream d'entrée/sortie");
            e.printStackTrace();
        }
        catch (SecurityException e)
        {
            System.out.println("Pb droit écriture");
            e.printStackTrace();
        }

    }

    public void lecture()
    {
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

    public void menuHumain()
    {
        try {
            //creation de l'objet Humain que l'on ajoutera dans la memoire
            Humain h = null;
            //creation du descripteur d'entree
            BufferedReader entree = new BufferedReader(new FileReader(FileDescriptor.in));
            char reponse = ' ';
            //variable qui serviront aux constructeurs appropries
            String nom;
            String boisson;
            int argent;
            String clan;
            String seigneur;
            //Il est délicat d'ajouter une grand-mere... car elle-meme devra avoir un fichier de sauvegarde. Attention alors a avoir des noms differents pour ne pas
            //effacer la memoire de la grand-mere que l'on est en train de traiter.
            System.out.println("Voulez-vous ajouter Commercant(c), Ronin(r),Yakuza(y), Samourai(s), GrandMere(g) ou rien($) ?");

            while ((reponse=(entree.readLine()).charAt(0)) !='$')
            {
                //tous les constructeurs necessitent un nom
                System.out.println("Le nom");
                nom = entree.readLine();
                switch (reponse) {
                case 'c': //constructeur avec attribut argent
                    System.out.println("L'argent");
                    argent=Integer.parseInt(entree.readLine());
                    h=new Commercant(nom,argent);
                    break;
                case 'r':// constructeur avec argent et boisson
                    System.out.println("L'argent");
                    argent=Integer.parseInt(entree.readLine());
                    System.out.println("La boisson");
                    boisson = entree.readLine();
                    h=new Ronin(nom,argent,boisson);
                    break;

                case 'y'://constructeur avec argent, boisson et clan
                    System.out.println("L'argent");
                    argent=Integer.parseInt(entree.readLine());
                    System.out.println("La boisson");
                    boisson = entree.readLine();
                    System.out.println("Le clan");
                    clan = entree.readLine();
                    h=new Yakuza(nom,argent,boisson,clan);
                    break;

                case 's': //constructeur avec argent, boisson et seigneur
                    System.out.println("L'argent");
                    argent=Integer.parseInt(entree.readLine());
                    System.out.println("La boisson");
                    boisson = entree.readLine();
                    System.out.println("Le seigneur");
                    seigneur = entree.readLine();
                    h=new Samourai(nom,argent,boisson,seigneur);
                    break;

                case 'g': //constructeur avec le nom uniquement
                    if(nom.equals(getNom()))
                        nom += "-";
                    h=new GrandMere(nom);
                    break;
                    // pas de cas par defaut : on recommence si le caractere lu n'est pas l'un de ceux propose
                }
                //renouveler la demande pour le while
                System.out.println("Voulez-vous ajouter Commercant(c), Ronin(r),Yakuza(y), Samourai(s), GrandMere(g) ou rien($) ?");
                faireConnaissanceAvec(h);
            }
        }
        catch (IOException e)
        {
            //gestion de l'exception
            System.out.println("Pb lecture standard");
            e.printStackTrace();
        }
    }


}
