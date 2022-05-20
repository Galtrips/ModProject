package fr.galtrips.modproject.proxy;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void registerRender() {
		System.out.println("Méthode côté client.");
	}
}
