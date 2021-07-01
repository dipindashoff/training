package jsonpath;

import com.jayway.jsonpath.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ReadFromJsonUsingJayway {

    // Data: movies.json
    String filePath = ".//src//test//java//jsonpath//movies.json";
    String jsonString;

    /*
    Reading a JSON file
     */
    @Test
    public void readingJSON() {

        try {
            String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));

            // METHOD 1
            Map<String, ?> item1 = JsonPath.read(jsonString, "$[0]");
            Map<String, ?> item2 = JsonPath.read(jsonString, "$[1]");

            // DISADVANTAGE OF THE ABOVE  METHOD:
            // Here, if you only want to read once this is OK.
            // In case you need to read another path as well this is not the way to go since the document
            // will be parsed every time you call JsonPath.read(...).
            // To avoid the problem you can parse the json first.

            // METHOD 2
            // Parse the json & pass the configuration along with it
            Object document = Configuration.defaultConfiguration().jsonProvider().parse(jsonString);

            Map<String, ?> item1_1 = JsonPath.read(document, "$[0]");
            Map<String, ?> item2_2 = JsonPath.read(document, "$[1]");
            System.out.println(item1_1);

            // METHOD 3
            ReadContext cxt = JsonPath.parse(jsonString);
            List<String> listOfMovieDesc = cxt.read("$[?(@.title == 'Spectre')].desc");
            System.out.println(listOfMovieDesc.get(0)); //Twenty-fourth James Bond movie

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Parse the JSON to a String
     */
    public String getJsonAsString() {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
    Getting Object Data Given IDs
     */
    @Test
    public void getMovieByID() {
        String jsonString = getJsonAsString();

        // METHOD 1 - extract as a Map
        List<Map<String, ?>> movieListOfID2 = JsonPath.read(jsonString, "$[?(@.id == 2)]");
        Map<String, ?> movieOfID2 = movieListOfID2.get(0);

        // Assert the values in the Map output
        assertEquals(movieOfID2.get("id"), 2);
        assertEquals(movieOfID2.get("title"), "Quantum of Solace");
        assertEquals(movieOfID2.get("desc"), "Twenty-second James Bond movie");

        // METHOD 2 - extract as an Object and then to a single String
        Object dataObject = JsonPath.parse(jsonString).read("$[?(@.id == 2)]");
        String dataString = dataObject.toString();

        // Assert from a String output
        assertTrue(dataString.contains("2"));
        assertTrue(dataString.contains("Quantum of Solace"));
        assertTrue(dataString.contains("Twenty-second James Bond movie"));

        // METHOD 3 - Using JsonPath of Rest Assured
        io.restassured.path.json.JsonPath jsonObj = new io.restassured.path.json.JsonPath(jsonString);
        // JsonPath object returns a list of ids
        assertTrue(jsonObj.getString("id").contains("2"));
    }

    /*
    Getting the Movie Title Given Starring - using 'in'
     */
    @Test
    public void getMovieTitleFromStarring() {
        String jsonString = getJsonAsString();
        // in --> Checks if the left-side value is present in the right-side list  [?(@.size in ['S', 'M'])]
        List<Map<String, ?>> moviesListOfActor = JsonPath.read(jsonString, "$[?('Lea Seydoux' in @.starring)]");
        System.out.println(moviesListOfActor.get(0).get("title")); // Spectre
    }

    /*
    Get ID of the movie containing title - using 'contains'
     */
    @Test
    public void getMovieWithTitleContaining() {
        String jsonString = getJsonAsString();
        // contains --> Checks if a string contains the specified substring (case-sensitive), or an array contains the
        // specified element  eg. [?(@.name contains 'Alex')]
        List<Integer> listOfIDs = JsonPath.read(jsonString, "$[?(@.title contains 'Skyfall')].id");
        System.out.println(listOfIDs.get(0)); //3
    }

    /*
    Get movies with both Daniel Craig AND Sam Mendes
     */
    @Test
    public void getMovieWith2Characters(){
        String jsonString = getJsonAsString();
        List<String> listOfMovies = JsonPath.read(jsonString, "$[?('Daniel Craig' in @.starring && @.director == " +
                "'Sam Mendes')].title ");
        System.out.println(listOfMovies); //["Skyfall","Spectre"]
    }

    /*
    Using Filter Predicates
    Find a movie with poor box office collection
     */
    @Test
    public void usingFilterPredicate(){
        String jsonString = getJsonAsString();
        Filter flopFilter = filter(
                where("['box office']").lte(591692079) //lte = less than or equal to (<=)
                // here, where("box office") - won't work!
                // property with space: Use bracket notion ['my prop'] if your property contains blank characters
                // without space: where("price")
        );

        List<Map<String, Object>> flopMovieList =
                JsonPath.parse(jsonString).read("$[?]", flopFilter);
        System.out.println(flopMovieList.get(0).get("title")); //Quantum of Solace

        // NOTE: Filters can also be combined with 'OR' and 'AND'
    }

    /*
    Return Path rather than the value
    Path vs Value
    In the Goessner implementation a JsonPath can return either Path or Value.
    Value is the default and what all the examples above are returning.
    If you rather have the path of the elements our query is hitting this can be achieved with an option.

    i.e by default the values of a list of String is returned.
    If you want to rather make it return the path of each objects, set Option.AS_PATH_LIST in Configuration
     */
    @Test
    public void getPath() throws IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get(".//src//test//java//DataDriven//store.json")));

        // By default values are returned
        List<String> valueList = JsonPath.parse(jsonString).read("$..author");
        System.out.println(valueList); //["Nigel Rees","Evelyn Waugh","Herman Melville","J. R. R. Tolkien"]

        // Change configuration to return the path (of each object) instead
        Configuration conf = Configuration.builder()
                .options(Option.AS_PATH_LIST).build();

        List<String> pathList = JsonPath.using(conf).parse(jsonString).read("$..author");
        System.out.println(pathList); //["$['store']['book'][0]['author']","$['store']['book'][1]['author']","$['store']['book'][2]['author']","$['store']['book'][3]['author']"]
    }

    /*
    Calculation of the Total Revenue
     */
    @Test
    public void getTotalRevenue() {
        String jsonString = getJsonAsString();
//        List<Integer> listOfRevenues = JsonPath.read(jsonString,"$..box office"); //throws error - Use bracket notion ['my prop'] if your property contains blank characters
        List<Integer> listOfRevenues = JsonPath.read(jsonString, "$..['box office']");

        // METHOD 1 - Get list of revenues & sum it using for-loop or streams
        long totalRevenueL = 0L;
        for (int revenue : listOfRevenues) {
            totalRevenueL += revenue;
        }
        System.out.println("Method 1: " + totalRevenueL); //exp: 3175870719

        // Or using streams()
        long totalRevenue = listOfRevenues.stream()
                .mapToLong(Integer::intValue) //intValue: Returns the value of this Integer as an int
                .sum();
        System.out.println("Method 2: " + totalRevenue);

        // METHOD 2 - Get individual box office revenue of each movie using a for loop & sum it
        DocumentContext context = JsonPath.parse(jsonString);
        int length = context.read("$.length()");
        long revenue = 0;
        for (int i = 0; i < length; i++) {
            revenue += context.read("$[" + i + "]['box office']", Long.class);
            // returns an Integer. Add Long.class to convert Integer to Long
        }

        assertEquals(revenue, 594275385L + 591692078L + 1110526981L + 879376275L);

        // METHOD 3 - using the 'sum()' function of Jayway
        Double sum = JsonPath.read(jsonString, "$.sum($.[0].['box office'], $.[1].['box office'], $.[2].['box " +
                "office'], $.[3].['box office'])");
        System.out.println("Method 3: " + sum); //3.175870719E9

        // Another way: Get the 'path' through code
        // Extract the PATH of all items
        // Pass this path value (as string) to the sum()

        // Return path instead of the value
        Configuration conf = Configuration.builder()
                .options(Option.AS_PATH_LIST).build();
        // Get the list of path
        List<String> pathList = JsonPath.using(conf).parse(jsonString).read("$..['box office']]");
        System.out.println(pathList); //["$[0]['box office']","$[1]['box office']","$[2]['box office']","$[3]['box office']"]

        // To remove the '[', ']' from the list, convert the list to a String
        String queryPath = String.join(", ", pathList);
        System.out.println(queryPath); //$[0]['box office'], $[1]['box office'], $[2]['box office'], $[3]['box office']

        Double sum1 = JsonPath.read(jsonString, "$.sum('"+ queryPath +"')");
        System.out.println(sum1);
    }

    /*
    Find the movie with the Highest Revenue
     */
    @Test
    public void findMovieWithHighestRevenue() {
        String jsonString = getJsonAsString();

        // METHOD 1 - Get the max revenue from the list of revenues & pass it inside the filter to get the title
        List<Integer> listOfRevenues = JsonPath.read(jsonString,"$..['box office']");

        // Find max revenue
        int max = 0;
        for(int revenue: listOfRevenues){
            if(max < revenue)
                max = revenue;
        }
        List<String> list = JsonPath.read(jsonString,"$.[?(@.['box office'] == '" + max + "')].title");
        System.out.println(list.get(0)); //Skyfall

        // METHOD 2
        // Find the maximum revenue
        DocumentContext context = JsonPath.parse(jsonString);
        List<Object> revenueList = context.read("$[*]['box office']");
        Integer[] revenueArray = revenueList.toArray(new Integer[0]);
        Arrays.sort(revenueArray);

        int highestRevenue = revenueArray[revenueArray.length - 1];

        // Returns a list of path strings rather than the value
        Configuration pathConfiguration =
                Configuration.builder().options(Option.AS_PATH_LIST).build();
        // Get the 'path' with highest revenue instead of the 'value'
        List<String> pathList = JsonPath.using(pathConfiguration).parse(jsonString)
                .read("$[?(@['box office'] == " + highestRevenue + ")]");

        // Get title
        Map<String, String> dataRecord = context.read(pathList.get(0));
        String title = dataRecord.get("title");

        // Assert
        assertEquals("Skyfall", title);
    }

    /*
    Get Latest Movie of a Director
     */
    @Test
    public void getLatestMovieOfDirector(){
        // Find all release dates of a director
        // Find the 'latest' release date
        // Filter by director AND the 'latest release date'

        String jsonString = getJsonAsString();
        ReadContext cxt = JsonPath.parse(jsonString);
        // Date date = JsonPath.parse(json).read("$['date_as_long']", Date.class);

        // Find all release dates of Sam Mendes
        List<Long> releaseDatesOfSamMendesMovies = cxt.read("$[?(@.director == 'Sam Mendes')].['release date']");
        System.out.println(releaseDatesOfSamMendesMovies);

        // Find the latest release date
        long latestReleaseDate = 0;
        for(long relDt: releaseDatesOfSamMendesMovies)
            if(latestReleaseDate < relDt)
                latestReleaseDate = relDt;

        // Filter by director AND the 'latest release date'
        List<String> ListOfLatestMovieTitle =
                cxt.read("$[?(@.director == 'Sam Mendes' && @.['release date'] == '"+ latestReleaseDate +"')].title");
        System.out.println(ListOfLatestMovieTitle.get(0)); //Spectre
    }


    /*
    SUMMARY:
    1. Different ways to parse JSON String - read from a JsonString, an Object, and a ReadContext object
    2. Filter by a property: Filter movie by ID and assert movie ID, title
    3. Filter by a property inside a List: Get the Movie Title Given Starring - using 'in' operator
    4. Filter by a property containing specified substring:  Get ID of the movie containing title - using 'contains' operator
    5. Using AND operator: Get movies with both Daniel Craig AND Sam Mendes
    6. Using Filter Predicates - Find a movie with poor box office collection
    7. Using the sum() function: Calculation of the Total Revenue - extract paths & pass it to sum()
    8. Find the movie with the Highest Revenue
    9. Return Path rather than the value
    10. Get Latest Movie of a Director

    Additional notes:
    i. If you configure JsonPath to use JacksonMappingProvider or GsonMappingProvider you can even map your JsonPath
    output directly into POJO's.
    example:
    Book book = JsonPath.parse(json).read("$.store.book[0]", Book.class);
    This is especially useful to convert an Integer value to Long
    eg long revenue = 0;
        for (int i = 0; i < length; i++) {
            revenue += context.read("$[" + i + "]['box office']", Long.class);
            // returns an Integer - add Long.class to convert to Long
        }

    ii. You can also set a new value to a property in a JSON file
    String newJson = JsonPath.parse(json).set("$['store']['book'][0]['author']", "Paul").jsonString();

    Reference:
    https://www.baeldung.com/guide-to-jayway-jsonpath
    https://support.smartbear.com/alertsite/docs/monitors/api/endpoint/jsonpath.html
     */


}
