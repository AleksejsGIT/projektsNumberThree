//Aleksejs Šepeļevs, 221RDB494, 3.grupa;
//Anna Kate Zbitkovska, 221RDB208, 3.grupa;
//Anna Lipenberga, 221RDB237, 3.grupa;

import java.io.*;
import java.util.*;


public class Main {

  static public Map<String, String> morze = new HashMap<String, String>();


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choiseStr;
		String sourceFile, resultFile, firstFile, secondFile;
		
		loop: while (true) {
			
			choiseStr = sc.next();
								
			switch (choiseStr) {
			case "comp":
				System.out.print("source file name: ");
				sourceFile = sc.next();
        File fails = new File(sourceFile);
        if (!fails.exists()) {
          System.out.println("file doesn't exist");
          continue;
        }
				System.out.print("archive name: ");
				resultFile = sc.next();
				comp(sourceFile, resultFile);
				break;
			case "decomp":
				System.out.print("archive name: ");
				sourceFile = sc.next();
        File f = new File(sourceFile);
        if (!f.exists()) {
          System.out.println("file doesn't exist");
          continue;
        }
				System.out.print("file name: ");
				resultFile = sc.next();
				decomp(sourceFile, resultFile);
				break;
			case "size":
				System.out.print("file name: ");
				sourceFile = sc.next();
        File ff = new File(sourceFile);
        if (!ff.exists()) {
          System.out.println("file doesn't exist");
          continue;
        }
				size(sourceFile);
				break;
			case "equal":
				System.out.print("first file name: ");
				firstFile = sc.next();
        File fff = new File(firstFile);
        if (!fff.exists()) {
          System.out.println("file doesn't exist");
          continue;
        }
				System.out.print("second file name: ");
				secondFile = sc.next();
        File fa = new File(secondFile);
        if (!fa.exists()) {
          System.out.println("file doesn't exist");
          continue;
        }
				System.out.println(equal(firstFile, secondFile));
				break;
			case "about":
				about();
				break;
			case "exit":
				break loop;
      default:
        System.out.println("wrong command");
        break;
			}
		}

