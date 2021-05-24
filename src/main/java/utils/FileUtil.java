package utils;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import entity.Script;

public class FileUtil {

	public Recordset getRecords(String xlPath, String sheetName, String select, String where) throws FilloException {

		Fillo fillo = new Fillo();
		Connection con = fillo.getConnection(xlPath);
		
		String query = "select "+ select + " from " + sheetName;
		
		if(!where.isEmpty() && where != null) {			
			query = query + " where " + where;			
		}
		
		Recordset records = con.executeQuery(query);		
		return records;
	}
	
	public Map<Integer, Script> getAllScripts(Recordset rec) throws FilloException {
		
		Map<Integer, Script> scripts = new HashedMap<>();
		
		int i = 0;
		
		while(rec.next()) {
			Script script = new Script();
			
			script.setTestID(rec.getField("TestID"));
			script.setModule(rec.getField("Mdule"));
			
			script.setAutomatedBy(rec.getField("Automated By"));
			script.setBatchFileName(rec.getField("Batch File Name"));
			script.setRun(Boolean.valueOf(rec.getField("Run")));
			script.setTestDesc(rec.getField("Test Description"));
			script.setTestTitle(rec.getField("Test Title"));
			
			scripts.put(i++, script);
		}
		
		return scripts;
		
	}

}
