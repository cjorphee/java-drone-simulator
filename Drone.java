public class Drone 
	{
	    private String ref;
	    private boolean started;
	    private int posX;
	    private int posY;
	    private int posZ;
	
	    public Drone(String ref) 
		    {
		        this.ref = ref;
		        this.started = false;
		        this.posX = 0;
		        this.posY = 0;
		        this.posZ = 0;
		    }
	
	    public Drone(String ref, int posX, int posY, int posZ) 
		    {
		        this.ref = ref;
		        this.started = false;
		        this.posX = posX;
		        this.posY = posY;
		        this.posZ = Math.max(posZ, 0);
		    }
	
	    public String getRef() 
		    {
		        return ref;
		    }
		
	    public boolean isStarted() 
		    {
		        return started;
		    }
	
	    public int getPosX() 
		    {
		        return posX;
		    }
	
	    public int getPosY() 
		    {
		        return posY;
		    }
	
	    public int getPosZ() 
		    {
		        return posZ;
		    }
	
	    public void demarrer() 
		    {
		        this.started = true;
		    }
		
	    public void arreter() 
		    {
		        this.started = false;
		    }
	
	    public void deplacer(int dX, int dY, int dZ) 
		    {
		        if (started) 
			        {
			            this.posX += dX;
			            this.posY += dY;
			            if (this.posZ + dZ >= 0) 
				            {
				                this.posZ += dZ;
				            } 
			            else 
				            {
				                this.posZ = 0;
				                this.started = false;
				                System.out.println("Drone " + ref + " crashed !!!");
				            }
			        } 
		        else 
			        {
			            System.out.println("Drone " + ref + " not started !!!");
			        }
		    }
	
	    public int calculerDistanceOrigine() 
		    {
		        return (int) Math.sqrt(posX * posX + posY * posY + posZ * posZ);
		    }
		
	    public double calculerDistanceAutreDrone(Drone autreDrone) 
		    {
		        int dX = this.posX - autreDrone.getPosX();
		        int dY = this.posY - autreDrone.getPosY();
		        int dZ = this.posZ - autreDrone.getPosZ();
		        return Math.sqrt(dX * dX + dY * dY + dZ * dZ);
		    }
	
	    public void verifierAlerteProximite(Drone autreDrone, double seuilMin) 
		    {
		        double distance = calculerDistanceAutreDrone(autreDrone);
		        if (distance < seuilMin) 
			        {
			            System.out.println("ALERT : Risque de collision entre le drone " 
			                    + this.ref + " et le drone " + autreDrone.getRef() 
			                    + " (Distance : " + String.format("%.2f", distance) + "m)");
			        }
		    }
	}
