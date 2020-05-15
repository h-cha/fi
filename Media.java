package memo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Media {
	String[] array = new String[124];
	Map<String, String> student;
	Map<String, String> zemi;
	int count = 0;

	public Media(String filename,String teacher) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));

			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				array[i] = line;
				i++;
			}

		} catch (FileNotFoundException e) {
			System.out.println(e);

		} catch (IOException e) {
			System.out.println(e);
		}
		for (int i = 0; i < array.length; i++) {
			Pattern p = Pattern.compile("( |　)+");
			String[] list = p.split(array[i]);

			student = new HashMap<>();
			zemi = new HashMap<>();
			student.put(list[0], list[1] + " " + list[2]);
			zemi.put(list[0], list[3]);

			for ( String a : zemi.values()) {

				if (a.equals(teacher)){
					count ++;
					for (Map.Entry<String, String> entry : student.entrySet()) {
						System.out.println(entry.getKey() + " : " + entry.getValue());
					}
				}
			}
		}
		System.out.println("合計" + count + "人");
	}

	public static void main(String args[]) {
		System.out.println("調べたいゼミの先生の名前を入力");
		System.out.println("先生の名前は苗字のみ");
		Scanner s = new Scanner (System.in);
		String teacher = s.nextLine();
		Media fi = new Media("media.txt",teacher);
	}
}
