package Utils;

import Bron.Lowcy.Luk;
import Bron.Maga.Rozdzka;
import Bron.Woja.Miecz;
import Bron.Woja.Mlot;
import Bron.Zabojcy.Sztylet;
import Postacie.Dystansowe.Lowca;
import Postacie.Dystansowe.Mag;
import Postacie.Postac;
import Postacie.WZwarciu.Wojownik;
import Postacie.WZwarciu.Zabojca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public abstract class Utils {
	public static ArrayList readArrayListFromTXTFile(File file){
		ArrayList<Postac> arr = new ArrayList<>();
		try (BufferedReader breader = new BufferedReader(new FileReader(file))){

			String wiersz = "";
			String[] staty;

			while ((wiersz = breader.readLine()) != null){
				staty = wiersz.split(";");

				for (int i = 0; i < staty.length; i++) {
					staty[i] = staty[i].trim();
					if (i == 1) continue;
					staty[i] = staty[i].toLowerCase();
				}

				switch (staty[0]){
					case "zabojca":
						if(staty[2].equals("sztylet")) {
							arr.add(new Zabojca(staty[1], new Sztylet()));
						}
					case "lowca":
						if (staty[2].equals("luk")) {
							arr.add(new Lowca(staty[1], new Luk()));
						}
					case "wojownik":
						if(staty[2].equals("miecz")) {
							arr.add(new Wojownik(staty[1], new Miecz()));
						}
						if(staty[2].equals("mlot")) {
							arr.add(new Wojownik(staty[1], new Mlot()));
						}
					case "mag":
						if (staty[2].equals("rozdzka")) {
							arr.add(new Mag(staty[1], new Rozdzka()));
						}
				}
			}
		} catch (Exception e){
		}
		return arr;
	}
}
