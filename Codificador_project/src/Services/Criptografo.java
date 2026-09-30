package Services;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.swing.JFileChooser;

public class Criptografo {

    //======================================================
    // MDC
    //======================================================

    public int mdc(int a, int b) {

        a = Math.abs(a);
        b = Math.abs(b);

        if (b == 0)
            return a;

        return mdc(b, a % b);
    }

    //======================================================
    // GERATRIZ
    //======================================================

    public Geratriz criarGeratriz(String dizima) {

        int indice = dizima.indexOf('.');

        if (indice == -1)
            return new Geratriz(1, 1);

        String parteInteira = dizima.substring(0, indice);
        int inteiro = Integer.parseInt(parteInteira);

        String parteDecimal = dizima.substring(indice + 1);

        int tam = parteDecimal.length();

        int intrusos = 0;

        if (tam > 6)
            intrusos = tam - 6;

        int periodo = tam - intrusos;

        long denominador = 0;

        for (int i = 0; i < periodo; i++)
            denominador = denominador * 10 + 9;

        for (int i = 0; i < intrusos; i++)
            denominador *= 10;

        long parteTotal = Long.parseLong(parteDecimal);

        long parteNaoPeriodica = 0;

        if (intrusos > 0)
            parteNaoPeriodica = Long.parseLong(parteDecimal.substring(0, intrusos));

        long numerador = parteTotal - parteNaoPeriodica;

        numerador += (long) inteiro * denominador;

        int divisor = mdc((int) Math.abs(numerador),(int) Math.abs(denominador));

        return new Geratriz(
                (int) (numerador / divisor),
                (int) (denominador / divisor)
        );
    }

    //======================================================
    // CODIFICAR
    //======================================================

    public void codificar(String mensagem,String tituloArquivo,String chave) throws IOException {

        Geratriz g = criarGeratriz(chave);

        int numerador = g.getNumerador();
        int denominador = g.getDenominador();

        JFileChooser fileChooser = new JFileChooser();

        // Sugere o nome do arquivo
        fileChooser.setSelectedFile(new File(tituloArquivo + ".txt"));

        int resultado = fileChooser.showSaveDialog(null);

        if (resultado != JFileChooser.APPROVE_OPTION) {
            return; // Usuário cancelou
        }

        File arquivo = fileChooser.getSelectedFile();

        // Garante que o arquivo tenha extensão .txt
        if (!arquivo.getName().toLowerCase().endsWith(".txt")) {
            arquivo = new File(arquivo.getAbsolutePath() + ".txt");
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo));

        for (int i = 0; i < mensagem.length(); i++) {

            double valor =
                    ((double) mensagem.charAt(i) * denominador) / numerador;

            long codigo = Math.round(valor * 1000);

            writer.write(Long.toString(codigo));
            writer.newLine();
        }

        writer.close();
    }

    //======================================================
    // DECODIFICAR
    //======================================================

    public String decodificar(String caminho, String chave) throws IOException {

        Geratriz g = criarGeratriz(chave);

        int numerador = g.getNumerador();
        int denominador = g.getDenominador();

        List<String> linhas = Files.readAllLines(Path.of(caminho));

        StringBuilder mensagem = new StringBuilder();

        for (String linha : linhas) {

            long codigo = Long.parseLong(linha);

            double valor =
                    ((double) codigo / 1000.0) * numerador / denominador;

            int caractere = (int) Math.round(valor);

            if (caractere < 32 || caractere > 126)
                caractere = '?';

            mensagem.append((char) caractere);
        }

        return mensagem.toString();
    }

}
