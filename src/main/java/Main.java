import service.*;

public class Main {

    private static final String FILE_PATH_TO_READ = "src/main/resources/fruitShopInfo";
    private static final String FILE_PATH_TO_WRITE = "src/main/resources/fruitShopInfoResult";

    public static void main(String[] args) throws WrongQuantityException {
        FruitShopService.handleActivities(FILE_PATH_TO_READ, FILE_PATH_TO_WRITE);
    }
}
