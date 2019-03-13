/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdfisica;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Helbert Monteiro
 */
public class SDFisica {

    /**
     * @param args the command line arguments
     */
    
    private static ServerSocket socketServidor;
    private static Socket       dispositivoCliente;
    
    private static Scanner  scanner;
    private static String   json;
    private static Gson     gson;
    private static float    x, y, z;
    
    private static List<Captura>  listaCaptura;
    
    private static Thread   thread;
    
    private static Type listTypeCaptura;
    
    private static GeradorGrafico geradorGrafico;

    public SDFisica() {}
    
    public static void main(String[] args) throws IOException {
        geradorGrafico = new GeradorGrafico();
        
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    socketServidor = new ServerSocket(9000);
                    while(true){
                        dispositivoCliente = socketServidor.accept();

                        System.out.println("\n\nCliente conectado: " + dispositivoCliente.getInetAddress().getHostAddress());

                        scanner = new Scanner(dispositivoCliente.getInputStream());
                        json    = scanner.nextLine();

                        listTypeCaptura = new TypeToken<ArrayList<Captura>>(){}.getType();
                        gson    = new Gson();
                        listaCaptura = new ArrayList<>();
                        listaCaptura = gson.fromJson(json, listTypeCaptura);

                        for(int i = 0; i < listaCaptura.size(); i++){
                            System.out.println(listaCaptura.get(i).toString());
                            
                            x = listaCaptura.get(i).getX();
                            y = listaCaptura.get(i).getY();
                            z = listaCaptura.get(i).getZ();
                            
                            geradorGrafico.addValor(x, y, z, i);
                        }

                        //geradorGrafico.exibeGrafico();
                        listaCaptura.clear();
                        
                        dispositivoCliente.close();
                    }
                }catch(IOException ex){
                    Logger.getLogger(SDFisica.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        });
        
        thread.start();
    }
    
}
