package homework.api.steps;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import homework.api.testobjects.Data;
import homework.api.testobjects.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class SearchMethods {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final String JSON = "src/test/resources/api/users.json";

    public User searchByExactMatch(String name) throws FileNotFoundException {
        Data data = gson.fromJson(new JsonReader(new FileReader(JSON)), Data.class);
        return data.getData().stream().filter(u -> u.getUsername().equals(name)).findAny().get();
    }

    public User searchByPartialMatch(String name) throws FileNotFoundException {
        Data data = gson.fromJson(new JsonReader(new FileReader(JSON)), Data.class);
        return data.getData().stream().filter(u -> u.getUsername().contains(name)).findAny().get();
    }

    public List<User> searchUsers() throws FileNotFoundException {
        Data data = gson.fromJson(new JsonReader(new FileReader(JSON)), Data.class);
        return data.getData();
    }
}
