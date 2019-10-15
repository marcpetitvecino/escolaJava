import java.util.Scanner;

public class Escola {

    private String nom;

    private Aula aula;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public void crearAula() {

        Scanner read = new Scanner(System.in);

        int capacitatAula;

        System.out.println("Introdueix la capaciat de l'aula");
        capacitatAula = read.nextInt();
        Aula aulaUnica = new Aula();
        setAula(aulaUnica);
        aulaUnica.setCapacitat(capacitatAula);

    }

}
