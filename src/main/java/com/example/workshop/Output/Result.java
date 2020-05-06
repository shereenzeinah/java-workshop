package com.example.workshop.Output;

public class Result {
    String name,continent;
    int populaiton;
    Double life;
    String language;

    public String getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", populaiton=" + populaiton +
                ", life=" + life +
                ", language=" + language +
                '}';
    }

    public Result(String name, String continent, int populaiton, Double life, String language) {
        this.name = name;
        this.continent = continent;
        this.populaiton = populaiton;
        this.life = life;
        this.language = language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getPopulaiton() {
        return populaiton;
    }

    public void setPopulaiton(int populaiton) {
        this.populaiton = populaiton;
    }

    public Double getLife() {
        return life;
    }

    public void setLife(Double life) {
        this.life = life;
    }
}
