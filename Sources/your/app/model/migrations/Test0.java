package your.app.model.migrations;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;

public class Test0 extends ERXMigrationDatabase.Migration {
	@Override
	public NSArray<ERXModelVersion> modelDependencies() {
		return null;
	}

	@Override
	public void downgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
		// DO NOTHING
	}

	@Override
	public void upgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
		ERXMigrationTable movieRoleTable = database.newTableNamed("MOVIE_ROLE");
		movieRoleTable.newIntegerColumn("MOVIE_ID", false);
		movieRoleTable.newStringColumn("ROLE_NAME", 255, true);
		movieRoleTable.newIntegerColumn("TALENT_ID", false);
		movieRoleTable.create();
		movieRoleTable.setPrimaryKey("MOVIE_ID", "TALENT_ID");

		ERXMigrationTable talentTable = database.newTableNamed("TALENT");
		talentTable.newIntegerColumn("id", false);
		talentTable.newStringColumn("NAME", 255, true);
		talentTable.create();
		talentTable.setPrimaryKey("id");

		ERXMigrationTable movieTable = database.newTableNamed("MOVIE");
		movieTable.newStringColumn("DESCRIPTION", 1000, true);
		movieTable.newIntegerColumn("id", false);
		movieTable.newStringColumn("TITLE", 255, true);
		movieTable.newIntegerColumn("YEAR", true);
		movieTable.create();
		movieTable.setPrimaryKey("id");

		movieRoleTable.addForeignKey("MOVIE_ID", "MOVIE", "id");
		movieRoleTable.addForeignKey("TALENT_ID", "TALENT", "id");
	}
}