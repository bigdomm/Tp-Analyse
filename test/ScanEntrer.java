import java.util.Scanner;

abstract class ScanEntrer {

	// Le scan utilisé dans les méthode de la classe
	private static Scanner scan;

	// methode qui scan un entier et le valide. affiche un message d'erreur
	static int scannerEntier(int valeurMin, int valeurMax,
			String messageErreur) {

		// contiendra le scan
		scan = new Scanner(System.in);
		String entreeScan;

		// contiendra le nombre retourné
		int entier;

		// deviendra vrai si l'entier est bon pour quitter la boucle
		boolean ok = false;

		do {
			entreeScan = scan.nextLine();

			// essai de mettre le scan en un int.
			try {
				entier = Integer.parseInt(entreeScan);
			

				if (entier < valeurMin || entier > valeurMax)
					throw new NumberFormatException();
				
				ok = true;
				return entier;
			}

			// Si le scan n'est pas un entier compris entre le Min et le Max
			catch (NumberFormatException exception) {
				System.out.print(messageErreur);
			}

		} while (!ok); // tant que cest pas un entier

		return 0;
	}

	static String regString(){
			
		return scan.nextLine();
	}
}
