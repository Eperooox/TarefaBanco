package br.com.newtonpaiva.dominio;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        String path = "C:/Users/12117275/IdeaProjects/TarefaBanco/Nomes.txt";
        String path2 = "C:/Users/12117275/IdeaProjects/TarefaBanco/Sobrenome.txt";
        Leitura.leitor(path);
        Leitura.leitor(path2);
        Escrita.escritor(path);
        Escrita.escritor(path2);


    }
}

