package br.com.pla.backend.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.pla.backend.entity.Entry;

public class ReadRemoteJson implements IRead {

	@Override
	public List<Entry> getEntries(String path) {
		List<Entry> res = new ArrayList<Entry>();
		try {
			StringBuffer buffer = new StringBuffer();
			InputStream inputStream = new URL(path).openStream();
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(inputStream, Charset.forName("UTF-8")));
			bufferedReader.lines().forEach(it -> buffer.append(it));
			JSONArray json = new JSONArray(buffer.toString());

			for (int i = 0; i < json.length(); i++) {
				JSONObject jObj = json.getJSONObject(i);
				res.add(new Entry(jObj.getString("data"), jObj.getString("descricao"), jObj.getString("valor"), jObj.getString("categoria")));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}

}
