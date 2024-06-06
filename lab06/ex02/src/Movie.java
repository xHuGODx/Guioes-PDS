import java.util.List;
import java.util.ArrayList;

public class Movie {
   /**
    * Title of the movie
    */
   private final String title;
   /**
    * Year from which the movie was released
    */
   private final int year;
   /**
    * Director of the movie
    @see Person
    */
   private final Person director;
   /**
    * Writer of the movie
    @see Person
    */
   private final Person writer;
   /**
    * Series to which the movie belongs
    */
   private final String series;
   /**
    * List of People who belong to the cast
    @see Person
    */
   private final List<Person> cast;
   /**
    * List of locations in which the movie was shot
    @see Place
    */
   private final List<Place> locations;
   /**
    * List of languages for which the movie is available
    */
   private final List<String> languages;
   /**
    * List of genres that describe the movie
    */
   private final List<String> genres;
   /**
    * Represents whether the movie is being broadcasted on TV or not
    */
   private final boolean isTelevision;
   /**
    * Represents whether the movie is available on Netflix or not
    */
   private final boolean isNetflix;
   /**
    * Represents whether this is an independent movie or not
    */
   private final boolean isIndependent;

   /**
    * Private Constructor for Movie. Should only be used by the Builder. Takes the builder as input for construction.
    * @param movieBuilder
    */
   private Movie(MovieBuilder movieBuilder)    {
      this.title = movieBuilder.title;
      this.year = movieBuilder.year;
      this.director = movieBuilder.director;
      this.writer = movieBuilder.writer;
      this.series = movieBuilder.series;
      this.cast = movieBuilder.cast;
      this.locations = movieBuilder.locations;
      this.languages = movieBuilder.languages;
      this.genres = movieBuilder.genres;
      this.isTelevision = movieBuilder.isTelevision;
      this.isNetflix = movieBuilder.isNetflix;
      this.isIndependent = movieBuilder.isIndependent;
   }

   /**
    * Getter for the title
    */
   public String getTitle() {
      return this.title;
   }
   /**
    * Getter for the year
    */
   public int getYear() {
      return this.year;
   }

   /**
    * Getter for the director
    */
   public Person getDirector() {
      return this.director;
   }

   /**
    * Getter for the writer
    */
   public Person getWriter() {
      return this.writer;
   }

   /**
    * Getter for the series name
    */
   public String getSeries() {
      return this.series;
   }

   /**
    * Getter for the cast members
    */
   public List<Person> getCast() {
      return this.cast;
   }

   /**
    * Getter for the locations
    */
   public List<Place> getLocations() {
      return this.locations;
   }

   /**
    * Getter for the languages
    */
   public List<String> getLanguages() {
      return this.languages;
   }

   /**
    * Getter for the genres
    */
   public List<String> getGenres() {
      return this.genres;
   }

   /**
    * Getter for the television boolean
    */
   public boolean isTelevision() {
      return this.isTelevision;
   }

   /**
    * Getter for the netflix boolean
    */
   public boolean isNetflix() {
      return isNetflix;
   }

   /**
    * Getter for the independent boolean
    */
   public boolean isIndependent() {
      return isIndependent;
   }

   @Override
   public String toString(){
      return "Movie Title: " + this.getTitle() + " (" + this.getYear() + ") \n" +  "\tMovie Director: " + this.getDirector() + "\n\tMovie Writer: " + this.getWriter(); 
   }

   /**
    * gets detailed info about the movie
    */
   public String printDetailed(){
      return this.toString() + "\n\tMovie Genres: \n" + printDetails(this.getGenres()) + "\tMovie Cast: \n" + printDetails(this.getCast()) + "\tMovie Series: " + this.getSeries() + "\n\tMovie Languages: \n" + printDetails(this.getLanguages()) + ((this.isIndependent) ? "\tThis is an independent movie\n" : "") + ((this.isNetflix) ? "\tThis movie is on Netflix\n" : "") + ((this.isTelevision) ? "\tThis movie is on television\n" : "") ;
   }

   /**
    * Generates a string with all the members of a list descripted. Used as an auxiliary function in printDetailed
    */
   private static String printDetails(List listOfDetails){
      String res = "";
      for (int idx = 0; idx < listOfDetails.size(); idx++){
         res += "\t\t" + listOfDetails.get(idx) + "\n";
      }
      return res;
   }



   public static class MovieBuilder {
      //Mandatory arguments
      private final String title;
      private final int year;

