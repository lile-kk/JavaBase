package pure.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 自定义类加载器
 * @author Administrator
 *
 */
public class MyClassLoader extends ClassLoader{
	private String root;
	
	protected Class<?> findClass(String name) throws ClassNotFoundException{
		byte[] classData = loadClassData(name);
		if(classData == null){
			throw new ClassNotFoundException();
		}else {
			return defineClass(name, classData, 0,classData.length);
		}
	}
	
	private byte[] loadClassData(String className){
		String fileName = root + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
		try {
			InputStream ins = new FileInputStream(fileName);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];
			int length = 0;
			while((length = ins.read()) != -1){
				baos.write(buffer,0,length);
			}
			return baos.toByteArray();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String getRoot(){
		return root;
	}
	
	public void setRoot(String root){
		this.root = root;
	}
	
	public static void main(String[] args){
		MyClassLoader classLoader = new MyClassLoader();
		classLoader.setRoot("E:\\apach\\eclipse\\workspace\\AlgrithmTest\\src");
		
		Class<?> testClass = null;
		try {
			testClass = classLoader.loadClass("pure.test.classloader.Test2");
			Object object= testClass.newInstance();
			System.out.println(object.getClass().getClassLoader());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
