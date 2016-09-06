
public class Telephone {
	
	private int areaCode, exchange, extension;
	private String number;
	
	public Telephone(int areaCode, int exchange, int extension){
		this.areaCode = areaCode;
		this.exchange = exchange;
		this.extension = extension;
		number = null;
	}
	
	@SuppressWarnings("null")
	public Telephone(int exchange, int extension){
		this.exchange = exchange;
		this.extension = extension;
		areaCode = (Integer) null;
		number = null;
	}
	
	public Telephone(String string)throws Exception{
		number = string.replaceFirst("-", "").replaceFirst("-", "");
		if(number.length() != 10 || number.length() != 7)
			throw new Exception("String in not a telephone number");
		else if(number.length() == 10){
			areaCode = Integer.parseInt(string.substring(0, 3));
			exchange = Integer.parseInt(string.substring(3, 6));
			try{
				areaCode = Integer.parseInt(string.substring(6, 10));
			} catch(Exception ex){
				areaCode = 0;
				areaCode += 1000 * charToInt(string.toLowerCase().charAt(6));
				areaCode += 100 * charToInt(string.toLowerCase().charAt(7));
				areaCode += 10 * charToInt(string.toLowerCase().charAt(8));
				areaCode += charToInt(string.toLowerCase().charAt(9));
			}
		}
	}
	
	public boolean isTollFree(){
		if(areaCode == 800 || areaCode == 866 || areaCode == 877 || areaCode == 880 || areaCode == 881 || areaCode == 882 || areaCode == 888)
			return true;
		else return false;
	}
	
	private int charToInt(char c)throws Exception{
		if(c == 'a' || c == 'b' || c == 'c')
			return 2;
		else if(c == 'd' || c == 'e' || c == 'f')
			return 3;
		else if(c == 'g' || c == 'h' || c == 'i')
			return 4;
		else if(c == 'j' || c == 'k' || c == 'l')
			return 5;
		else if(c == 'm' || c == 'n' || c == 'o')
			return 6;
		else if(c == 'p' || c == 'q' || c == 'r' || c == 's')
			return 7;
		else if(c == 't' || c == 'u' || c == 'v')
			return 8;
		else if(c == 'w' || c == 'x' || c == 'y' || c == 'z')
			return 9;
		else
			throw new Exception("String is not a telephone number");
	}
}
