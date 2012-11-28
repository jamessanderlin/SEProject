import java.util.*;
import java.io.*;

/* Format of meters.txt
 * 
 * meterId
 * accountid
 * isdigital - 0 means not digital, 1 means digital 
 * rate
 * READINGS:
 * readingvalue
 * readingDate
 * reading_id (partial key)
 * (Note: the previous lines repeat several times)
 * end
 */
public class Meter_IO 
{
	public Meter_IO()
	{
		File meterFile = new File("meters.txt");
	}
}
