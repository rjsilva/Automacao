package br.com.userede.crossbrowser;

public enum Navegadores {
	
	Chrome("chrome"), FireFox("firefox");
	
	  private String action;
	  
	    public String getAction(){
	        return this.action;
	    }
	    private Navegadores(String action){
	        this.action = action;
	    }

}
