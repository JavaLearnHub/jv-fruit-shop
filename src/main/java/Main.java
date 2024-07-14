import db.Storage;
import db.StorageImpl;
import service.*;

public class Main {

    private static final String FILE_PATH_TO_READ = "src/main/resources/fruitShopInfo.txt";
    private static final String FILE_PATH_TO_WRITE = "src/main/resources/fruitShopInfoResult.txt";

    public static void main(String[] args) throws WrongQuantityException {

        Storage storage = new StorageImpl();
        FruitShopService fruitShopService = new FruitShopService(storage);

        fruitShopService.handleActivities(FILE_PATH_TO_READ, FILE_PATH_TO_WRITE);
    }
}
