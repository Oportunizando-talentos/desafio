package br.com.meganews.desafiojunior.desafiojunior.util;

import java.math.BigDecimal;
import java.math.MathContext;


public class ArredondaPreco {

    static public Double Arredonda(double aValor, int Digits)
    {
        MathContext digitos = new MathContext(digitosParaArredondamento(aValor,Digits));
        BigDecimal valor = new BigDecimal(aValor,digitos);
        return valor.doubleValue();
    }

    static private int digitosParaArredondamento(double valor, int digito) {
        BigDecimal ValorAbs = BigDecimal.valueOf(Math.abs(valor));
        int parteInteira = getParteInteira(ValorAbs.doubleValue()).intValue();
        return String.valueOf(parteInteira).length() + digito;
    }

    static private BigDecimal getParteInteira(Double valor)
    {
        if (valor >= 0.0)
            return BigDecimal.valueOf(Math.floor(valor));
        else
            return BigDecimal.valueOf(Math.ceil(valor));
    }


}
