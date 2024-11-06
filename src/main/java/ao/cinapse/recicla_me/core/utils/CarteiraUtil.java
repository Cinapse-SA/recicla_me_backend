package ao.cinapse.recicla_me.core.utils;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


public class CarteiraUtil
{
    public static final String MOEDA = "Kwanza";
    public static final String SIMBOLO_MOEDA = "Kz";
    public static final String NUMERO_CARTEIRA_CUT = "00000000000000001";

    public static String gerarNumeroCarteira(String pessoaId) throws NoSuchAlgorithmException {
        // Obter o timestamp atual em milissegundos
        long timestamp = System.currentTimeMillis();

        Random random = new Random();
        int randomValue = random.nextInt(1000000); // até 1 milhão para adicionar variação

        String rawString = pessoaId + "-" + timestamp + "-" + randomValue;

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(rawString.getBytes(StandardCharsets.UTF_8));

        StringBuilder numericString = new StringBuilder();
        for (byte b : hash) {
            int num = (b & 0xff) % 10; // Converter cada byte em um número de 0 a 9
            numericString.append(num);
        }

        return numericString.toString().substring(0, 17);
    }


    public static String separarQuadrantes( String numero ) {
        String quadrantes = numero;

        String carteira = quadrantes.substring(0, 4) + " " +
                quadrantes.substring(4, 8) + " " +
                quadrantes.substring(8, 12) + " " +
                quadrantes.substring(12, 16) + " " +
                quadrantes.substring(16, 17);

        return carteira;
    }
}
