package classes;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.MILLISECONDS;


public class DBConnector {
    //Attributes
    private String dbAddress;
    private String JWT;
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request;

    List<Event> events = new ArrayList<>();
    //Constructor
    public DBConnector(String dbAddress){
        this.dbAddress = dbAddress;

    }

    //Methods

    /**
     * Sends a GET request with the username and password to the database in order to log in. If successful,
     * writes the JWT to the corresponding variable in the connector object
     * @param username
     * @param password
     * @return The result of JWT != null
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    public boolean login(String username, String password) throws URISyntaxException, IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(new URI(dbAddress+"auth/login?username="+username+"&password="+password))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response);

        if(response.statusCode() == 200){
            JWT = response.body();
        }

        return (response.statusCode() == 200);
    }

    /**
     * Sends a GET request with the username and password to the database in order to sign up. If successful,
     * writes the JWT to the corresponding variable in the connector object
     * @param username
     * @param password
     * @return response.statusCode() == 200
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    public boolean signUp(String username, String password) throws URISyntaxException, IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(new URI(dbAddress+"auth/signup?username="+username+"&password="+password))
                .POST(HttpRequest.BodyPublishers.ofString(""))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response);

        if(response.statusCode() == 200){
            JWT = response.body();
        }

        return (response.statusCode() == 200);
    }

    /**
     * Sends a GET request to the database address, returns true of the request was returned
     * @return The result of request.uri() != null
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    public boolean reachable() throws URISyntaxException, IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(new URI(dbAddress))
                .timeout(Duration.of(200, MILLISECONDS.toChronoUnit()))
                .GET()
                .build();

        client.send(request, HttpResponse.BodyHandlers.ofString());

        return request.uri() != null;
    }

    /**
     * Sends a GET request to the database
     * @return A list containing every event the user is a member of
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    public List<Event> getEvents() throws URISyntaxException, IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(new URI(dbAddress+"event/"))
                .GET()
                .header("Authorization", "Bearer "+JWT)
                .build();

        client.send(request, HttpResponse.BodyHandlers.ofString());

        List<Event> events = new ArrayList<>();
        return events;
    }

    /**
     * Sends a GET request to the database, in order to get an event by its id. Fails if the user is not the host
     * @param id
     * @return
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    public void getEvent(int id) throws URISyntaxException, IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(new URI(dbAddress + "event/"+id))
                .GET()
                .header("Authorization", "Bearer "+JWT)
                .build();

        client.send(request, HttpResponse.BodyHandlers.ofString());

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        deserializeEvent(response.toString());
    }

    public Event newEvent(String title, String description, String date) throws URISyntaxException, IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(new URI(dbAddress + "event/?title="+title+"&description="+description+"&date="+date))
                .POST(HttpRequest.BodyPublishers.ofString(""))
                .header("Authorization", "Bearer "+JWT)
                .build();

        client.send(request, HttpResponse.BodyHandlers.ofString());

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() == 200){
            return
        }
    }

    /**
     * Sends a PATCH request to the database with updated event parameters. Fails if the user is not the host
     * @param id
     * @param title
     * @param description
     * @param place
     * @param date
     * @return The result of response.statusCode()==200
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    public boolean updateEvent(int id, String title, String description, String place, String date) throws URISyntaxException, IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(new URI(dbAddress+"event/"+id+"?date="+date+"&title="+title+"&description="+description+"&place="+place))
                .method("PATCH", HttpRequest.BodyPublishers.ofString(""))
                .header("Authorization", "Bearer "+JWT)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.statusCode()==200;
    }

    public boolean addUser(int id, int userID) throws IOException, InterruptedException, URISyntaxException {
        request = HttpRequest.newBuilder()
                .uri(new URI(dbAddress+"event/"+id+"/add?userID="+userID))
                .POST(HttpRequest.BodyPublishers.ofString(""))
                .header("Authorization", "Bearer "+JWT)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.statusCode()==200;
    }

    public boolean removeUser(int id, int userID) throws IOException, InterruptedException, URISyntaxException {
        request = HttpRequest.newBuilder()
                .uri(new URI(dbAddress+"event/"+id+"/remove?userID="+userID))
                .POST(HttpRequest.BodyPublishers.ofString(""))
                .header("Authorization", "Bearer "+JWT)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.statusCode()==200;
    }

    public String me() throws URISyntaxException, IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .uri(new URI(dbAddress+"me"))
                .GET()
                .header("Authorization", "Bearer "+JWT)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    private void deserializeEvent(String json) throws URISyntaxException, IOException, InterruptedException {
        Gson deserializer = new Gson();
        events.add(deserializer.fromJson(json, Event.class));
    }
}
