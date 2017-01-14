package e.arranz.miw_upm.klondike.utils;

public class LimitedStringDialog {

	private String title;
	
	private ClosedIntervalString limits;
	
	public LimitedStringDialog(String title, ClosedIntervalString limits){
		assert title != null;
		this.limits = limits;
		this.title = title + ": ";
	}
	
	
	public String read(){
		IO io = new IO();
		String value;
		boolean ok;
		do {
			value = io.readString(title);
			ok = limits.includes(value);
			if (!ok) {
				io.writeln("El valor debe estar entre " + limits);
			}
		} while (!ok);
		return value;
	}
}
