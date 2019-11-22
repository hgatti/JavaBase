package com.base.JavaBase.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.apache.commons.lang3.RandomUtils;

public class RandomService {

    private static String[] maleNames = {"Miguel","Arthur","Bernardo","Heitor","Davi","Lorenzo","Théo","Pedro","Gabriel","Enzo","Matheus","Lucas","Benjamin","Nicolas","Guilherme","Rafael","Joaquim","Samuel","Enzo Gabriel","João Miguel","Henrique","Gustavo","Murilo","Pedro Henrique","Pietro","Lucca","Felipe","João Pedro","Isaac","Benício","Daniel","Anthony","Leonardo","Davi Lucca","Bryan","Eduardo","João Lucas","Victor","João","Cauã","Antônio","Vicente","Caleb","Gael","Bento","Caio","Emanuel","Vinícius","João Guilherme","Davi Lucas","Noah","João Gabriel","João Victor","Luiz Miguel","Francisco","Kaique","Otávio","Augusto","Levi","Yuri","Enrico","Thiago","Ian","Victor Hugo","Thomas","Henry","Luiz Felipe","Ryan","Arthur Miguel","Davi Luiz","Nathan","Pedro Lucas","Davi Miguel","Raul","Pedro Miguel","Luiz Henrique","Luan","Erick","Martin","Bruno","Rodrigo","Luiz Gustavo","Arthur Gabriel","Breno","Kauê","Enzo Miguel","Fernando","Arthur Henrique","Luiz Otávio","Carlos Eduardo","Tomás","Lucas Gabriel","André","José","Yago","Danilo","Anthony Gabriel","Ruan","Miguel Henrique","Oliver"};
    private static String[] femaleNames = {"Alice","Sophia","Helena","Valentina","Laura","Isabella","Manuela","Júlia","Heloísa","Luiza","Maria Luiza","Lorena","Lívia","Giovanna","Maria Eduarda","Beatriz","Maria Clara","Cecília","Eloá","Lara","Maria Júlia","Isadora","Mariana","Emanuelly","Ana Júlia","Ana Luiza","Ana Clara","Melissa","Yasmin","Maria Alice","Isabelly","Lavínia","Esther","Sarah","Elisa","Antonella","Rafaela","Maria Cecília","Liz","Marina","Nicole","Maitê","Isis","Alícia","Luna","Rebeca","Agatha","Letícia","Maria-","Gabriela","Ana Laura","Catarina","Clara","Ana Beatriz","Vitória","Olívia","Maria Fernanda","Emilly","Maria Valentina","Milena","Maria Helena","Bianca","Larissa","Mirella","Maria Flor","Allana","Ana Sophia","Clarice","Pietra","Maria Vitória","Maya","Laís","Ayla","Ana Lívia","Eduarda","Mariah","Stella","Ana","Gabrielly","Sophie","Carolina","Maria Laura","Maria Heloísa","Maria Sophia","Fernanda","Malu","Analu","Amanda","Aurora","Maria Isis","Louise","Heloise","Ana Vitória","Ana Cecília","Ana Liz","Joana","Luana","Antônia","Isabel","Bruna"};

    public static String getMaleName() {
        int i = RandomUtils.nextInt(0, 99);
        return maleNames[i];
    }

    public static String getFemaleName() {
        int i = RandomUtils.nextInt(0, 99);
        return femaleNames[i];
    }

    public static LocalDate getDateNasc(int idadeInicio, int idadeFim) {
        int diff = RandomUtils.nextInt(idadeInicio, idadeFim);

        int day = RandomUtils.nextInt(1, 28);
        int month = RandomUtils.nextInt(1, 12);
        int year = (LocalDate.now().getYear()) - diff;

        return LocalDate.of(year, month, day);
    }

    public static LocalDateTime getDateTime(int anoInicio, int anoFim) {
        int diff = RandomUtils.nextInt(anoInicio, anoFim);

        int day = RandomUtils.nextInt(1, 28);
        int month = RandomUtils.nextInt(1, 12);
        int year = (LocalDate.now().getYear()) - diff;
        int hour = RandomUtils.nextInt(0, 23);
        int minute = RandomUtils.nextInt(0, 59);

        return LocalDateTime.of(year, month, day, hour, minute);
    }

    public static Long gerenateRandomNumber(int size) {
        String result = "";

        for (int i = 0; i < size; i++) {
            int valor = RandomUtils.nextInt(0, 9);
            result = result + String.valueOf(valor);
        }

        return Long.valueOf(result);
    }

}


