import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String nomEscola;
        String matricula;
        int progres;

        boolean sortir = false;
        boolean escolaCreada = false;
        int accio;

        Escola escola = null;

        Scanner read = new Scanner(System.in);

        System.out.println("Benvingut al generador d'escoles 284K/3");

        while (!sortir) {

            crearMenu();
            accio = read.nextInt();

            switch (accio) {

                case 1:

                    if (!escolaCreada) {

                        System.out.println("Introdueix el nom de l'escola: ");
                        nomEscola = read.next();
                        escola = new Escola();
                        escola.setNom(nomEscola);
                        escola.crearAula();

                        escolaCreada = true;

                    } else {

                        System.out.println("No pots crear més d'una escola");

                    }

                    break;

                case 2:

                    escola.getAula().crearAlumne();
                    break;

                case 3:

                    System.out.println("Introdueix la matricula de l'alumne");
                    matricula = read.next();
                    escola.getAula().esborrarAlummne(escola.getAula().comprobarMatricula(matricula));

                    break;

                case 4:

                    System.out.println("Introdueix la matricula de l'alumne: ");
                    matricula = read.next();
                    System.out.println("Introdueix el progrés de l'alumne");
                    progres = read.nextInt();

                    escola.getAula().progresAlumne(escola.getAula().comprobarMatricula(matricula), progres);

                    break;

                case 5:

                    System.out.println("Introdueix la matricula de l'alumne: ");
                    matricula = read.next();

                    escola.getAula().modificarAlumne(escola.getAula().comprobarMatricula(matricula));

                    break;

                case 6:

                    System.out.println("Introdueix la matricula de l'alumne");
                    matricula = read.next();

                    escola.getAula().getAlumneByMatricula(escola.getAula().comprobarMatricula(matricula));

                    break;

                case 7:

                    System.out.println("Nom de l'escola: " + escola.getNom());
                    System.out.println("Capacitat de l'aula " + escola.getAula().getCapacitat());
                    System.out.println(" ");
                    System.out.println("Alumnes: ");

                    for (int i = 0; i < escola.getAula().getAlumnes().length; i++) {

                        Alumne alumne = escola.getAula().getAlumnes()[i];

                        if (alumne == null) {

                            System.out.print("");

                        } else {

                            System.out.println("Nom: " + alumne.getNom());
                            System.out.println("Matricula: " + alumne.getMatricula());
                            System.out.println("Progrés: "  + alumne.getProgres());
                            System.out.println(" ");

                        }

                    }

                    break;

                case 8:

                    sortir = true;

                    break;

                default:

                    System.out.println("Introdueix una opció vàlida");
            }

        }

    }

    private static void crearMenu() {
        System.out.println("Escolleix que vols fer: ");
        System.out.println("1. Donar d'alta una escola (màxim 1)");
        System.out.println("2. Donar d'alta un alumne");
        System.out.println("3. Donar de baixa un alumne");
        System.out.println("4. Fer progressar un alumne");
        System.out.println("5. Modificar les dades d'un alumne");
        System.out.println("6. Mostrar totes les dades d'un alumne");
        System.out.println("7. Mostrar totes les dades de l'escola");
        System.out.println("8. Sortir");
        System.out.println(" ");
    }

}
