/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaston.contactos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {

    public Map<String, String> contacts;
    public String filePath = "C:\\Users\\gasto\\OneDrive\\Documentos\\NetBeansProjects\\Contactos\\contactos.txt";

    public AddressBook(String filePath) {
        this.filePath = filePath;
        this.contacts = new HashMap<>();
        
    }

    public void load() throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String phoneNumber = parts[0];
                String name = parts[1];
                contacts.put(phoneNumber, name);
            }
        }
    }

    public void save() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                String phoneNumber = entry.getKey();
                String name = entry.getValue();
                bw.write(phoneNumber + "," + name + "\n");
            }
        }
    }

    public void list() {
        if (contacts.isEmpty()) {
            System.out.println("No hay contactos en la agenda.");
        } else {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                String phoneNumber = entry.getKey();
                String name = entry.getValue();
                System.out.println(phoneNumber + " - " + name);
            }
        }
    }

    public void create(String phoneNumber, String name) {
        if (contacts.containsKey(phoneNumber)) {
            System.out.println("Ya existe un contacto con ese número telefónico.");
        } else {
            contacts.put(phoneNumber, name);
            System.out.println("Contacto creado: " + phoneNumber + " - " + name);
        }
    }

    public void delete(String phoneNumber) {
        if (contacts.containsKey(phoneNumber)) {
            String name = contacts.remove(phoneNumber);
            System.out.println("Contacto eliminado: " + phoneNumber + " - " + name);
        } else {
            System.out.println("No existe un contacto con ese número.");
        }
    }
}
