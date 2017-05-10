package zhujie;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 注解处理器的例子，他将读取一个类文件，检查其上的数据库注解，并生成用来创建数据库的SQL命令
 * @author Administrator
 *
 */
public class TableCreator {
	public static void main(String[] args) throws Exception{
		if(args.length < 1){
			System.out.println("arguments:annotated classes");
			System.exit(0);
		}
		for(String className:args){
			Class<?> cl = Class.forName(className);
			DBTable dbTable = cl.getAnnotation(DBTable.class);
			if(dbTable == null){
				System.out.print("No DBTable annotations in class" + className);
				continue;
			}
			String tableName = dbTable.name();
			if(tableName.length() < 1){
				tableName = cl.getName().toUpperCase();
			}
			List<String> columnDefs = new ArrayList<String>();
			for(Field field : cl.getDeclaredFields()){
				String columnName = null;
				Annotation[] anns = field.getDeclaredAnnotations();
				if(anns.length < 1){
					continue;
				}
				if(anns[0] instanceof SQLInteger){
					SQLInteger sInt = (SQLInteger) anns[0];
					if(sInt.name().length() < 1){
						columnName = field.getName().toUpperCase();
					}else{
						columnName = sInt.name();
					}
					columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
				}
				if(anns[0] instanceof SQLString){
					SQLString sString = (SQLString)anns[0];
					if(sString.name().length() < 1){
						columnName = field.getName().toUpperCase();
					}else
						columnName = sString.name();
					columnDefs.add(columnName + " VARCHAR(" + sString.value()+")"
						+getConstraints(sString.constraints()));
				}
				StringBuilder createCommand = new StringBuilder("CREATE TABLE "+ tableName + "(");
				for(String columnDef : columnDefs)
					createCommand.append("\n    " + columnDef +",");
				String tableCreate = createCommand.substring(0,createCommand.length() - 1) + ");";
				System.out.println("Table Creation SQL for " +
				className + " is :\n" + tableCreate);
			}
		}
	}
	
	private static String getConstraints(Constraints con){
		String constrains = "";
		if(!con.allowNull())
			constrains += " NOT NULL";
		if(con.PrimaryKey())
			constrains += " PRIMARY KEY";
		if(con.unique())
			constrains += " UNIQUE";
		return constrains;
	}
}
