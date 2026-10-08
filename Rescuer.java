

public class Rescuer 
	{
	    private String name;
	    private String firstName;
	    private int age;
	    private String speciality;
	
	    public Rescuer(String name, String firstName, int age, String speciality) 
		    {
		        this.name = name;
		        this.firstName = firstName;
		        this.age = age;
		        this.speciality = speciality;
		    }
	
	    public String getName() 
		    {
		        return name;
		    }
	
	    public String getFirstName() 
		    {
		        return firstName;
		    }
	
	    public int getAge() 
		    {
		        return age;
		    }
	
	    public String getSpeciality() 	
		    {
		        return speciality;
		    }
	
	    public void setName(String name) 
		    {
		        if (name != null && name.length() >= 3 && name.length() <= 30) 
			        {
			            this.name = name;
			        } 
		        else 
			        {
			            System.out.println("Erreur : Le nom doit contenir entre 3 et 30 caractères.");
			        }
		    }
	
	    public void setFirstName(String firstName) 
		    {
		        if (firstName != null && firstName.length() >= 3 && firstName.length() <= 30) 
			        {
			            this.firstName = firstName;
			        } 
		        else 
			        {
			            System.out.println("Erreur : Le prénom doit contenir entre 3 et 30 caractères.");
			        }
		    }
	
	    public void setAge(int age) 
		    {
		        if (age >= 18) 
			        {
			            this.age = age;
			        } 
		        else 
			        {
			            System.out.println("Erreur : Le sauveteur doit être majeur (18 ans ou plus).");
			        }
		    }
	
	    public void setSpeciality(String speciality) 
		    {
		        this.speciality = speciality;
		    }
	
	    public void afficher() 
		    {
		        System.out.println(name + " " + firstName + " - " + age + " ans - " + speciality);
		    }
}