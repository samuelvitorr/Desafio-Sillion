package com.exam;

import java.util.Map;
import java.util.Scanner;

import com.exam.service.HttpService;
import com.exam.service.TextCounterService;

public class Main {

    public static void main(String[] args) {
        HttpService http = new HttpService();
        TextCounterService counter = new TextCounterService();

        try (Scanner sc = new Scanner(System.in)) {

            boolean continuar = true;

            while (continuar) {
                System.out.println("=== Contador de palavras/frases em páginas web ===");

                String url;
                do {
                    System.out.print("Digite a URL da página (ex: https://pt.wikipedia.org/wiki/Linux): ");
                    url = sc.nextLine().trim();
                    if (url.isEmpty()) {
                        System.out.println("URL não pode ser vazia. Tente novamente.");
                    }
                } while (url.isEmpty());

                String phrase;
                do {
                    System.out.print("Digite a palavra ou frase para buscar: ");
                    phrase = sc.nextLine().trim();
                    if (phrase.isEmpty()) {
                        System.out.println("Frase não pode ser vazia. Tente novamente.");
                    }
                } while (phrase.isEmpty());

                try {
                    System.out.println("\nBuscando contédo da página...");
                    String content = http.fetchContent(url);

                    int phraseCount = counter.countPhrase(content, phrase);
                    System.out.println("\n\"" + phrase + "\" \u2192 repete " + phraseCount + " vezes");

                    String[] words = phrase.split("\\s+");
                    Map<String, Integer> wordCount = counter.countWords(content, words);

                    System.out.println("\nDetalhe por palavra:");
                    wordCount.forEach((w, c) -> System.out.println("\"" + w + "\" \u2192 repete " + c + " vezes"));

                } catch (Exception e) {
                    System.out.println("Erro ao buscar a página: " + e.getMessage());
                }

                System.out.print("\nDeseja fazer outra busca? (s/n): ");
                String resposta = sc.nextLine().trim().toLowerCase();
                continuar = resposta.equals("s") || resposta.equals("sim");
                System.out.println();
            }

            System.out.println("Programa encerrado. Até mais!");

        }
    }
}
