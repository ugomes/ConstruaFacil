package utils;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Logs {
    String dataHora;

    public void iniciarCSV(String dataHora) throws IOException {
        String[] cabecalho = {"data e hora", "caso de teste", "mensagem"};
        this.dataHora = dataHora;
        Writer escritor = Files.newBufferedWriter(Paths.get("target/Log/log - "+dataHora+".csv"));
        CSVWriter escritorCSV = new CSVWriter(escritor);

        escritorCSV.writeNext(cabecalho);

        escritorCSV.flush();
        escritor.close();

    }

    public void registrarCSV( String casoDeTeste, String mensagem) throws IOException {
        //List<String[]> linhas = new ArrayList<>();
        //linhas.add(new String[]{dataHoraLog,casoDeTeste,mensagem});

        String[] linha = new String[]{dataHora,casoDeTeste,mensagem};
        String dataHoraLog = new SimpleDateFormat("[yyyy/MM/dd HH: mm: ss]").format(Calendar.getInstance().getTime());

        //Writer escritor = Files.newBufferedWriter(Paths.get("target/Log/log"+dataHora+".csv"));
        FileWriter escritor = new FileWriter("target/Log/log - "+ dataHora +".csv",true);

        CSVWriter escritorCSV = new CSVWriter(escritor);

        escritorCSV.writeNext(linha);

        escritorCSV.flush();
        escritor.close();

    }
}
