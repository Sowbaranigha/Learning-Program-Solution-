package com.example.service;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) { this.api = api; }

    public String fetchData()           { return api.getData(); }
    public String getUserName(int id)   { return api.getUser(id); }
    public void   resetSystem()         { api.reset(); }
    public String fetchTwice()          { return api.getData() + " | " + api.getData(); }
    public void   doTwoCallsInOrder()   { api.getData(); api.reset(); }
}
