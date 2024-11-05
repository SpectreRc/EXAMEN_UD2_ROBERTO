package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Examen_ud2_roberto {

    public void ejer1() {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int numeroObjetivo = random.nextInt(100) + 1; //Defino que me de un número random entre 0 y 100
        int intentosRestantes = 10; //Defino los intentos máximos
        boolean adivinado = false;

        System.out.println("Adivina un número entre 1 y 100! Tienes 10 intentos: ");

        try{
            while (intentosRestantes > 0 && !adivinado) { //Minetras queden intentos y no se adivine te lo seguirá pidiendo, cuando te quedes sin intentos te dirá que has perdido en caso de que no lo adivinas, si lo adivinas antes se cerrará el bucle y te dará la enhorabuena
                System.out.print("Ingresa tu intento: ");
                int intento = scanner.nextInt();

                if (intento == numeroObjetivo) {//Si aciertas el número te da la enhorabuena
                    System.out.println("¡Correcto! Has adivinado el número.");
                    adivinado = true;//Se cierra el bucle si lo aciertas
                } else if (intento < numeroObjetivo) {//Si pones un número más grande del random te da la pista
                    System.out.println("El número es mayor");
                } else if (intento > numeroObjetivo){ //Si pones un número más pequeño del random te da la pista
                    System.out.println("El número es menor");
                }

                intentosRestantes--;//Cada intento que falles te baja un intento más

                if (intentosRestantes <= 0 && !adivinado) {
                    System.out.println("Te quedan " + intentosRestantes + " intentos");
                }
            }
        }catch (InputMismatchException error){ //Éste error es para que si pones letras en vez de números te salte un error
            System.out.println("Error. No admite ciertos caracteres");
        }


        if (!adivinado){ //Si no lo adivinas, te da un mensaje de que has perdido
            System.out.println("Lo siento, has perdido, el número era " + numeroObjetivo + ".");
        }
    }

    public void ejer2(){

        Scanner scanner = new Scanner(System.in);

        String modo = scanner.next();

        int anyo = 0;

        LocalDateTime hoy = LocalDateTime.now(); //Introduzo la variable del tiempo
        int anyo_actual = hoy.getYear(); //Éste código sirve para que me diga el año exacto de hoy
        int anyo1 = 1900; //Con esto haré que mínimo sea el 1900

        for (int i = 0; i > anyo1; i++){
            System.out.println("Indicame un año: "); //Pido un año
            anyo = scanner.nextInt(); //Introduzco variable del año
        }

        boolean error = false;

        try{
            anyo1 = Integer.parseInt(String.valueOf(anyo));
        }catch(NumberFormatException e1){
            System.out.println("El formato del año no es correto. " + e1.getMessage());
        }

        if(anyo1 < 1900 || anyo1 > anyo_actual) {
            System.out.println("El año introducido no es correcto. ");
            error = true;
        }

        int anyo_bisiesto = 4;


    }

}
