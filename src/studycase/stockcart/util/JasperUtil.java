package studycase.stockcart.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTable;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

public class JasperUtil {

	public JasperPrint GetJasperPrintForStockCardListTable(String path, JTable table) {
		InputStream stringPath = getClass().getResourceAsStream(path);

		Collection<Map<String, ?>> parameters = new ArrayList<>();
		Map<String, Object> maps = new HashMap<String, Object>();

		maps.put("StockCode", table.getModel().getValueAt(0, 0).toString());
		maps.put("StockName", table.getModel().getValueAt(0, 1).toString());
		maps.put("StockType", table.getModel().getValueAt(0, 2).toString());
		maps.put("Unit", table.getModel().getValueAt(0, 3).toString());
		maps.put("Barcode", table.getModel().getValueAt(0, 4).toString());
		maps.put("KdvType", table.getModel().getValueAt(0, 5).toString());
		maps.put("Description", table.getModel().getValueAt(0, 6).toString());
		maps.put("CreatedDate", table.getModel().getValueAt(0, 7).toString());
		maps.put("KdvTypeId", table.getModel().getValueAt(0, 8).toString());
		maps.put("KdvTypeName", table.getModel().getValueAt(0, 9).toString());
		maps.put("KdvTypeCode", table.getModel().getValueAt(0, 10).toString());
		maps.put("KdvTypeRatio", table.getModel().getValueAt(0, 11).toString());
		maps.put("StockId", table.getModel().getValueAt(0, 12).toString());
		maps.put("StockTypeName", table.getModel().getValueAt(0, 13).toString());
		maps.put("StockTypeCode", table.getModel().getValueAt(0, 14).toString());
		maps.put("StockTypeDescription", table.getModel().getValueAt(0, 15).toString());

		parameters.add(maps);

		JRMapCollectionDataSource beanColDataSource = new JRMapCollectionDataSource(parameters);

		JasperPrint jp = null;
		try {
			jp = JasperFillManager.fillReport(stringPath, maps, beanColDataSource);
		} catch (JRException e) {
			// TODO Auto-geSnerated catch block
			e.printStackTrace();
		}
		return jp;

	}

}
