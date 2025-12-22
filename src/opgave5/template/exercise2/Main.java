package opgave5.template.exercise2;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FileConvertor convertor = new Avi2MpgConvertor();
        convertor.convertFile();

        System.out.println();

        convertor = new Csv2XlsConvertor();
        convertor.convertFile();

        System.out.println();

        convertor = new Wav2Mp3Convertor();
        convertor.convertFile();
    }

}