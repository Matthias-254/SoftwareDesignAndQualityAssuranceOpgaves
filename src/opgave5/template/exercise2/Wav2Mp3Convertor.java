package opgave5.template.exercise2;

public class Wav2Mp3Convertor extends FileConvertor {

    @Override
    protected int estimateDestFileSize() {
        // TODO Auto-generated method stub
        return 190;
    }

    @Override
    protected void addMetaInfo() {
        // TODO Auto-generated method stub
        System.out.println("Adding MP3 Tag info");
    }

    @Override
    protected void convert() {
        // TODO Auto-generated method stub
        System.out.println("Converting Wav to MP3....done!");
    }

}