package opgave8.exercise1;

public class BadgeAccessSystem{

    private IBadgeLogger logger;

    public BadgeAccessSystem(IBadgeLogger logger) {
        this.logger = logger;
    }

    public void scanBadge(String studentName) {
        logger.logEntry(studentName);
        //....
    }

}