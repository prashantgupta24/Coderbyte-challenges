package coderbyte;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WeightedPath {

	HashMap<String, Integer> dist = new HashMap<String, Integer>();
	ArrayList<String> wc = new ArrayList<String>();

	String WeightedPath(String[] strArr) {

		int numNodes = Integer.parseInt(strArr[0]);

		HashMap<String, String> adList = new HashMap<String, String>();
		HashMap<String, String> trbk = new HashMap<String, String>();
		StringBuilder ans = new StringBuilder();

		for (int i = 0; i < numNodes; i++) {
			adList.put(strArr[i + 1], "");
			if (i == 0)
				dist.put(strArr[i + 1], 0);
			else
				dist.put(strArr[i + 1], 10000);
		}

		for (int i = numNodes + 1; i < strArr.length; i++) {

			String sp[] = strArr[i].split("\\|");
			String value = adList.get(sp[0]);
			value += sp[1] + "," + sp[2] + "|";
			adList.put(sp[0], value);

			value = adList.get(sp[1]);
			value += sp[0] + "," + sp[2] + "|";
			adList.put(sp[1], value);
		}

		wc.add(strArr[1]);

		for (int i = 0; i < numNodes; i++) {
			String v1 = wc.get(wc.size() - 1);
			String ad = adList.get(v1);
			int disFromSrce = dist.get(v1);

			if (ad != "") {
				String ads[] = ad.split("\\|");
				for (int j = 0; j < ads.length; j++) {
					String adsSp[] = ads[j].split(",");
					String v2 = adsSp[0];
					int edgeWt = Integer.parseInt(adsSp[1]);

					if (!wc.contains(v2)) {
						if (disFromSrce + edgeWt < dist.get(v2))
							dist.put(v2, disFromSrce + edgeWt);
						trbk.put(v2, v1);
					}
				}
			}
			String minNode = getMinNode();
			if (!(minNode == "")) {
				wc.add(minNode);
			}

		}

		String nd = trbk.get(strArr[numNodes]);
		if (nd == null)
			return String.valueOf(-1);
		
		ans.append(strArr[numNodes] + "-");
		while (!nd.equals(strArr[1])) {
			ans.append(nd + "-");
			nd = trbk.get(nd);
		}
		ans.append(strArr[1]);

		return ans.reverse().toString();

	}

	private String getMinNode() {

		String node = "";
		String finalNode = "";
		int dis = 0;

		for (Map.Entry<String, Integer> entry : dist.entrySet()) {
			node = entry.getKey();
			if (!wc.contains(node)) {
				finalNode = node;
				dis = entry.getValue();
				break;
			}

		}

		for (Map.Entry<String, Integer> entry : dist.entrySet()) {
			int value = entry.getValue();
			node = entry.getKey();

			if (!wc.contains(node)) {
				if (value < dis) {
					dis = value;
					finalNode = entry.getKey();
				}
			}

		}
		if (dis != 10000)
			return finalNode;
		else
			return "";
	}

	public static void main(String[] args) {
		// keep this function call here
		// Scanner s = new Scanner(System.in);
		WeightedPath c = new WeightedPath();
		// System.out.print(c.WeightedPath(new
		// String[]{"7","A","B","C","D","E","F","G","A|B|1","A|E|9","B|C|2","C|D|1","D|F|2","E|D|6","F|G|2"}));
//		System.out.print(c.WeightedPath(new String[] { "4", "A", "B", "C", "D",
//				"A|B|2", "C|B|11", "C|D|3", "B|D|2" }));
		// System.out.print(c.WeightedPath(new
		// String[]{"4","x","y","z","w","x|y|2","y|z|14", "z|y|31"}));
		// System.out.print(c.WeightedPath(new
		// String[]{"6","A","B","C","D","E","F","B|A|2","A|F|12","A|C|4","B|D|1","D|E|1","C|D|4","F|E|1"}));
		 System.out.print(c.WeightedPath(new
		 String[]{"5","c","a","b","d","e","c|a|3","a|b|2","a|d|34","b|e|15","e|d|2"}));
	}

}







  
