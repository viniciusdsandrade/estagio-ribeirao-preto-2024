import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String str = "Vinícius dos Santos Andrade";
        System.out.println(reverseString(str));
        System.out.println(reverseString2(str));
        System.out.println(reverseString3(str));
        System.out.println(reverseString4(str));

        for (long i = 0; i < 100; i++)
            System.out.println(isFibonacciNumberString(i));

        for (int i = 0; i < 100; i++)
            System.out.println(somaSequencia(i));
    }

    /**
     * Calcula a soma dos primeiros números inteiros positivos até o índice especificado.
     *
     * @param INDICE O índice até o qual a sequência será somada.
     * @return A soma dos números inteiros positivos até o índice especificado.
     */
    public static Long somaSequencia(int INDICE) {
        long SOMA = 0L, K = 0L;

        while (K < INDICE) {
            K = K + 1;
            SOMA = SOMA + K;
        }

        return SOMA;
    }

    /**
     * Inverte uma string fornecida.
     *
     * @param str A string a ser invertida.
     * @return A string invertida.
     */
    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    /**
     * Inverte uma string fornecida usando concatenação de caracteres.
     *
     * @param str A string a ser invertida.
     * @return A string invertida.
     */
    public static String reverseString2(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);
        }
        return reversed;
    }

    /**
     * Inverte uma string fornecida usando a classe StringBuilder.
     *
     * @param str A string a ser invertida.
     * @return A string invertida.
     */
    public static String reverseString3(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * Inverte uma string fornecida usando fluxo de caracteres.
     *
     * @param str A string a ser invertida.
     * @return A string invertida.
     */
    public static String reverseString4(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);
    }

    /**
     * Verifica se um número dado pertence à sequência de Fibonacci.
     *
     * @param num O número a ser verificado.
     * @return Uma string indicando se o número pertence ou não à sequência de Fibonacci.
     */
    public static String isFibonacciNumberString(long num) {
        return isFibonacciNumber(num) ?
                num + " pertence à sequência de Fibonacci" :
                num + " não pertence à sequência de Fibonacci";
    }

    /**
     * Verifica se um número dado pertence à sequência de Fibonacci.
     *
     * @param num O número a ser verificado.
     * @return true se o número pertence à sequência de Fibonacci, caso contrário, false.
     */
    public static boolean isFibonacciNumber(long num) {
        if (num < 0) return false;

        List<Long> sequence = new ArrayList<>();
        sequence.add(0L);
        sequence.add(1L);
        int i = 2;
        while (true) {
            long nextNum = sequence.get(i - 1) + sequence.get(i - 2);
            if (nextNum > num) {
                break;
            }
            sequence.add(nextNum);
            i++;
        }
        return sequence.contains(num);
    }

    public static List<Long> generateFirstNFibonacciNumbers(int n) {
        List<Long> sequence = new ArrayList<>();
        sequence.add(0L);
        sequence.add(1L);
        for (int i = 2; i < n; i++) {
            sequence.add(sequence.get(i - 1) + sequence.get(i - 2));
        }
        return sequence;
    }

    public static List<Long> generateFibonacciNumbersLessThan(long num) {
        List<Long> sequence = new ArrayList<>();
        sequence.add(0L);
        sequence.add(1L);
        int i = 2;
        while (true) {
            long nextNum = sequence.get(i - 1) + sequence.get(i - 2);
            if (nextNum > num) {
                break;
            }
            sequence.add(nextNum);
            i++;
        }
        return sequence;
    }
}