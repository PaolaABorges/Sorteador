package sorteador.projeto.Service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class S_sorteio {
    int quantidade = 0;
    int inicio = 0;
    int fim = 0;


    public static int[] sortear(int quantidade, int inicio, int fim) {

        Random geradordenumeros = new Random();
        int[] numerosSorteados = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
            numerosSorteados[i] = geradordenumeros.nextInt((fim - inicio) + 1) + inicio;
        }

        return numerosSorteados;

    }

    public static int[] Ordenar(int[] ordenacaonumeros) {
        Arrays.sort(ordenacaonumeros);
        return ordenacaonumeros;
    }

    public static int[] sortearSemRepetir(int quantidade, int inicio, int fim) {
        if (quantidade > fim) {
            throw new IllegalArgumentException("A quantidade de números a serem sorteados não pode ser maior que o limite.");
        }

        Set<Integer> numerosSorteados = new HashSet<>();
        Random random = new Random();

        while (numerosSorteados.size() < quantidade) {
            int numeroSorteado = random.nextInt(fim) + inicio; // Gera um número aleatório entre 1 e o limite
            numerosSorteados.add(numeroSorteado);
        }

        // Converter o Set em um vetor
        int[] vetorNumeros = new int[quantidade];
        int index = 0;
        for (int numero : numerosSorteados) {
            vetorNumeros[index++] = numero;
        }

        return vetorNumeros;
    }
}
