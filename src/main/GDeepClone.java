package main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;

import shape.GImageRectangle;

public class GDeepClone {
	
	public Object clone(Object o) {
		try {
			ByteArrayOutputStream BAOS = new ByteArrayOutputStream();
			ObjectOutputStream OOS = new ObjectOutputStream(BAOS);
			if (o.getClass().toString().equals("class shape.GImageRectangle")) {
				ImageIO.write(((GImageRectangle)o).getImage(),"jpg",OOS);
			}else {OOS.writeObject(o);}
		
			ByteArrayInputStream BAIS = new ByteArrayInputStream(BAOS.toByteArray());
			ObjectInputStream OIS;
			OIS = new ObjectInputStream(BAIS);
			if (o.getClass().toString().equals("class shape.GImageRectangle")) {
				return ImageIO.read(ImageIO.createImageInputStream(OIS));
			} else {
				return OIS.readObject();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
