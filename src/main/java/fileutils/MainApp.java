package fileutils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import entity.Script;
import utils.FileUtil;

public class MainApp {

	public static void main(String[] args) throws FilloException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String localPath = "E:\\DREAM\\AutomationTesting\\dev_environment\\seleniumeasy\\src\\main\\resources\\ACT_MasterDriver.xlsx";
		
		FileUtil fileUtil = new FileUtil();
		Recordset rec = fileUtil.getRecords(localPath, "TAScripts", "*", " Run = 'Y' ");
		
		Map<Integer, Script> scripts = fileUtil.getAllScripts(rec);
		
		// Sorting
		TreeMap<Integer, Script> sortedScripts = new TreeMap<>();
		
		sortedScripts.putAll(scripts);
		
		for(Integer key : sortedScripts.keySet()) {
			Script script = scripts.get(key);
			
			Recordset comps = fileUtil.getRecords(localPath, "TAComponents", "*", " TestID = '"+script.getTestID()+"' ");
			
			comps.next();
			
			int index = 2;
			
			while(true) {
				
				String componentName = comps.getField(index).value();
				
				if(componentName.isEmpty() || componentName == null)
					break;
				
				// Reflection
				
				Class cls = Class.forName(componentName);
				
				Object obj = (Object) cls.getConstructor().newInstance();
				
				Method m = cls.getMethod("run");
				
				m.invoke(obj);
				
				index++;
			}
		}
		
	}

}
