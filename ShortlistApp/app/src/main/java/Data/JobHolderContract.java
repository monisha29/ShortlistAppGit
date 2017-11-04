package Data;

import android.provider.BaseColumns;

/**
 * Created by FDUSER on 11/1/2017.
 */

public class JobHolderContract {

    public static final class JobholderEntry implements BaseColumns {
        public static final String TABLE_NAME = "jobholder";
        public static final String COLUMN_JBH_ID = "id";
        public static final String COLUMN_TITLE = "jobholderdesc";
        public static final String COLUMN_DEADLINE= "deadline";
    }
}
