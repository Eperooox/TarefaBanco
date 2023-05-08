package br.com.newtonpaiva.dominio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Escrita
{
    public static void escritor (String path) throws IOException
    {

        BufferedWriter escrever = new BufferedWriter(new FileWriter(path));
        String linha = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Escreva algo: ");
        linha = in.nextLine();
        escrever.append(linha + "\n");
        escrever.close();

    }
}
