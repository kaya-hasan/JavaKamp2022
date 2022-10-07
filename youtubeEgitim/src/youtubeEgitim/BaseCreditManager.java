package youtubeEgitim;

public  abstract class BaseCreditManager implements ICreditManager{

	
	public abstract void calculate(); // her yerde degisken

	@Override
	public void save() {
		System.out.println("Kaydedildi");
		
	}
	
}
