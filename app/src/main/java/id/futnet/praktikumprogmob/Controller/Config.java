package id.futnet.praktikumprogmob.Controller;

import java.util.Random;

/**
 * Created by Devtian Dicky on 09-Nov-17.
 */

public class Config {

    public static final int DATABASE_VERSION = 1;

    // DATABASE Name
    public static final String DATABASE_NAME = "MEMBER_KOPLAR";

    // member table name
    public static final String TABLE_MEMBER = "MEMBER";


    // Member table columns name
    public static final String MEMBER_ID = "member_id";
    public static final String MEMBER_NAME = "member_name";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    private static Random rnd = new Random();

    public static int getRandomNumber() {
        StringBuilder sb = new StringBuilder(20);
        for(int i=0; i < 10; i++)
            sb.append((char)('0' + rnd.nextInt(10)));

        int value = Integer.parseInt(sb.toString());
        return value;
    }
    public static int randInt() {

        // NOTE: This will (intentionally) not run as written so that folks
        // copy-pasting have to think about how to initialize their
        // Random instance.  Initialization of the Random instance is outside
        // the main scope of the question, but some decent options are to have
        // a field that is initialized once and then re-used as needed or to
        // use ThreadLocalRandom (if using at least Java 1.7).
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((20 - 10) + 1) + 10;

        return randomNum;
    }
}

