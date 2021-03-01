package pl.wpulik.gender_recognizer.service;

public enum Variants {
	
	FIRST_TOKEN(1, FirstTokenRecognizer.getInstance()),
	ALL_TOKENS(2, AllTokenRecognizer.getInstance());
	
 	private int variant;
	private IRecognizer instance;	
	
	Variants(int variant, IRecognizer instance){
		this.variant = variant;
		this.instance = instance;
	}
	
	public int getVariant() {
		return variant;
	}
	
	public IRecognizer getInstance() {
		return instance;
	}
	
	public static Variants setVariant(int variant) {
		Variants[] variants = Variants.values();
		for(Variants value : variants) {
			if(value.getVariant()==variant)
				return value;
		}
		throw new IllegalArgumentException("NO VARIANT FOUND");
	}

	
	

}
