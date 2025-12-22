package opgave5.template.exercise2;

public abstract class FileConvertor {

    public final void convertFile() {
        selectSourceFile();
        selectTargetDir();
        int size = estimateDestFileSize();
        if (hasEnoughFreeSpace(size)) {
            addMetaInfo();
            convert();
        }
    }

    private boolean hasEnoughFreeSpace(int size) {
        // TODO Auto-generated method stub
        //hier kan in werkelijkheid een vergelijking komen met targetdir
        if (size < 200)
            return true;
        else
            return false;
    }

    private void selectSourceFile() {
        System.out.println("Geef het bronbestand in:");

    }

    private void selectTargetDir() {
        System.out.println("Selecteer doelmap:");
    }

    protected abstract int estimateDestFileSize();

    protected abstract void addMetaInfo();

    protected abstract void convert();
}