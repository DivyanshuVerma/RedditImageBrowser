import java.io.*;
import java.net.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class ImageDwnl
{
	public static boolean readIm(String url_img, File filename) throws Exception
	{
		
		BufferedImage image = null;
		URL url = new URL(url_img);
		int count = 0;
		while(count<5)
		{
			try
			{
				image = ImageIO.read(url);
				ImageIO.write(image, "jpg" , filename);
				break;
			}
			catch(ConnectException e)
			{
				count++;
				//Connection Failed, Trying Again
			}
			catch(UnknownHostException ue)
			{
				count++;
				//The system is not connected to the internet. Please check your connections
				Thread.sleep(1000);
			}
			catch(javax.imageio.IIOException ie)
			{
				//URL does not exist
				return false;
			}
			catch(IllegalArgumentException iae)
			{
				//Image not found on server
				return false;
			}
		}
		if(count==5)
			return false;
		return true;
	}
}
