package segundoParcial;

public class Main {

    public static void main(String[] args) {

        Estudiante estudiante = new Estudiante( 26844349 ,"Matias", "Suarez" , "Analista de Sistemas");

        Profesor profesor = new Profesor(100, "John", "Doe");


        estudiante.getMateriasAprobadas().add("POO");
        estudiante.getMateriasAprobadas().add("Experiencia de Usuario");
        estudiante.getMateriasAprobadas().add("Programacion Web");


        estudiante.getMateriasInscriptas().add("Sistemas Empresariales");
        estudiante.getMateriasInscriptas().add("Base de datos");


        System.out.println(estudiante);
        System.out.println(profesor);


        estudiante.imprimirMateriasAprobadas();
        estudiante.imprimirMateriasInscriptas();
    }


}
