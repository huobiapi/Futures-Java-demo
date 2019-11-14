package com.huobi.wss.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;

public class ZipUtil {

	/**
	 * 解压客户端发来的程序
	 * Unzip the program from the client-ends
	 * @param depressData
	 * @return
	 * @throws Exception
	 */
	public static byte[] decompress(byte[] depressData) throws Exception {

		ByteArrayInputStream is = new ByteArrayInputStream(depressData);
		ByteArrayOutputStream os = new ByteArrayOutputStream();

		GZIPInputStream gis = new GZIPInputStream(is);

		int count;
		byte data[] = new byte[1024];
		while ((count = gis.read(data, 0, 1024)) != -1) {
			os.write(data, 0, count);
		}
		gis.close();
		depressData = os.toByteArray();
		os.flush();
		os.close();
		is.close();
		return depressData;
	}

}
