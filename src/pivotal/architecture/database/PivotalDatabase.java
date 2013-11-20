package pivotal.architecture.database;

import pivotal.architecture.PivotalApplication;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PivotalDatabase extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 5;

	public PivotalDatabase(Context context, String name) {
		super(context, name, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(final SQLiteDatabase db) {
		Log.d(PivotalApplication.DEBUG_TAG, "onCreate PivotalDatabase");
		db.execSQL(PivotalPeopleTable.DROP);
		db.execSQL(PivotalPeopleTable.CREATE);
		db.execSQL(PivotalPeopleTable.DATA_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (oldVersion != newVersion)
			onCreate(db);

	}

}
