/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaston.contactos;

/**
 *
 * @author gasto
 */


import java.util.Scanner;

public class AddressBookMenu {
    private static final String FILEPATH = "C:\\Users\\gasto\\OneDrive\\Documentos\\NetBeansProjects\\Contactos\\contactos.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook(FILEPATH);

        System.out.println("Bienvenido a sus contactos");

        boolean running = true;
        while (running) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Mostrar contactos");
            System.out.println("2. Agregar contacto");
            System.out.println("3. Borrar contacto");
            System.out.println("4. Salir");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    addressBook.list();
                    break;
                case "2":
                    System.out.println("Ingrese el número de teléfono:");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Ingrese el nombre:");
                    String name = scanner.nextLine();
                    addressBook.create(phoneNumber, name);
                    break;
                case "3":
                    System.out.println("Ingrese el número de teléfono del contacto que desea borrar:");
                    String number = scanner.nextLine();
                    addressBook.delete(number);
                    break;
                case "4":
                    running = false;
                    break;
                
            }
        }

        System.out.println("Se cerro la aplicacion.");
    }
}
