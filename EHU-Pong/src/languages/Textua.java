package languages;

public class Textua {

	private language lang;
	private static Textua nT;

	private Textua() {
		lang = null;
	}

	public static Textua getT() {
		if (nT == null) {
			nT = new Textua();
		}
		return nT;
	}

	public void lengHas(String language) {
		lang = new language(language);
	}

	public String textuaLortu(String textua) {
		return lang.getProperty(textua);
	}
}