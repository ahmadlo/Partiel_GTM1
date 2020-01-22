package metier;

public class Etudiant {

	
	private int numEtudiant;
	private String nomEtudiant;
	private String prenomEtudiant;
	private Ecole ecole;
		
	public Etudiant(String nomE, String prenomE) {
		this.nomEtudiant = nomE;
		this.prenomEtudiant = prenomE;
	}
	
	public int getNumEtudiant() {
		return numEtudiant;
	}
	public void setNumEtudiant(int numE) {
		this.numEtudiant = numE;
	}
	public String getNomEtudiant() {
		return nomEtudiant;
	}
	public void setNomEtudiant(String nomE) {
		this.nomEtudiant = nomE;
	}
	public String getPrenomEtudiant() {
		return prenomEtudiant;
	}
	public void setPrenomEtudiant(String prenomE) {
		this.prenomEtudiant = prenomE;
	}
	
	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	
	public String faireExamen() {
		return nomEtudiant + " a fait un examen" ;
	}
	
	public boolean inscrire() {
		if (this.getEcole() == null) {
			return false;
		}
		return true;
	}
	

	@Override
	public String toString() {
		return "Etudiant [numEtudiant=" + numEtudiant + ", nomEtudiant=" + nomEtudiant + ", prenomEtudiant=" + prenomEtudiant + "]";
	}	
}
