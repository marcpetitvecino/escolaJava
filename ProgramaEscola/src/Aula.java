import java.util.Scanner;

class Aula {

    private int capacitat;
    private Alumne[] alumnes;

    public Alumne[] getAlumnes() {
        return alumnes;
    }

    public void setAlumnes(Alumne[] alumnes) {
        this.alumnes = alumnes;
    }

    public int getCapacitat() {
        return capacitat;
    }

    int quantitatAlumnes = 0;

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;

        alumnes = new Alumne[capacitat];

    }

    public void crearAlumne() {

        int increment = 0;
        boolean trobat = false;

        Scanner read = new Scanner(System.in);

        String nomAlumne;
        String matriculaAlumne;

        System.out.println("Introdueix el nom de l'alumne: ");
        nomAlumne = read.next();

        System.out.println("Introdueix la matricula de l'alumne: ");
        matriculaAlumne = read.next();

        Alumne alumne = new Alumne();
        alumne.setNom(nomAlumne);
        alumne.setMatricula(matriculaAlumne);

        while (!trobat && increment < alumnes.length) {

            if (alumnes[increment] == null ) {
                trobat = true;
            }
            else {
                increment++;
            }

        }
        alumnes[increment] = alumne;


    }

    int comprobarMatricula(String matricula) {

        int increment = 0;
        boolean trobat = false;

        while (!trobat && increment < alumnes.length) {

            if (alumnes[increment].getMatricula().equals(matricula) ) {

                trobat = true;

            }
            else {
                increment++;
            }

        }

        if (increment == alumnes.length && !trobat) {

            System.out.println("No s'ha trobat un alumne amb aquesta matrícula");

        } else {

            return increment;

        }

        return 0;

    }

    void esborrarAlummne(int posicio) {

        System.out.println("S'ha esborrat l'alumne");
        System.out.println("");
        alumnes[posicio] = null;

    }

    void progresAlumne(int posicio, int progres) {

        Alumne alumne = alumnes[posicio];

        if (progres > 5 || progres < 1) {

            System.out.println("El progrés ha de ser entre 1 i 5");

        } else {



            alumne.setProgres(alumne.getProgres() + progres);

        }

        if (alumne.getProgres() >= 10) {

            System.out.println("L' alumne s'ha graduat!");
            System.out.println(" ");
            alumnes[posicio] = null;

        }

    }

    void modificarAlumne (int posicio) {

        Alumne alumne = alumnes[posicio];
        int decisio;
        boolean check = false;
        boolean sortir = false;
        Scanner read = new Scanner(System.in);


            System.out.println("Quines dades vols modificar?");
            System.out.println("1. Nom");
            System.out.println("2. Matricula");
            System.out.println("3. Sortir");

            decisio = read.nextInt();

            while (!sortir) {

                switch (decisio) {

                    case 1:

                        String nouNom;

                        System.out.println("Quin és el nou nom de l'alumne?");
                        nouNom = read.next();

                        alumne.setNom(nouNom);

                        break;

                    case 2:

                        String novaMatricula;

                        System.out.println("Quina és la nova matricula de l'alumne?");
                        novaMatricula = read.next();

                        alumne.setMatricula(novaMatricula);

                        break;

                    case 3:

                        sortir = true;

                        break;


                    default:

                        System.out.println("Introdueix una opció vàlida");

                }

                System.out.println("Quines dades vols modificar?");
                System.out.println("1. Nom");
                System.out.println("2. Matricula");
                System.out.println("3. Sortir");
                System.out.println(" ");

                decisio = read.nextInt();

            }

    }

    void getAlumneByMatricula(int posicio) {

        Alumne alumne = alumnes[posicio];

        String nom = alumne.getNom();
        String matricula = alumne.getMatricula();
        int progres = alumne.getProgres();

        System.out.println("Nom: " + nom);
        System.out.println("Matricula: " + matricula);
        System.out.println("Progrés: " + progres);
        System.out.println(" ");

    }

}
