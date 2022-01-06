package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GFile {
	public GFile() {}
	
	public Object readObject(File file) {
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Object object = objectInputStream.readObject();
			objectInputStream.close();
			return object;
		} catch (Exception e) {e.printStackTrace();}
		return null;
	}
	
	public void saveObject(Object object, File file) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(object);;
			objectOutputStream.close();
		} catch (Exception e) {e.printStackTrace();}
	}
}

