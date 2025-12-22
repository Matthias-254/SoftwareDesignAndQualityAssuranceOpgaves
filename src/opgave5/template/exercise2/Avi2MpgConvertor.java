package opgave5.template.exercise2;

public class Avi2MpgConvertor extends FileConvertor {

    @Override
    protected int estimateDestFileSize() {
        // TODO Auto-generated method stub
        return 120;
    }

    @Override
    protected void addMetaInfo() {
        // TODO Auto-generated method stub
        System.out.println("Adding Mpg metainfo");
    }

    @Override
    protected void convert() {
        // TODO Auto-generated method stub
        System.out.println("Converting from avi to mpg format...done!");

    }

}