package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileDownloader {
    private final ExecutorService executor;

    public FileDownloader() {
        // ExecutorService con un pool de un solo hilo para descargas secuenciales
        this.executor = Executors.newSingleThreadExecutor();
    }

    public void downloadFile(String fileName) {
        executor.submit(() -> {
            System.out.println("Descargando archivo: " + fileName);
            try {
                for (int progress = 0; progress <= 100; progress += 20) {
                    System.out.println(fileName + " - Progreso: " + progress + "%");
                    Thread.sleep(500); // Simula el tiempo entre cada progreso
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Descarga completada: " + fileName);
        });
    }

    public void shutdown() {
        executor.shutdown(); // Finaliza el ExecutorService después de todas las descargas
    }

    public static void main(String[] args) {
        FileDownloader downloader = new FileDownloader();
        Scanner scanner = new Scanner(System.in);
        
        // Lista de archivos disponibles
        List<String> archivos = new ArrayList<>(Arrays.asList("archivo1.zip", "archivo2.zip", "archivo3.zip", "archivo4.zip"));
        List<Integer> seleccionados = new ArrayList<>();
        
        System.out.println("Archivos disponibles para descargar:");
        for (int i = 0; i < archivos.size(); i++) {
            System.out.println((i + 1) + ". " + archivos.get(i));
        }
        
        System.out.println("Seleccione los archivos a descargar ingresando sus números (ejemplo: 1 3 4), o 0 para finalizar:");
        
        // Leer selección del usuario
        while (scanner.hasNextInt()) {
            int opcion = scanner.nextInt();
            if (opcion == 0) break; // Salir si el usuario ingresa 0
            if (opcion > 0 && opcion <= archivos.size()) {
                seleccionados.add(opcion - 1); // Almacenar índices seleccionados
            } else {
                System.out.println("Opción no válida, intente de nuevo.");
            }
        }
        
        // Procesar descargas en el orden seleccionado por el usuario
        for (int index : seleccionados) {
            downloader.downloadFile(archivos.get(index));
        }
        
        downloader.shutdown(); // Finalizar ExecutorService después de todas las tareas
        scanner.close();
    }
}