      //Optional arguments
      Person unspecifiedPerson = Person.createPerson("Unspecified");

      private Person director = unspecifiedPerson;
      private Person writer = unspecifiedPerson;
      private String series = "Unspecified";
      private List<Person> cast = new ArrayList<Person>();
      private List<Place> locations = new ArrayList<Place>();
      private List<String> languages = new ArrayList<String>();
      private List<String> genres = new ArrayList<String>();
      private boolean isTelevision = false;
      private boolean isNetflix = false;
      private boolean isIndependent = false;

      public MovieBuilder(String title, int year) {
         this.title = title;
         this.year = year;
      }
      /**
       * Resets the builder
       */
      public void reset() {
         this.director = unspecifiedPerson;
         this.writer = unspecifiedPerson;
         this.series = "Unspecified";
         this.cast = new ArrayList<Person>();
         this.locations = new ArrayList<Place>();
         this.languages = new ArrayList<String>();
         this.genres = new ArrayList<String>();
         this.isTelevision = false;
         this.isNetflix = false;
         this.isIndependent = false;
      }

      public MovieBuilder setDirector(Person director) {
         this.director = director;
         return this;
      }

      public MovieBuilder setWriter(Person writer) {
         this.writer = writer;
         return this;
      }

      public MovieBuilder setSeries(String series) {
         this.series = series;
         return this;
      }

      public MovieBuilder setCast(List<Person> cast) {
         this.cast = cast;
         return this;
      }

      public MovieBuilder setLocations(List<Place> locations) {
         this.locations = locations;
         return this;
      }

      public MovieBuilder setLanguages(List<String> languages) {
         this.languages = languages;
         return this;
      }

      public MovieBuilder setGenres(List<String> genres) {
         this.genres = genres;
         return this;
      }

      public MovieBuilder setTelevision(boolean isTelevision) {
         this.isTelevision = isTelevision;
         return this;
      }

      public MovieBuilder setNetflix(boolean isNetflix) {
         this.isNetflix = isNetflix;
         return this;
      }

      public MovieBuilder setIndependent(boolean isIndependent) {
         this.isIndependent = isIndependent;
         return this;
      }

      public Movie build(){
         return new Movie(this);
      }
   }

   public static void main(String args[]){
      System.out.println("-------- CLIENT INITIATED --------");
      
      List<Person> castSonic = List.of(
         Person.createPerson("Jim Carrey"),
         Person.createPerson("James Marsden"),
         Person.createPerson("Ben Schwartz"),
         Person.createPerson("Tika Sumpter"),
         Person.createPerson("Idris Elba"),
         Person.createPerson("Natasha Rothwell"),
         Person.createPerson("Adam Pally"),
         Person.createPerson("Shemar Moore"),
         Person.createPerson("Lee Majdoub"),
         Person.createPerson("Colleen O'Shaughnessey"),
         Person.createPerson("Melody Nosipho Niemann"),
         Person.createPerson("Tom Butler"),
         Person.createPerson("Brad Kalilimoku")
      );

      List<Place> locationsSonic = List.of(
         Place.createPlace("Port Coquitlam", "Canada"),
         Place.createPlace("Hawaii", "USA"),
         Place.createPlace("Vancouver", "Canada"),
         Place.createPlace("Four Seasons Resort Oahu at Ko Olina", "USA"),
         Place.createPlace("Fort Langley", "Canada")
      );

      List<String> languagesSonic = List.of(
         "English",
         "Japanese",
         "Spanish",
         "French",
         "Portuguese"
      );

      List<String> genresSonic = List.of(
         "Action",
         "Adventure",
         "Comedy",
         "Family",
         "Fantasy",
         "Sci-Fi"
      );




      Movie movieMaker = new Movie.MovieBuilder("Sonic The Hedgehog 2", 2022)
                                  .setDirector(Person.createPerson("Jeff Fowler"))
                                  .setWriter(Person.createPerson("Pat Casey"))
                                  .setCast(castSonic)
                                  .setLocations(locationsSonic)
                                  .setSeries("Sonic The Hedgehog")
                                  .setLanguages(languagesSonic)
                                  .setGenres(genresSonic)
                                  .setTelevision(false)
                                  .setNetflix(true)
                                  .setIndependent(false)
                                  .build();

      //print basic info
      System.out.println(movieMaker);

      //print detailed info
      System.out.println(movieMaker.printDetailed());
      
   }
}