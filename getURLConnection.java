package IPAddress;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class getURLConnection {
	public static void main(String[] args) {
		URL u;
		URLConnection uc;
		try {
			u = new URL("http://www.iuh.edu.vn/TuyenSinh/thiSinh/fDHCQXemDiem?pDotXetTuyen=NV1&pDotXT=1&pNamTS=2020");
			uc = u.openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}