		sc.close();
	}

  public static HashMap<Character, String> getMorse() {
    HashMap<Character, String> morse = new HashMap<>();
    morse.put('A', "._");
    morse.put('Á', ".__._");
    morse.put('Ä', "._._");
    morse.put('E', ".");
    morse.put('M', "__");
    morse.put('B', "_...");
    morse.put('C', "_._.");
    morse.put('D', "_..");
    morse.put('F', ".._.");
    morse.put('G', "__.");
    morse.put('H', "....");
    morse.put('I', "..");
    morse.put('J', ".___");
    morse.put('K', "_._");
    morse.put('L', "._..");
    morse.put('N', "_.");
    morse.put('O', "___");
    morse.put('P', ".__.");
    morse.put('R', "._.");
    morse.put('S', "...");
    morse.put('T', "_");
    morse.put('U', ".._");
    morse.put('V', "..._");
    morse.put('W', ".__");
    morse.put('X', "_.._");
    morse.put('Y', "_.__");
    morse.put('Z', "__..");
    morse.put('Q', "__._");
    morse.put(',', "__..__");
    morse.put('?', "..__..");
    morse.put('"', "._.._.");
    morse.put('(', "_.__.");
    morse.put(')', "_.__._");
    morse.put(':', "___...");
    morse.put(';', "_._._.");
    morse.put('.', "._._._");
    morse.put('=', "_..._");
    morse.put(' ', "_.._.");
    morse.put('<', "_...._");
    morse.put('>', ".____.");
    morse.put('@', ".__._.");
    morse.put('1', ".____");
    morse.put('2', "..___");
    morse.put('3', "...__");
    morse.put('4', "...._");
    morse.put('5', ".....");
    morse.put('6', "_....");
    morse.put('7', "__...");
    morse.put('8', "___..");
    morse.put('9', "____.");
    morse.put('0', "_____");
    morse.put('a', "._____");
    morse.put('b', "..____");
    morse.put('c', "...___");
    morse.put('d', "....__");
    morse.put('e', "....__..");
    morse.put('f', "....._");
    morse.put('g', "_.....");
    morse.put('h', "__....");
    morse.put('i', "...___..");
    morse.put('j', "___....");
    morse.put('k', "_.___");
    morse.put('l', "..._._.");
    morse.put('m', "..._._._");
    morse.put('n', "....._._");
    morse.put('o', "......._");
    morse.put('p', ".__..");
    morse.put('r', ".___..._");
    morse.put('s', ".___...._");
    morse.put('t', "._....");
    morse.put('u', "._.....");
    morse.put('v', "..._._");
    morse.put('x', "__...._");
    morse.put('y', "___.._");
    morse.put('z', "_...__");
    return morse;
  }


	public static void comp(String sourceFile, String resultFile) {
    File fails = new File(sourceFile);

    if (fails.exists()) { 
      try {
        FileInputStream fin = new FileInputStream(fails);
        InputStreamReader isr = new InputStreamReader(fin, "UTF-8");
        int i;
        StringBuilder sb = new StringBuilder();
        HashMap<Character, String> morse = getMorse();
        do {
          i = isr.read();
          if (i != -1) {
            String binary = String.format("%8s", Integer.toBinaryString(i)).replace(' ', '0');
            //System.out.println(binary);
            char burtss = (char) Integer.parseInt(binary, 2);
            //System.out.println(burtss);
            String result = morse.getOrDefault(burtss, binary);
            //System.out.println(result);
            result = result.replace("_", "0").replace(".", "1");
            sb.append(result);
            sb.append(" ");

          }
        } while (i != -1);
        fin.close();
        isr.close();

        File jauns = new File(resultFile);

        FileOutputStream fos = new FileOutputStream(jauns);
        fos.write(sb.toString().getBytes());

        fos.close();

      } 
      catch (Exception e) {
        System.out.println(e.getMessage());
        return;
        
      }
    }

		// TODO: implement this method
	}

  public static HashMap<String, String> getMorzee() {

    HashMap<String, String> morzee = new HashMap<>();

    
    morzee.put("._", "A");
    morzee.put(".", "E");
    morzee.put("__", "M");
    morzee.put("_...", "B");
    morzee.put("_._.", "C");
    morzee.put("_..", "D");
    morzee.put(".._.", "F");
    morzee.put("__.", "G");
    morzee.put("....", "H");
    morzee.put("..", "I");
    morzee.put(".___", "J");
    morzee.put("_._", "K");
    morzee.put("._..", "L");
    morzee.put("_.", "N");
    morzee.put("___", "O");
    morzee.put(".__.", "P");
    morzee.put("._.", "R");
    morzee.put("...", "S");
    morzee.put("_", "T");
    morzee.put(".._", "U");
    morzee.put("..._", "V");
    morzee.put(".__", "W");
    morzee.put("_.._", "X");
    morzee.put("_.__", "Y");
    morzee.put("__..", "Z");
    morzee.put("__._", "Q");
    morzee.put("__..__", ",");
    morzee.put("..__..", "?");
    morzee.put("._.._.", "\"");
    morzee.put("_.__.", "(");
    morzee.put("_.__._", ")");
    morzee.put("___...", ":");
    morzee.put("_._._.", ";");
    morzee.put("._._._", ".");
    morzee.put("_..._", "=");
    morzee.put("_.._.", " ");
    morzee.put("_...._", "<");
    morzee.put(".____.", ">");
    morzee.put(".__._.", "@");
    morzee.put(".____", "1");
    morzee.put("..___", "2");
    morzee.put("...__", "3");
    morzee.put("...._", "4");
    morzee.put(".....", "5");
    morzee.put("_....", "6");
    morzee.put("__...", "7");
    morzee.put("___..", "8");
    morzee.put("____.", "9");
    morzee.put("_____", "0");
    morzee.put("._____", "a");
    morzee.put("..____", "b");
    morzee.put("...___", "c");
    morzee.put("....__", "d");
    morzee.put("....__..", "e");
    morzee.put("....._", "f");
    morzee.put("_.....", "g");
    morzee.put("__....", "h");
    morzee.put("...___..", "i");
    morzee.put("___....", "j");
    morzee.put("_.___", "k");
    morzee.put("..._._.", "l");
    morzee.put("..._._._", "m");
    morzee.put("....._._", "n");
    morzee.put("......._", "o");
    morzee.put(".__..", "p");
    morzee.put(".___..._", "r");
    morzee.put(".___...._", "s");
    morzee.put("._....", "t");
    morzee.put("._.....", "u");
    morzee.put("..._._", "v");
    morzee.put("__...._", "x");
    morzee.put("___.._", "y");
    morzee.put("_...__", "z");
    return morzee;
  }
  
	public static void decomp(String sourceFile, String resultFile) {

    try {
      StringBuilder sbu = new StringBuilder();
      HashMap<String, String> morzee = getMorzee();
      File f = new File(sourceFile);
      FileInputStream fis = new FileInputStream(f);
      DataInputStream dis = new DataInputStream(fis);

      byte[] dati = new byte[(int) f.length()];
      dis.read(dati);
      dis.close();

      String datii = new String(dati, "UTF-8");
      String[] masivs = datii.split(" ");

      

      for (int k = 0; k < masivs.length; k++) {
        char resultt;
        String substring = masivs[k];
        if (substring.contains("0") || substring.contains("1")) {
          
          String result = substring.replace("0", "_").replace("1", ".");
          result = morzee.get(result);
          //System.out.println(result);
          if (result != null) {
            resultt = result.charAt(0);

            sbu.append(resultt);
            continue;
          } else {
            result = substring.replace("_", "0").replace(".", "1");
            int vertiba = Integer.parseInt(result, 2);
            resultt = (char) vertiba;
            
            sbu.append(resultt);
            continue;
          }
        } else {
          resultt = substring.charAt(0);

          sbu.append(resultt);
        }
        sbu.append(" ");
        
      
      }
      //System.out.println(sbu);

      byte[] rezultats = sbu.toString().getBytes("UTF-8");

      File jauns = new File(resultFile);

      FileOutputStream fos = new FileOutputStream(jauns);
      DataOutputStream dos = new DataOutputStream(fos);
      dos.write(rezultats);

      dos.close();


    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    
		// TODO: implement this method
	}
	
	public static void size(String sourceFile) {
		try {
			FileInputStream f = new FileInputStream(sourceFile);
			System.out.println("size: " + f.available());
			f.close();
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	public static boolean equal(String firstFile, String secondFile) {
		try {
			FileInputStream f1 = new FileInputStream(firstFile);
			FileInputStream f2 = new FileInputStream(secondFile);
			int k1, k2;
			byte[] buf1 = new byte[1000];
			byte[] buf2 = new byte[1000];
			do {
				k1 = f1.read(buf1);
				k2 = f2.read(buf2);
				if (k1 != k2) {
					f1.close();
					f2.close();
					return false;
				}
				for (int i=0; i<k1; i++) {
					if (buf1[i] != buf2[i]) {
						f1.close();
						f2.close();
						return false;
					}
						
				}
			} while (k1 == 0 && k2 == 0);
			f1.close();
			f2.close();
			return true;
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	public static void about() {
		System.out.println("Aleksejs Šepeļevs, 221RDB494, 3.grupa");
		System.out.println("Anna Kate Zbitkovska, 221RDB208, 3.grupa");
    System.out.println("Anna Lipenberga, 221RDB237, 3.grupa");
	}
}
