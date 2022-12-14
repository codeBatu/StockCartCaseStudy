package studycase.stockcart.model;

import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class DbUtils {
	public static TableModel resultSetToTableModel(ResultSet rs) {
		try {
			ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();

			int numberOfColumns = metaData.getColumnCount();
			Vector columnNames = new Vector();
//			
//
//			 Get the column names
			for (int column = 1; column < numberOfColumns; column++) {
				columnNames.addElement(metaData.getColumnLabel(column));
			}

			// Get all rows.
			Vector rows = new Vector();

			while (rs.next()) {
				Vector newRow = new Vector();

				for (int i = 1; i <= numberOfColumns; i++) {
					newRow.addElement(rs.getObject(i));
				}

				rows.addElement(newRow);
			}

			return new DefaultTableModel(rows, columnNames);
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}
}